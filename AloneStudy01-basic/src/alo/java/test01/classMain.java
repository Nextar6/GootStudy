package alo.java.test01;

public class classMain {

	public static void main(String[] args) {
		Score score = new Score(70,67,90);
		
		score.scorePrint();
		System.out.println("총점 : " + score.scoreSum());
		System.out.println("평균 : " + score.scoreAvg());
		
		Student student = new Student(60, "가비", score);
		student.stuDis();
		
		Student student2 = new Student(33, "카리나", score);
		student2.stuDis();
	

 } // end main

} // end ClassMain