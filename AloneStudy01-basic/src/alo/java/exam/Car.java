package alo.java.exam;

public class Car {
	private int fuel;
	
	public Car() {}

	public Car(int fuel) {
		super();
		this.fuel = fuel;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public void display() {
		System.out.println("자동차 연료 " + fuel);
	}

}
