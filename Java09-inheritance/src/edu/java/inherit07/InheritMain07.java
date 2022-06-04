package edu.java.inherit07;

class ParentClass {
	private int x;
	
	public ParentClass(int x) {
		this.x = x;
		System.out.println("ParentClass(x) 생성자");
		
	}
	public int getX() {
		return x;
		
	}
} // end ParentClass


class ChildClass extends ParentClass {
	private int y; // 멤버 변수

	public ChildClass(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("ChildClass(x, y) 생성자");
		
	}
	public int getY() {
		return y;
	}
	
} // end childClass

public class InheritMain07 {

	public static void main(String[] args) {
		ParentClass class1 = new ParentClass(100);
		
		System.out.println();
		ParentClass class2 = new ChildClass(100, 200); // 다형성
		System.out.println();
		
		System.out.println(class2.getX());
//		System.out.println(class2.getY());
//		class2는 ParentClass 타입으로 선언했기 때문에
//		childClass에서 정의한 getY()메소드를 사용 할 수 없음
//		강제 형 변환(casting)을 하면, ChildClass가 가지고 있는 메소드 사용가능
		System.out.println();
		System.out.println(((ChildClass) class2).getY());
		
//		instanceof 키워드
//		- 기본형태
//		참조변수 instanceof 클래스이름
//		- 명시한 클래스 타입의 인스턴스와 같으면 true, 아니면 false를 리턴
//		- 특정 인스턴스가 원래 어떤 클래스인지 확인 할때 사용
		System.out.println(class2 instanceof ChildClass);
		if (class2 instanceof ChildClass) {
			System.out.println("x = " + class2.getX());
			System.out.println("y = " + ((ChildClass)class2).getY());
			
		} else {
			System.out.println("x = " + class2.getX());
		}
	} // end main()

} // end InheritMain07
