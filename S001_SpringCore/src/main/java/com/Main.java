package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student st = (Student) context.getBean("std");
		//System.out.println(st.getId()+" "+st.getEmail()+" "+st.getEmail());
		st.display();
		
		}
}
