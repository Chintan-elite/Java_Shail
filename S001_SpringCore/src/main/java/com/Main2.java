package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		
		Employee e = (Employee) context.getBean("emp");
		
		e.display();
		
		
		}
}
