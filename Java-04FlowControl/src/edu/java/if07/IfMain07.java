package edu.java.if07;

import java.util.Scanner;

public class IfMain07 {

	public static void main(String[] args) {
		System.out.println("if 중첩문 연습");
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.close();
		
		if(num % 2 == 0 ) { 
			System.out.println("짝수");// 짝수 일때
			if (num % 4 == 0) {
				System.out.println("4의 배수");
			}
		} else { 
			System.out.println("홀수");// 홀수 일 때
		}	
	} // end main()


}// end IfMain07
