package edu.java.switch01;


// switch
// - if문과 같이 쓰이는 제어문
// - 변수의 값에 따라 본문이 선택됨
// - 선언 형태
//		switch(변수) {
//			case 특정값 : 본문1 ; (break)
//			case 특정값 : 본문2 ; (break)
//			case 특정값 : 본문3 ; (break)
//			default : 본문4 ; (break)
//		}
public class SwitchMain01 {

	public static void main(String[] args) {
		System.out.println("switch문");
		
		System.out.println(Math.random());
		// Math.random() : 0이상 1미만의 값 중 무작위로 double 값을 돌려줌
		// 0 * 6 <= r < 1 * 6
		// 0 <= 6 & r < 6 : 0 ~ 5.9999
		// 0 + 1 <= 6 * r + 1 < 7 : 1 ~ 6.9999
		// 정수만 뽑으면 1, 2, 3, 4, 5, 6
		int num = (int) (Math.random() * 6) + 1; // double -> int 강제 형 변환 : 소수점 제거
		System.out.println(num);
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		default :
			System.out.println("6번이 나왔습니다.");
			break;
		}
		} // end main()

} // end SwitchMain01
