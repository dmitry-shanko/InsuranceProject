package main.java.by.itacademy.service.user;

import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.service.exception.ServiceException;

public interface UserServiceFacadeI
{
	User getUser(String password, String email) throws ServiceException;
	
}
