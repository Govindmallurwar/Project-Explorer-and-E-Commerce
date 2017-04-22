package com.app.service;

import java.util.List;

import com.app.pojo.User;


public interface UserService {
	User registerUser(User user);
	User validateUser(User user);
	User getUserId(int id);
}
