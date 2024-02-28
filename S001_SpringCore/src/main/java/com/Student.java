package com;

import java.util.List;
import java.util.Set;

public class Student {
	
	int id;
	String name;
	String email;
	List<String> sub;
	Set<String> hobbies;
	Address adr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getSub() {
		return sub;
	}
	public void setSub(List<String> sub) {
		this.sub = sub;
	}
	
	
	public Set<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	public void display()
	{
		System.out.println(id+" "+name+" "+email);
		System.out.println("*****Subjects*****");
		for(String s : sub)
		{
			System.out.println(s);
		}
		System.out.println("*****Hobbies*****");
		for(String h : hobbies)
		{
			System.out.println(h);
		}
		adr.show();
	}
}
