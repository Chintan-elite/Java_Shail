package com;

import org.springframework.stereotype.Component;

@Component
public class AddressInfo implements CustomerInfo{

	@Override
	public void basicInfo() {
		
		String name = "shail";
		String email = "shail@gmail.com";
		System.out.println(name+" "+email);
		
	}

}
