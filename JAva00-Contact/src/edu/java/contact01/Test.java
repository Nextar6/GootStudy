package edu.java.contact01;

public class Test {
	public static void main(String[] args) {
		String[] strings = new String[100];
		strings[0] = "test1";
		strings[1] = "test1";
		strings[2] = "test1";
		for (int i = 0; i < 101; i++) {
			// length로 범위를 지정하는 것이 아니라 다른 방법을 찾을것.
			System.out.println(strings[i]);
		}
		
	}

}
