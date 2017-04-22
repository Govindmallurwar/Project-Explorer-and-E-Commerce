package com.app.dao;

import com.app.pojo.User;

public interface UserDao {
	
 User registerUser(User user);
 User validateUser(User user);
 User getUserId(int id);
}
