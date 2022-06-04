package edu.java.if04;

import java.util.Scanner;

public class IfMain04 {

	public static void main(String[] args) {
		System.out.println("if - else if - else");
		// ctrl + shift + f : 자동 줄맞춤

		// if(조건1) { 본문 A}
		// else if(조건2) { 본문 B }
		// ...
		// else { 본문 C }
		
		// - 조건1이 참인 경우 본문A, 조건2가 참인 경우 본문B, 둘다 아닐경우 본문 C
		// - else if 절은 1개 이상 작성 가능
		
		// 1. 정수 하나를 입력받음
		// 2. 0보다 크면 "양수", 0이면 "0", 0보다 작으면 "음수"를 출력하는 코드 작성
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if (x > 0) {
			System.out.println("양수");
		}
		else if ( x == 0) {
			System.out.println("0");
		}	
		else { 
			System.out.println("음수");
		}
			
		// else는 else if (x < 0)으로 대체 가능
			
		
	} // end main()

} // end IfMain04
