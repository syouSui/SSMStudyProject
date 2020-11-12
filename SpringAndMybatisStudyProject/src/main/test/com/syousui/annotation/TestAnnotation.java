package com.syousui.annotation;

import com.syousui.annotation.controller.AnnotationController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : annotation.java
 * @PackageLoaction : com.syousui
 * @createTime : 2020-09-08 09:30:00 星期二
 * @Description : TODO
 */
public class TestAnnotation {
    public static void main ( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "baseAnnotation.xml" );
        AnnotationController myController = applicationContext.getBean( "myController", AnnotationController.class );
        myController.save();
    }
}
