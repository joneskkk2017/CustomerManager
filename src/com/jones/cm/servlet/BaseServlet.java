package com.jones.cm.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取客户端提交到服务端的method对应的值
		String method = request.getParameter("method");
		if (null == method || "".equals(method) || method.trim().equals("")) {
			method = "execute";
		}

		// 此处this代表子类的对象
		Class clazz = this.getClass();
		try {
			// 获取clazz上名称为md的方法
			Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			if (null != md) {
				// 调用找到的方法
				String jspPath = (String) md.invoke(this, request, response);
				if (null != jspPath) {
					// 服务器的转发
					request.getRequestDispatcher(jspPath).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}

}
