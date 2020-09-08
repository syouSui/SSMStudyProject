package com.syousui.instance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestInstance.java
 * @PackageLoaction : com.syousui.instance
 * @createTime : 2020-09-08 10:21:00 星期二
 * @Description : TODO
 */
public class TestInstance {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "instance.xml");
        Bean1 bean1 = applicationContext.getBean( "bean1", Bean1.class );
        Bean2 bean2 = applicationContext.getBean( "bean2", Bean2.class );
        Bean3 bean3 = applicationContext.getBean( "bean3", Bean3.class );
    }
}
