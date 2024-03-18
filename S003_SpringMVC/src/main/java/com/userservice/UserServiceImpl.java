package com.userservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.userdao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void addOrUpodateUser(User u) {
		userDao.addOrUpodateUser(u);
	}

	@Override
	public ArrayList<User> getAllUser() {
		
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

}
