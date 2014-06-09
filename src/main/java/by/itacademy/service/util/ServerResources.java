package main.java.by.itacademy.service.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import main.java.by.itacademy.service.exception.ServiceException;
import main.java.by.itacademy.web.dto.InsuranceCalculator;

public class ServerResources 
{
	private static final Lock singletoneLock = new ReentrantLock();
	private static ServerResources instance;
	private Lock mapLock = new ReentrantLock();
	private Map<String, InsuranceCalculator> insuranceCalculators;

	private ServerResources()
	{
		insuranceCalculators =  new HashMap<String, InsuranceCalculator>();
	}

	public static ServerResources getInstance() throws ServiceException
	{
		singletoneLock.lock();
		if (null == ServerResources.instance)
		{
			ServerResources.instance = new ServerResources();
		}
		singletoneLock.unlock();
		return ServerResources.instance;
	}

	public InsuranceCalculator getCalculatorBySessionid(String sessionid)
	{
		if (null != sessionid)
		{
			mapLock.lock();
			try
			{
				return insuranceCalculators.get(sessionid);
			}
			finally
			{
				mapLock.unlock();
			}
		}
		return null;
	}

	public void putInsuranceCalculator(String sessionid, InsuranceCalculator ic)
	{		
		if (null != ic && null != sessionid)
		{
			mapLock.lock();
			insuranceCalculators.put(sessionid, ic);
			mapLock.unlock();
		}		
	}
}
