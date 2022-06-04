package edu.java.array002;

public class ArrayMain02 {

	public static void main(String[] args) {
		System.out.println("배열의 선언, 초기화, 출력");
		
		// int형 정수 10개를 저장할 수 있는 배열 선언
		int[] array = new int[10];
		
		// 배열의 길이 출력
		System.out.println("배열의 길이 : " + array.length);
		
		// 배열의 인덱스 : 0 ~ (length - 1)
		
		// for문을 사용하여 배열에 1 ~ 10까지의 값을 저장
		for(int i = 0; i < array.length; i++) {
			System.out.println("i 값 : " + i);
			System.out.println("array[" + i + "] = " + (i + 1) );
			array[i] = i + 1;
		}
		
		// for문을 사용한 배열 내용 추력
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// 배열의 모든 값(원소)을 더하기
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		System.out.println("sum = " + sum);
		
		
	} // end main()

} // end ArrayMain02
