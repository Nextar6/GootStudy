package alo.java.exam;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		SuperCar car1 = new SuperCar();
		Car car2 = new SuperCar();
		
		Car[] cars = new Car[3];
		cars[0] = car;
		cars[1] = car1;
		cars[2] = car2;
		for(Car x: cars) {
			x.display();
			System.out.println("--------------");
		}
		
		CarUtil carU = new CarUtil();
		carU.drive(cars);
	} // end main()

} // end CarMain
