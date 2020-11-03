package com.syousui.aop;

import com.syousui.aop.aspectJ.base_xml.dao.UserDao;
import com.syousui.aop.aspectJ.base_xml.dao.impl.UserDaoImpl;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestAop.java
 * @PackageLoaction : com.syousui.proxy
 * @createTime : 2020-09-22 09:12:00 星期二
 * @Description : TODO
 */
public class TestProxy {
    public static void jdk_method ( ) {
        JdkProxy jdkProxy = new JdkProxy( );
        UserDao userDao = (UserDao) jdkProxy.useProxy( new UserDaoImpl( ) );
        userDao.addUser( );
        userDao.deleteUser( );
    }
    public static void cglib_method ( ) {
        CglibProxy cglibProxy = new CglibProxy( );
        UserDao userDao = (UserDao) cglibProxy.useProxy( new UserDaoImpl( ) );
        userDao.addUser( );
        userDao.deleteUser( );
    }
    public static void main ( String[] args ) {
        jdk_method( );

        System.out.println( );

        cglib_method( );
    }
}
