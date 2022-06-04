package edu.java.for04;

public class ForMain04 {

	public static void main(String[] args) {
		System.out.println("for문 연습3");
		
		// 1 ~ 10까지 숫자 중
		// 홀수면 "홀수", 짝수면 "짝수" 출력
		for (int x = 1; x <= 10; x++) {
			if(x % 2 == 0) {
				System.out.println("짝수");

			} else {
				System.out.println("홀수");
			}
		}
		
		// for문과 if문을 활용하여 아래 출력 결과를 나타내시오.
		// 1꼬마 2꼬마 3꼬마 인디언
		// 4꼬마 .... 
		// 10꼬마 인디언 보이~
		
		//1증감
		//꼬마, 줄바꿈
		//10 인디언보이
		
		for (int y = 1; y <=10; y++) {
			System.out.print(y + "꼬마 ");
			if (y % 3 == 0) {
				System.out.println("인디언");
			}
			if ( y % 10 == 0)
				System.out.print("인디언 보이~");
		}
	} // end main()

} // end ForMain04
