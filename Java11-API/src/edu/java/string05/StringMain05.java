package edu.java.string05;

import javax.management.StringValueExp;

// String 클래스 " immutable 클래스(내용이 바뀌지 않는 클래스)
// StringBuffer, StringBuilder : mutable 클래스(내용을 바꿀 수 있는 클래스)

// StringBuffer : Java 1.0 버전부터 사용된 클래스
// - 추가/삭제 속도가 느림
// - Thread-safe : 쓰레드에 안전한 클래스
// - 멀티쓰레드 환경에서 사용하기 적합
// StringBuilder : Java 5.0 버전부터 사용된 클래스
// - 추가/삭제 속도가 느림
// - Thread-unsafe : 쓰레드에 안전하지 않은 클래스
// - 싱글쓰레드 환경에서 사용하기 적합
// 그 외 모든 기능이 동일( 동일한 기능의 메소드들을 가지고 있음)
public class StringMain05 {

	public static void main(String[] args) {
		// StringBuffer, StringBuilder 클
		StringBuffer buffer = new StringBuffer("abc");
//		StringBuffer = "abc; // 컴파일 에러
		// StringBuffer, StringBuilder는 반드시 생성자를 사용하여 초기화해야 함
		// 문자열 리터럴로 초기화 불가능
		System.out.println(buffer);
		System.out.println(buffer.hashCode());
		// hashCode가 동일하면 같은 객체(주소값)를 갖는다.
		// - 새로운 주소를 할당 받지 않으므로 메모리를 절약 할 수 있음
		// append() : 문자열을 덧붙이는 메소드
		buffer.append("def").append("ghi");
		System.out.println(buffer);
		System.out.println(buffer.hashCode());

		System.out.println();
		String str = "abc";
		System.out.println(str);
		System.out.println(str.hashCode());
		
		System.out.println();
		 str = str + "def";
		System.out.println(str);
		System.out.println(str.hashCode());
		
		// String 변수는 문자열 연결 시 새로운 주소로 변경됨.
		// 그만큼 메모리를 차지하게 되므로 특정 상황(문자열 연결)에서는 비효율적임.
		// 다만, 읽기용으로 사용하면 StringBuffer, StringBuilder보다 효율적임
		System.out.println();
		StringBuffer buffer2 = new StringBuffer("ABCDEF");
		buffer2.insert(2, "abc");
		System.out.println(buffer2);
		
		System.out.println();
		StringBuffer buffer3 = new StringBuffer("ABCDEF");
		buffer3.delete(1, 4);
		System.out.println(buffer3);
		
		System.out.println();
		StringBuffer buffer4 = new StringBuffer("Hello, Java!");
		buffer4.replace(0, 5, "안녕하세요");
		System.out.println(buffer4);
	} // end main()

} // end StringMain05
