package alo.java.test01;

public class Score {
	int kor;
	int eng;
	int math;
	public Score(){}
	
	public Score(int kor, int eng, int math){
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	public int scoreSum() {
		return kor + eng + math; 
	}
	public int scoreSum(int kor, int eng, int math) {
		return kor + eng + math; 
		
	}
	public double scoreAvg() {
		return (double) scoreSum() / 3; 
	}
	public void scorePrint() {
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);

	}

	
	

}
