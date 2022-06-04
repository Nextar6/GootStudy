package edu.java.if03;

import java.util.Scanner;

public class IfMain03 {

	public static void main(String[] args) {
		System.out.println("if-else 문과 삼항 연산자");
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 숫자 입력 : ");
		int x =sc.nextInt();
		System.out.println("두 번째 숫자 입력 : ");
		int y =sc.nextInt();
		System.out.println("입력한 수 : " + x + "," + y);
		sc.close();
		
		// 입력된 x,y 중 더 큰 숫자를 저장하고 출력하기
		int big;
		if ( x > y) {
			big = x;
		}
			else {
			big = y;
		}
		System.out.println("큰 수 : " + big);
		System.out.println("===============");
		
		// 삼항 연산자 : (조건식) ?/ (값1) : (값2)
		// (조건식)이 참이면 (값1)을 선택
		// (조건식)이 거짓이면 (값2)를 선택
		int big2 = (x > y) ? x : y;
		System.out.println("big2 = " + big2);
		
		
	} // end main()

} // end IfMain03
