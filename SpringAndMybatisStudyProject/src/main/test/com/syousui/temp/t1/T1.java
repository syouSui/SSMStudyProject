package com.syousui.temp.t1;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : T1.java
 * @PackageLoaction : com.syousui.temp.t1
 * @createTime : 2020-10-15 22:25:00 星期四
 * @Description : TODO
 */
public class T1 {
    public static void main ( String[] args ) {
        Object a1 = new A( );
        Object a2 = new A( );
        System.out.println( a1.equals( a2 ) );
    }
}

class A {
    int x;
//    @Override
//    public boolean equals ( Object obj ) {
//        return super.equals( obj );
//    }

    public boolean equals ( Object a ) {
//        System.out.println( this.x );
//        System.out.println( ((A) a).x );
        return this.x == ((A) a).x;
    }
}
