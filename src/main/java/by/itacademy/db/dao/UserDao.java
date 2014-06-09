package main.java.by.itacademy.db.dao;

import main.java.by.itacademy.db.exception.DaoException;
import main.java.by.itacademy.pojo.User;

public interface UserDao extends GeneralDao<User, Integer>
{
	
	User getUserByEmail(String email, String password) throws DaoException;

}
