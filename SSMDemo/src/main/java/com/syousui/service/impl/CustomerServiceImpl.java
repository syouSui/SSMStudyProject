package com.syousui.service.impl;

import com.syousui.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.syousui.mapper.CustomerMapper;
import com.syousui.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //注解注入CustomerDao
    @Autowired
    private CustomerMapper customerMapper;
    //查询客户
    public Customer findCustomerById ( Integer id ) {
        return this.customerMapper.findCustomerById( id );
    }
}
