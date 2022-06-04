package alo.java.basic01;

public class CalExam {

	public static void main(String[] args) {
	Calculator myCalc = new Calculator();
	double result1 = myCalc.areaRactangle(10);
	double result2 = myCalc.areaRactangle(10,20);
	
	
	System.out.println("정사각형의 넓이 = " + result1);
	System.out.println("직사각형의 넓이 = " + result2);
	
	}
	

}
