package edu.java.oper07;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		System.out.println("초간단 계산기");
		// double 타입의 숫자 2개를 입력받아서 저장
		// 두 수의 사칙연산(+, -, *, /)의 결과를 출력
		// 예시)
		// 1.0 + 2.0 = 3.0
		// 1.0 - 2.0 = -1.0
		// 1.0 * 2.0 = 2.0
		// 1.0 / 2.0 = 0.5
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자 입력 : ");
		double x = sc.nextDouble();
		
		System.out.println("두 번째 숫자 입력 : ");
		double y = sc.nextDouble();
	
		
		sc.close();
		
		double result; // 결과값 변수
		result = x + y;
		System.out.println(x + "+" + y + "=" + result);
		
		result = x - y;
		System.out.println(x + "-" + y + "=" + result);
		
		result = x * y;
		System.out.println(x + "*" + y + "=" + result);
		
		result = x / y;
		System.out.println(x + "/" + y + "=" + result);
		
			
				
		
		
		
		
	} // end main

} // end CalculatorMain
