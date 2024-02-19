package dao;

import java.util.ArrayList;

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

	public ArrayList<Emp> getAllEmp() {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		return (ArrayList<Emp>) s.createQuery("from Emp").list();
	}

	public void deleteEmp(int did) {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Emp e = s.get(Emp.class, did);
		s.delete(e);
		tx.commit();
	}

	public Emp getById(int did) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Emp e = s.get(Emp.class, did);
		return e;
	}
	
	
}
