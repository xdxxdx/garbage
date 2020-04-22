package com.xdx.garbage.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;

import com.xdx.garbage.common.util.OutPutMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class BackInterceptor implements HandlerInterceptor {
    private static final String NO_INTERCEPTOR_PATH = ".*login.*"; //对登录的操作不予拦截

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();

        Pattern r = Pattern.compile(NO_INTERCEPTOR_PATH);
        Matcher m = r.matcher(path);
        HttpSession session = request.getSession();
        String type = request.getMethod();// get还是post
        if (path.matches(NO_INTERCEPTOR_PATH)) {
            return true;// 匹配这些的将不受拦截
        } else {
            log.error("拦截路径" + path);
            // 后台
            if (session.getAttribute("admin") != null) {
                return true;
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", 50014);
                String json = JSON.toJSONString(map);
                OutPutMsg.outPutMsg(response, json);
                return false;
            }


        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
