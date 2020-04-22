package com.xdx.garbage.controller.back;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.xdx.garbage.common.controller.BaseController;
import com.xdx.garbage.common.dto.BaseResponse;
import com.xdx.garbage.common.util.EncryptionUtil;
import com.xdx.garbage.common.util.UploadUtil;
import com.xdx.garbage.entity.TAdmin;
import com.xdx.garbage.entity.TUser;
import com.xdx.garbage.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("ele/admin")
public class AdminController extends BaseController<AdminService, TAdmin> {
    @PostMapping("/login")
    public BaseResponse adminLogin(@RequestBody TAdmin admin, HttpSession session){
        if(service.checkAdminLogin(admin.getUserName(),admin.getPwd())){
            //登录成功，返回token
            //这边的token我们就返回sessionId
            String sessionId=session.getId();
            Map<String,String> token=new HashMap<>();
            token.put("token",sessionId);
            admin.setPwd(EncryptionUtil.encrypt(admin.getPwd()));
            admin=service.selectOne(admin);
            session.setAttribute("admin",admin);
            return BaseResponse.<Map<String,String>>success4element(token);
        }else{
            return BaseResponse.fail(1,"用户名或密码错误");
        }
    }
    @GetMapping("/info")
    public BaseResponse adminInfo(HttpSession session){
        log.info(session.getId()+"dddddddddd"+session.getAttribute("admin"));
            if(session.getAttribute("admin")!=null){
                //判定session是否过期
                log.info(session.getId());
                TAdmin admin= (TAdmin) session.getAttribute("admin");
                Map<String,Object>map=new HashMap<>();
                String roles=admin.getRole();
                String[] roleArr=roles.split(",");
                map.put("roles",roleArr);
                map.put("userName",admin.getUserName());
                map.put("avatar","http://www.xdx.com/avatar.jpg");
                return BaseResponse.<Map<String,Object>>success4element(map);
            }
        return BaseResponse.fail(50014,"服务端登录信息已过期");
    }
    @ResponseBody
    @RequestMapping(value="singleUpload/{path}",method = RequestMethod.POST)
    public BaseResponse singleUpload(HttpServletRequest req,@PathVariable("path")String path){

            MultipartFile upload = null;
            if (req instanceof MultipartHttpServletRequest) {
                upload = ((MultipartHttpServletRequest) req).getFile("upload");
                String result= UploadUtil.upload(req,upload,path);
                if(result!=null){
                    return BaseResponse.success(result);
                }
            }
            return BaseResponse.fail(-1);

    }
    @RequestMapping(value="/check/{userName}",method = RequestMethod.GET)
    public BaseResponse adminByUserName(@PathVariable("userName") String userName){
        TAdmin adminTmp=new TAdmin();
        adminTmp.setUserName(userName);
        adminTmp.setIsDel(0);
        TAdmin admin = service.selectOne(adminTmp);
        if(admin!=null){
            return BaseResponse.success4element("exist",null);
        }else{
            return BaseResponse.success4element("no-exist",null);
        }

    }
}
