package edu.java.thread01;
/* 쓰레드(Thread) : 하나의 작업을 순차적으로 진행하는 실행 코드
  멀티 쓰레디 프로그램 : 
  - 하나의 프로그램에서 여러개의 쓰레드를 동작하는 프로그램
  - 예) 채팅 프로그램 : 채팅 + 파일전송
 */
  
/*   자바에서 쓰레드를 생성하고 사용하는 방법1:
   1. thread 클래스를 상속받는 새로운 클래스 정의(extends Thread)
   2. 정의한 새로운 클래스 안에서 run() 메소드를 override
   -> run() : 쓰레드가 해야 할 기능 구현
   3. 정의한 클래스의 인스턴스를 생성
   4. 생성된 인스턴스에서 start() 메소드를 호출
   -> 쓰레드가 가져야 할 메모리 공간을 확보 스케쥴링을 위헤 쓰레드 등록, 초기화
   -> 쓰레드의 run() 메소드가 자동으로 실행됨
   */
//   1. Thread 클래스를 상속받는 새로운 클래스 정의
class MyThread extends Thread {
	//멤버 변수
	private String msg;
	
	// 생성자
	public MyThread(String msg) {
		this.msg = msg;
	}
//	2. run() 메소드를 override - 쓰레드가 해야 할 기능들을 구현
	@Override
	public void run() {
		for(int i =0 ; i < 100; i++) {
			System.out.println(i + " : " + msg);
			try {
				sleep(100); // 1초 동안 일을 멈춤(delay)
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			} 
		}
	}
} // end MyThread
public class ThreadMain01 {

	public static void main(String[] args) { // 메인 함수도 하나의 쓰레드이다.
		// 3. Thread 상속받는 클래스(MyThread)의 인스턴스 생성
		MyThread th1 = new MyThread("안녕");
		
//		4. 생성된 인스턴스에서 start() 메소드를 호출 -> 쓰레드 실행
		th1.start();
		Thread th2= new MyThread("Hello?");
		th2.start();
		
//		join() : 해당 쓰레드가 종료 될 때까지 기다림
		try {
			th1.join();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("<<메인 쓰레드 종료>>");
		
		

	} // end main()

} // end ThreadMain01
