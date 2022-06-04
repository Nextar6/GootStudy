package edu.java.array04;

public class ArrayMain04 {

	public static void main(String[] args) {
		System.out.println("배열 초기화 연습");
		// 배열 선언과 초기화 1:
		int[] korean = new int[3];
		korean[0] = 100;
		korean[1] = 90;
		korean[2] = 80;
		
		//배열 선언과 초기화 2:
		int[] english = {100, 90, 80};
		System.out.println(english.length);
		
		for(int i = 0; i < english.length; i++) {
			System.out.println(english[i]);
		}
			//for - each 구문(향상된 for 구문)
			//for (타입 변수이름 : 배열) { .... }
			// - 위 타입은 배열과 동일한 타입으로 선언
			// - 배열에 있는 모든 데이터를 접근할 때 사용
			System.out.println();
			for (int x : english) {
				System.out.println(x);
			}
			// 100, 90, 80
			// 1) x = 100
			//		x 출력
			// 2) x = 90
			//		x 출력
			// 3) x = 80
			//		x 출력
			} // end main()

} // end ArrayMain04
