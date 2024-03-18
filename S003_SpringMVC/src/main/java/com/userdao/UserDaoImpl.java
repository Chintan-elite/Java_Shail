package com.userdao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;




@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addOrUpodateUser(User u) {
		
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(u);
	}

	@Override
	public ArrayList<User> getAllUser() {
		
		return null;
	}

	@Override
	public User getUserById(int id) {
		
		return null;
	}

	@Override
	public void deleteUser(int id) {
		
		
	}

}
