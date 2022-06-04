package edu.java.class05;

import java.util.Scanner;

public class ClassMain05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String password = sc.next();
		
		Member member = new Member();
		boolean result = member.login(id, password);
		// id, password 주소값 전송
		if(result) {
			System.out.println("로그인 되었습니다.");
		} else {
			System.out.println("id 또는 password가 일치하지 않습니다.");
			
		}
		
		
		
		
		
		
		sc.close();
		
	} // end main()

} // end ClassMain05
