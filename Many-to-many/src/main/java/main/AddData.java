package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.Subject;
import com.Teacher;


public class AddData {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Subject.class);
		cfg.addAnnotatedClass(Teacher.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
//		Teacher t = new Teacher();
//		t.setName("Xyz");
//		
//		Subject s1 = new Subject();
//		s1.setSname("java");
//		s1.addTeacher(t);
//		
//		
//		Subject s2 = new Subject();
//		s2.setSname("Php");
//		s2.addTeacher(t);
		
		
		Subject s1 = new Subject();
		s1.setSname("node");
		
		Teacher t = new Teacher();
		t.setName("tops");
		t.addSubject(s1);
		
		Teacher t1 = new Teacher();
		t1.setName("tech");
		t1.addSubject(s1);
		
		
		s.save(s1);
		s.save(t);
		s.save(t1);
		
		
		
		
		
		
		tx.commit();
		
		
	}
}
