package main.java.by.itacademy.resources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public final class Resources 
{
	private static final Lock singletoneLock = new ReentrantLock();
	private static Resources instance;
	private final String webinfPath = "\\WEB-INF\\classes\\resources";	
	private final String log4jPropertiesFileName = "\\log4j.properties";
	private final String propertiesFile = "\\xml\\xml.properties";
	private final String stringResources = "";
	private final String enumResources = "";	
	private final String hibernateConfiguratingFile = "resources\\hibernate.cfg.xml";
	private final String springConfiguratingFile = "resources\\spring-config.xml";
	private String path = "D:\\Java Projects\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\InsuranceProject\\WEB-INF\\classes\\resources";
	private boolean log4jconfigurated = true;
	private Lock configuratingLock = new ReentrantLock();

	private Resources()
	{

	}

	public static Resources getInstance()
	{
		singletoneLock.lock();
		if (null == Resources.instance)
		{
			Resources.instance = new Resources();
		}
		singletoneLock.unlock();
		return Resources.instance;
	}

	public void setPath(String path)
	{
		if (null != path)
		{
			this.path = path.concat(webinfPath);
		}
	}

	public String getPath()
	{
		return path;
	}

	public Logger getLogger(Class<?> clazz)
	{
		configuratingLock.lock();
		if (this.log4jconfigurated)
		{
			this.configurating();
		}
		configuratingLock.unlock();
		return Logger.getLogger(clazz);
	}

	public Logger getLogger(String name)
	{
		if (this.log4jconfigurated)
		{
			configuratingLock.lock();
			if (this.log4jconfigurated)
			{
				this.configurating();
			}
			configuratingLock.unlock();
		}
		return Logger.getLogger(name);
	}

	public String getEnumResources()
	{
		return enumResources;
	}

	public String getStringResources()
	{
		return stringResources;
	}

	public String getPropertiesFile()
	{
		return propertiesFile;
	}

	public String getHibernateConfiguratingFile()
	{
		return hibernateConfiguratingFile;
	}

	/**
	 * @return the springConfiguratingFile
	 */
	public String getSpringConfiguratingFile() {
		return springConfiguratingFile;
	}

	private void configurating()
	{		
		log4jconfigurated = false;
		PropertyConfigurator.configure(getPath().concat(log4jPropertiesFileName));
		Logger.getRootLogger().info("Log4jLogger has been configurated.");	
	}		
}

