package com.syousui.annotation.controller;


import com.syousui.annotation.service.AnnotationService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : AnnotationController.java
 * @PackageLoaction : com.syousui.annotation.controller
 * @createTime : 2020-09-08 10:37:00 星期二
 * @Description : TODO
 */
@Controller ( "myController" )
public class AnnotationController {
    @Resource ( name = "myService" )
    private AnnotationService annotationService;
    public void save ( ) {
        this.annotationService.save();
        System.out.println( "controller worked..." );
    }
}
