package alo.java.test02;

public class RemoteMain {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.trunOn();
		tv.trunOff();
		
		Audio audio = new Audio();
		audio.trunOff();
		audio.trunOn();
		System.out.println();
		
		RemoteCon rc1 = new Tv();
		rc1.trunOn();
		RemoteCon rc2 = new Audio();
		rc2.trunOff();
		
		RemoteCon[] rcs =new RemoteCon[2];
		rcs[0] = tv;
		rcs[1] = audio;
		for (int i =0; i < rcs.length;i++) {
			System.out.println(rcs[i]);
			
			
		}
	}

}
