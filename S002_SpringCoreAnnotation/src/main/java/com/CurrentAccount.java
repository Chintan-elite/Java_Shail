package com;

import org.springframework.stereotype.Component;

@Component("current")
public class CurrentAccount implements Account {

	@Override
	public void getbalnace() {
		
		System.out.println("current account balance");
		
	}

}
