package alo.java.basic01;

abstract class TestAbstract {
	private int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public abstract void hello();
}
class TestChild extends TestAbstract{
	@Override
	public void hello() {
		System.out.println("하이");
	}
}

public class Twelve {

	public static void main(String[] args) {
		TestAbstract child = new TestChild();
		child.setX(100);
		System.out.println("x : " + child.getX());
		child.hello();
		

	}

}
