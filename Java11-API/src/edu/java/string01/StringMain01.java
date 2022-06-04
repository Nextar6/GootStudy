package edu.java.string01;


// API(Application Programming Interface)
// - 프로그램 언어나 운영 체제가 제공하는 기능을 사용 할 수 있게 만든 인터페이스
public class StringMain01 {

	public static void main(String[] args) {
		String str1 = "안녕하세요"; // 문자열 상수 : 기본타입, char, int, double
		System.out.println(str1);
		System.out.println("문자열의 길이 : " + str1.length());
		
		
		System.out.println();
		String str2 = new String("안녕하세요"); // 참조타입. 배열, 객체 등
		System.out.println(str2);
		String str3 = "안녕하세요";

		if(str1 == str2) {
			System.out.println(" 같은 참조 ");
		} else {
			System.out.println(" 다른 참조 ");
		}
		System.out.println(str1.equals(str2));
		
		// String 을 저장하는 참조 변수에는 문자열이 있는 주소값이 저장됨
		// 비교연산 (==, !=) 는 단순 주소값만 비교 
		// - > 실제 문자열의 내용이 같더라도 '주소값이 다르면' 다른 결과 false.
		// 따라서, 문자열의 내용이 같은 지다른지를 비교 할 때는 equals() 메소드를 사용해야함
	} // main()

} // end StringMain01
