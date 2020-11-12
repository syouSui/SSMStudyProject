package com.syousui.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.syousui.dao.CustomerDao;
import com.syousui.po.Customer;

public class CustomerDaoImpl
        extends SqlSessionDaoSupport implements CustomerDao {
    // 通过id查询客户
    public Customer findCustomerById ( Integer id ) {
        return this.getSqlSession( ).selectOne(
                "com.syousui.po.CustomerMapper.findCustomerById",
                id
        );
    }
}
