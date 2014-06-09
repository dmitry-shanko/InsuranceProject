package main.java.by.itacademy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import main.java.by.itacademy.resources.PageConstants;

public class RedirectFilter implements Filter
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain arg2) throws IOException, ServletException 
	{

		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(PageConstants.MAINPAGE_DISPATCHER.getContent()); 
		dispatcher.forward(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
