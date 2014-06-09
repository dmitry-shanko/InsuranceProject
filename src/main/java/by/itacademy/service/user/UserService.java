package main.java.by.itacademy.service.user;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.by.itacademy.db.dao.UserDao;
import main.java.by.itacademy.db.exception.DaoException;
import main.java.by.itacademy.pojo.Company;
import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.resources.Resources;
import main.java.by.itacademy.service.exception.ServiceException;
/**
 * Singletone class to connect command wed layer with Dao layer. Contains logic of working with concrete calls to data base.
 * @author Dmitry Shanko
 *
 */
@Service(value="userService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserService implements UserServiceI
{
	private static final Resources res = Resources.getInstance();
	private static final Logger log = res.getLogger(main.java.by.itacademy.service.user.UserService.class);
	private static final Lock singletoneLock = new ReentrantLock();
	private static UserService instance;
	@Autowired
	private UserDao uDao;

	public UserService() throws ServiceException
	{
//		uDao = this.getUserDao();
	}

	public static UserService getInstance() throws ServiceException
	{
		singletoneLock.lock();
		if (null == UserService.instance)
		{
			UserService.instance = new UserService();
		}
		singletoneLock.unlock();
		return UserService.instance;
	}
	/**
	 * Takes User from UserDao by password and email.
	 * @param password
	 * @param email
	 * @return User by such criterias
	 * @throws ServiceException
	 */
	public User getUser(String password, String email) throws ServiceException
	{
		try 
		{					
			User user = uDao.getUserByEmail(email, password);
			if (null != user)
			{
				Set<Company> companies = user.getCompanies();
				companies.hashCode();
			}
			return user;			
		} 
		catch (DaoException e) 
		{
			log.error("Can't get user from " + uDao.getClass(), e);
			throw new ServiceException("Can't get user from " + uDao.getClass(), e);
		}	
	}

//	private UserDao getUserDao() throws ServiceException
//	{
//		try 
//		{
//			return DAOFactory.HIBERNATE.getUserDao();
//		} 
//		catch (DaoException e) 
//		{
//			throw new ServiceException("Can't get Hibernate UserDao", e);
//		}
//	}
}
