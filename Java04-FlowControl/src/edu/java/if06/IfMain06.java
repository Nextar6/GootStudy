package edu.java.if06;

import java.util.Scanner;

public class IfMain06 {

	public static void main(String[] args) {
		System.out.println("if-else 문자 조건 연습");
		//문자 하나를 입력받아서 그 글자가
		// 1) A ~ Z 이면, "영대문자"라고 출력
		// 2) a ~ z 이면, "영소문자"라고 출력
		// 3) 0 ~ 9 이면, "숫자"라고 출력
		// 4) 그 외 경우는, "몰라요"라고 출력
		
		// 문자 하나 입력 , 문자하나 저장 charAT(0)
		// 문자 하나는 'A' 숫자로표현가능
				
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요>");
		String x = sc.nextLine();
		char str1= x.charAt(0);
		if  ('A' <= str1 && str1 <= 'Z') {
			System.out.println("영대문자");
		}
		else if ('a' <= str1 && str1 <= 'z') {
			System.out.println("영소문자");
		} else if ('0' <= str1 && str1 <='9') {
			System.out.println("숫자");
		}	else {
				System.out.println("몰라요");
			}
		
		// 아스키 코드로 입력되서 비교 연산자 사용 가능
		// 'A <= ch
		
			
			
		
		
		
	} // end main()

} // end IfMain06
