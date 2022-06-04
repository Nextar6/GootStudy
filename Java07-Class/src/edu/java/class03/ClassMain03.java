package edu.java.class03;

public class ClassMain03 {

	public static void main(String[] args) {
		// 기본 생성자를 사용하여, MyCircle 클래스의 인스턴스 생성 (c1)
		// 반지름과 면적을 출력
		
		
		// c1 객체의 반지름에 1.0값을 저장하여 반지름과 면적을 출력
		// 매개변수가 있는 생성자에 10.0을 값을 주고
		// MyCircle 클래스의 인스턴스를 생성(변수이름 c2)
		// 반지름과 면적 출력
	
		MyCircle c1 = new MyCircle();
		System.out.println("반지름 : " + c1.radius);
		System.out.println("면적 : " + c1.calcArea());
		c1.radius = 1.0;
		System.out.println("반지름 : " + c1.radius);
		System.out.println("면적 : " + c1.calcArea());
		
		MyCircle c2 = new MyCircle(10.0);
		System.out.println("반지름 : " + c2.radius);
		System.out.println("면적 : " + c2.calcArea());
		
	} // end main()

} // end ClassMain03
