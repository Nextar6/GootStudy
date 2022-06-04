package alo.java.test05;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		String date = sdf.format(year+month+day);
		System.out.println(date);
		

	}

}
