package edu.java.exception08;

import java.util.Scanner;

public class ExceptionMain08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("메뉴 선택>");
				int choice = Integer.parseInt(sc.nextLine());
				System.out.println("choice : " + choice);
				break;
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다.");
			}
		}

	} // end main()

} // ExceotionMin08
