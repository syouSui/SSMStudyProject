package com.syousui.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.syousui.mybatis.pojo.Customer;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestMybatis.java
 * @PackageLoaction : com.syousui.mybatis
 * @createTime : 2020-10-13 08:29:00 星期二
 * @Description : TODO
 */

/**
 * 入门程序测试类
 */
public class TestCustomerMapper {
    public SqlSessionFactory sqlSessionFactory;
    // SqlSession 线程不安全, 绝不能作为类成员, 但此处为测试类, 每个方法单个运行, 注意!!!
    public SqlSession sqlSession;

    @Before
    public void before ( ) throws Exception {
        // 根据配置文件构建 SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder( ).build(
                Resources.getResourceAsStream( "mybatis-config.xml" )
        );
        // 通过 SqlSessionFactory 创建 SqlSession
        sqlSession = sqlSessionFactory.openSession( );
//        // 1、读取配置文件
//        InputStream inputStream =
//                Resources.getResourceAsStream( "mybatis-config.xml" );
//        // 2、根据配置文件构建 SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder( ).build( inputStream );
//        // 3、通过 SqlSessionFactory 创建 SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession( );
    }

    @After
    public void after ( ) throws Exception {
        // 关闭SqlSession
        sqlSession.close( );
    }

    /**
     * 根据客户编号查询客户信息
     */
    @Test
    public void findAllTest ( ) throws Exception {
        // SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        List<Customer> customers = sqlSession.selectList(
                "com.syousui.mybatis.mapper.CustomerMapper.findAll"
        );
        // 打印输出结果集
        for ( Customer customer : customers ) {
            System.out.println( customer );
        }
    }


    /**
     * 根据客户编号查询客户信息
     */
    @Test
    public void findCustomerByIdTest ( ) throws Exception {
        // SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        Customer customer = sqlSession.selectOne(
                "com.syousui.mybatis.mapper.CustomerMapper.findCustomerById",
                1
        );
        // 打印输出结果
        System.out.println( customer.toString( ) );
    }

    /**
     * 根据用户名称查询用户信息列表
     */
    @Test
    public void findCustomerByNameTest ( ) throws Exception {
        // SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        List<Customer> customers = sqlSession.selectList(
                "com.syousui.mybatis.mapper.CustomerMapper.findCustomerByName",
                "jack"
        );
        // 打印输出结果集
        for ( Customer customer : customers ) {
            System.out.println( customer );
        }
    }

    /**
     * 根据用户名称来模糊查询用户信息列表
     */
    @Test
    public void findCustomerByName_vagueTest ( ) throws Exception {
        // SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        List<Customer> customers = sqlSession.selectList(
                "com.syousui.mybatis.mapper.CustomerMapper.findCustomerByName_vague",
                "j"
        );
        // 打印输出结果集
        for ( Customer customer : customers ) {
            System.out.println( customer );
        }
    }

    /**
     * 添加客户
     */
    @Test
    public void insertCustomerTest ( ) throws Exception {
        // 执行SqlSession的插入方法，返回的是SQL语句影响的行数
        int num = sqlSession.insert(
                "com.syousui.mybatis.mapper.CustomerMapper.insertCustomer",
                new Customer( "rose", "student", "13333533092" )
        );
        // 4.3通过返回结果判断插入操作是否执行成功
        if ( num > 0 ) {
            System.out.println( "您成功插入了" + num + "条数据！" );
        } else {
            System.out.println( "执行插入操作失败！！！" );
        }
        // 提交事务
        sqlSession.commit( );
    }

    /**
     * 更新客户
     */
    @Test
    public void updateCustomerTest ( ) throws Exception {
        // 执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int num = sqlSession.update(
                "com.syousui.mybatis.mapper.CustomerMapper.updateCustomer",
                new Customer( 4, "rose", "programmer", "13311111111" )
        );
        // 通过返回结果判断更新操作是否执行成功
        if ( num > 0 ) {
            System.out.println( "您成功修改了" + num + "条数据！" );
        } else {
            System.out.println( "执行修改操作失败！！！" );
        }
        // 提交事务
        sqlSession.commit( );
    }

    /**
     * 删除客户
     */
    @Test
    public void deleteCustomerTest ( ) throws Exception {
        // 执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int num = sqlSession.delete(
                "com.syousui.mybatis.mapper.CustomerMapper.deleteCustomer",
                4
        );
        // 通过返回结果判断删除操作是否执行成功
        if ( num > 0 ) {
            System.out.println( "您成功删除了" + num + "条数据！" );
        } else {
            System.out.println( "执行删除操作失败！！！" );
        }
        // 提交事务
        sqlSession.commit( );
    }

}
