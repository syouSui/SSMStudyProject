package com.syousui.aop.aspectJ.base_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : MyAspect.java
 * @PackageLoaction : com.syousui.aop.aspectJ
 * @createTime : 2020-09-22 11:40:00 星期二
 * @Description : TODO
 */

@Aspect
@Component
public class MyAspect {

    // 定义切入点表达式
    @Pointcut ( "execution(* com.syousui.aop.aspectJ.base_annotation.dao.*.*(..))" )
    // 使用一个返回值为void 方法体为空的方法来命名切入点
    private void myPointCut () {};

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before( "myPointCut()" )
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
    @AfterReturning( "myPointCut()" )
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
    @Around ( "myPointCut()" )
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
    @AfterThrowing( value= "myPointCut()", throwing="e" )
    public void myAfterThrowing ( JoinPoint joinPoint, Throwable e ) {
        System.out.println( );
        System.out.println( "异常通知: 出错了! " + e.getMessage( ) );
        System.out.println( );
    }

    /**
     * 最终通知
     */
    @After( "myPointCut()" )
    public void myAfter ( ) {
        System.out.println( "最终通知: 模拟释放方法结束后释放资源..." );
        System.out.println( );
    }

}
