package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SavingAccount implements Account{

	@Autowired
	@Qualifier("personalInfo")
	CustomerInfo customerInfo;
	
	@Override
	public void getbalnace() {
		
		customerInfo.basicInfo();
		System.out.println("saving account balance");
		
	}

}
