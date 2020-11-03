package com.syousui.aop;

import com.syousui.aop.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : CglibProxy.java
 * @PackageLoaction : com.syousui.aop.proxy
 * @createTime : 2020-09-22 09:28:00 星期二
 * @Description : TODO
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept ( Object o, Method method, Object[] objects, MethodProxy methodProxy ) throws Throwable {
        MyAspect myAspect = new MyAspect( );
        myAspect.check_Permission( );
        Object obj = methodProxy.invokeSuper( o, objects );
        myAspect.log( );
        return obj;
    }

    public Object useProxy ( Object target ) {
        // 创建一个动态类对象
        Enhancer enhancer = new Enhancer( );
        // 确定需要增强的类
        enhancer.setSuperclass( target.getClass( ) );
        // 添加回调函数
        enhancer.setCallback( this );
        // 返回创建的代理类
        return enhancer.create( );
    }
}
