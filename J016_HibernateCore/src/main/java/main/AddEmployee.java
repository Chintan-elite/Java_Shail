package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class AddEmployee {
	public static void main(String[] args) {
		
		
		Employee e = new Employee();
		e.setName("xyz");
		e.setEmail("xyz@gmail.com");
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(e);
		
		tx.commit();
		
		
		
		
	}
}
