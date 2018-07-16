package com.jones.cm.service.impl;

import java.util.List;

import com.jones.cm.dao.CustomerDao;
import com.jones.cm.dao.impl.CustomerDaoImpl;
import com.jones.cm.domain.Customer;
import com.jones.cm.service.CustomerService;

/**   
*    
* 项目名称：CustomerMana   
* 名称：CustomerServiceImpl   
* 描述：   
* 创建人：jones   
* 创建时间：2018年7月15日 下午2:36:35   
* @version        
*/
public class CustomerServiceImpl implements CustomerService {
	CustomerDao cd = new CustomerDaoImpl();

	// 查询所有用户
	@Override
	public List<Customer> findAll() throws Exception {
		return cd.findAll();
	}

	// 根据id查询用户
	@Override
	public Customer findCustomerById(String id) throws Exception {
		return cd.findCustomerById(id);
	}

	// 根据id删除用户
	@Override
	public void delCustomerById(String id) throws Exception {
		cd.delCustomerById(id);
	}

	// 添加客户
	@Override
	public void addCustomer(Customer customer) throws Exception {
		cd.addCustomer(customer);
	}

	// 修改客户
	@Override
	public void editCustomer(Customer customer) throws Exception {
		cd.editCustomer(customer);

	}

	// 根据条件查询客户
	@Override
	public List<Customer> findCustomer(Customer customer) throws Exception {
		return cd.findCustomer(customer);
	}
}
