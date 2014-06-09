package main.java.by.itacademy.db.dao.hibernate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Repository;

import main.java.by.itacademy.db.dao.RoleDao;
import main.java.by.itacademy.pojo.Role;

@Repository
public class RoleDaoImpl extends GeneralDaoImpl<Role, Integer> implements RoleDao
{
	private static final Lock singletoneLock = new ReentrantLock();
	private static RoleDaoImpl instance;
	
	
	private RoleDaoImpl()
	{
		
	}

	public static RoleDaoImpl getInstance()
	{
		singletoneLock.lock();
		if (null == RoleDaoImpl.instance)
		{
			RoleDaoImpl.instance = new RoleDaoImpl();
		}
		singletoneLock.unlock();
		return RoleDaoImpl.instance;
	}
}
