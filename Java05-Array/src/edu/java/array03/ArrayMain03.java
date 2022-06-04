package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		// 입력받은 정수 n만큼 점수를 입력하는 코드 작성
		// ctrl + shift + o : 자동 imprt 단축키
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] scores = new int[n];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println("입력>");
			scores[i] = sc.nextInt();
		}
		
		// for문을 사용하여, 입력받은 모든 점수 출력
		for(int i = 0; i < scores.length; i++) {
			System.out.println(i + "번째 점수 : " + scores[i]);
		}
		// 배열에 저장된 모든 점수의 합 출력
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("합계 = " + sum);
		double avg = (double) sum / n;
		System.out.println("평균 = " + avg );
		
		// 점수의 최대값 출력
		int max = scores[0]; // 배열의 0번째 원소를 최대값이라고 가정
		for(int i =1; i < scores.length; i++) {
			max = scores[i]; // 배열의 값이 max보다 큰경우 max에 배열값을 저장
		}
	System.out.println("최대값 = " + max);
		//점수의 최소값 출력 
		int min = Integer.MAX_VALUE; // int 범위 중 최대값 저장
		for (int i = 0; i < scores.length; i++) {
			if(scores[i] < min) {
				min = scores[i];
			
			}
		}
	
	
	} // end main()

} // end ArrayMain03
