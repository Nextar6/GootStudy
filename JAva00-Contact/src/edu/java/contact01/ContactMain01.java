package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
//	static 가장 먼저 저장됨. 어디서나 쓸 수 있음.
	public static final int MENU_QUIT = 0; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SELECT_ALL = 2; // 전체 검색
	public static final int MENU_SELECT = 3; // 상세 검색
	public static final int MENU_UPDATE = 4; // 수정

	public static final int MAX = 100;

//	연락처 저장 배열!!
	public static Contact[] contactList = new Contact[MAX];
	public static int count = 0; // 배열에 데이터를 저장하면 증가하는 count
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("연락처 version 1.0");
		int choice = 0; // 메뉴 선택용 변수
		boolean run = true; // 반복문 온오프용

		while (run) {
			showMain();
			choice = sc.nextInt();
			sc.nextLine(); // 숫자 뒤에 엔터키를 제거
			switch (choice) {
			case MENU_INSERT:
				insertContact();
				break;

			case MENU_SELECT_ALL:
				selectAllContact();
				break;
			case MENU_SELECT:
				selectContact();
				break;
			case MENU_UPDATE:
				updateContact();
				break;
			case MENU_QUIT:
				run = false;
				System.out.println("프로그램이 종료 되었습니다.");
				break;
			default:
				System.out.println("잘못된 번호 선택입니다. 0 ~ 4 까지 선택해주세요.");
			}
		}

	} // end main()

	public static void showMain() {
		System.out.println("--------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("--------------------------------------------------");
		System.out.println("선택 > ");
	} // end showMain()

	public static void insertContact() {
		System.out.println();
		System.out.println("연락처 등록 메뉴");
		System.out.println("--------------");
		System.out.println("이름 입력 >");
		String name = sc.nextLine();
		System.out.println("전화 번호 입력>");
		String phone = sc.nextLine();
		System.out.println("이메일 입력 >");
		String email = sc.nextLine();

		// Contact 인스턴스 생성
		Contact c = new Contact(name, phone, email);
		// 배열에 저장 (인덱스 0 부터)
		contactList[count] = c;
		count++; // 증가하며 저장
		System.out.println("count : " + count);
		System.out.println("연락처 입력 완료.");
	} // end insertContact()

	public static void selectAllContact() {
		
		System.out.println("연락처 개수 : " + count);
		for(int i = 0 ; i < count ; i++) {
			System.out.println("-----연락처 " + i + "---");
			System.out.println(contactList[i]);
		}

	} // end selectAllcontact()

	public static void selectContact() {
		System.out.println();
		System.out.println("검색할 인덱스를 입력>");
		int index = sc.nextInt();
		if(index >= 0 && index < count) { // 입력된 인덱스 이하로 검색제한.
			System.out.println(contactList[index]);
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		

	} // end insertContact()

	public static void updateContact() {
		System.out.println();
		System.out.println("수정할 인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();
		if(index >= 0 && index < count) {
			System.out.println("수정할 이름 입력>");
			String name = sc.nextLine();
			System.out.println("전화번호 입력>");
			String phone = sc.nextLine();
			System.out.println("이메일 입력>");
			String email = sc.nextLine();
			
			contactList[index].setName(name);
			contactList[index].setPhone(phone);
			contactList[index].setEmail(email);
			System.out.println("연락처 수정 완료.");
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		

	} // end updateContact()

} // ContactMain01
