package main.java.by.itacademy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface Wrapper 
{
	HttpServletRequest getRequest();
	HttpServletResponse getResponse();
	HttpSession getSession();


}
