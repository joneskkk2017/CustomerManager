package com.jones.cm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**   
*    
* 项目名称：CustomerMana   
* 名称：CharacterEncodingFilter   
* 描述：  中文过滤器代码
* 创建人：jones   
* 创建时间：2018年7月16日 下午2:44:28   
* @version        
*/
public class CharacterEncodingFilter implements Filter {
	protected String encoding = null; // 定义编码格式变量
	protected FilterConfig filterConfig = null; // 定义过滤器配置对象

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig; // 初始化过滤器对象
		this.encoding = filterConfig.getInitParameter("encoding"); // 获取配置文件中指定的编码格式
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (encoding != null) {
			request.setCharacterEncoding(encoding);// 设置请求的编码
			response.setContentType("text/html;charset=" + encoding);
		}
		chain.doFilter(request, response); // 传递给下一个过滤器
	}

	@Override
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
}
