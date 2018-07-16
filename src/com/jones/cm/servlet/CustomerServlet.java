package com.jones.cm.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jones.cm.domain.Customer;
import com.jones.cm.service.CustomerService;
import com.jones.cm.service.impl.CustomerServiceImpl;

import cn.itcast.commons.CommonUtils;

public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 跳转到add.jsp页面
	public String toAddJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "/add.jsp";
	}

	// 查询所有客户
	public String findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerService cs = new CustomerServiceImpl();
		try {
			List<Customer> list = cs.findAll();
			req.setAttribute("pb", list);
			return "/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 通过id查询一个用户并跳转到edit.jsp页面
	public String preEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取到当前id
		String id = req.getParameter("id");
		CustomerService cs = new CustomerServiceImpl();
		try {
			Customer ct = cs.findCustomerById(id);
			req.setAttribute("customer", ct);
			return "/edit.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除客户
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取到当前id
		String id = req.getParameter("id");
		CustomerService cs = new CustomerServiceImpl();
		try {
			cs.delCustomerById(id);
			List<Customer> list = cs.findAll();
			req.setAttribute("pb", list);
			return "/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 添加客户
	public String addCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> map = req.getParameterMap();
		Customer customer = CommonUtils.toBean(map, Customer.class);
		customer.setId(CommonUtils.uuid());
		CustomerService cs = new CustomerServiceImpl();
		try {
			cs.addCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", "恭喜,添加客户成功,");
		return "/msg.jsp";
	}

	// 修改客户
	public String editCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> map = req.getParameterMap();
		Customer customer = CommonUtils.toBean(map, Customer.class);
		CustomerService cs = new CustomerServiceImpl();
		try {
			cs.editCustomer(customer);
			req.getRequestDispatcher("/CustomerServlet?method=findAll").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 根据条件查询
	public String query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> map = req.getParameterMap();
		Customer customer = CommonUtils.toBean(map, Customer.class);
		CustomerService cs = new CustomerServiceImpl();
		try {
			List<Customer> list = cs.findCustomer(customer);
			req.setAttribute("pb", list);
			return "/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
