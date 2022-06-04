package edu.java.inherit11;

// final : 최종적인, 변경 할수 없는
// - final + 멤버 변수 or 지역 변수 : 상수(한 번 초기화된 값을 변경할 수 없는 변수)
// - final + 메소드 : override 할 수 없는 메소드
// - final + 클래스 : 상속을 허용하지 않는 클래스
class SuperClass {
	public void test() {
		System.out.println("테스트");
	
	} // end test()
	public final void testFinal() {
		System.out.println("파이널 메소드");
		
	}
} // end Superclass
class SubClass extends SuperClass {
	@Override
	public void test() {
		
	}
//	 testFinal() // final 으로 선언된 메소드는 override 불가능
	
} // end SubClass
public class InheritMain11 {
	public static final int Max = 100; // final 멤버변수
 
	
	
	public static void main(String[] args) {
		// 멤버 변수 : 클래스 단계에서 선언된 변수
		// 지역 변수 : 메소드나 특정 위치에 포함된 곳에서 선언된 변수
		// - 지역 변수의 이름은 멤버 변수와 동일하게 선언되면 안됨
		System.out.println(Max);
		// static은 메모리를 생성할 때 JVM에 가장 먼저 생성된다.
//		MAX = 100;  변경 불가
		
		
		final int number = 123; // final 지역 변수
		
		
		

	} // main()

} // InheritMain11
