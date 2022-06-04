package edu.java.loop03;

import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		System.out.println("JAVA 은행");
		// while문과 Scanner를 이용하여 예금, 출금, 조회, 종료 등을 제공하는
		Scanner sc = new Scanner(System.in);
		int balance = 0; // 예금 잔고 저장 변수
		boolean run = true; // while 문의 반복 여부 검사

		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.println("선택>");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("예금액>");
				balance += sc.nextInt();
				break;

			case 2:
				System.out.println("출금액>");
				balance -= sc.nextInt();
				break;
			case 3:
				System.out.println("잔고>" + balance);
				break;
			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("올바른 메뉴를 선택하세요.");
				break;
			}
		}

	} // end main()

} // end Banking
