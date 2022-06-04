package alo.java.test01;

public class BasicTv {
	boolean powerOn;
	int channel;
	int volume;

	public void turnOnOff() {
		if (powerOn == true) {
			powerOn = false;
			System.out.println("Tv가 꺼졌습니다.");
		} else {
			powerOn=true;
			System.out.println("Tv가 켜졌습니다.");
		}
	}
	public void channelUp() {
		if(channel==5) {
			channel = 1;
			
		}else {
		channel++;
		}
		System.out.println("현재 채널 : " + channel);
	}
	public void channelDown() {
		if(channel==1) {
			channel = 5;
			
		}else {
		channel--;
		}
		System.out.println("현재 채널 : " + channel);
	}
	public void volumeUp() {
		if(volume < 4) {
			volume++;
		}
		System.out.println("현재 볼륨 " + volume);
	}
	public void volumeDown() {
		if(volume > 0) {
			volume--;
		}
		System.out.println("현재 볼륨 " + volume);
	}
	public void disPlay() {
		System.out.println("---현재 TV상태---");
		System.out.println("전원 : " + powerOn);
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volume);
	}

} // end basicTV
