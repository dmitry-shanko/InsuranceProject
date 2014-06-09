package main.java.by.itacademy.db.dao;

import java.util.List;

import main.java.by.itacademy.db.exception.DaoException;
import main.java.by.itacademy.pojo.Company;
import main.java.by.itacademy.pojo.Insurance;


public interface InsuranceDao extends GeneralDao<Insurance, Integer>
{
	List<Insurance> collectInsurancesByCompany(Company company) throws DaoException;
	List<Insurance> collectInsurancesByLongId(Long id) throws DaoException;
	Insurance getInsuranceByLongIdAndCompany(Long id, Company company) throws DaoException;
}
