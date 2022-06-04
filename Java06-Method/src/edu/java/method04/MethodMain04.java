package edu.java.method04;

import java.util.Scanner;

public class MethodMain04 {

	public static void main(String[] args) {
		System.out.println("배열을 매개변수로 갖는 메서드");
		//	점수(int) 5개를 저장 할 수 있는 배열 선언
		int[] scores = new int[5];
		inputScores(scores); // scores는 주소값을 인자로 전달함
		// 배열에 데이터 입력
		for(int x : scores) {
			System.out.println(x);
		}
		// 배열값 출력
		printScores(scores);
	
		// 배열에 저장된 점수들의 총합을 출력
		int total = scalcTotal(scores);
		System.out.println("총합 = " + total);
		
		// 배열의 값 중에 최대값을 출력
		int max = findMax(scores);
		System.out.println("최대값 = " + max);
		
	} // end main()

	private static int findMax(int[] scores) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if(max < scores[i]) {
				max = scores[i];
			}
		}
		
		return max;
	} // end findMax

	private static int scalcTotal(int[] scores) {
		int total = 0;
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		return total;
	} // end scalcTotal

	private static void printScores(int[] scores) {
		for(int x : scores) {
			System.out.println("입력한 점수 : " + x );
		}
	} // end printScores

	private static void inputScores(int[] scores) { // 주소값을 전달 받음
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			System.out.println("점수" + i + "번째 입력 >");
			scores[i] = sc.nextInt();
		}
		sc.close();
		
	} // end inputScores()

} // end MethodMain04
