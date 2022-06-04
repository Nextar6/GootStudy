package edu.java.method05;

import java.util.Scanner;

public class MethodReivew {


	public static void main(String[] args) {
	
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력>");
		String n = sc.next();
		sayHello(n);;
		
		
		
	} // end main()

	public static void sayHello(String n) {
		System.out.println("안냥하세요 제이름은");
		System.out.println(n + "입니다.");
	
	}
} // end review
