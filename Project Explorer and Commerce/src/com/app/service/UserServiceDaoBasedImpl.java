package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojo.User;

@Service("UserService")
@Transactional
public class UserServiceDaoBasedImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	
	public User registerUser(User user) 
	{
		System.out.println("in user service");
		return dao.registerUser(user);
	}

	@Override
	public User validateUser(User user) {
		return dao.validateUser(user);
	}

	@Override
	public User getUserId(int id) {
		
		return dao.getUserId(id);
	}


	
	
}
