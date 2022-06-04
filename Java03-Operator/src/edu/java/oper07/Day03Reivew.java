package edu.java.oper07;

import java.util.Scanner;

public class Day03Reivew {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초 간단 계산기");
		System.out.println("첫 번째 숫자 입력 : ");
		double x = sc.nextDouble();
		System.out.println("두 번째 숫자 입력 : ");
		double y = sc.nextDouble();
		
		sc.close();
		
		double result;
		result = x + y;
		System.out.println(x + "+" + y + "=" + result);
		
		result = x - y;
		System.out.println(x + "-" + y + "=" + result);

		result = x * y;
		System.out.println(x + "*" + y + "=" + result);
		
		
		result = x / y;
		System.out.println(x + "/" + y + "=" + result);
	}
	

}
