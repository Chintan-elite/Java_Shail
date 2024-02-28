package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainclass {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext cx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Account a  = cx.getBean("savingAccount",Account.class);
		a.getbalnace();
		
		Account b = cx.getBean("current",Account.class);
		b.getbalnace();
		
		
		
		
		
	}
}
