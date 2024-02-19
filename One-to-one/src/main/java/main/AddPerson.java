package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Details;
import model.Person;

public class AddPerson {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Details.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		Person p = new Person();
		p.setName("Tops");
		p.setEmail("Tops@gmail.com");
		
		Details d = new Details();
		d.setPhno("9859685745");
		d.setAddress("Surat");
		d.setPerson(p);
		
		
		s.save(d);
		
		tx.commit();
		
		
		
		
		
		
		
		
		
		
	}
}
