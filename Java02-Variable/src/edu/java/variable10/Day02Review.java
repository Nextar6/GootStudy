package edu.java.variable10;

import java.util.Scanner;

public class Day02Review {

	public static void main(String[] args) {
		System.out.println("문자열 입력 받기");
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str1 = sc.nextLine();
		System.out.println(str1);
	
		char ch1 = str1.charAt(4);
		System.out.println(ch1);
		char ch2 = str1.charAt(str1.length() - 1);
				
	}

}
