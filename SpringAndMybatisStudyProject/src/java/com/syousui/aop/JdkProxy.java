package com.syousui.aop;

import com.syousui.aop.aspectJ.base_xml.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : JDKProxy.java
 * @PackageLoaction : com.syousui.proxy.dao.com.syousui.proxy
 * @createTime : 2020-09-22 08:54:00 星期二
 * @Description : TODO
 */
public class JdkProxy implements InvocationHandler {
    @Override
    public Object invoke ( Object proxy, Method method, Object[] args ) throws Throwable {
        MyAspect myAspect = new MyAspect( );
        myAspect.check_Permission( );
        Object obj = method.invoke( userDao, args );
        myAspect.log( );
        return obj;
    }

    private UserDao userDao;

    public Object useProxy ( UserDao userDao ) {
        this.userDao = userDao;
        // 1. 类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader( );
        // 2. 被代理类对象的所有方法
        Class<?>[] interfaces = userDao.getClass( ).getInterfaces( );
        // 3. 返回使用代理类创建增强的对象
        return Proxy.newProxyInstance( classLoader, interfaces, this );
    }
}
