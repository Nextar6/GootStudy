package edu.java.access07;

public class AccessMain07 {

	public static void main(String[] args) {
		MyNumber num1 = new MyNumber();
		System.out.println(num1); // num1 인스턴스 참조값(주소값)출력
		num1.setNumber(5); // num1 객체의 number 값에 5를 저장
		System.out.println(num1.getNumber()); // num1객체의 number값
		
		MyNumber num2 = new MyNumber(10);
		System.out.println(num2.getNumber()); // num2 객체의 number값
		
		MyNumber result = num1.add(num2);
		// num1 객체의 number와 num2 객체의 number 값을 더해서
		// number 변수에 저장하고, 그 객체를 반환한다.
		System.out.println(result.getNumber());
		System.out.println("=====================");
		MyNumber x = new MyNumber(1);
		MyNumber y = new MyNumber(2);
		MyNumber z = new MyNumber(3);
		MyNumber end = new MyNumber(4);
		
		x.add(y).add(z).add(end);
		System.out.println(x.getNumber());
		
		x.setNumber(1);
		// 위에 한줄로 작성된 코드와 동일한 과정
		MyNumber r1 = x.add(y);
		MyNumber r2 = r1.add(z);
		MyNumber r3 = r2.add(end);
		System.out.println(r3.getNumber()); 
		
		
	} // end main()

} // end AccessMain
