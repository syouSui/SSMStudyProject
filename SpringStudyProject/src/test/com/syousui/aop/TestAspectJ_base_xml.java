package com.syousui.aop;

import com.syousui.aop.aspectJ.base_xml.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestAspectJ.java
 * @PackageLoaction : com.syousui.aop.proxy
 * @createTime : 2020-09-29 08:55:00 星期二
 * @Description : TODO
 */
public class TestAspectJ_base_xml {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "aspectJ_base_xml.xml" );
        UserDao userDao = applicationContext.getBean( "userDao_aspectJ_base_xml", UserDao.class );
        userDao.addUser( );
    }
}
