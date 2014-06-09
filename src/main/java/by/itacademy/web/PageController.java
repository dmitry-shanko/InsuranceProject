package main.java.by.itacademy.web;

import javax.servlet.http.HttpServletRequest;

import main.java.by.itacademy.resources.RequestConstants;
import main.java.by.itacademy.resources.Resources;
import main.java.by.itacademy.resources.SessionConstants;
import main.java.by.itacademy.service.exception.ServiceException;
import main.java.by.itacademy.service.insurance.InsuranceServiceFacadeI;
import main.java.by.itacademy.service.user.UserServiceFacadeI;
import main.java.by.itacademy.web.dto.InsuranceCalculator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController 
{
	private static final Logger log = Resources.getInstance().getLogger(main.java.by.itacademy.web.PageController.class);

	@Autowired
	private InsuranceServiceFacadeI is;

	@Autowired
	private UserServiceFacadeI us;

	@RequestMapping(value = "/mainpage", method = {RequestMethod.GET, RequestMethod.POST})
	public String showPages(Model model, HttpServletRequest request,
			@RequestParam(value = "id", required = false) String idpage_str,
			@RequestParam(value = "cartype", required = false) String cartype_req,
			@RequestParam(value = "carcountry", required = false) String carcountry_req,
			@RequestParam(value = "carvalue", required = false) String carvalue_req,
			@RequestParam(value = "term", required = false) String term_req,
			@RequestParam(value = "propiska", required = false) String propiska_req,
			@RequestParam(value = "driveage", required = false) String driverage_req,
			@RequestParam(value = "fio", required = false) String fio_req,
			@RequestParam(value = "adress", required = false) String adress_req,
			@RequestParam(value = "namecar", required = false) String namecar_req,
			@RequestParam(value = "vin", required = false) String vin_req,
			@RequestParam(value = "regnum", required = false) String regnum_req,
			@RequestParam(value = "onfirst", required = false) String onfirst_req,
			@RequestParam(value = "dtp", required = false) String dtp_req,
			@RequestParam(value = "k3", required = false) String k3_req)
	{
		try
		{
			String errormassage = null;			
			String sessionid = (String) request.getSession().getAttribute(SessionConstants.PREVSESSIONID_COOKIE.getContent());
			int idpage = Integer.parseInt(idpage_str);
			switch (idpage)
			{

			case 2:
				String cartype = cartype_req;
				String carcountry = carcountry_req;
				String carvalue = carvalue_req;
				String term = term_req;
				String propiska = propiska_req;
				String driverage = driverage_req;
				if (null == cartype || null == carcountry || null == carvalue || null == term || null == propiska || null == driverage)
				{
					if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag1())
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
						break;
					}
					errormassage = "error key";
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					break;
				}
				try
				{
					int cartype_int = Integer.parseInt(cartype);
					int carcountry_int = Integer.parseInt(carcountry);
					int carvalue_int = Integer.parseInt(carvalue);
					int term_int = Integer.parseInt(term);
					int propiska_int = Integer.parseInt(propiska);
					int driverage_int = Integer.parseInt(driverage);					
					if (is.compilerPart_1(cartype_int, carcountry_int, carvalue_int, term_int, propiska_int, driverage_int, sessionid))
					{	
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
					}
					else
					{
						if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag1())
						{
							model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
							break;
						}
						errormassage = "error key";	
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					}
				}
				catch (NumberFormatException e)
				{
					if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag1())
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
						break;
					}
					errormassage = "error key";
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					break;
				}
				break;

			case 3:
				if (null == is.getInsuranceCalculatorBySessionid(sessionid))
				{
					errormassage = "error key";	
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					break;
				}
				String fio = fio_req;
				String adress = adress_req;
				String namecar = namecar_req;
				String vin = vin_req;
				String regnum = regnum_req;
				String onfirst = onfirst_req;
				String dtp = dtp_req;
				String k3 = k3_req;
				if (null == fio || null == adress || null == namecar || null == vin || null == regnum || null == onfirst || null == dtp || null == k3)
				{
					if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag2())
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
						model.addAttribute(RequestConstants.INSURANCECALC_ATTRIBUTE.getContent(), is.getInsuranceCalculatorBySessionid(sessionid));
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
						break;
					}
					errormassage = "error key";
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
					break;
				}
				try
				{
					int onfirst_int = Integer.parseInt(onfirst);
					int dtp_int = Integer.parseInt(dtp);
					int k3_int = Integer.parseInt(k3);
					if (is.compilerPart_2(fio, adress, namecar, vin, regnum, onfirst_int, dtp_int, k3_int, sessionid))
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
						model.addAttribute(RequestConstants.INSURANCECALC_ATTRIBUTE.getContent(), is.getInsuranceCalculatorBySessionid(sessionid));
						break;
					}
					else
					{
						if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag2())
						{
							model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
							model.addAttribute(RequestConstants.INSURANCECALC_ATTRIBUTE.getContent(), is.getInsuranceCalculatorBySessionid(sessionid));
							model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
							break;
						}
						errormassage = "error key";
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
						break;						
					}
				}
				catch (NumberFormatException e)
				{
					if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag2())
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
						model.addAttribute(RequestConstants.INSURANCECALC_ATTRIBUTE.getContent(), is.getInsuranceCalculatorBySessionid(sessionid));
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
						break;
					}
					errormassage = "error key";
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
					break;
				}	

			case 4:
				if (null == is.getInsuranceCalculatorBySessionid(sessionid))
				{
					errormassage = "error key";	
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					break;
				}
				if (is.compilerPart_3(sessionid))
				{
					InsuranceCalculator ic = is.getInsuranceCalculatorBySessionid(sessionid);
					model.addAttribute(RequestConstants.PRICE1_ATTRIBUTE.getContent(), ic.getPrice1());
					model.addAttribute(RequestConstants.PRICE2_ATTRIBUTE.getContent(), ic.getPrice2());
					model.addAttribute(RequestConstants.PRICE3_ATTRIBUTE.getContent(), ic.getPrice3());
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 4);
					break;
				}
				else
				{
					if (null != is.getInsuranceCalculatorBySessionid(sessionid) && is.getInsuranceCalculatorBySessionid(sessionid).isFlag3())
					{
						InsuranceCalculator ic = is.getInsuranceCalculatorBySessionid(sessionid);
						model.addAttribute(RequestConstants.PRICE1_ATTRIBUTE.getContent(), ic.getPrice1());
						model.addAttribute(RequestConstants.PRICE2_ATTRIBUTE.getContent(), ic.getPrice2());
						model.addAttribute(RequestConstants.PRICE3_ATTRIBUTE.getContent(), ic.getPrice3());
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 4);
						break;
					}
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					break;
				}

			default:
				model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), idpage);
				break;
			}		
			model.addAttribute(RequestConstants.ERRORMASSAGE_ATTRIBUTE.getContent(), errormassage);
		}
		catch (NumberFormatException | NullPointerException e)
		{
			model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
		} 
		catch (ServiceException e) 
		{
			log.error("Error in trying to compiler Insurance through request params", e);
			model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
		}

		return "mainpage";
	}

	@RequestMapping(value = "/createnewinsurance", method = {RequestMethod.GET, RequestMethod.POST})
	public String createNewInsurance(Model model, HttpServletRequest request,
			@RequestParam(value = "optionsRadios", required = false) String idcompany_req)
	{
		String sessionid = (String) request.getSession().getAttribute(SessionConstants.PREVSESSIONID_COOKIE.getContent());
		try 
		{
			String idcompany = idcompany_req;
			if (null != idcompany)
			{
				int idcompany_int = Integer.parseInt(idcompany);
				if (is.compilerPart_4(sessionid, idcompany_int))
				{
					InsuranceCalculator ic = is.getInsuranceCalculatorBySessionid(sessionid);
					if (null != ic)
					{
						model.addAttribute(RequestConstants.IDINSURANCE_PAREMETER.getContent(), ic.getIdinsurance());
						model.addAttribute(RequestConstants.IDCOMPANY_PARAMETER.getContent(), ic.getIdcompany());
						return "end";
					}
					else
					{
						String errormassage = "error key";
						model.addAttribute(RequestConstants.ERRORMASSAGE_ATTRIBUTE.getContent(), errormassage);
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					}
				}
				else
				{
					return this.countPrevPageId(model, sessionid);
				}
			}
			else
			{
				return this.countPrevPageId(model, sessionid);
			}
		}
		catch (ServiceException e) 
		{
			log.error("Can't work with InsuranceService in " + getClass(), e);
		} 
		return "mainpage";		
	}

	@RequestMapping(value = "/addwrite", method = {RequestMethod.GET, RequestMethod.POST})
	public String addWriteInsurance(Model model, HttpServletRequest request)
	{
		String sessionid = (String) request.getSession().getAttribute(SessionConstants.PREVSESSIONID_COOKIE.getContent());
		try 
		{
			if (is.createNewInsurance(sessionid))
			{
				log.info("Insurance has been created");				
			}
		}
		catch (ServiceException e) 
		{
			log.error("Can't work with InsuranceService in " + getClass(), e);
		} 
		return "mainpage";
	}

	private String countPrevPageId(Model model, String sessionid)
	{
		if (null == sessionid || null == model)
		{
			return "mainpage";
		}
		String errormassage = "error key";
		InsuranceCalculator ic = is.getInsuranceCalculatorBySessionid(sessionid);
		model.addAttribute(RequestConstants.ERRORMASSAGE_ATTRIBUTE.getContent(), errormassage);
		if (null == ic)
		{
			model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
		}
		else
		{
			if (ic.isFlag1() && ic.isFlag2() && ic.isFlag3() && ic.isFlag4())
			{
				model.addAttribute(RequestConstants.IDINSURANCE_PAREMETER.getContent(), ic.getIdinsurance());
				model.addAttribute(RequestConstants.IDCOMPANY_PARAMETER.getContent(), ic.getIdcompany());
				return "end";
			}
			if (ic.isFlag3() && ic.isFlag2() && ic.isFlag1())
			{
				model.addAttribute(RequestConstants.PRICE1_ATTRIBUTE.getContent(), ic.getPrice1());
				model.addAttribute(RequestConstants.PRICE2_ATTRIBUTE.getContent(), ic.getPrice2());
				model.addAttribute(RequestConstants.PRICE3_ATTRIBUTE.getContent(), ic.getPrice3());
				model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 4);
			}
			else
			{
				if (ic.isFlag1() && ic.isFlag2())
				{
					model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 3);
				}
				else
				{
					if (ic.isFlag1())
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 2);
					}
					else
					{
						model.addAttribute(RequestConstants.PREVID_PARAMETER.getContent(), 1);
					}
				}
			}
		}
		return "mainpage";
	}



}
