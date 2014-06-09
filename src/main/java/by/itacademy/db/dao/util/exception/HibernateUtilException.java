package main.java.by.itacademy.db.dao.util.exception;

import main.java.by.itacademy.db.exception.DaoException;

public class HibernateUtilException extends DaoException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HibernateUtilException()
	{
		super();
	}
	
	public HibernateUtilException(String s)
	{
		super(s);
	}
	
	public HibernateUtilException(Throwable e)
	{
		super(e);
	}
	
	public HibernateUtilException(String s, Throwable e)
	{
		super(s, e);
	}
}
