package alo.java.test04;

public class CompareMethod {

	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<>(1,"사과");
		Pair<Integer, String> p2 = new Pair<>(1,"사과");
		
		boolean result1 = Utill.<Integer,String> compare(p1, p2);
	if(result1) {
		System.out.println("동등 객체");
	}else {
		System.out.println("동등하지 않음 객체");
	};
	
	
	}

}
