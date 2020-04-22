package com.xdx.garbage.common.config;

import com.xdx.garbage.common.interceptor.BackInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class BackInterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器，并且拦截所有路径
        registry.addInterceptor(new BackInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**","/mini/**","/upload/**","/favicon.ico");
        super.addInterceptors(registry);
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**","/upload/**").addResourceLocations("classpath:/static/","classpath:/upload/");
        super.addResourceHandlers(registry);
    }
}
