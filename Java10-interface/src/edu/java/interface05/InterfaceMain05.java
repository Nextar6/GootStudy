package edu.java.interface05;

import java.util.Scanner;

public class InterfaceMain05 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run =true;
		
		while(run) {
			System.out.println("=====================");
			System.out.println("0. 종료|1. 입력|2. 검색|");
			System.out.println("=====================");
			int choice = sc.nextInt();
			switch(choice) {
			case Menu.QUIT :
				System.out.println(Menu.QUIT);
				break;
			case Menu.INSERT :
				System.out.println(Menu.INSERT);
				break;
			case Menu.SELECT :
				System.out.println(Menu.SELECT);
				break;
			default : 
				System.out.println("다시 선택하세요.");
			
			}
					
		}
		
		

	}

}
