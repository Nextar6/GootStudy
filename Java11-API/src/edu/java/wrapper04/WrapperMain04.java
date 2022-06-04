package edu.java.wrapper04;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WrapperMain04 {

	public static void main(String[] args) {
		// 다음 문자열에서 숫자들을 구분하여 합을 구하시오.
		
		
		String str = "2022년 1월 27일 17: 33: 20";
//		String[] result = str.split("년 |월 |일 |: ");
		String[] result = str.split("[^0-9]+");
//		문자는 계산이 안된다.
//		계산을 위해 문자 - > 숫자로 변경.
		int sum = 0;
		for(String x : result) {
			System.out.println(x);
			sum += Integer.parseInt(x);
		}
		System.out.println(sum);
		
		

	} // end main()

} // End WrapperMain04
