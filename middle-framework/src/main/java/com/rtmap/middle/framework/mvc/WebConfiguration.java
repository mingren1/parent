package com.rtmap.middle.framework.mvc;

import com.rtmap.middle.framework.mvc.filter.XssFilter;
import com.rtmap.middle.framework.mvc.interceptor.AuthenticationInterceptor;
import com.rtmap.middle.framework.mvc.interceptor.ResponseResultInterceptor;
import com.rtmap.middle.framework.mvc.filter.XssFilter;
import com.rtmap.middle.framework.mvc.interceptor.AuthenticationInterceptor;
import com.rtmap.middle.framework.mvc.interceptor.ResponseResultInterceptor;
import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns(apiUri);
        //统一响应拦截器
        registry.addInterceptor(responseResultInterceptor()).addPathPatterns(apiUri);
    }

    @Bean
    public ResponseResultInterceptor responseResultInterceptor() {
        return new ResponseResultInterceptor();
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    public FilterRegistrationBean getCORSFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CORSFilter());
        registration.setName("CORSFilter");
        registration.addUrlPatterns("/*");
        registration.addInitParameter("cors.allowOrigin", "*");
        registration.addInitParameter("cors.supportedMethods", "OPTIONS, GET, POST, HEAD, PUT, DELETE");
        registration.addInitParameter("cors.supportedHeaders", "Accept, Origin, X-Requested-With, token, JSESSIONID, cookie, Cookie, Content-Type, Last-Modified, Authorization");
        registration.addInitParameter("cors.exposedHeaders", "Set-Cookie");
        registration.addInitParameter("cors.supportsCredentials", "true");
        registration.setOrder(0);
        return registration;
    }

    @Bean
    public FilterRegistrationBean getXssFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new XssFilter());
        registration.setName("XssFilter");
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
        registration.setOrder(2);
        return registration;
    }
}
