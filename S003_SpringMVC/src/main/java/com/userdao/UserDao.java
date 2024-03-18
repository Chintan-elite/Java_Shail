package com.userdao;

import java.util.ArrayList;



import com.model.User;




public interface UserDao {
	
	public void addOrUpodateUser(User u);
	public ArrayList<User> getAllUser();
	public User getUserById(int id);
	public void deleteUser(int id);
}
