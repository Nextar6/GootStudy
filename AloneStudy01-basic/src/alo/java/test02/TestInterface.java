package alo.java.test02;

public interface TestInterface {
	public static final int MAX = 100;
	public abstract int insert(String id,String pw);
	public default void connect() {
		System.out.println("DB 연결 성공");
		
	}
	public static void creatDB() {
		System.out.println("DB 생성 성공");
	}
	

}
