package edu.java.homework;

public class HomeWork2 {

	public static void main(String[] args) {

//		<언어특성 활용하기>
//		1. 배열 1, 2, 3, 5, 6의 값 중에 최대값 출력하기
		int[] array = { 1, 2, 3, 4, 5, 6 };

		int max = array[0];

		for (int i = 0; i <= 5; i++) {
			if (array[i] > max)
				max = array[i];

		}
		System.out.println("최대값 : " + max);

		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
//		2. 주어진 배열(1, 2, 3, 5, 6)의 전체 합과 평균 값을 구하기
		System.out.println("전체 합 : " + sum);

		double div = sum / array.length;
		System.out.println("평균 : " + div);

//
//		3. 피보나치 수열 20개를 출력
//		피보나치(Fibonacci) 수열: 1, 1, 2, 3, 5, 8, 13, 21, ...
		int[] f = new int[20];
		f[0] = 1;
		f[1] = 1;
		for (int a = 2; a < 20; a++) {
			f[a] = f[a - 1] + f[a - 2];
		}
		for (int i1 = 0; i1 < 20; i1++) {
			System.out.println(f[i1]);
		}
//		4. 아래 2차원 배열의 전체 합과 평균 구하기
//		int[][] array = {
//		 {95, 86}, 
//		 {83, 92, 96}, 
//		 {78, 83, 93, 87, 88}
//		};

	} // end main()

} // end HomeWork02
