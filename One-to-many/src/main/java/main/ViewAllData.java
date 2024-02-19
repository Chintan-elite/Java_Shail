package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;

public class ViewAllData {
		
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Category.class);
		cfg.addAnnotatedClass(Product.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		List<Category> cat = s.createQuery("from Category").list();
		
		for(Category c : cat)
		{
			System.out.println(c.getCatname());
			for(Product p : c.getProducts())
			{
				System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
			}
		}
		
		
		
	}
}
