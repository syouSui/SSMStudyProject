package com.syousui.mybatis;

import com.syousui.mybatis.pojo.User;
import com.syousui.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestUserMapper.java
 * @PackageLoaction : com.syousui.mybatis
 * @createTime : 2020-10-15 09:32:00 星期四
 * @Description : TODO
 */
public class TestUserMapper {
    // SqlSession 线程不安全, 绝不能作为类成员, 但此处为测试类, 每个方法单个运行, 注意!!!
    public SqlSession sqlSession;

    @Before
    public void before ( ) throws Exception {
        // 通过 SqlSessionFactory 创建 SqlSession
        sqlSession = MybatisUtils.getSession();
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
    public void findAllUserTest ( ) throws Exception {
        // SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        List<User> users = sqlSession.selectList(
                "com.syousui.mybatis.mapper.UserMapper.findAllUser"
        );
        // 打印输出结果集
        for ( User user : users ) {
            System.out.println( user );
        }
    }
}
