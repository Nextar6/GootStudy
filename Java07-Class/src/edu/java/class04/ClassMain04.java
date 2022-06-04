
package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// Score 클래스의 인스턴스 생성
		Score score1 = new Score(10, 20, 30);
		// socre1의 점수 출력
		score1.printScores();
		System.out.println("평균 : " + score1.calcAverage());
		Student stu1 = new Student(1, "진혁", score1);
				stu1.displayStudentInfo();
		System.out.println("===============================");
		Student stu2 = new Student(2, "둘리", score1);
		System.out.println("총점 : " + stu2.score.calcTotal());
			stu2.displayStudentInfo();
				
	} // end main()

} // ClassMain04

