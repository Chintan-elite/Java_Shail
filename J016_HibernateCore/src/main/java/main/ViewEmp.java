package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class ViewEmp {
	public static void main(String[] args) {
		
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx  =s.beginTransaction();
		
		
		List<Employee> emp =   s.createQuery("from Employee").list();
		
		for(Employee e : emp)
		{
			System.out.println(e.getId()+" "+e.getName()+" "+e.getEmail());
				
		}
		
		
		
		
	}
}
