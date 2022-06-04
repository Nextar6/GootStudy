package edu.java.class02;

public class MyRectangle {
	// 멤버 변수
	double width; // 직사각형의 가로
	double height; // 세로
	
	
// 생성자
	public MyRectangle() {} // 기본 생성자
	
	// 매개변수가 있는 생성자
	public MyRectangle(double width, double height) {
		this.width = width;
		this.height = height;
		// this : 자기 자신(MyRectangle 클래스)
	}
	
	// 메소드
	public double calcArea() {
		return width * height;
	} // end calcArea()
	
} // end MyRectangle
