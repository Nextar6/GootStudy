package edu.java.if02;

import java.util.Scanner;

public class IfMain02 {

	public static void main(String[] args) {
		System.out.println("if-else 문");
		// if(조건) {본문 A }
		// else {본문 B }
		// - 조건이 참이면 본문A가 실행되고 거짓이면 본문 B가 실행
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		
		if (x > 0) { // x가 0보다 크면 "양수"를 출력
			System.out.println("양수");
		} else { // 그게아니면 "0보다 크지 않음"을 출력
			System.out.println("0보다 크지 않음");
		}
		
		if (x != 0) {
			System.out.println("0이 아닌 정수");
		}
 		else {
		System.out.println("0입니다.");
		
	}
		// 만약 x가 0이 아니면 "0이 아닌 정수"를 출력
		
		
		
		// end main()

} } // end IfMain02
