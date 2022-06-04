package edu.java.array08;

import java.util.Scanner;

public class Review05day {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		int[] korean = {10, 20, 30};
		int[] english = {40, 50, 60};
		int[][] scores = {
				{10, 20, 30},
				{40, 50, 60}
		
		};
		
		System.out.println(scores[1][1]);
		System.out.println(scores[0][2]);
		System.out.println("층의 길이(개수) " + scores.length);
		System.out.println("각 층에 있는 길이(개수) : " + scores[0].length);
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				if(scores[i][j] % 3 == 0) {
					System.out.println(scores[i][j] + " "); 
				}
			}
			System.out.println();
			

		}
		System.out.println("=======================");
		
			
	} //end main()

} // end Review05day
