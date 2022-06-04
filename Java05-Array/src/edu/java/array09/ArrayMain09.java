package edu.java.array09;

public class ArrayMain09 {

	public static void main(String[] args) {
		//1.10일 월요일 수업 시작
		System.out.println("2차원 배열 연습");
		String[] avengers = {"아이언맨", "토르", "헐크", "캡틴아메리카"};
		String[] villain = {"타노스", "하이드라", "레드스컬"};
		String[][] characters = {
				avengers,
				villain
		};
		// 문자열 2차원 -> 문자열 1차원 -> 문자열
		for(String[] group : characters) {
			for(String name : group) {
				System.out.print(name + " ");
			}
			System.out.println();
		}
		
		

	} // end main()


} // end ArrayMain09
