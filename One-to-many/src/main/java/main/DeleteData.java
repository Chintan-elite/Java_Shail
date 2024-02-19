package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;

public class DeleteData {
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(Product.class);
	
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
//		Category c = s.load(Category.class, 3);
//		s.delete(c);
		
		Product p = s.load(Product.class, 6);
		s.delete(p);
		
		
		
		tx.commit();
		
		
		
	}
}
