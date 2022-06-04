package edu.java.method02;

public class MethodMain02 {
	
	// 기능 : 두개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
	// 메서드 이름 : add
	// 리턴타입 : int
	// 매개변수 : int x, int y
	
	public static int add(int x, int y) {
//		int sum = x + y;
		return x + y;
	}
	// 기능 : 두개의 정수를 매개변수로 전달받아서, 두 정수의 차를 리턴
		// 메서드 이름 : sub
		// 리턴타입 : int
		// 매개변수 : int x, int y
	public static int sub(int x, int y) {
		return x - y;
		
	}

	public static double mul(double x, double y) {
		return x * y;
	}
	public static double div(double x, double y) {
		return x % y;
	}
	// 기능 : 두개의 실수 (double)를 전달 받아서, 두 수의곱(double)을 리턴
	// 기능 : 두 개의 실수(double)을 전달 받아서, x를 y로 나눈 값(double)을 리턴 
	public static void main(String[] args) {
		System.out.println("메서드 연습");
		int result = add(10, 20);
		System.out.println("result " + result);
		
		result = sub(20, 10);
		System.out.println("result = " + result);
		
		double m = mul(10, 10);
		System.out.println("m = " + m);
		
		double d = div(3, 2); // 강제 형 변환 가능성을 염두
		System.out.println("d = " + d);

	} // main()

} // MethodMain02
