package edu.java.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		// 2차원 배열 : 1 차원 배열을 원소로 갖는 배열
		int[] korean = {10, 20, 30}; // 1차원 배열
		int[] english = {40, 50 ,60}; // 1차원 배열
		int[][] scores = {
				{10, 20, 30},
				{40, 50, 60}
				
		}; // 2 X 3 인 2차원 배열
		
		System.out.println(scores[1][1]); // 1층 1호
		System.out.println(scores[0][2]); // 0층 2호
		System.out.println("층의 길이(개수) " + scores.length);
		System.out.println("각 층에 있는 길이(개수) : " + scores[0].length );
		
		// 2차원 배열의 값을 모두 출력
		for(int i = 0; i < scores.length; i++) { // 층 만큼 반복
			for(int j =0; j < scores[i].length; j++) { // 호 만큼 반복
				if(scores[i][j] % 3 == 0) {
				System.out.print(scores[i][j] + " ");
				
				
				
			}
			System.out.println();
		}
			System.out.println("===========");
			int[][] array = {
					{1, 2, 3},
					{4, 5},
					{6, 7, 8, 9}
			};
			for (int i1 = 0; i1 < array.length; i1++) {
				for (int j = 0; j < array[i1].length; j++) {
					System.out.print(array[i1][j] + " ");
				}
				System.out.println();
			}
		}
		int[][] a = new int[2][2]; // 2 x 2 배열 생성
		// 배열이 생성되면서 특정 주소값을 갖는다.
		System.out.println(a);
		
	} // end main()

} // end ArrayMain08
