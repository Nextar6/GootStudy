package alo.java.test01;

public class Student {
	int stuNo;
	String stuName;
	Score score;
	
	public Student(int stuNo, String stuName, Score score) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.score = score;
	}
		
	
	public void stuDis() {
		System.out.println("학생 번호 " + stuNo);
		System.out.println("학생 이름 " + stuName);
		System.out.println("학생 총점 " + score.scoreSum());
		System.out.println("학생 평균 " + score.scoreAvg
				());
	}
	

}
