package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		System.out.println("배열 연습3");
		String test = "문자열입니다.";
		System.out.println("문자열의 길이 : " + test.length());
		String[] subjects = {"국어", "영어", "수학", "프로그래밍"};
		for(int i =0; i < subjects.length; i++)	{
			System.out.println("과목명 : " + subjects[i]);
		System.out.println(subjects[i]+ ": " + subjects[i].length());
		}
		
		
	} // end main()

} // end ArrayMain07
