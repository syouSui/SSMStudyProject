package com.syousui.aop.aspectJ.base_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : MyAspect.java
 * @PackageLoaction : com.syousui.aop.aspectJ
 * @createTime : 2020-09-22 11:40:00 星期二
 * @Description : TODO
 */
public class MyAspect {
    /**
     * 前置通知
     *
     * @param joinPoint
     */
    public void myBefore ( JoinPoint joinPoint ) {
        System.out.println( "前置通知:  模拟权限检查..." );
        System.out.println( "目标类是: " + joinPoint.getTarget( ) );
        System.out.println( ", 被植入增强处理的目标方法为: " + joinPoint.getSignature( ).getName( ) );
        System.out.println( );
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    public void myAfterReturning ( JoinPoint joinPoint ) {
        System.out.println( );
        System.out.println( "后置通知: 模拟记录日志..., " );
        System.out.println( "被植入曾强处理的目标方法为: " + joinPoint.getSignature( ).getName( ) );
        System.out.println( );
    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint 是 JoinPoint 子接口, 表示可以执行的目标方法
     * @return 必须是 Object 类型的返回值
     * @throws Throwable
     */
    public Object myAround ( ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        // 开始
        System.out.println( );
        System.out.println( "---> 环绕开始: 执行目标方法之前, 模拟开启事务... <---" );
        System.out.println( );
        // 执行当前目标方法
        Object obj = proceedingJoinPoint.proceed( );
        // 结束
        System.out.println( );
        System.out.println( "---> 环绕结束: 执行目标方法之后, 模拟关闭事务... <---" );
        System.out.println( );
        return obj;
    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param e
     */
    public void myAfterThrowing ( JoinPoint joinPoint, Throwable e ) {
        System.out.println( );
        System.out.println( "异常通知: 出错了! " + e.getMessage( ) );
        System.out.println( );
    }

    /**
     * 最终通知
     */
    public void myAfter ( ) {
        System.out.println( "最终通知: 模拟释放方法结束后释放资源..." );
        System.out.println( );
    }


}
