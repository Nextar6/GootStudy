package edu.java.interface07;

import java.util.Scanner;


// MV 디자인 패턴에서 View 클래스
public class MemberMain {
	private static Scanner sc;
	private static MemberDAO dao; // MemberDAOImple 인스턴스를 저장
	
	
	public static void main(String[] args) {
		System.out.println("회원 관리 프로그램");
		sc = new Scanner(System.in);
		dao = new MemberDAOImple(); // 다형성
		

		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case Menu.QUIT:
				run = false;
				break;
			case Menu.INSERT:
				insertMember();
				break;

			case Menu.SELECT_ALL:
				selectAll();
				break;
			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;
			case Menu.UPDATE:
				updateMember();
				break;
			default:
				System.out.println("다시 선택하세요.");

			}
		}

	} // end main()

	private static void insertMember() {
		System.out.println();
		System.out.println("---회원정보등록---");
		System.out.println("아이디 입력>");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력>");
		String pw = sc.nextLine();
		System.out.println("이메일 입력>");
		String email = sc.nextLine();

		MemberVO vo = new MemberVO(id, pw, email);
		
		int result = dao.insert(vo);
		if (result == 1) {
			System.out.println("회원 등록 성공");
		}
	}

	private static void selectAll() {
		MemberVO[] list = dao.select();
		int count = ((MemberDAOImple)dao).getCount();
		for(int i = 0 ; i < count; i++) {
			System.out.println("회원정보[" + i + "]");
			System.out.println(list[i]);
		}
	}
	private static void selectByIndex() {

		System.out.println();
		System.out.println("검색할 인덱스를 입력>");
		int index = sc.nextInt();
		sc.nextLine();
		
		int count = ((MemberDAOImple)dao).getCount();
		if(index >= 0 && index < count) { // 입력된 인덱스 이하로 검색제한.
			MemberVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		
	
		
	} // end selectByIndex()
		
	private static void updateMember() {
		System.out.println("회원 정보 수정");
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();
		sc.nextLine();
		
		int count = ((MemberDAOImple)dao).getCount();
		if(index >= 0 && index < count) {
			
			
			System.out.println("비밀번호 입력>");
			String pw = sc.nextLine();
			
			System.out.println("이메일 입력>");
			String email = sc.nextLine();
			
			MemberVO vo = new MemberVO();
			vo.setPw(pw);
			vo.setEmail(email);
			
			System.out.println("연락처 수정 완료.");
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	} // updateMember

	public static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");
	} // end showMainMenu()
	
	
} // end MemberMain
