package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Emp;


public class EmpDao {
	
	SessionFactory sf;
	public EmpDao() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Emp.class);
		sf = cfg.buildSessionFactory();
	}
	
	public void addemp(Emp e)
	{
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(e);
		tx.commit();
	}
}
