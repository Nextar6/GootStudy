package alo.java.basic01;

import java.util.Calendar;

public class Enum1 {

	public static void main(String[] args) {

		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNSDAY;
		int result = day1.compareTo(day2);
		System.out.println(result);
		int result1 = day2.compareTo(day1);
		System.out.println(result1);
		
		Week weekDay =Week.valueOf("SUNDAY");
		if(weekDay == Week.SUNDAY) {
			System.out.println("주말이군요");
		} else {
			System.out.println("평일이군요");
		}
		Week[] days = Week.values();
		for(Week day : days) {
		System.out.println(day );
		}
	
	}

}
