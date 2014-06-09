package main.java.by.itacademy.db.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import main.java.by.itacademy.db.exception.DaoException;

public interface GeneralDao<T, ID extends Serializable>
{
	void setSessionFactory(SessionFactory sessionFactory);
	
	void delEntity(ID id) throws DaoException;

	void delEntity(T entity) throws DaoException;

	T saveOrUpdate(T entity) throws DaoException;

	T getEntityById(ID id) throws DaoException;

	List<T> findAll() throws DaoException;

	List<T> findAll(int langId) throws DaoException;
	
}
