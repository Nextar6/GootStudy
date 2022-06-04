package edu.java.access04;

public class AccessMain04 {

	public static void main(String[] args) {
		// 객체 생성 및 데이터 저장 방식1
		Contact c1 = new Contact("유재석", "010-2222-2222", "you@gamil.com");
		System.out.println(c1.toString());
		System.out.println();
		// 번호를 변경
		c1.setPhone("010-1111-2222");
		System.out.println(c1.toString());
		
		// 객체 생성 및 데이터 저장 방식2
		Contact c2 = new Contact();
		c2.setName("박명수");
		c2.setPhone("010-3333-3333");
		c2.setEmail("park@gamil.com");
		System.out.println(c2.toString());
		
		// 3명의 연락처 정보를 배열로 묶음
		Contact[] contacts = new Contact[3];
		// 유재석의 정보를 contacts[0]에 저장
		contacts[0] = c1;
		System.out.println(contacts[0].toString());
		// 박명수의 정보를 contacts[1]에 저장
		contacts[1] = c2;
		// 아이유의 정보를 contacts[2]에 저장
		contacts[2] = new Contact("아이유", "010-4444-4444", "iu@gamil.com");
		
		for(Contact c : contacts) {
			System.out.println(c.toString());
		}
		
		
		
		
	} // end main()

} // end AccessMain04
