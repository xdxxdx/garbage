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
import com.xdx.garbage.common.util.wechatUtil.WXDecrypt;
import com.xdx.garbage.entity.*;
import com.xdx.garbage.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.metal.MetalIconFactory;
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
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private DoorRecycleService doorRecycleService;

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
        Long userId=(Long) session.getAttribute("c_userId");
        TUser user=userService.getUserById(userId);
        Map<String,Object>maps=new HashMap<String, Object>();
        maps.put("user", user);
        maps.put("result", 1);
        maps.put("SESSION", session.getId());
        session.setAttribute("openId", user.getOpenId());
        session.setAttribute("c_userId", userId);
        return BaseResponse.success(maps);
    }

    @RequestMapping("bind/nickName")
    @ResponseBody
    public BaseResponse bindNickName(TUser user) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer result = 0;
        map.put("msg", "更新微信昵称失败");
        TUser userTemp = userService.getUserById(user.getId());
        if (StringUtils.isNotEmpty(userTemp.getNickName())) {
            result = userService.updateSelectiveById(user);
        } else {
            result = -1;
            map.put("msg", "已有微信昵称");
        }
        if (result > 0) {
            map.put("msg", "更新微信昵称成功");
        }
        map.put("result", result);
        return BaseResponse.success(map);
    }
    @RequestMapping("bind/phone")
    @ResponseBody
    public Integer bindPhone(String encryptedData, String iv,
                                   HttpSession session) {
        Integer result = 0;
        Long userId = (Long) session.getAttribute("c_userId");
        String sessionKey = (String) session.getAttribute("sessionKey");
        String phoneInfo = WXDecrypt.decrypt(Constant.appId, encryptedData,
                sessionKey, iv);
        if (!phoneInfo.equals("")) {
            JSONObject jsonObject =JSON.parseObject(phoneInfo);
            String phone = "";
            if (jsonObject.get("phoneNumber") != null) {
                phone = (String) jsonObject.get("phoneNumber");
                TUser user=new TUser();
                user.setId(userId);
                user.setPhone(phone);
                user.setContactPhone(phone);
                result = userService.updateSelectiveById(user);
            }
        }
        return result;
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
     * 用户，我的回收订单
     * @param session
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("bag/list")
    public BaseResponse bagList(HttpSession session,QueryParam queryParam,
                                @RequestParam(value = "limit",required = false) Integer pageSize,
                                @RequestParam(value = "page",required = false) Integer pageNum){
        Long userId= (Long) session.getAttribute("c_userId");
        if(userId!=null){
            queryParam.setUserId(userId);
        }
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum, pageSize);
        }
        queryParam.formatSort();
        List<TBag>bagList=bagService.selectListByQueryParam(queryParam);
        Map<String,Object> map=new HashMap<>();
        map.put("bagList",bagList);
        return BaseResponse.success(map);
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
        return BaseResponse.success(map);

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

    /**
     * 省份列表
     * @return
     */
    @RequestMapping("province/list")
    public BaseResponse provinceList(){
        List<TProvince>provinceList=provinceService.selectListAll();
        Map<String, Object> map = new HashMap<>();
        map.put("provinceList",provinceList);
        return BaseResponse.success(map);
    }

    /**
     * 按省份查询城市列表
     * @param provinceId
     * @return
     */
    @RequestMapping("city/list")
    public BaseResponse cityList(Long provinceId){
        QueryParam queryParam=new QueryParam();
        queryParam.setProvinceId(provinceId);
        List<TCity>cityList=cityService.selectListByQueryParam(queryParam);
        Map<String, Object> map = new HashMap<>();
        map.put("cityList", cityList);
        return BaseResponse.success(map);
    }

    /**
     * 根据条件获取小区列表
     * @param queryParam
     * @return
     */
    @RequestMapping("house/list")
    public BaseResponse houseList(QueryParam queryParam){
        List<THouse>houseList=houseService.selectListByQueryParam(queryParam);
        Map<String,Object>maps=new HashMap<>();
        maps.put("houseList",houseList);
        return BaseResponse.success(maps);
    }

    /**
     * 用户详情
     * @param session
     * @return
     */
    @RequestMapping("user/detail")
    public BaseResponse userDetail(HttpSession session){
        Long userId=(Long) session.getAttribute("c_userId");
        if(userId!=null){
            TUser user=userService.getUserById(userId);
            if(user.getHouseId()!=null){
                THouse house = houseService.selectById(user.getHouseId());
                user.setHouse(house);
            }
            return BaseResponse.success(user);
        }
        return BaseResponse.fail(-1);

    }

    /**
     * 用户信息编辑
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("user/address/edit")
    public BaseResponse userAddressEdit(HttpSession session,TUser user) {
        Long userId=(Long) session.getAttribute("c_userId");
        if(userId!=null){
            user.setId(userId);
            return BaseResponse.success(userService.updateSelectiveById(user));
        }
        return BaseResponse.fail(-1);
    }
    @RequestMapping("doorRecycle/apply")
    public BaseResponse doorRecycleApply(HttpSession session, TDoorRecycle doorRecycle) {
        Long userId=(Long) session.getAttribute("c_userId");
        if(userId!=null){
            doorRecycle.setUserId(userId);
            return BaseResponse.success(doorRecycleService.insertSelective(doorRecycle));
        }
        return BaseResponse.fail(-1);
    }

    /**
     *
     * 上门回收订单
     * @param session
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("doorRecycle/list")
    public BaseResponse doorRecycleList(HttpSession session,QueryParam queryParam,
                                @RequestParam(value = "limit",required = false) Integer pageSize,
                                @RequestParam(value = "page",required = false) Integer pageNum){
        Long userId= (Long) session.getAttribute("c_userId");
        if(userId!=null){
            queryParam.setUserId(userId);
        }
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum, pageSize);
        }
        queryParam.formatSort();
        List<TDoorRecycle>orderList=doorRecycleService.selectListByQueryParam(queryParam);
        Map<String,Object> map=new HashMap<>();
        map.put("orderList",orderList);
        return BaseResponse.success(map);
    }
}