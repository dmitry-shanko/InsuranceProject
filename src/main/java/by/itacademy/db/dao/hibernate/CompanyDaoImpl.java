package main.java.by.itacademy.db.dao.hibernate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import main.java.by.itacademy.db.dao.CompanyDao;
import main.java.by.itacademy.pojo.Company;

import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends GeneralDaoImpl<Company, Integer> implements CompanyDao
{
	private static final Lock singletoneLock = new ReentrantLock();
	private static CompanyDaoImpl instance;


	private CompanyDaoImpl()
	{

	}

	public static CompanyDaoImpl getInstance()
	{
		singletoneLock.lock();
		if (null == CompanyDaoImpl.instance)
		{
			CompanyDaoImpl.instance = new CompanyDaoImpl();
		}
		singletoneLock.unlock();
		return CompanyDaoImpl.instance;
	}

}
