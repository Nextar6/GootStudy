package edu.java.homework;

public class Homework4 {

	public static void main(String[] args) {
//		1. 아래 str 문자열을 split 함수를 이용해서 사과, 배, 바나나, 복숭아로 
//		나눈 후 배열에 저장 및 출력
//		String str = "사과:배:바나나:복숭아";
//
//		2. 퀴즈1번 배열에 저장된 문자열들을 StringBuffer를 이용해서 
//		하나로 연결 및 출력
//		StringBuffer buff = new StringBuffer();
		
		
		String str = "사과:배:바나나:복숭아";
		String[] result = str.split("\\:");
		for (String x : result) {
			System.out.println(x);
		}
		
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		int sum = 0;
		for(i=0 ; i < result.length;i++) {
			System.out.print(result[i]);	
			
		}
		
//		3. 아래 문자열에서 "자바" 문자열이 포함되어 있는지 확인하고,
//		만약, 문자열에 자바가 포함되어 있으면 :
//		"자바"를 "Java"로 대체한 새로운 문자열 생성 및 출력
//		문자열에 자바가 포함되어 있지 않으면
//		"자바 문자열이 포함되어 있지 않습니다."를 출력
//		- "모든 프로그램은 자바 언어로 개발될 수 있다."
		System.out.println();
		String str1 = "모든 프로그램은 자바 언어로 개발 될 수 있다.";
		if(str1.contains("자바")) {
			System.out.println(str1.replace("자바", "Java"));
		} else {
			System.out.println("자바 문자열이 포함되지 않았습니다.");
		}
		
		
	} // main()

} // Homework4
