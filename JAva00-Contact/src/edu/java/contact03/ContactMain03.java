package edu.java.contact03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ContactMain03 implements Menu {

	public static Scanner sc = new Scanner(System.in);
	public static ContactDAO dao;

	public static void main(String[] args) {
		System.out.println("연락처 version 3.0");
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
			case DELETE:
				deleteContact();
				break;
			case QUIT:
				run = false;
				System.out.println("프로그램이 종료 되었습니다.");
				break;
			case RANDOM:
				randomContact();
				break;
			default:
				System.out.println("잘못된 번호 선택입니다. 0 ~ 6 까지 선택해주세요.");
			}
		}

	} // end main()

	public static void showMain() {
		System.out.println("---------------------------------------------------------");
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

	} // end insertContact()

	public static void selectAllContact() {
		ArrayList<ContactVO> contactList = dao.select();
		int size = ((ContactDAOImple) dao).getSize();
		System.out.println("연락처 개수 : " + size);
		for (int i = 0; i < size; i++) {
			System.out.println("-----연락처 " + i + "---");
			System.out.println(contactList.get(i));
		}

	} // end selectAllcontact()

	public static void selectContact() {
		System.out.println();
		System.out.println("검색할 인덱스를 입력>");
		int index = sc.nextInt();
		int size = ((ContactDAOImple) dao).getSize();
		if (index >= 0 && index < size) { // 입력된 인덱스 이하로 검색제한.
			ContactVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}

	} // end insertContact()
	
	public static void randomContact() {
		ArrayList<ContactVO> contactList = dao.select();
		Random generator = new Random();
		int randomIndex = generator.nextInt(contactList.size());
		
		
			ContactVO vo = dao.select(randomIndex);
		
		System.out.println(vo);

		// 배열선언되있는거에서 셀렉트를 그냥이용 해서 하나 뽑아옴
		// 랜덤 선언하고 변수 만들고 그걸 그냥 셀렉트 인덱스에 넣어버림 
		
	} // end raddomContact

	public static void updateContact() {
		System.out.println();
		System.out.println("수정할 인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();

		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
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
	public static void deleteContact() {
		System.out.println();
		System.out.println("삭제할 인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >=0 && index < size) {
			int result = dao.delete(index);
			if( result ==1) {
				System.out.println("연락처 삭제 완료");
			}
			
		}else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	} // end deleteContact()

} // ContactMain02
