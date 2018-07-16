package com.jones.cm.dao;

import java.util.List;

import com.jones.cm.domain.Customer;

/**   
*    
* 项目名称：CustomerMana   
* 名称：CustomerDao   
* 描述：   
* 创建人：jones   
* 创建时间：2018年7月15日 下午2:37:17   
* @version        
*/
public interface CustomerDao {

	// 查询所有用户
	public List<Customer> findAll() throws Exception;

	// 根据id查询用户
	public Customer findCustomerById(String id) throws Exception;

	// 根据id删除用户
	public void delCustomerById(String id) throws Exception;

	// 添加用户
	public void addCustomer(Customer customer) throws Exception;

	public void editCustomer(Customer customer) throws Exception;

	public List<Customer> findCustomer(Customer customer) throws Exception;
}
