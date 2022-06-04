package edu.java.exception03;

public class ExceoptionMain03 {

	public static void main(String[] args) {

		
		try {
			System.out.println("try 내부");
			int[] array = new int[10];
			array[13] = 100;
			System.out.println(array[10]);
		} catch (Exception e) { // 모든 예외 처리
			System.out.println("예외 메세지 : " + e.toString());
			
		}
		

	} // main()
}// End ExceptionMain03
