package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02 implements Menu {

	public static Scanner sc = new Scanner(System.in);
	public static ContactDAO dao;

	public static void main(String[] args) {
		System.out.println("연락처 version 2.0");
		dao = ContactDAOImple.getInstance();

		int choice = 0; // 메뉴 선택용 변수
		boolean run = true; // 반복문 온오프용

		while (run) {
			showMain();
			choice = sc.nextInt();
			sc.nextLine(); // 숫자 뒤에 엔터키를 제거
			switch (choice) {
			case INSERT:
				insertContact();
				break;

			case SELECT_ALL:
				selectAllContact();
				break;
			case SELECT_BY_INDEX:
				selectContact();
				break;
			case UPDATE:
				updateContact();
				break;
			case QUIT:
				run = false;
				System.out.println("프로그램이 종료 되었습니다.");
				break;
				
			default:
				System.out.println("잘못된 번호 선택입니다. 0 ~ 4 까지 선택해주세요.");
			}
		}

	} // end main()

	public static void showMain() {
		System.out.println("--------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제| 0. 종료");
		System.out.println("--------------------------------------------------------");
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
		ContactVO vo = new ContactVO(name, phone, email);
		int result = dao.insert(vo);
		if (result == 1) {
			System.out.println("연락처 입력 완료!");
		}

		System.out.println("연락처 입력 완료.");
	} // end insertContact()

	public static void selectAllContact() {
		ContactVO[] contactList = dao.select();
		int count = ((ContactDAOImple) dao).getCount();
		System.out.println("연락처 개수 : " + count);
		for (int i = 0; i < count; i++) {
			System.out.println("-----연락처 " + i + "---");
			System.out.println(contactList[i]);
		}

	} // end selectAllcontact()

	public static void selectContact() {
		System.out.println();
		System.out.println("검색할 인덱스를 입력>");
		int index = sc.nextInt();
		int count = ((ContactDAOImple) dao).getCount();
		if (index >= 0 && index < count) { // 입력된 인덱스 이하로 검색제한.
			ContactVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}

	} // end insertContact()

	public static void updateContact() {
		System.out.println();
		System.out.println("수정할 인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();

		int count = ((ContactDAOImple) dao).getCount();
		if(index >= 0 && index < count) {
		System.out.println("수정할 이름 입력>");
		String name = sc.nextLine();
		System.out.println("전화번호 입력>");
		String phone = sc.nextLine();
		System.out.println("이메일 입력>");
		String email = sc.nextLine();
		ContactVO vo = new ContactVO(name, phone, email);
		int result = dao.update(index, vo);
		if(result == 1 ) {
			System.out.println("연락처 수정 완료");
		}
	} else {
		System.out.println("해당 인덱스에 연락처가 없습니다.");
	}

	} // end updateContact()

} // ContactMain02
