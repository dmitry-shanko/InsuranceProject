package main.java.by.itacademy.db.dao.factory;

import main.java.by.itacademy.db.dao.CompanyDao;
import main.java.by.itacademy.db.dao.InsuranceDao;
import main.java.by.itacademy.db.dao.RoleDao;
import main.java.by.itacademy.db.dao.UserDao;
import main.java.by.itacademy.db.dao.hibernate.CompanyDaoImpl;
import main.java.by.itacademy.db.dao.hibernate.RoleDaoImpl;
import main.java.by.itacademy.db.dao.hibernate.UserDaoImpl;
import main.java.by.itacademy.db.dao.hibernate.InsuranceDaoImpl;
import main.java.by.itacademy.db.exception.DaoException;

/**
 * Enum Factory for Dao. Uses dbfactory property from xml file to get proper Dao class.<p>
 * Uses special id to each RDBMS.
 * @author Dmitry Shanko
 *
 */
public enum DAOFactory
{
	MYSQL(1), ORACLE(2), COMMON(3), HIBERNATE(4);
	private int id;
	private static DAOFactory e = DAOFactory.COMMON;
	private DAOFactory(int id)
	{
		this.id = id;
	}
	/**
	 * Gets UserDao for DaoFactory enum. Enum must be chosen to get instance of Dao.
	 * @return Instance of proper UserDao
	 * @throws DaoException
	 */
	public UserDao getUserDao() throws DaoException 
	{
		switch(id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return UserDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No UserDao can be created for such Dao Factory enum");		
	}
	/**
	 * Gets InsuranceDao for DaoFactory enum. Enum must be chosen to get instance of Dao.
	 * @return Instance of proper InsuranceDao
	 * @throws DaoException
	 */
	public InsuranceDao getInsuranceDao() throws DaoException 
	{
		switch(id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return InsuranceDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No InsuranceDao can be created for such Dao Factory enum");	
	}
	/**
	 * Gets RoleDao for DaoFactory enum. Enum must be chosen to get instance of Dao.
	 * @return Instance of proper RoleDao
	 * @throws DaoException
	 */
	public RoleDao getRoleDao() throws DaoException
	{
		switch(id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return RoleDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No RoleDao can be created for such Dao Factory enum");	
	}
	/**
	 * Gets CompanyDao for DaoFactory enum. Enum must be chosen to get instance of Dao.
	 * @return Instance of proper CompanyDao
	 * @throws DaoException
	 */
	public CompanyDao getCompanyDao() throws DaoException
	{
		switch(id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return CompanyDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No CompanyDao can be created for such Dao Factory enum");	
	}
	/**
	 * This method must be used before calling any static method with "Initialized" in its names.<p>
	 * Takes id of DaoFactory enum and sets its value to private static variable. It makes possible to get concrete Dao without choosing enum.
	 * @param e DaoFactory enum to be set as static initializing variable
	 */
	public static void init(DAOFactory e)
	{
		if (null != e)
		{
			DAOFactory.e = e;
		}
	}
	/**
	 * Gets UserDao for initialized DaoFactory enum. Enum must be initialized in DaoFactory to get instance of Dao.
	 * @return Instance of proper UserDao
	 * @throws DaoException
	 */
	public static UserDao getInitializedUserDao() throws DaoException 
	{
		switch(DAOFactory.e.id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return UserDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No EmployeeDao can be created for such initialized Dao Factory enum. Or no EmployeeDao has been initialized yet.");		
	}
	/**
	 * Gets InsuranceDao for initialized DaoFactory enum. Enum must be initialized in DaoFactory to get instance of Dao.
	 * @return Instance of proper InsuranceDao
	 * @throws DaoException
	 */
	public static InsuranceDao getInitializedInsuranceDaoDao() throws DaoException 
	{
		switch(DAOFactory.e.id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return InsuranceDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No InsuranceDao can be created for such initialized Dao Factory enum. Or no InsuranceDao has been initialized yet.");	
	}
	/**
	 * Gets RoleDao for initialized DaoFactory enum. Enum must be initialized in DaoFactory to get instance of Dao.
	 * @return Instance of proper RoleDao
	 * @throws DaoException
	 */
	public static RoleDao getInitializedRoleDao() throws DaoException
	{
		switch(DAOFactory.e.id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return RoleDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No RoleDao can be created for such initialized Dao Factory enum. Or no RoleDao has been initialized yet.");	
	}
	/**
	 * Gets CompanyDao for initialized DaoFactory enum. Enum must be initialized in DaoFactory to get instance of Dao.
	 * @return Instance of proper CompanyDao
	 * @throws DaoException
	 */
	public static CompanyDao getInitializedCompanyDao() throws DaoException
	{
		switch(DAOFactory.e.id)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			return CompanyDaoImpl.getInstance();
		default:
			break;
		}
		throw new DaoException("No CompanyDao can be created for such initialized Dao Factory enum. Or no RoleDao has been initialized yet.");	
	}

}
