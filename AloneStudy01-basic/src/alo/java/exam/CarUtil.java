package alo.java.exam;

public class CarUtil {
	public void drive(Car[] cars) {
		for(Car car: cars) {
			car.display();
			System.out.println("현재 연료 : " + car.getFuel());
			System.out.println("부릉부릉");
		}
	}

}
