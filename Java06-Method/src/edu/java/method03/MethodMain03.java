package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	public static void main(String[] args) {
		/* 1. 국어, 영어, 수학 점수를 입력 받아서 3개의 변수에 저장
		2. 입력받은 점수를 출력
		3. 함수를 정의하여 세 과목의 총점을 출력
		4. 함수를 정의하여 세 과목의 평균을 출력 (소수점까지 출력)
		5. 함수를 평균에 따른 등급을 출력
		리턴타입 : char
		매개변수 : double avg
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어입력>");
		int kor = sc.nextInt();
		System.out.println("영어입력>");
		int eng = sc.nextInt();
		System.out.println("수학입력>");
		int math = sc.nextInt();
		sc.close();
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		
		int total = calcTotal(kor, eng, math);
		System.out.println("합계 : " + total);
		
		double avg =  calAverage(total);
		System.out.println("평균 : " + avg);
		
		char grade = selectGrade(avg);
		System.out.println("학점 : " + grade);
		
	} // end main()

	/* 함수의기능 : 세 개의 정수를 매개 변수로 전달받아, 세개의 합을 리턴
  메서드이름 : calcTotal 바깥에 쓰는게 핵심
  리턴타입 : int
  매개변수 : int kor, int eng, int math */
	
	public static double calAverage(int total) {
		return total / 3.0;
	} // end calAverage()
	
	public static int calcTotal(int kor, int eng, int math) {
		return kor + eng + math;
	} // end calcTotal()
	public static char selectGrade(double avg) {
		
		if(100 >= avg && avg >= 90) {
			return  'A';
		} else if(avg >= 80) {
			return  'B';
		} else if(avg >= 70) {
			return  'C';
			
		}else {
			return 'F';
		}
		
	} // end selectGrade()
	
} // MethodMain03
