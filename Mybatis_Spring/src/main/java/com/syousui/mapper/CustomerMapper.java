package com.syousui.mapper;

import com.syousui.po.Customer;

public interface CustomerMapper {
    // 通过id查询客户
    public Customer findCustomerById ( Integer id );

    // 添加客户
    public void addCustomer ( Customer customer );

}
