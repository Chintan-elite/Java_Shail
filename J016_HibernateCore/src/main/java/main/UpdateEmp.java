package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class UpdateEmp {
	public static void main(String[] args) {
		
		
		Employee e = new Employee();
		e.setId(1);
		e.setName("topstech");
		e.setEmail("tops@yahoo.com");
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.saveOrUpdate(e);
		
		tx.commit();
		
		
		
		
	}
}
