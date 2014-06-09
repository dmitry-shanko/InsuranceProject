package main.java.by.itacademy.db.dao.hibernate;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import main.java.by.itacademy.db.dao.UserDao;
import main.java.by.itacademy.db.dao.fields.UserFileds;
import main.java.by.itacademy.db.exception.DaoException;
import main.java.by.itacademy.pojo.User;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<User, Integer> implements UserDao
{
	private static final Lock singletoneLock = new ReentrantLock();
	private static UserDaoImpl instance;


	private UserDaoImpl()
	{

	}

	public static UserDaoImpl getInstance()
	{
		singletoneLock.lock();
		if (null == UserDaoImpl.instance)
		{
			UserDaoImpl.instance = new UserDaoImpl();
		}
		singletoneLock.unlock();
		return UserDaoImpl.instance;
	}

	@Override
	public User getUserByEmail(String email, String password) throws DaoException 
	{
		List<User> users = findByCriteria(Restrictions.eq(UserFileds.email.name(), email), Restrictions.eq(UserFileds.password.name(), password) );
		if (users.size() > 0)
		{
			return users.get(0);
		}
		else
		{
			return null;
		}
	}
}
