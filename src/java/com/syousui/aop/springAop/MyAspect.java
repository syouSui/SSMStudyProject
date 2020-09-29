package com.syousui.aop.springAop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : MyAspect.java
 * @PackageLoaction : com.syousui.aop.springAop
 * @createTime : 2020-09-22 10:25:00 星期二
 * @Description : TODO
 */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke ( MethodInvocation methodInvocation ) throws Throwable {
        check_Permission( );
        Object obj = methodInvocation.proceed( );
        log();
        return obj;
    }

    public void check_Permission( ) {
        System.out.println( "--- checking permission ---" );
    }

    public void log () {
        System.out.println( "--- logging ---" );
    }
}
