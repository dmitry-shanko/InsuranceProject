package main.java.by.itacademy.db.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import main.java.by.itacademy.db.dao.InsuranceDao;
import main.java.by.itacademy.db.dao.fields.InsuranceFields;
import main.java.by.itacademy.db.exception.DaoException;
import main.java.by.itacademy.pojo.Company;
import main.java.by.itacademy.pojo.Insurance;

@Repository
public class InsuranceDaoImpl extends GeneralDaoImpl<Insurance, Integer> implements InsuranceDao
{
	private static final Lock singletoneLock = new ReentrantLock();
	private static InsuranceDaoImpl instance;

	private InsuranceDaoImpl()
	{

	}	

	public static InsuranceDaoImpl getInstance()
	{
		singletoneLock.lock();
		if (null == InsuranceDaoImpl.instance)
		{
			InsuranceDaoImpl.instance = new InsuranceDaoImpl();
		}
		singletoneLock.unlock();
		return InsuranceDaoImpl.instance;
	}

	@Override
	public Insurance saveOrUpdate(Insurance entity) throws DaoException 
	{
		try
		{
			if (null != entity)
			{
				Session session = getSession();
				if (collectInsurancesByLongId(entity.getIdinsurance()).size() == 0)
				{
					session.saveOrUpdate(entity);
					session.flush();
				}
			}
		}
		catch (HibernateException e)
		{
			throw new DaoException("Can't saveOrUpdate Entity " + getPersistentClass() + " in " + getClass() + " because of " + e.getClass() + ".\n", e);
		}
		return entity;
	}

	@Override
	public List<Insurance> collectInsurancesByCompany(Company company) throws DaoException 
	{
		if (null != company)
		{
			return findByCriteria(Restrictions.eq(InsuranceFields.company.name(), company));
		}
		else
		{
			return new ArrayList<Insurance>();
		}
	}

	@Override
	public List<Insurance> collectInsurancesByLongId(Long id) throws DaoException 
	{
		if (null != id)
		{
			return findByCriteria(Restrictions.eq(InsuranceFields.idinsurance.name(), id));
		}
		else
		{
			return new ArrayList<Insurance>();
		}
	}

	@Override
	public Insurance getInsuranceByLongIdAndCompany(Long id, Company company) throws DaoException 
	{
		if (null != id && null != company)
		{
			List<Insurance> results = findByCriteria(Restrictions.eq(InsuranceFields.idinsurance.name(), id), Restrictions.eq(InsuranceFields.company.name(), company));
			if (null != results && results.size() > 0)
			{
				return results.get(0);
			}
		}
		return null;
	}
}
