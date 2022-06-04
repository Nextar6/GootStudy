package edu.java.interface06;

/* 상속 : IS-A 관계가 성립 할 때 
 	- 스마트 TV는 TV이다. (SmartTv is a TV)
 	- class SmartTv extends BasicTV{...}
 
 	구현(인터페이스) : HAS-A 관계가 성립할 떄
 	- TV는 리모콘을 가지고 있다. (TV has a remote controller)
 	- class BasicTv implements RemoteController {...}
 
 
*/
public class InterfaceMain06 {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.turnOn();
		tv.turnOff();
		
		Audio audio = new Audio();
		audio.turnOn();
		audio.turnOff();
		
		System.out.println();
		// 인터페이스 활용 : 다형성 이용
		RemoteController rc1 = new Tv();
		rc1.turnOn();
		RemoteController rc2 = new Audio();
		rc2.turnOn();
		
		// 인터페이스 타입의 배열
		RemoteController[] arrRc = new RemoteController[2];
		arrRc[0] = tv;
		arrRc[1] = audio;

	} // end main()

} // end InterfaceMain06
