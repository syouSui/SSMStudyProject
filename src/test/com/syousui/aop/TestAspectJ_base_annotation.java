package com.syousui.aop;

import com.syousui.aop.aspectJ.base_annotation.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestAspectJ_base_annotation.java
 * @PackageLoaction : com.syousui.aop
 * @createTime : 2020-09-29 10:20:00 星期二
 * @Description : TODO
 */
public class TestAspectJ_base_annotation {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "aspectJ_base_annotation.xml" );
        UserDao userDao = applicationContext.getBean("aspectJ_dao", UserDao.class);
        userDao.addUser();
    }
}
