package edu.java.oper01;

public class OperatorMain01 {

	public static void main(String[] args) {
		System.out.println("대입 연산자(=)");
		// 변수 = 값;
		// - 오른쪽의 값을 왼쪽 변수에 저장하는 연산자
		int num1 = 246 + 234 + 100 / 10;
		System.out.println("num = " + num1);
		
		System.out.println("==============");
		System.out.println("산술 연산자(+, -, *, /, %)");
		int num2 = 1 + 2;
		System.out.println(num2);
		num2 = 3 - 1;
		System.out.println(num2);
		num2 = 4 * 10;
		System.out.println(num2);
		num2 = 4 / 1;
		System.out.println(num2);
		
		// (정수) / (정수) : 나눈 몫을 계산
		// (실수) / (실수), (실수) / (정수), (정수) / (실수) :
		//			소수점 까지 계산하는 나눗셈 결과
		// (정수) % (정수) : 나눈 나머지를 계산
		System.out.println("정수 나눗셈 몫 : " + (246/100));
		System.out.println("실수 나눗셈 : " + (246 / 100.0));
		System.out.println("정수 나눗셈 몫 : " + (246 % 100));
		// 소수점 n째 자리 까지 출력
		System.out.printf("소수점 6자리 출력 : %.6f", (246/100.0));
		System.out.println(246/0.0);
		// 정수 0으로 나누는 것은 불가능 때문에 Exception 발생
		// 실수 0.0으로 나누면 Infinity를 결과로 보여줌.
		
	} // end main()

} // end OperatorMain01
