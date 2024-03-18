package com.userservice;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.model.User;


public interface UserService {
	
	public void addOrUpodateUser(User u);
	public ArrayList<User> getAllUser();
	public User getUserById(int id);
	public void deleteUser(int id);
}
