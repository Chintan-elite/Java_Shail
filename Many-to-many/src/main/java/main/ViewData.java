package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.Subject;
import com.Teacher;


public class ViewData {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Subject.class);
		cfg.addAnnotatedClass(Teacher.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		List<Subject> list = s.createQuery("from Subject").list();
		
		for(Subject sub : list)
		{
			System.out.println(sub.getSname());
			for(Teacher t : sub.getTeachers())
			{
				System.out.println(t.getName());
			}
		}
		
		
	}
}
