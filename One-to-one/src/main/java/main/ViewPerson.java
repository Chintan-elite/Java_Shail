package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Details;
import model.Person;

public class ViewPerson {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Details.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		List<Person> allp =  s.createQuery("from Person").list();
		
		
		for(Person p : allp)
		{
			System.out.println(p.getId()+" "+p.getName()+" "+p.getEmail()+" "+p.getDetails().getPhno()+" "+p.getDetails().getAddress());
		}
		
		
		
		
		
		
	}
}
