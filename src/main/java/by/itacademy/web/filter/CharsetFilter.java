package main.java.by.itacademy.web.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.by.itacademy.resources.SessionConstants;

public class CharsetFilter implements Filter
{
	private final String content = "utf-8";

	@Override
	public void init(FilterConfig config) throws ServletException 
	{

	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain next) throws IOException, ServletException 
	{
		Locale.setDefault(Locale.US);
		request.setCharacterEncoding(content);
		response.setCharacterEncoding(content);
		if (request instanceof HttpServletRequest)
		{
			HttpServletRequest thisRequest = ((HttpServletRequest)request);
			Cookie[] cookies = thisRequest.getCookies();
			if (null != cookies)
			{
				boolean session = false;
				for (Cookie cookie : cookies)
				{
					if (SessionConstants.LANG_ATTRIBUTE.getContent().equals(cookie.getName()))
					{
						String lang = cookie.getValue();
						if (null != lang && (lang.matches("ru_RU") || lang.matches("en_US")))
						{						
							thisRequest.getSession().setAttribute(SessionConstants.LANG_ATTRIBUTE.getContent(), lang);
						}
					}
					if (SessionConstants.PREVSESSIONID_COOKIE.getContent().equals(cookie.getName()))
					{
						String prevsessionid = cookie.getValue();
						if (null != prevsessionid && prevsessionid.length() > 5)
						{
							thisRequest.getSession().setAttribute(SessionConstants.PREVSESSIONID_COOKIE.getContent(), prevsessionid);
							session = true;
							Cookie newCookie = new Cookie(SessionConstants.PREVSESSIONID_COOKIE.getContent(), prevsessionid);
							newCookie.setMaxAge(60);
							((HttpServletResponse)response).addCookie(newCookie);
						}
					}
					if (!session)
					{
						thisRequest.getSession().setAttribute(SessionConstants.PREVSESSIONID_COOKIE.getContent(), thisRequest.getSession().getId());
						Cookie newCookie = new Cookie(SessionConstants.PREVSESSIONID_COOKIE.getContent(), thisRequest.getSession().getId());
						newCookie.setMaxAge(60);
						((HttpServletResponse)response).addCookie(newCookie);
					}
				}				
			}
		}
		response.setCharacterEncoding(content);
		next.doFilter(request, response);		
	}

	@Override
	public void destroy() 
	{

	}
}
