package edu.java.class04;

public class Score {
	// 멤버 변수(필드, 프로퍼터)
	int korean; // 국어점수
	int english; // 영어점수
	int math; // 수학점수
	
	public Score() {}
	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
		
	} 
	
	// 세 과목의 총점을 리턴하는 메소드
	public int calcTotal() {
		return korean + english + math;
		
	}
	// 세 과목의 평균을 리턴하는 메소드
	public double calcAverage() {
		return (double) calcTotal() / 3;
				
	}
	// 세 과목의 각 점수를 출력하는 메소드
	public void printScores() {
		System.out.println("국어 : " + korean);
		System.out.println("영어 : " + english);
		System.out.println("수학 : " + math);
	}
} // end Score
