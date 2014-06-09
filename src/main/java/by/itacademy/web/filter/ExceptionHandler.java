package main.java.by.itacademy.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.by.itacademy.resources.PageConstants;
import main.java.by.itacademy.resources.Resources;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

public class ExceptionHandler extends OncePerRequestFilter
{
	private static Logger log = Resources.getInstance().getLogger(main.java.by.itacademy.web.filter.ExceptionHandler.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException 
	{
		try 
		{
			filterChain.doFilter(request, response);
		} 
		catch (Exception e) 
		{
			log.error(e.getMessage(), e);
			redirect(request, response, e);
		}
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, Throwable ex) throws ServletException, IOException 
	{
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PageConstants.ERROR_DISPATCHER.getContent());
        dispatcher.forward(request, response);
    }
}
