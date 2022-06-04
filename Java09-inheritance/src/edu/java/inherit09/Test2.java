package edu.java.inherit09;

public class Test2 extends Test1{
	@Override
	public void display() {
//		System.out.println("a = " + a); private 선언이라 불능
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("b = " + d);
		}

}
