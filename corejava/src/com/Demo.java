package com;

class Student
{
	static int id = 50;
	String name = "test";
	
	public void display()
	{
		System.out.println(id+" "+name);
	}
}

public class Demo {
	public static void main(String[] args) {
		
		Student st = new Student();
		st.display();
		
		Student st1 = new Student();
		st1.id=50;
		st1.display();
		
		Student st2 = new Student();
		st2.display();
		
//		final int a = 50;
//		a = 100;
//		System.out.println(a);
		
	}
}
