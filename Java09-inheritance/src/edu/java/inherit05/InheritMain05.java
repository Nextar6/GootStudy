package edu.java.inherit05;

public class InheritMain05 {

	public static void main(String[] args) {
		Person p1 = new Person("구트");
		System.out.println(p1);
		// Object 클래스의 toString은 모든 클래스에서 사용 가능
		// p1과 p1.toString()은 같은 결과를 출력한다.
		
		String str = new String("문자열");
		System.out.println(str);
		
		// 즉석퀴즈)
		// 1. Point 클래스 생성(5번 패키지에서)
		// - 멤버 변수 (double x, double y)
		// - 매개변수 생성자
		// - toString 오버라이드해서 (x, y) 형식의 문자열을 리턴하는 메소드
		// 2. main() 함수에서 Point 변수 및 인스턴스를 생성하고
		//	아래와 같이 출력.
		// - 예시) (1.0, 2.0)
		Point pt = new Point(1.0, 2.0);
		System.out.println(pt);
		
		
	} // main()

} // end InheritMain05
