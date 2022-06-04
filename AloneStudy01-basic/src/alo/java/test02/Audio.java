package alo.java.test02;

public class Audio implements RemoteCon{

	@Override
	public void trunOn() {
		System.out.println("오디오 켜짐");
		
	}

	@Override
	public void trunOff() {
		System.out.println("오디오 꺼짐");
		
	}

}
