package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		// 국어/영어/수학 점수를 입력받아서
		// 총점과 평균을 출력하는 프로그램 작성

		// 1. 입력 받을 준비 : Scanner 생성
		
		// 2. 국,영,수 점수 정수로 입력받아서 저장
		// 3. 국, 영, 수 점수를 출력
		// 4. 총점을 계산해서 출력
//		int sum = kor + eng + math;
//		System.out.println("총점 : " + sum);
		// 5. 평균을 계산해서 출력 (소수점 셋째자리까지)
		// 참고) 정수 / 실수 -> 실수값을 돌려줌
		// 예시) 10 / 3.0 = 3.333333
//		double average = sum / 3.0;
		// 6. Scanner 종료 (close)
	
		Scanner sc = new Scanner(System.in);
			System.out.println("국어점수를 입력하세요 :");
			int kor = sc.nextInt();
			System.out.println("영어점수를 입력하세요 :");
			int eng = sc.nextInt();
			System.out.println("수학점수를 입력하세요 :");
			int mat = sc.nextInt();
			
			System.out.println("국어점수 = " + kor);
			System.out.println("영어점수 = " + eng);
			System.out.println("수학점수 = " + mat);
			
			int sum = kor + eng + mat;
			System.out.println("총점 = " + sum);
			
			double average = sum / 3.0;
			System.out.printf("평균 = %.3f" , average);
		
		
	} // end main()

} // end ScoreMain
