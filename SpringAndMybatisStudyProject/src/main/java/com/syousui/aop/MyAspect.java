package com.syousui.aop;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : MyAspect.java
 * @PackageLoaction : com.syousui.aop
 * @createTime : 2020-09-22 08:57:00 星期二
 * @Description : TODO
 */
public class MyAspect {
    public void check_Permission ( ) {
        System.out.println( "--- checking permission ---" );
    }
    public void log ( ) {
        System.out.println( "--- logging ---" );
    }
}
