package com.smates.dbc2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置允许跨域
 */
public class AccessAllowFilter implements Filter {
	/**
	 * 设置允许跨域，添加response 头标签Access-Control-Allow-Origin
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setHeader("Access-Control-Allow-Origin", "*");
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}