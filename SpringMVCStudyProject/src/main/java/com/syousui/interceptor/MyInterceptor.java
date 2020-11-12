package com.syousui.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 实现了HandlerInterceptor接口的自定义拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle ( HttpServletRequest request,
                               HttpServletResponse response, Object handler ) throws Exception {
        System.out.println( "MyInterceptor...preHandle" );
        //对拦截的请求进行放行处理
        return true;
//        // 获取请求的URL
//        String url = request.getRequestURI( );
//        // URL:除了login 和 register 是可以公开访问的，其它的URL都进行拦截控制
//         return url.contains( "/login" ) || url.contains( "/register" );
    }
    @Override
    public void postHandle ( HttpServletRequest request,
                             HttpServletResponse response, Object handler,
                             ModelAndView modelAndView ) throws Exception {
        System.out.println( "MyInterceptor...postHandle" );
    }
    @Override
    public void afterCompletion ( HttpServletRequest request,
                                  HttpServletResponse response, Object handler,
                                  Exception ex ) throws Exception {
        System.out.println( "MyInterceptor...afterCompletion" );
    }
}
