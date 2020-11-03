package com.syousui.temp.t2;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : T2.java
 * @PackageLoaction : com.syousui.temp.t2
 * @createTime : 2020-10-15 22:26:00 星期四
 * @Description : TODO
 */
public class T2 {
    public static void main ( String[] args ) {
        Object a1 = new A( );
        Object a2 = new A( );
        System.out.println( a1.equals( a2 ) );
    }
}

class A {
    int x;
    public boolean equals ( A a ) {
        System.out.println( this.x );
        System.out.println( a.x );
        return this.x == a.x;
    }
}

