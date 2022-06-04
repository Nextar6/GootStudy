package alo.java.test00;

public class Person {
	private String name;
	
	public Person() {
		System.out.println("Person 부모 생성자");
	}

	public Person(String name) {
		super();
		this.name = name;
		System.out.println("Person의 부모 매개변수 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
