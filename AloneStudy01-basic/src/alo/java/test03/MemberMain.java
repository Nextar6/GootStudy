package alo.java.test03;

import java.util.Scanner;

public class MemberMain {
	private static Scanner sc;
	private static MemberDAO dao;

	public static void main(String[] args) {
		System.out.println("회원 관리프로그램");
		sc = new Scanner(System.in);
		dao = new MemberDAOImple();

		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case Menu.QUITE:
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
				

			default:
				System.out.println("다시 선택하세요");

			}

		}

	} // end main()

	public static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");

	} // end showMain

	private static void insertMember() {
		System.out.println();
		System.out.println("---회원정보등록---");
		System.out.println("아이디>");
		String id = sc.nextLine();
		System.out.println("비밀번호>");
		String pw = sc.next();
		System.out.println("이메일>");
		String email = sc.nextLine();

		MemberVO vo = new MemberVO(id, pw, email);

		int result = dao.insert(vo);
		if (result == 1) {
			System.out.println("회원 등록 성공");
		}
	}

	private static void selectAll() {
		MemberVO[] list = dao.select();
		int count = ((MemberDAOImple) dao).getCount();
		for (int i = 0; i < count; i++) {
			System.out.println("회원정보 [" + i + "]");
			System.out.println(list[i]);
		}

	}

	public static void selectByIndex() {
		System.out.println();
		System.out.println("검색할 인덱스>");
		int index = sc.nextInt();
		sc.nextLine();

		int count = ((MemberDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			MemberVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	}

} // end MemberMain
