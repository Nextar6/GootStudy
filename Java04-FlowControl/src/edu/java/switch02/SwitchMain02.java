package edu.java.switch02;

import java.util.Scanner;

public class SwitchMain02 {

	public static void main(String[] args) {
		System.out.println("switch문 연습");
		//대 소문자 구분 없이 입력된 a, b, c에 따라 등급 출력
		Scanner sc = new Scanner(System.in);
		char grade = sc.nextLine().charAt(0);
		sc.close();
		
		switch (grade) {
		case 'A' :
		case 'a' :
			System.out.println("우수 회원입니다.");
			break;
		case 'B' :
		case 'b' :
			System.out.println("우수 회원입니다.");
			break;
		default  :
			System.out.println("손님입니다.");
			break;
		}
			
	} // end main()

} // end SwitchMain02
