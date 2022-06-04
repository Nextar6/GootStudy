package edu.java.homework;

public class Homework1 {

	public static void main(String[] args) {
		//알파벳 A ~ Z 출력
		
		for ( char x = 'A'; x <= 'Z'; x++) {
			System.out.println(x );
		}
	

		int i = 0;
		int j = 0;
		for (i = 0; i <= 5; i++) {
			for (j = 1; j <= 5; j++) {
				if (i < j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// ***** 별 다섯개
		//  **** 공백 1 별 4
		//   *** 공백 2 별 3     와 반대 모양
		//    ** 공백 3 별 2
		//     * 공백 4 별 1

		
		
		for (i = 0; i <= 5; i++) {
			for (j = 1; j <= i; j++) {
				System.out.print("*");

			}
			System.out.println(" ");
		}

// sum = 1 + (-2) + 3 + (-4) + 5 + ... + n >= 100 
//을 만족하는 n과 sum의 값을 출력

		int[] f = new int[20];
		f[0] = 1;
		f[1] = 1;
		for (int a = 2; a < 20; a++) {
			f[a] = f[a - 1] + f[a - 2];
		}
		for (int i1 = 0; i1 < 20; i1++) {
			System.out.println(f[i1]);
		}
			
			
		
	} //end main()

} // end
