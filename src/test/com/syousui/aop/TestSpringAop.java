package com.syousui.aop;

import com.syousui.aop.aspectJ.base_xml.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestSpringAop.java
 * @PackageLoaction : com.syousui.proxy
 * @createTime : 2020-09-22 10:34:00 星期二
 * @Description : TODO
 */
public class TestSpringAop {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "springAop.xml" );
        UserDao userDaoProxy = (UserDao) applicationContext.getBean( "userDaoProxy" );
        userDaoProxy.addUser();
        userDaoProxy.deleteUser();
    }
}
