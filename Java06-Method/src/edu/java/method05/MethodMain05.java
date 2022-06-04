package edu.java.method05;

 /* 메서드 overLoading
1. 매개 변수의 개수가 다르거나
2. 매개변수의 타입이 다른경우
같은 이름으로 정의 할 수 있음
(주의) 메서드의 리턴타입만 다른 경우는 같은 이름으로 메서드를 정의 할 수 없음 */
public class MethodMain05 {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("문자열");
		System.out.println(1);
		System.out.println(1.0);
		System.out.println(true);
		
	} // end main()
	public static void sayHello() {
		System.out.println("안녕하세요");
		
	}
	public static void sayHello(String name) {
		System.out.println("안녕하세요");
		System.out.println("제 이름은 " + name + "입니다.");
		
	} // end sayHeollo
	
	public static void sayHello(String name, int age) {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
	}
	public static void sayHello(int age, String name) {
		System.out.println("나이 : " + age);
		System.out.println("이름 : " + name);
	} 

} // MethodMain05
