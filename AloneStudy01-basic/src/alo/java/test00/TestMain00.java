package alo.java.test00;

class ParentClass{
	private int x;
	
	public ParentClass() {}
	
	public ParentClass(int x) {
		this.x = x;
		System.out.println("부모 생성자");
	}
	public int getX() {
		return x;
	}
} // end ParnetClass

class ChildClass extends ParentClass{
	private int y;
	
	public ChildClass() {}
	public ChildClass(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("자식 (부모의 x),y 생성자");
		
	}
	public int getY() {
		return y = y;
	}
}


public class TestMain00 {

	public static void main(String[] args) {
		ParentClass pc = new ParentClass(22);
		System.out.println(pc.getX());
		ParentClass cc = new ChildClass(33, 55);
		System.out.println(cc.getX());
//		System.out.println(cc.getY());
		System.out.println(((ChildClass)cc).getY());
		System.out.println(cc instanceof ParentClass);
		System.out.println();
		if(cc instanceof ChildClass) {
			System.out.println("X = " + cc.getX());
			System.out.println("Y = "  + ((ChildClass)cc).getY());
		}else {
			System.out.println("x = " + cc.getX());
		}
		
		
	}

}
