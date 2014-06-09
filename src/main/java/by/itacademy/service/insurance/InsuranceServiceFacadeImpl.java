package main.java.by.itacademy.service.insurance;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.itacademy.pojo.Insurance;
import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.service.exception.ServiceException;
import main.java.by.itacademy.web.dto.InsuranceCalculator;

@Service(value = "is")
public class InsuranceServiceFacadeImpl implements InsuranceServiceFacadeI
{

	@Autowired
	private InsuranceServiceI insuranceService;

	@Override
	public boolean compilerPart_1(int cartype, int carcountry, int carvalue, int term, int propiska, int driverage, String sessionid) throws ServiceException 
	{
		return insuranceService.compilerPart_1(cartype, carcountry, carvalue, term, propiska, driverage, sessionid);
	}

	@Override
	public boolean compilerPart_2(String fio, String adress, String namecar, String vin, String regnum, int onfirst, int dtp, int k3, String sessionid) throws ServiceException 
	{
		return insuranceService.compilerPart_2(fio, adress, namecar, vin, regnum, onfirst, dtp, k3, sessionid);
	}

	@Override
	public boolean compilerPart_3(String sessionid) throws ServiceException 
	{
		return insuranceService.compilerPart_3(sessionid);
	}

	@Override
	public boolean compilerPart_4(String sessionid, int idcompany) throws ServiceException 
	{
		return insuranceService.compilerPart_4(sessionid, idcompany);
	}

	@Override
	public boolean createNewInsurance(String sessionid) throws ServiceException 
	{
		return insuranceService.createNewInsurance(sessionid);
	}

	@Override
	public Set<Insurance> getInsurancesForUser(User user) throws ServiceException 
	{
		return insuranceService.getInsurancesForUser(user);
	}

	@Override
	public Insurance getInsuranceByLongIdAndIdCompany(Long idinsurance, int idcompany) throws ServiceException 
	{
		return insuranceService.getInsuranceByLongIdAndIdCompany(idinsurance, idcompany);
	}

	@Override
	public InsuranceCalculator getInsuranceCalculatorBySessionid(String sessionid) 
	{
		return insuranceService.getInsuranceCalculatorBySessionid(sessionid);
	}
}
