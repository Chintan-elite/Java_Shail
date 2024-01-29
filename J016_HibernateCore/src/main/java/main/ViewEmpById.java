package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class ViewEmpById {
	public static void main(String[] args) {
		
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx  =s.beginTransaction();
		
		
		Employee e =  s.get(Employee.class, 2);
		
		System.out.println(e.getId()+" "+e.getName()+" "+e.getEmail());
		
		
		
	}
}
