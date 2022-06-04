package edu.java.array05;

public class ArrayMain05 {

	public static void main(String[] args) {
		System.out.println("배열 연습1");
		
		// char 26개를 저장 할 수 있는 배열 선언
		char[] alphas = new char[26];
		alphas[0] ='a';
		// for 문을 사용하여 'a' ~ 'z' 까지 저장
		for(int i = 0 ; i < alphas.length; i++) {
			alphas[i] = (char) ('a' + i);
			
		}
		for(char ch : alphas) {
			System.out.println(ch);
		}
		
		for(char ch = 'a'; ch <= 'z'; ch++) {
			alphas[ ch - 'a'] = ch;
			// a-a 0이되고 b-a는 1이됨 (아스키코드)
		}

	} // end main()

} // end ArrayMain05
