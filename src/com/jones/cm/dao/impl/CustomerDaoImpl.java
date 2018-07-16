package com.jones.cm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jones.cm.dao.CustomerDao;
import com.jones.cm.domain.Customer;
import com.jones.cm.utils.JDBCUtils;

/**   
*    
* 项目名称：CustomerMana   
* 名称：CustomerDaoImpl   
* 描述：   
* 创建人：jones   
* 创建时间：2018年7月15日 下午2:39:56   
* @version        
*/
public class CustomerDaoImpl implements CustomerDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.dataSource());

	// 查询所有客户
	@Override
	public List<Customer> findAll() throws SQLException {
		String sql = "select * from t_customer";
		List<Customer> list = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		return list;

	}

	// 根据id查询客户
	@Override
	public Customer findCustomerById(String id) throws SQLException {
		String sql = "select * from t_customer where id =?";
		Customer ct = qr.query(sql, new BeanHandler<Customer>(Customer.class), id);
		return ct;
	}

	// 根据id删除用户
	@Override
	public void delCustomerById(String id) throws Exception {
		String sql = "delete from t_customer where id =?";
		qr.update(sql, id);
	}

	// 添加客户
	@Override
	public void addCustomer(Customer customer) throws Exception {
		String sql = "insert into t_customer values(?,?,?,?,?,?)";
		qr.update(sql, customer.getId(), customer.getName(), customer.getGender(), customer.getPhone(),
				customer.getEmail(), customer.getDescription());
	}

	// 修改客户
	@Override
	public void editCustomer(Customer customer) throws Exception {
		String sql = "update t_customer set name=?,gender=?,phone=?,email=?,description=? where id=?";
		qr.update(sql, customer.getName(), customer.getGender(), customer.getPhone(), customer.getEmail(),
				customer.getDescription(), customer.getId());
	}

	// 根据条件查找客户
	@Override
	public List<Customer> findCustomer(Customer customer) throws Exception {
		String sql = "select * from t_customer where name=? or gender=? or phone=? or email=?";
		return qr.query(sql, new BeanListHandler<Customer>(Customer.class), customer.getName(), customer.getGender(),
				customer.getPhone(), customer.getEmail());
	}
}