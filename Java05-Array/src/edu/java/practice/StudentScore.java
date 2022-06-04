package edu.java.practice;

import java.util.Scanner;

public class StudentScore {

	public static void main(String[] args) {
		System.out.println("<학생 점수 관리 프로그램>");
		// 변수 명명 규칙
		// 1. 첫 번째 글자는 문자이거나, '$',"_' 이어야 하고 숫자로 시작 할 수 없다.
		// 2. 영어 대소문자가 구분된다.  (필수)
		// 3. 첫 문자는 영어 소문자로 시작하되,다음단어가 붙을 경우 첫 문자를 대문자로. (관례)
		// 4. 문자 수(길이)의 제한은 없다.
		// 5. 자바 예약어는 사용 할 수 없다. (필수)

		// 자바 예약어
		// boolean, byte, char, String, private, public, new, true, false
		int[] stuScores = null; //학생점수. null은 값이 없음을 나타냄
		int stuNo = 0;
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------------------------------------------");
			System.out.println("선택>");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) { // 학생 수 입력
				System.out.println("학생수를 입력하세요>");
				stuNo = sc.nextInt();
				stuScores = new int[stuNo];
				System.out.println("학생수 : " + stuNo);
			}
			else if(selectNo == 2) { // 점수 입력
				 for(int i = 0; i < stuScores.length; i++) {
					System.out.println(i + "번 학생의 점수를 입력하시오");
					stuScores[i] = sc.nextInt();
				}
					
				}
			else if(selectNo == 3) { // 점수 리스트 출력
				for(int i = 0; i < stuScores.length; i++) {
					System.out.println(i + "번 학생 점수 : " + stuScores[i]);
				}
			}
			else if(selectNo == 4) { // 합계, 평균 출력
			
			}
			else if(selectNo == 5) { // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
			sc.close();
			
		
		}
		
		
	} // end main()

} // end StudentScore
