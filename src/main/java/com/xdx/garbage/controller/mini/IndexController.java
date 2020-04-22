package com.xdx.garbage.controller.mini;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.PageHelper;
import com.xdx.garbage.common.constant.Constant;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.common.dto.PageResponse;
import com.xdx.garbage.common.dto.QueryParam;
import com.xdx.garbage.common.util.HttpClientUtil;
import com.xdx.garbage.common.util.HttpUtil;
import com.xdx.garbage.entity.*;
import com.xdx.garbage.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mini")
@Slf4j
public class IndexController {
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private UserService userService;
    @Autowired
    private LaunchPointService launchPointService;
    @Autowired
    private BagService bagService;
    @Autowired
    private NewsService newsService;

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse login(String jsCode,HttpSession session) {
        log.info(Constant.appId);
        log.info(Constant.appSecret);
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String>param=new HashMap<>();
        param.put("appid",Constant.appId);
        param.put("secret",Constant.appSecret);
        param.put("js_code",jsCode);
        param.put("grant_type","authorization_code");
        int result = 0;
        String grantStr = HttpClientUtil.doGet(url, param);
        Map<String, Object> maps = new HashMap<String, Object>();
        JSONObject jsonObject = JSON.parseObject(grantStr);
        String session_key = (String) jsonObject.get("session_key");
        String openId = jsonObject.getString("openid");
        maps.put("session_key", session_key);
        TUser user = userService.getUserByOpenId(openId);//根据xcxOpenId获取
        Long userId;
        if (user == null) {
            // 首次授权新增账户
            TUser userTmp = new TUser();
            userTmp.setOpenId(openId);
            userService.insertSelective(userTmp);
            userId=userTmp.getId();
        } else {
            // 不是新增账户
            userId = user.getId();
        }
        result=1;
        user=userService.getUserById(userId);
        session.setAttribute("openId", openId);//小程序openId
        session.setAttribute("sessionKey", session_key);//会话表示，用于解密
        session.setAttribute("c_userId", userId);
        maps.put("user", user);
        maps.put("result", result);
        // 将sessionId放入map中
        String sessionId = session.getId();
        maps.put("SESSION", sessionId);
        return BaseResponse.success(maps);
    }
    @RequestMapping("checkSession")
    @ResponseBody
    public BaseResponse wxCheckSessionAjax(HttpServletRequest req) {
        Integer result;
        HttpSession s = req.getSession();
        if (s.getAttribute("c_userId") != null) {
            return BaseResponse.success();
        } else {
            return BaseResponse.fail(-1);
        }
    }
    @RequestMapping("user/change")
    @ResponseBody
    public BaseResponse userChange(HttpSession session) {
        Integer userId=(Integer) session.getAttribute("c_userId");
        TUser user=userService.getUserById(userId);
        Map<String,Object>maps=new HashMap<String, Object>();
        maps.put("user", user);
        maps.put("result", 1);
        maps.put("SESSION", session.getId());
        session.setAttribute("openId", user.getOpenId());
        session.setAttribute("c_userId", userId);
        return BaseResponse.success(maps);
    }

    @RequestMapping("index")
    public BaseResponse index(HttpSession session){
        Map<String, Object> map = new HashMap<>();
        QueryParam queryParam=new QueryParam();
        queryParam.setStatus(1);
        List<TCarousel>carouselList=carouselService.selectListByQueryParam(queryParam);
        map.put("carouselList",carouselList);
        Long c_userId= (Long) session.getAttribute("c_userId");
        if(c_userId!=null){
            TUser user = userService.getUserById(c_userId);
            map.put("user", user);
        }

        return BaseResponse.success(map);

    }
    @RequestMapping("carousels")
    public BaseResponse carousels(){
        Map<String, Object> map = new HashMap<>();
        QueryParam queryParam=new QueryParam();
        queryParam.setStatus(1);
        List<TCarousel>carouselList=carouselService.selectListByQueryParam(queryParam);
        map.put("carouselList",carouselList);
        return BaseResponse.success(map);
    }
    @RequestMapping("points")
    public BaseResponse points(){
        Map<String, Object> map = new HashMap<>();
        //所有的投放点
        List<TLaunchPoint>points=launchPointService.getActivePoints();
        map.put("points", points);
        return BaseResponse.success(map);
    }

    /**
     * 绑定环保袋
     * @param bag
     * @return
     */
    @RequestMapping("bag/bind")
    public BaseResponse bagBind(TBag bag){
        bag.setStatus(2);
        TBag bagExist=new TBag();
        bagExist.setBagCode(bag.getBagCode());
        bagExist.setStatus(1);
        if(bagService.selectOne(bagExist)!=null){
            bag.setReceiveTime(new Date());//绑定时间
            if(bagService.bindBag(bag)>0){
                return BaseResponse.success();
            }else{
                return BaseResponse.fail(-1,"绑定失败,请联系管理员");
            }
        }else{
            return BaseResponse.fail(-2,"绑定失败，编号错误");
        }

    }

    /**
     * 新闻列表
     * @param request
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("news/list")
    public BaseResponse newsList(HttpServletRequest request, QueryParam queryParam,
                                 @RequestParam(value = "limit",required = false) Integer pageSize,
                                 @RequestParam(value = "page",required = false) Integer pageNum) {
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum, pageSize);
        }
        queryParam.formatSort();
        List<TNews> list = newsService.selectListByQueryParam(queryParam);
        Map<String,Object> map=new HashMap<>();
        map.put("newsList",list);
        return PageResponse.<Map<String,Object>>success4element(map);

    }

    /**
     * 阅读数新增
     * @param news
     * @return
     */
    @RequestMapping("news/read")
    public BaseResponse newsRead(TNews news){
       newsService.increaseReadNum(news);
       return BaseResponse.success();
    }
}
