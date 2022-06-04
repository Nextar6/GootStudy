package alo.java.test02;

import java.util.Scanner;

public class InterMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("아이디 입력>");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력>");
		String pw = sc.nextLine();
		sc.close();
		
		DataBaseQ dbq = new OracleDatabase();
		int result = dbq.insert(id, pw);
		if(result > 0) {
			System.out.println("성공");
		}else 
			System.out.println("실패");
		
		
	}

}
