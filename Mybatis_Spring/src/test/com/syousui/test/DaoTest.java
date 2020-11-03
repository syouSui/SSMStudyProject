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

//    public static void main ( String[] args ) {
//        findCustomerByIdDaoTest();
//    }

    @Test
    public void findCustomerByIdDaoTest(){
//	@Test
//	public static void findCustomerByIdDaoTest(){
		ApplicationContext act = 
		    new ClassPathXmlApplicationContext("applicationContext.xml");
          // 根据容器中Bean的id来获取指定的Bean
	     CustomerDao customerDao =
                              (CustomerDao) act.getBean("customerDao");
//	     CustomerDao customerDao = act.getBean(CustomerDao.class);
		 Customer customer = customerDao.findCustomerById(1);
		 System.out.println(customer);
	}
	
//	@Test
	public static void findCustomerByIdMapperTest(){
	    ApplicationContext act = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    CustomerMapper customerMapper = act.getBean( CustomerMapper.class);
	    Customer customer = customerMapper.findCustomerById(1);
	    System.out.println(customer);
	}

}
