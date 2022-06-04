package edu.java.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		System.out.println("배열 연습2");
		// boolean 타입을 저장 할 수 있는 배열 선언
		boolean[] arr1 = {true, false, true, false};
		for(boolean b : arr1) {
			System.out.println(b);
		}
		
		System.out.println("=========");
		boolean[] arr2 = new boolean[4];
		for(int i = 0; i < arr2.length; i++) {
			if(i % 2 == 0) {
				arr2[i] = true;
			} else {
				arr2[i] = false;
			}
		}
	} // end main()

} // end ArrayMain06
