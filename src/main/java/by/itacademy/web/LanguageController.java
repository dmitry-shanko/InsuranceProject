package main.java.by.itacademy.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.by.itacademy.resources.RequestConstants;
import main.java.by.itacademy.resources.SessionConstants;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("lang")
public class LanguageController 
{

	@RequestMapping(value = "*/language", method = {RequestMethod.GET, RequestMethod.POST})
	public String changeLanguage(HttpServletResponse servletResponse, HttpServletRequest request, Model model, 
			@ModelAttribute String lang,
			@RequestParam(value = "lang", required = true) String lang_str,
			@RequestParam(value = "id", required = false) String id_req,
			@RequestParam(value = "page", required = false) String page)
	{	
		if (null != lang_str)
		{
			lang = lang_str.toLowerCase().trim();
			if (null != lang && (lang.matches("ru") || lang.matches("en")))
			{
				switch(lang)
				{
				case "ru":
					lang = lang.concat("_RU");
					break;
				case "en":
					lang = lang.concat("_US");
					break;
				}
				model.addAttribute(SessionConstants.LANG_ATTRIBUTE.getContent(), lang);
				int day = 60 * 60 * 24;
				Cookie cookie = new Cookie(SessionConstants.LANG_ATTRIBUTE.getContent(), lang);
				cookie.setMaxAge(day);
				servletResponse.addCookie(cookie);
			}
		}				
		if (null != page)
		{
			for (Pages p : Pages.values())
			{
				if (p.toString().equals(page))
				{
					switch(p)
					{
					case mainpage:
						return "redirect:/mainpage?id=" + id_req;
					case end:
						return "redirect:/createnewinsurance";
					default:
						return page;
					}
				}				
			}
		}
		if (null != id_req)
		{
			model.addAttribute(RequestConstants.ID_PARAMETER.getContent(), id_req);
		}
		return Pages.mainpage.toString();
	}	
	
	@RequestMapping(value = "/language", method = {RequestMethod.GET, RequestMethod.POST})
	public String changeLanguageMainpage(HttpServletResponse servletResponse, HttpServletRequest request, Model model, 
			@ModelAttribute String lang,
			@RequestParam(value = "lang", required = true) String lang_str,
			@RequestParam(value = "id", required = false) String id_req,
			@RequestParam(value = "page", required = false) String page)
	{	
		return changeLanguage(servletResponse, request, model, lang, lang_str, id_req, page);
	}	

	private enum Pages
	{
		admin, 
		mainpage,
		signin,
		print,
		end,
		;
	}
}
