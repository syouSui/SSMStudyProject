package com.syousui.dao;

import com.syousui.po.Customer;

public interface CustomerDao {
    // 通过id查询客户
    public Customer findCustomerById ( Integer id );
}
