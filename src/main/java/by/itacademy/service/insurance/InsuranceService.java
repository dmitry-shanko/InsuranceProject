package main.java.by.itacademy.service.insurance;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import main.java.by.itacademy.db.dao.CompanyDao;
import main.java.by.itacademy.db.dao.InsuranceDao;
import main.java.by.itacademy.db.exception.DaoException;
import main.java.by.itacademy.pojo.Company;
import main.java.by.itacademy.pojo.Insurance;
import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.resources.Resources;
import main.java.by.itacademy.service.exception.ServiceException;
import main.java.by.itacademy.service.util.ServerResources;
import main.java.by.itacademy.web.dto.InsuranceCalculator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="insuranceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InsuranceService implements InsuranceServiceI
{
	private static final Resources res = Resources.getInstance();
	private static final Logger log = res.getLogger(main.java.by.itacademy.service.insurance.InsuranceService .class);
	private static final Lock singletoneLock = new ReentrantLock();
	private static InsuranceService  instance;
	@Autowired
	private InsuranceDao iDao;
	@Autowired
	private CompanyDao cDao;
	
	private ServerResources sr = ServerResources.getInstance();

	public InsuranceService () throws ServiceException
	{
//		iDao = this.getInsuranceDao();
//		cDao = this.getCompanyDao();
	}

	public static InsuranceService  getInstance() throws ServiceException
	{
		singletoneLock.lock();
		if (null == InsuranceService .instance)
		{
			InsuranceService .instance = new InsuranceService ();
		}
		singletoneLock.unlock();
		return InsuranceService .instance;
	}

	public boolean compilerPart_1(int cartype, int carcountry, int carvalue, int term, int propiska, int driverage, String sessionid) throws ServiceException
	{
		if((cartype < 1 || cartype > 7) || (carcountry < 1 || carcountry > 2) 
				|| (carvalue <1 || carvalue > 5) || (term < 1 || term > 13) 
				|| (propiska < 1 || propiska > 4) || (driverage < 1 || driverage > 4) || null == sessionid)
		{
			return false;
		}
		else
		{
			InsuranceCalculator ic = sr.getCalculatorBySessionid(sessionid);
			if (null == ic)
			{
				ic = new InsuranceCalculator();
				sr.putInsuranceCalculator(sessionid, ic);
			}
			ic.setCarcountry_int(carcountry);
			ic.setCartype_int(cartype);
			ic.setCarvalue_int(carvalue);
			ic.setDriverage_int(driverage);
			ic.setPropiska_int(propiska);
			ic.setTerm_int(term);
			ic.setFlag1(true);
			return true;
		}		
	}

	public boolean compilerPart_2(String fio, String adress, String namecar, String vin, String regnum, int onfirst, int dtp, int k3, String sessionid) throws ServiceException
	{
		if ((null == fio) || (null == adress) || (null == namecar) || (null == sessionid)
				|| (null == vin) || (null == regnum) || ((onfirst < 1) || (onfirst > 2)) || ((dtp < 1) || (dtp > 2)) || ((k3 < 1) || (k3 > 3))
				|| ((fio.length() < 3) || (adress.length() < 3) || (namecar.length() < 3) || (vin.length() < 3) || (regnum.length() < 3)))
		{
			return false;
		}
		else
		{
			InsuranceCalculator ic = sr.getCalculatorBySessionid(sessionid);
			if (null == ic)
			{
				return false;
			}
			ic.setFio(fio);
			ic.setAdress(adress);
			ic.setNamecar(namecar);
			ic.setVin(vin);
			ic.setRegnum(regnum);
			ic.setOnfirst_int(onfirst);
			ic.setDtp_int(dtp);
			ic.setK3_int(k3);
			ic.setFlag2(true);
			ic.calculate();
			return true;
		}
	}

	public boolean compilerPart_3(String sessionid) throws ServiceException
	{
		InsuranceCalculator ic = sr.getCalculatorBySessionid(sessionid);
		if (null == ic)
		{
			return false;
		}		
		if (ic.isFlag1() && ic.isFlag2())
		{
			ic.setFlag3(true);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean compilerPart_4(String sessionid, int idcompany) throws ServiceException
	{
		InsuranceCalculator ic = sr.getCalculatorBySessionid(sessionid);
		if (null == ic)
		{
			return false;
		}
		if (ic.isFlag1() && ic.isFlag2() && ic.isFlag3())
		{
			switch (idcompany) 
			{		
			case 1:
				ic.setPrice(ic.getPrice1());
				ic.setIdcompany(1);
				break;
			case 2:
				ic.setPrice(ic.getPrice2());
				ic.setIdcompany(2);
				break;
			case 3:
				ic.setPrice(ic.getPrice3());
				ic.setIdcompany(3);
				break;
			default:
				return false;
			}
			for (long i = 0; ; )
			{
				i = (long)(( (1_000_000_000_000L) * Math.random()) + 1_000_000_000_000L );
				try
				{
					if (iDao.collectInsurancesByLongId(i).size() == 0)
					{
						ic.setIdinsurance(i);
						ic.setFlag4(true);
						return true;
					}	
				}
				catch (DaoException e) 
				{
					e.printStackTrace();
					return false;
				}	
			} 
		}
		return false;
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean createNewInsurance(String sessionid) throws ServiceException
	{
		InsuranceCalculator ic = sr.getCalculatorBySessionid(sessionid);
		if (null == ic)
		{
			return false;
		}
		if (true == ic.isFlag1() && true == ic.isFlag2() && true == ic.isFlag3() && true == ic.isFlag4())
		{
			Insurance is = new Insurance();
			is.setFio(ic.getFio());
			is.setIdinsurance(ic.getIdinsurance());
			is.setPrice(ic.getPrice());
			Company company = null;
			try 
			{				
				company = cDao.getEntityById(ic.getIdcompany());
			} 
			catch (DaoException e) 
			{
				e.printStackTrace();
				return false;
			}
			if (null != company)
			{
				is.setCompany(company);
				try 
				{
					iDao.saveOrUpdate(is);
				} 
				catch (DaoException e) 
				{
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

	public Set<Insurance> getInsurancesForUser(User user) throws ServiceException
	{
		Set<Insurance> insurances = new HashSet<Insurance>();
		if (null != user)
		{
			try
			{
				for (Company c : user.getCompanies())
				{
					insurances.addAll(iDao.collectInsurancesByCompany(c));
				}	
			}
			catch (DaoException e) 
			{
				log.error("Can't get user from " + iDao.getClass(), e);
				throw new ServiceException("Can't get user from " + iDao.getClass(), e);
			}
		}
		return insurances;
	}

	public Insurance getInsuranceByLongIdAndIdCompany(Long idinsurance, int idcompany) throws ServiceException
	{
		Insurance i = null;
		if (null != idinsurance && idcompany > 0 && idinsurance > 1)
		{
			try 
			{				
				Company comp = cDao.getEntityById(idcompany);
				if (null != comp)
				{

					i = iDao.getInsuranceByLongIdAndCompany(idinsurance, comp);
				}
			}
			catch (DaoException e) 
			{
				log.error("Can't get user from " + iDao.getClass(), e);
				throw new ServiceException("Can't get user from " + iDao.getClass(), e);
			}			
		}
		return i;
	}

//	private InsuranceDao getInsuranceDao() throws ServiceException
//	{
//		try 
//		{
//			return DAOFactory.HIBERNATE.getInsuranceDao();
//		} 
//		catch (DaoException e) 
//		{
//			throw new ServiceException("Can't get Hibernate InsuranceDao", e);
//		}
//	}
//
//	private CompanyDao getCompanyDao() throws ServiceException
//	{
//		try 
//		{
//			return DAOFactory.HIBERNATE.getCompanyDao();
//		} 
//		catch (DaoException e) 
//		{
//			throw new ServiceException("Can't get Hibernate InsuranceDao", e);
//		}
//	}

	public InsuranceCalculator getInsuranceCalculatorBySessionid(String sessionid)
	{
		return sr.getCalculatorBySessionid(sessionid);
	}
}
