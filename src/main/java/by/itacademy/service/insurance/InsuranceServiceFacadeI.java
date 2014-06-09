package main.java.by.itacademy.service.insurance;

import java.util.Set;

import main.java.by.itacademy.pojo.Insurance;
import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.service.exception.ServiceException;
import main.java.by.itacademy.web.dto.InsuranceCalculator;

public interface InsuranceServiceFacadeI 
{

	boolean compilerPart_1(int cartype, int carcountry, int carvalue, int term, int propiska, int driverage, String sessionid) throws ServiceException;

	boolean compilerPart_2(String fio, String adress, String namecar, String vin, String regnum, int onfirst, int dtp, int k3, String sessionid) throws ServiceException;

	boolean compilerPart_3(String sessionid) throws ServiceException;

	boolean compilerPart_4(String sessionid, int idcompany) throws ServiceException;

	boolean createNewInsurance(String sessionid) throws ServiceException;

	Set<Insurance> getInsurancesForUser(User user) throws ServiceException;

	Insurance getInsuranceByLongIdAndIdCompany(Long idinsurance, int idcompany) throws ServiceException;

	InsuranceCalculator getInsuranceCalculatorBySessionid(String sessionid);
}
