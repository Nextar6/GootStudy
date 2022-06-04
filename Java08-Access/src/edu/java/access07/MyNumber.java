package edu.java.access07;

public class MyNumber {
	// 멤버 변수
	private int number;

	public MyNumber(int number) {
		super();
		this.number = number;
	}

	public MyNumber() {}
	
	//getter / setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public void addToNumber(int x) {
		number += x;
	}
	/* 기능 : 현재 객체(this : MyNumber)의 number 변수와
			매개변수에 있는 number를 더한 후, 현재 객체의 number에저장
	 리턴 타입 : MyNumber
	 함수 이름 : add
	 매개변수 : MyNumber number */
	
	public MyNumber add(MyNumber number) {
		this.number = this.number + number.number;
		return this;
		
	}
} // end MyNumber
