package com.syousui.springDB.springJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : SpringJDBC.java
 * @PackageLoaction : com.syousui.springDB.springJDBC
 * @createTime : 2020-09-29 10:53:00 星期二
 * @Description : TODO
 */
public class SpringJDBC {
    /**
     * 使用execute()方法建表
     */
    public static void main ( String[] args ) {
        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext( "springJDBC.xml" );
        // 获取JdbcTemplate实例
        JdbcTemplate jdTemplate =
                (JdbcTemplate) applicationContext.getBean( "springJDBC_jdbcTemplate" );
        // 使用execute()方法执行SQL语句，创建用户账户管理表account
        jdTemplate.execute( "create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double)" );
        System.out.println( "账户表account创建成功！" );
    }

}
