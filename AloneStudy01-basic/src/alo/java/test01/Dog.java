package alo.java.test01;

public class Dog extends Animal {
	private String type;

	public Dog() {
	}

	public Dog(String type, String name) {
		super(name);
		this.type = type;
	}

	
	public void speak() {
		System.out.println("멍멍");
	}

}
