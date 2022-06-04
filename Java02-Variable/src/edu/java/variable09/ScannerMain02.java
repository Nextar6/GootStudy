package edu.java.variable09;

import java.util.Scanner;

public class ScannerMain02 {

	public static void main(String[] args) {
		try (// Scanner 사용시 주의 할 점
		Scanner sc = new Scanner(System.in)) {
			System.out.println("나이 입력: ");
			int age = sc.nextInt();
			System.out.println("age = " + age);
			
			sc.nextLine();
			// 나이를 입력하고 엔터를 치면
			// 엔터를 문자로 인식해서 뒤에 이름 입력 부분에 저장됨
			// 따라서 엔터를 제거해주는 코드가 필요함
			//
			System.out.println("이름 입력 : ");
			String name = sc.nextLine();
			System.out.println("name = " + name);
		}
		
	} // end main()

} // end ScannerMain02
