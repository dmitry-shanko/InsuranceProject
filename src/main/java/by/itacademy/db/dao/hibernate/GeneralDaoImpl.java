package main.java.by.itacademy.db.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

import main.java.by.itacademy.db.dao.GeneralDao;
import main.java.by.itacademy.db.exception.DaoException;


public abstract class GeneralDaoImpl<T, ID extends Serializable> implements GeneralDao<T, ID>
{
	private Class<T> persistentClass;
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public GeneralDaoImpl()
	{
		this.setPersistentClass((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		if (null != sessionFactory)
		{
			this.sessionFactory = sessionFactory;
		}
	}

	public Class<T> getPersistentClass() 
	{
		return persistentClass;
	}

	private void setPersistentClass(Class<T> arg)
	{
		this.persistentClass = arg;
	}

	@Override
	public void delEntity(ID id) throws DaoException 
	{
		if (id != null) 
		{
			try
			{
				Session session = getSession();
				@SuppressWarnings("unchecked")
				T t = (T) session.get(getPersistentClass(), id);
				session.delete(t);
				session.flush();
			}
			catch (HibernateException e)
			{
				throw new DaoException("Can't delete by id " + id + " in " + getClass() + " because of " + e.getClass() + ".\n", e);
			}
		}
	}

	@Override
	public void delEntity(T entity) throws DaoException {
		if (null != entity)
		{
			try
			{
				Session session = getSession();
				session.delete(entity); 
				session.flush();
			}
			catch (HibernateException e)
			{
				throw new DaoException("Can't delete Entity " + getPersistentClass() + " in " + getClass() + " because of " + e.getClass() + ".\n", e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityById(ID id) throws DaoException 
	{
		if (id == null) 
		{
			return null;
		}
		else
		{
			try
			{
				Session session = getSession();
				return (T) session.get(getPersistentClass(), id);
			}
			catch (HibernateException e)
			{
				throw new DaoException("Can't get Entity " + getPersistentClass() + " in " + getClass() + " because of " + e.getClass() + ".\n", e);
			}
		}
	}

	@Override
	public T saveOrUpdate(T entity) throws DaoException 
	{
		try
		{
			if (null != entity)
			{
				Session session = getSession();
				session.saveOrUpdate(entity);
				session.flush();
			}
		}
		catch (HibernateException e)
		{
			throw new DaoException("Can't saveOrUpdate Entity " + getPersistentClass() + " in " + getClass() + " because of " + e.getClass() + ".\n", e);
		}
		return entity;
	}

	@Override
	public List<T> findAll() throws DaoException
	{
		return findByCriteria();
	}

	@Override
	public List<T> findAll(int langId) throws DaoException 
	{
		// TODO Auto-generated method stub
		return null;

	}	

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) throws DaoException
	{		
		if (null != criterion)
		{
			try
			{
				Session session = getSession();
				Criteria crit = session.createCriteria(getPersistentClass());
				for (Criterion c : criterion) 
				{
					crit.add(c);
				}
				return crit.list();
			}
			catch (HibernateException e)
			{
				throw new DaoException("Can't find " + getPersistentClass() + " in " + getClass() + " because of " + e.getClass() + ".\n", e);
			}
		}
		else
		{
			return new ArrayList<T>(0);
		}
	}

	protected Session getSession() throws DaoException
	{
		Session session = null;
		if (null == sessionFactory)
		{
			throw new DaoException("SessionFactory is null, can't proceed");
		}
		else
		{
			try 
			{
				session = sessionFactory.getCurrentSession();
			} 
			catch (HibernateException e) 
			{
				try
				{
					e.printStackTrace();
					System.out.println("Open session?");
					session = sessionFactory.openSession();
//					session.beginTransaction();
				}
				catch (HibernateException e1)
				{
					throw new DaoException("Can't get current session from " + sessionFactory + " or open new session in " + getClass(), e1);
				}
			}
		}		
		return session;
	}
}
