package edu.java.access06;

import edu.java.access05.TestPublic;

public class AccessMain06 {

	public static void main(String[] args) {
		TestPublic test1 = new TestPublic();
		System.out.println(test1);
//		TestPackage test2 = new TestPackage();
//		다른 패키지에 속해있는 클래스는 인스턴스 생성 불가능(package 선언 클래스)
	}

}
