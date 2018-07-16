package com.jones.cm.service;

import java.util.List;

import com.jones.cm.domain.Customer;

/**   
*    
* 项目名称：CustomerMana   
* 名称：CustomerService   
* 描述：   
* 创建人：jones   
* 创建时间：2018年7月15日 下午2:35:26   
* @version        
*/
public interface CustomerService {
	// 查询所有客户
	public List<Customer> findAll() throws Exception;

	// 根据id查询客户
	public Customer findCustomerById(String id) throws Exception;

	// 删除客户
	public void delCustomerById(String id) throws Exception;

	// 添加客户
	public void addCustomer(Customer customer) throws Exception;

	// 修改客户
	public void editCustomer(Customer customer) throws Exception;

	public List<Customer> findCustomer(Customer customer) throws Exception;
}
