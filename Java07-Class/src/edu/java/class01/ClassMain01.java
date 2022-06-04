package edu.java.class01;


public class ClassMain01 {
// Art + Shift + R : 이름 변경
// 프로그램의 시작점 : main() 메소드	
	public static void main(String[] args) {
		// 클래스의 "객체(인스턴스)"를 "생성"한다.
		// 클래스이름 변수이름 = new 생성자();
		
		// 변수 타입
		
		// - 기본 타입 변수 : byte, char, int 등 실제값을 변수안에 저장
		// 예 ) int a= 3, b =10;
		// - 참조타입변수 : 배열, 클래스, 인터페이스 등, 주소를 통해 객체 참조
		// 예 ) int[] a =new int[3]; BasicTv tv = new BasicTv();
		
		
		
		BasicTv tv = new BasicTv();
		tv.displayInfo();
		
		tv.channel = 0;
		/* 기본 생성자를 호출하여 객체를 생성하게 되면 
		기본값으로 초기화
			숫자(int, double, ..)타입의 기본값 : 0
			boolean 타입의 기본값 : false
			그 외 타입(참조 타입) : n
		*/
		tv.turnOnOff(); // 전원버튼 한번 클릭
		tv.turnOnOff(); // 2번 클릭
		
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.volumeUp();
		tv.displayInfo();
		
		// BasicTv라는 변수타입
		// tv는 이름
		// new BasicTv()는 객체를 생성하여 저장
		// BasicTv라는 붕어빵 틀에 tv라고 이름을 붙이고
		// 이틀에 BasicTv의 객체(재료)를 저장
		
		
 /*		BasicTv tv2 = null;
		tv2.displayInfo();
		NullPointerException : 참조변수가 null 값을 가진 경우
		객체의 멤버변수나 메소드를 사용하면 발생하는 프로그램 오류
	*/	
	} // end main()

} // end ClassMain01
