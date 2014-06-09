package main.java.by.itacademy.db.dao.util;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: Maksim
 * Date: 11.06.13
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class CustomNamingStrategy extends DefaultNamingStrategy
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String classToTableName(String className)
	{
		return "T_" + super.classToTableName(className).toUpperCase();
	}
	
	public String propertyToColumnName(String proName)
	{
		return "F_" + super.propertyToColumnName(proName);
	}
	
	public String columnName(String columnName)
	{
		return columnName;
	}
	
	public String tableName(String tableName)
	{
		return tableName;
	}
}
