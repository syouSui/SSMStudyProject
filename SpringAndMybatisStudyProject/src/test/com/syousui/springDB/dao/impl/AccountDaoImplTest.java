package com.syousui.springDB.dao.impl;

import com.syousui.springDB.dao.AccountDao;
import com.syousui.springDB.pojo.Account;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * AccountDaoImpl Tester.
 *
 * @author syouSui
 * @version 1.0
 * @since Seep, 29, 2020
 */
public class AccountDaoImplTest {

    public static ApplicationContext applicationContext;
    public static AccountDao accountDao;

    @Before
    public void before ( ) throws Exception {
        applicationContext = new ClassPathXmlApplicationContext( "springJDBC.xml" );
        accountDao = applicationContext.getBean( "springJDBC_accountDao", AccountDao.class );
    }

    @After
    public void after ( ) throws Exception {
    }

    /**
     * Method: setJdbcTemplate(JdbcTemplate jdbcTemplate)
     */
    @Test
    public void testSetJdbcTemplate ( ) throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: addAccount(Account account)
     */
    @Test
    public void testAddAccount ( ) throws Exception {
        int num = accountDao.addAccount( new Account( "tom", 1000.00 ) );
        if ( num > 0 ) {
            System.out.println( "成功插入了" + num + "条数据！" );
        } else {
            System.out.println( "插入操作执行失败！" );
        }
    }

    /**
     * Method: updateAccount(Account account)
     */
    @Test
    public void testUpdateAccount ( ) throws Exception {
        // 执行updateAccount()方法，并获取返回结果
        int num = accountDao.updateAccount( new Account( 1, "tom", 2000.00 ) );
        if ( num > 0 ) {
            System.out.println( "成功修改了" + num + "条数据！" );
        } else {
            System.out.println( "修改操作执行失败！" );
        }
    }

    /**
     * Method: deleteAccount(int id)
     */
    @Test
    public void testDeleteAccount ( ) throws Exception {
        // 执行deleteAccount()方法，并获取返回结果
        int num = accountDao.deleteAccount( 1 );
        if ( num > 0 ) {
            System.out.println( "成功删除了" + num + "条数据！" );
        } else {
            System.out.println( "删除操作执行失败！" );
        }
    }

    /**
     * Method: findAccountById(int id)
     */
    @Test
    public void testFindAccountById ( ) throws Exception {
        // 执行findAccountById()方法
        System.out.println( accountDao.findAccountById( 1 ) );
    }

    /**
     * Method: findAllAccount()
     */
    @Test
    public void testFindAllAccount ( ) throws Exception {
        // 执行findAllAccount()方法,获取Account对象的集合
        List<Account> account = accountDao.findAllAccount( );
        // 循环输出集合中的对象
        for ( Account act : account ) {
            System.out.println( act );
        }
    }

    /**
     * Method: transfer(String outUser, String inUser, Double money)
     */
    @Test
    public void testTransfer ( ) throws Exception {
        // 调用实例中的转账方法
        accountDao.transfer_xml(
                "Jack",
                "Rose",
                100.0
        );
        // 输出提示信息
        System.out.println( "转账成功！" );
    }

    /**
     * Method: transfer_annotation(String outUser, String inUser, Double money)
     */
    @Test
    public void testTransfer_annotation ( ) throws Exception {
        // 调用实例中的转账方法
        accountDao.transfer_annotation(
                "Jack",
                "Rose",
                100.0
        );
        // 输出提示信息
        System.out.println( "转账成功！" );
    }
}
