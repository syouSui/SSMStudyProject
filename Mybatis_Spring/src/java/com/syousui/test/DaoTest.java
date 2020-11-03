package com.syousui.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.syousui.dao.CustomerDao;
import com.syousui.mapper.CustomerMapper;
import com.syousui.po.Customer;

/**
 * DAO测试类
 */
public class DaoTest {

    @Test
    public void findCustomerByIdDaoTest ( ) {
        ApplicationContext act =
                new ClassPathXmlApplicationContext( "applicationContext.xml" );
        // 根据容器中Bean的id来获取指定的Bean
        CustomerDao customerDao = act.getBean( "customerDao", CustomerDao.class );
//	     CustomerDao customerDao = act.getBean(CustomerDao.class);
        Customer customer = customerDao.findCustomerById( 1 );
        System.out.println( customer );
    }

    @Test
    public void findCustomerByIdMapperTest ( ) {
        ApplicationContext act =
                new ClassPathXmlApplicationContext( "applicationContext.xml" );
        CustomerMapper customerMapper = act.getBean( CustomerMapper.class );
        Customer customer = customerMapper.findCustomerById( 1 );
        System.out.println( customer );
    }

}
