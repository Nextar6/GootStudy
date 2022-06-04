package edu.java.exception01;

// 컴파일 에러 : 소스코드 빌드 시 발생하는 에러
// -> 실행 파일이 만들어지지 않기 떄문에 실행 할 수 없음
// 예외(Exception) :
// -> 소스코드를 실행 할땐 에러가 없었지만 
// 	실행 파일을 실 행할 때 발생하는 오류
// 논리적 오류 :
// - 컴파일 에러도없고, 실행할때 예외도 발생하지 않지만
// 논리적인 문제 때문에 원하는 실행결과가 나오지 않는 경우

public class ExceptionMain01 {

	public static void main(String[] args) {
		// int 123; // 컴파일 에러
		
//		int n = 123 / 0 ; 컴파일 에러는 안뜨지만 0으로 나눌수없어서 예외 발생
		int result = findMax(20, 1);
		System.out.println(result);

	} // end main()
	public static int findMax(int x, int y) {
		return (x > y) ? x : y;
	}

} // end ExceptionMain01
