package codeup;

import java.util.Scanner;

public class Main00 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char grade = sc.nextLine().charAt(0);
		sc.close();
		
		switch (grade) {
		case 'A' :
		
			System.out.println("best!!!");
			break;
		case 'B' :
		
			System.out.println("good!!");
			break;
		case 'C' :
			
			System.out.println("run!");
			break;
		case 'D' :
			
			System.out.println("slowly~");
			break;
		default  :
			System.out.println("what?");
			break;
		}
			
	} // end main()

} // end SwitchMain02

