package alo.java.test02;

interface Test1 {
	public abstract void test1();
}
interface Test2 {
	public abstract void test2();
}
class TestImple implements Test1, Test2{


@Override
public void test2() {
	System.out.println("테스트 2");
}

@Override
public void test1() {
	System.out.println("테스트 1");
	
}
}
public class InterTest {

	public static void main(String[] args) {
		TestImple imple1 = new TestImple();
		imple1.test1();
		imple1.test2();
		
		Test1 imple2 = new TestImple();
		imple2.test1();
		((Test2) imple2).test2();

	}

}