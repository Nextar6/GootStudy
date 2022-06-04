package edu.java.for05;

public class ForMain05 {

	public static void main(String[] args) {
		System.out.println("for문 연습4");
		
		
		// 등차수열의 합 구하기
		// 1 + 2 + 3 + ... + 10
		
		int sum1 = 0;
		for ( int i = 1; i <= 10; i++) {
			sum1 = sum1 + i;
			System.out.println("i = " + i + ", sum1 = " + sum1);
		}System.out.println(sum1);
		
		// 1 ~ 100가지의 짝수들의 합
		
		int sum2 = 0;
		for ( int i = 1; i <= 100; i++) {
			
			if (i % 2 == 0) { 
				sum2 = sum2 + i;	
			}
		}
		System.out.println(sum2);
		
	} // end main ()

} // end ForMain05
