package alo.java.basic01;

class SuperClass {
	public void test() {
		System.out.println("테스트");
	} // end test()
	public final void testFinal() {
		System.out.println("파이널테스트메소드");
		
	}
} // end SuperClass
class SupClass extends SuperClass {
	@Override
	public void test() {
		
	}
}

public class Elelven {

	public static final int Max = 100;
	public static void main(String[] args) {
		System.out.println(Max);
final int number = 123;
System.out.println(number);
	}

}
