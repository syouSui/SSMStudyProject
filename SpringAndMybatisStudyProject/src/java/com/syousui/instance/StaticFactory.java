package com.syousui.instance;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : StaticFactory.java
 * @PackageLoaction : com.syousui.instance
 * @createTime : 2020-09-08 09:49:00 星期二
 * @Description : TODO
 */
public class StaticFactory {
    public static  Bean1 createBean1 ( ) {
        System.out.println( "Static Factory working..." );
        return new Bean1( );
    }
    public static  Bean2 createBean2 ( ) {
        System.out.println( "Static Factory working..." );
        return new Bean2( );
    }
    public static  Bean3 createBean3 ( ) {
        System.out.println( "Static Factory working..." );
        return new Bean3( );
    }
}
