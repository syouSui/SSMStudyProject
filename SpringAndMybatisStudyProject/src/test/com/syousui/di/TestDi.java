package com.syousui.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestDi.java
 * @PackageLoaction : com.syousui.di
 * @createTime : 2020-09-03 16:31:00 星期四
 * @Description : TODO
 */
public class TestDi {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "baseXml.xml" );
        UserService userService = applicationContext.getBean( "userService", UserService.class );
        userService.say();
    }
}
