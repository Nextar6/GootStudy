package alo.java.exam;

public class SuperCar extends Car{
	private int battery;
	
	public SuperCar() {}

	public SuperCar(int battery) {
		super();
		this.battery = battery;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	@Override
	public void display() {
		System.out.println("슈퍼카 연료 "  + getFuel());
		System.out.println("슈퍼카 배터리 "  + battery);
	}

}
