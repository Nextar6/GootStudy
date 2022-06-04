package alo.java.test02;

public class Tv implements RemoteCon{

	@Override
	public void trunOn() {
		System.out.println("티비 켜짐");
		
	}

	@Override
	public void trunOff() {
		System.out.println("티비 꺼짐");
		
	}

}
