package edu.java.class02;
//여기서부터 2.03일 할차례
 /* 클래스 :
//		상태(속성,성질) - 멤버 변수(field, property)
		기능 - 메소드
		생성자(constructor) - 멤버 변수들을 초기화
			- 클래스 이름과 동일
			- 매개변수는 있을 수도 있고 없을 수도 있음.
			- 클래스를 작성할 때 생성자를 하나도 정의하지 않은 경우
			
 */
public class ClassMain02 {

	public static void main(String[] args) {
		// 기본 생성자를 사용하여 MyRectangle 클래스의 인스턴스 생성
		MyRectangle rect1 = new MyRectangle();
		rect1.width = 3.0;  // rect1.width 변수에 3.0을 저장
		rect1.height = 4.0; // rect1.height에 4.0을 저장
		System.out.println("가로 : " + rect1.width);
		System.out.println("세로 : " + rect1.height);
		System.out.println("넓이 : " + rect1.calcArea());
		
		System.out.println("===================");
		// 매개변수가 있는 생성자를 호출하여 인스턴스 생성
		MyRectangle rect2 = new MyRectangle(10.0, 20.0);
		System.out.println("가로 : " + rect2.width);
		System.out.println("세로 : " + rect2.height);
		System.out.println("넓이 : " + rect2.calcArea());
		
		
	} // end main()

} // end Class Main02
