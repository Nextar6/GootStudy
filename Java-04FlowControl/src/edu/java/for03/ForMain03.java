package edu.java.for03;

public class ForMain03 {

	public static void main(String[] args) {
		System.out.println("for문 연습2");
		
		// 1 ~ 100까지 정수 중에서 9의 배수들만 출력
		
		for(int x = 1; x <= 100; x++) {
			System.out.print(x + " ");
			if( x % 10 == 0 ) {
			System.out.println( );
		} 
			
			
		 
		}	
		// 1 2 3 ... 10
		// 11 12 13 ... 20
		// 91 92 93 ... 100
	} // end main()

	
} // end ForMain03
