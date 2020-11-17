package com.syousui.mapper;

import com.syousui.po.Customer;

/**
 * Customer接口文件
 */
public interface CustomerMapper {
	/**
	 * 根据id查询客户信息
	 */
	public Customer findCustomerById( Integer id);
}
