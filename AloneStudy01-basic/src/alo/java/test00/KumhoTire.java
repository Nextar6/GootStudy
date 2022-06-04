package alo.java.test00;

public class KumhoTire extends Tire{
	public KumhoTire(String location,int maxRotation) {
		super(location,maxRotation);
		
	}
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation ) { 
			System.out.println(location + "KumhoTire 수명 : "+(maxRotation-accumulatedRotation));
			return true;
		}else {
			System.out.println("***" + location + "KumhoTire 펑크 ***");
			return false;
			
		}
	}
}
