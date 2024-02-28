package com;

public class Employee {
		
		int id;
		String name;
		String dept;
		double sal;
		
		public Employee(int id, String name, String dept, double sal) {
			
			this.id = id;
			this.name = name;
			this.dept = dept;
			this.sal = sal;
		}
		
		public void display()
		{
			System.out.println(id+" "+name+" "+dept+" "+sal);
		}
		
		
}
