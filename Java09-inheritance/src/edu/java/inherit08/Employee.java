package edu.java.inherit08;
// 2. 4  할차례

public class Employee {
	// 멤버 변수
	private String name;
	
	// 생성자
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
		
	}
	public void test() {
		System.out.println("직원");
	}
} // end Employee
