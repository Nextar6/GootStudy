package edu.java.exception05;

public class ExceptionMain05 {

	public static void main(String[] args) {
		System.out.println("여러 개의 예외 처리");
//		하나의 try 구문에서 여러 개의 catch 를 사용하는 방법1
		try {
			int x = 12345;
			int y = 0;
			int result = x / y;
			System.out.println("result = " + result);
			
			int[] array = new int[10];
			array[11] = 10;
			System.out.println("array[11] = " + array[11]);
			String name = null;
			System.out.println("문자열 길이 "+ name.length());
		} catch (ArithmeticException e) { // e 변수에 예외에 대한 정보가 저장됨		
			System.out.println("산술 연산 예외 : " + e.toString());
		} catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("배열 인덱스 예외 : " + e.toString());
		} catch (Exception e) {
			System.out.println("예외 : " + e.toString());
		}
		
		/* 하나의 try 구문에서 여러개의 catch를 사용하는경우,
		 * 자식 클래스의 exception을 먼저 catch 구문에서 사용하고
		 * 가장 마지막에 최상위 부모 클래스인 Exception을 사용해야 함
		  
		 */
		System.out.println("프로그램 종료");

	} // end main()

} // End ExceptionMain05
