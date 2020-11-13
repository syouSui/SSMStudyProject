package com.syousui.test;

import com.syousui.dao.CustomerDao;
import com.syousui.mapper.CustomerMapper;
import com.syousui.po.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DAO测试类
 */
public class DaoTest {

    /**
     * Dao的开发模式测试
     */
    @Test
    public void findCustomerByIdDaoTest ( ) {
        ApplicationContext act = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        CustomerDao customerDao = act.getBean( "customerDao", CustomerDao.class );
//        CustomerDao customerDao = act.getBean( CustomerDao.class );
        Customer customer = customerDao.findCustomerById( 1 );
        System.out.println( customer );
    }

    /**
     * Mapper的开发模式测试
     */
    @Test
    public void findCustomerByIdMapperTest ( ) {
        ApplicationContext act = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        CustomerMapper customerMapper = act.getBean( "customerMapper", CustomerMapper.class );
//        CustomerMapper customerMapper = act.getBean( CustomerMapper.class );
        Customer customer = customerMapper.findCustomerById( 1 );
        System.out.println( customer );
    }

}
