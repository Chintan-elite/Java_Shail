package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;


public class AddData2 {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(Product.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Category c =s.load(Category.class, 2);
		
		
		Product p1 = new Product();
		p1.setPname("Radio");
		p1.setPrice(5000);
		p1.setQty(10);
		p1.setCategory(c);
		
		Product p2 = new Product();
		p2.setPname("Laptop");
		p2.setPrice(100);
		p2.setQty(2);
		p2.setCategory(c);
		
		
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		
		
	}
}
