package edu.java.codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] no = new int[n];
		
		for(int i = 0; i < n; i++) {
			no[i] = sc.nextInt();
		}
			int min =23;
			for(int i =0; i < no.length; i++) {
				if(no[i] < min ) {
					min = no[i];
					
				}
			}
			
			System.out.println(min);
		
			
		
		} // end main()

} // end Main
