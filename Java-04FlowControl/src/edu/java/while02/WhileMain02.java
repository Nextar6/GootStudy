package edu.java.while02;

import java.util.Scanner;

public class WhileMain02 {

	public static void main(String[] args) {
		System.out.println("while 구구단 연습");
		
		
		// 구구단 2단을 while문을 사용하여 출력
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		sc.close();
		int i = 1;
		while ( i <=9) {
			System.out.println(dan + " X " + i + " = " + (dan * i));
			i++;
		}
		
		// 2 ~ 9 구구단 출력
		// 변수 초기화
		int d = 2;
		while(d <= 9) {
			System.out.println(d + "단");
			i = 1;
			while ( i <=9) {
				System.out.println(d + " X " + i + " = " + (d * i));
				i++;
			}
			d++;
		}
		
			//for 문으로 구구단 출력하기
			// 2~9단
		//곱하는 수 : 1 ~ 9
		for(int x = 2; x <=9; x++) {
			System.out.println(x + "단");
			for(int y = 1; y <= 9; y++) {
				System.out.println(x + " X " + y + " = " + (x * y));
			}
		}
		
		
	} // end main()

} // end WhileMain02
