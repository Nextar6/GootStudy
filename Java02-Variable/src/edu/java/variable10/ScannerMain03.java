package edu.java.variable10;

import java.util.Scanner;

public class ScannerMain03 {

	public static void main(String[] args) {
		System.out.println("문자열 입력 받기");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str1 = sc.nextLine();
		System.out.println(str1);
				
				// 입력 받은 문자 열에서 첫번째 글자 저장하는 방법
				char ch1 = str1.charAt(4);
				System.out.println(ch1);
				// 입력 받은 문자열에서 마지막 글자 저장법
				char ch2 = str1.charAt(str1.length() - 1);
		
	} // end main

} // end Scanner main03
