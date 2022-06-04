package edu.java.variable07;

public class TypeCastingMain {

	public static void main(String[] args) {
		System.out.println("형 변환(Type Casting)");
		byte num1 = 123;
		int num2 = num1; // int > byte 이므로 자동 형 변환
		System.out.println("num2 = " + num2);
		
		int num3 = 123;
		byte num4 = (byte) num3; // byte < int 이므로 자동 형 변환 불가능
		// 저장되는 사이즈로 강제로 형 변환 해야 함.
		System.out.println("num4 = " + num4);
		
		// 주의) num3에 저장된 값이 byte의 범위를 넘어가면
		// 형 변환은 가능하지만, 잘못된 값이 저장됨
		int num5 = Byte.MAX_VALUE + 1;
		System.out.println("num5 = " + num5);
		byte num6 = (byte) num5;
		System.out.println("num6 = " + num6);
		
		short num7 = 12345;
		// 12345는 리터럴(상수)이기 때문에 int 타입
		// 정수 리터럴을 byte나 short에 저장할 때
		// 해당 타입에 저장할 수 있는 범위만 넘지 않으면
		// 자동 형 변환을 해줌
		// int -> byte, int -> short 
		
		// long 타입의 리터럴은 자동 형 변환을 하지 않음
//		int num8 = 100L;
		
		double num9 = 123; 	// int -> double 자동 형 변환
		System.out.println("num9 = " + num9);
		// 실수 타입 리터럴의 기본타입은 double
		// 1.23 -> double 취급
		int num10 = (int) 3.14; // double -> int 강제 형 변환
		System.out.println("num10 = " + num10);
		
		char ch1 = 'A';
		System.out.println("ch1 = " + ch1); // 문자 자체 출력
		System.out.println("ch1 = " + (int) ch1); // 문자의 코드값 출력
		
		char ch2 = (char)(ch1 + 1);
		System.out.println("ch2 = " + ch2);
		
	} // end main()

} // end TypeCastingMain






