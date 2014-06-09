package main.java.by.itacademy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.resources.RequestConstants;
import main.java.by.itacademy.resources.Resources;
import main.java.by.itacademy.resources.SessionConstants;
import main.java.by.itacademy.service.exception.ServiceException;
import main.java.by.itacademy.service.insurance.InsuranceServiceFacadeI;
import main.java.by.itacademy.service.user.UserServiceFacadeI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "/admin")
public class AdminController 
{
	private static final Logger log = Resources.getInstance().getLogger(main.java.by.itacademy.web.AdminController.class);
	@Autowired
	private UserServiceFacadeI us;

	@Autowired
	private InsuranceServiceFacadeI is;

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String showLogin(Model model)
	{
		return "signin";
	}

	@RequestMapping(value = "/login.form", method = {RequestMethod.GET, RequestMethod.POST})
	public String loggin(Model model, HttpServletRequest request,
			@RequestParam(value = "pass", required = true) String pass_req,
			@RequestParam(value = "email", required = true) String email_req)
	{
		logout(model, request);
		String pass = pass_req;
		String email = email_req;
		System.out.println("password:" + pass);
		System.out.println("email:" + email);
		try
		{
			User user = us.getUser(pass, email);
			if (null != user)
			{
				request.getSession().setAttribute(SessionConstants.LOGIN_ATTRIBUTE.getContent(), user);
				return showAdmin(model, request);
			}
		}
		catch (ServiceException e)
		{
			log.error("Can't get User from UserService", e);			
		}
		return "signin";
	}

	@RequestMapping(value = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
	public String showAdmin(Model model, HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(SessionConstants.LOGIN_ATTRIBUTE.getContent());
		if (null != user && (user.getRole().getId() == 1 || user.getRole().getId() == 2))
		{
			return "admin";
		}
		else
		{
			return showLogin(model);
		}
	}

	@RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
	public String search(Model model, HttpServletRequest request,
			@RequestParam(value = "idcompany", required = false) String idcompany_req,
			@RequestParam(value = "idinsurance", required = false) String idinsurance_req)
	{
		User user = (User) request.getSession().getAttribute(SessionConstants.LOGIN_ATTRIBUTE.getContent());
		if (null != user && (user.getRole().getId() == 1 || user.getRole().getId() == 2))
		{
			String idcompany = idcompany_req;
			String idinsurance = idinsurance_req;
			try
			{
				if (null != idcompany && null != idinsurance)
				{
					try
					{
						int idcompany_int = Integer.parseInt(idcompany);
						long idinsurance_long = Long.parseLong(idinsurance.trim());
						model.addAttribute(RequestConstants.SEARCHINSURANCE_ATTRIBUTE.getContent(), is.getInsuranceByLongIdAndIdCompany(idinsurance_long, idcompany_int));
					}
					catch (NumberFormatException e)
					{
						log.info("Incorrect parameters came in " + getClass());
					}
				}
			}
			catch (ServiceException e)
			{
				log.error("Service can't get any Insurance.", e);
			}
			return "result";
		}
		return showLogin(model);
	}

	@RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String loggout(Model model, HttpServletRequest request)
	{
		logout(model, request);
		return "mainpage";
	}
	
//	@RequestMapping(value = "*", method = {RequestMethod.GET, RequestMethod.POST})
//	public String others(Model model)
//	{
//		System.out.println("others");
//		return "mainpage";
//	}


	private void logout(Model model, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		for (SessionConstants sc : SessionConstants.values())
		{
			if (!sc.equals(SessionConstants.LANG_ATTRIBUTE))
			{
				session.removeAttribute(sc.getContent());
			}
		}
		return;
	}
}
