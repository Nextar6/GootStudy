package edu.java.class03;

public class MyCircle {
	//멤버 변수
	double radius;
	//기본 생성자
	public MyCircle() {
		
	}
	// 매개 변수가 있는 생성자
	public MyCircle(double radius) {
		this.radius = radius;	// this 자기 자신(MyCircle)클래스
				//현재 클래스(MyCircle)에 있는 radius 변수에
				//외부에서 받아오는 radius의 값을 저장한다.
	}
		//메소드
		public double calcArea() {
			return 3.14 * radius * radius;
		}
	
	
	
 } // end MyCircle
