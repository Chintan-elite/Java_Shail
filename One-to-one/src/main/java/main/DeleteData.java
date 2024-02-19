package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Details;
import model.Person;

public class DeleteData {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Details.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		Person p =  s.load(Person.class, 1);
		s.delete(p);
		
		
		tx.commit();
		
		
		
		
		
		
		
		
		
		
	}
}
