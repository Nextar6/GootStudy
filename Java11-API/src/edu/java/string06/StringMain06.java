package edu.java.string06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringMain06 {

	public static void main(String[] args) {
		System.out.println("정규표현식 연습");
		
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		// (02|010) : 02 또는 010으로 시작
		// - : '-' 기호확인
		// \d{3,4} : 3 ~ 4자리의 숫자
		// \d{4} : 4자리의 숫자
		
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정상적인 전화번호");
		}else {
			System.out.println("정상적인 번호가 아닙니다.");
		}
		
		data = sc.nextLine(); // test@test.com(.kr)
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		/*  \w+ : 한개 이상의 알파벳 또는 숫자
			@  : @ 가 존재하는지
			\w+ : 한개이상의 알파벳 또는 숫자
			\.  : . 이 존재하는지
			\w+ : 한개이상의 알파벳 또는 숫자
			(\.\w+)? : \.\w+가 없거나 한번 더 올수 있음.
		*/
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정상적인 이메일입니다.");
		} else {
			System.out.println("정상적인 이메일이 아닙니다.");
		}
		

		sc.close();
	} // end main()


} // end StringMain
