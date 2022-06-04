package edu.java.method01;

// 메서드 : 기능을 수행하기 위한 코드
// - 메서드는 클래스 안에서, 다른 메소드 외부에서 만든다.
// - (주의) 메서드 안에 또 다른 메서드를 만들수 없음
// - 메서드 정의:
//		[수식어] 리턴타입 메서드이름([매개변수1, 매개변수2, ...]) {본문}
//			수식어 종류 : public, private, static, ... - 생략가능
//			리턴타입 : 자료타입 (int, double, String, class, ...), void(없음)
//			매개변수 : 메서드를 호출할 때 전달하는 데이터
//					전달받은 데이터가 없으면 매개변수 선언이 없어도 됨
// 			{ 본문 } : 메서드 본체(body). 수행해야 할 기능을 작성
public class MethodMain01 {

	public static void sayHello(String name) {
		System.out.println("안녕하세요~");
		System.out.println("저는 " + name + "입니다.");
	} // end sayHello() 
	
	public static void sayAge(int age) {
		System.out.println("제 나이는 " + age + "입니다!");
	} // end sayAge()
		
	// static 수식어 : 프로그램이 실행 될 때 생성하도록 선언하는 키워드
	// static 메서드에서는 static으로 선언된 메서드만 호출 가능
	
	public static void main(String[] args) {
		System.out.println("안녕하세요~");
		System.out.println("저는 컴퓨터입니다.");
		System.out.println("저는 스마트폰입니다.");
		
		sayHello("토르"); // 메서드 호출. 인자값으로 "토르"를 넘겨줌
		sayHello("아이언맨");
		
		sayAge(20);
		
		
	} // end main()

} // end MethodMain01
