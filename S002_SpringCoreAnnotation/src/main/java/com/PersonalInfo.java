package com;

import org.springframework.stereotype.Component;

@Component
public class PersonalInfo implements CustomerInfo{

	@Override
	public void basicInfo() {
		
		System.out.println("personal info");
		
	}

}
