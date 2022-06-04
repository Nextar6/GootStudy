package edu.java.contact04;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactMain04 implements Menu{
	public static Scanner sc = new Scanner(System.in);
	public static ContactDAO dao;
	
	public static void main(String[] args) {
		System.out.println("연락처 version 4.0"); // 1
		dao = ContactDAOImple.getInstance(); // 2
		System.out.println("");
		
		int choice = 0; // 메뉴 선택용
		boolean run = true; // 반복문 종료용
		while(run) {
			showMainMenu();
			choice = sc.nextInt(); // 값 선택받음
			sc.nextLine(); // 숫자 뒤에 엔터키를 제거
			
			// 선택된 번호에 따라 각 기능을 수행
			switch(choice) {
			case INSERT: // 등록
				insertContact();
				break;
			case SELECT_ALL: // 전체검색
				selectAllContact();
				break;
			case SELECT_BY_INDEX: // 검색
				selectContact();
				break;
			case UPDATE: // 수정
				updateContact();
				break;
			case DELETE : // 삭제
				deleteContact();
				break;
			case QUIT: // 종료
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
				break;
			default:
				System.out.println("잘못된 번호 선택입니다. 0 ~ 4까지 선택해주세요.");
			}
		} // end while()
		
	} // end main()
	
	// 메뉴 UI를 보여주는 함수
	public static void showMainMenu() {
		System.out.println("---------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
		System.out.println("---------------------------------------------------------");
		System.out.println("선택>");
	} // end showMainMenu()
	
	public static void insertContact() { // 입력 
		System.out.println();
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력>");
		String name = sc.nextLine();
		System.out.println("전화번호 입력>");
		String phone = sc.nextLine();
		System.out.println("이메일 입력>");
		String email = sc.nextLine();
		
		// Contact 인스턴스 생성 // 입력2
		ContactVO vo = new ContactVO(name, phone, email);
		
		int result = dao.insert(vo);
		if(result == 1) {
			System.out.println("연락처 입력 완료!");			
		}
		
	} // end insertContact()
	
	public static void selectAllContact() {
		// 전체검색
		ArrayList<ContactVO> contactList = dao.select();
		int size = ((ContactDAOImple) dao).getSize();
		System.out.println("연락처 개수 : " + size);
		for(int i = 0; i < size; i++) {
			System.out.println("--- 연락처 " + i + " ---");
			System.out.println(contactList.get(i));
		}
	} // end selectAllContact()
	
	public static void selectContact() {
		System.out.println();
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			ContactVO vo = dao.select(index);
			System.out.println(vo);	
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	} // end selectContact()
	
	public static void updateContact() {
		System.out.println();
		System.out.println("수정할 인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			System.out.println("이름 입력>");
			String name = sc.nextLine();
			System.out.println("전화번호 입력>");
			String phone = sc.nextLine();
			System.out.println("이메일 입력>");
			String email = sc.nextLine();
			
			ContactVO vo = new ContactVO(name, phone, email);
			int result = dao.update(index, vo);
			if(result == 1) {
				System.out.println("연락처 수정 완료");
			}
			
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	} // end updateContact()
	
	private static void deleteContact() {
		System.out.println();
		System.out.println("삭제할 인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			int result = dao.delete(index);
			if(result == 1) {
				System.out.println("연락처 삭제 완료");
			}
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		
	} // end deleteContact()

} // ContactMain04



