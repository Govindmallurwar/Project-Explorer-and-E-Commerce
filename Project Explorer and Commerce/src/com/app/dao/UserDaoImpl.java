package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.User;



@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	public SessionFactory factory;
	
	@Override
	public User registerUser(User user) 
	{
		System.out.println("in user dao"+user);
		if(user.getCategory().equals("Vendor"))
			user.setFlag(0);
		else
			user.setFlag(1);
		
		System.out.println("user pojo from dao"+user);
		factory.getCurrentSession().saveOrUpdate(user);
		
		return user;
	}

	@Override
	public User validateUser(User user) {
	    return (User) factory.getCurrentSession().createQuery("select u from User u where u.userName=:un and u.password=:pass").setParameter("un",user.getUserName()).setParameter("pass",user.getPassword()).uniqueResult();	
	}

	@Override
	public User getUserId(int id) {
		
		return (User) factory.getCurrentSession().get(User.class,id);
	}
}
