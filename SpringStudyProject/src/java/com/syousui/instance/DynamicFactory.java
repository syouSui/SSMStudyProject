package com.syousui.instance;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : DynamicFactory.java
 * @PackageLoaction : com.syousui.instance
 * @createTime : 2020-09-08 09:50:00 星期二
 * @Description : TODO
 */
public class DynamicFactory {
    public DynamicFactory ( ) {
        System.out.println( "Dynamic Factory working..." );
    }
    public Bean1 createBean1 ( ) {
        return new Bean1( );
    }
    public Bean2 createBean2 ( ) {
        return new Bean2( );
    }
    public Bean3 createBean3 ( ) {
        return new Bean3( );
    }
}
