package com.syousui.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestIoc.java
 * @PackageLoaction : com.syousui.ioc
 * @createTime : 2020-09-03 09:47:00 星期四
 * @Description : TODO
 */
public class TestIoc {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "baseXml.xml" );
        UserDao userDao = (UserDao) applicationContext.getBean( "userDao" );
        userDao.say();
    }
}
