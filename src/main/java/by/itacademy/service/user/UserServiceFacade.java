package main.java.by.itacademy.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.itacademy.pojo.User;
import main.java.by.itacademy.service.exception.ServiceException;

@Service(value = "us")
public class UserServiceFacade implements UserServiceFacadeI
{

	@Autowired
	private UserServiceI userService;
	@Override
	public User getUser(String password, String email) throws ServiceException 
	{
		return userService.getUser(password, email);
	}

}
