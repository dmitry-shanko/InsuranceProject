package main.java.by.itacademy.web.exception;

import javax.servlet.ServletException;

public class UIException extends ServletException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UIException()
	{
		super();
	}
	
	public UIException(String s)
	{
		super(s);
	}
	
	public UIException(String s, Throwable t)
	{
		super(s, t);
	}
	
	public UIException(Throwable t)
	{
		super(t);
	}
}
