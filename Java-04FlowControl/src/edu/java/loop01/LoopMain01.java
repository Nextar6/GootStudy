package edu.java.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		System.out.println("break 키워드");
		
		// 반복문(for, while, do-while) 안에서 break를 만나면
		// break 가 있는 위치에서 가장 가까운 곳(포함하는곳)의 반복문을 종료
		for(int i = 1; i <= 10; i ++) {
			System.out.println(i);
			if(i ==5) {
				break;
			}
		}
		System.out.println("=============");
		
		int n = 1;
		while (n <= 10) {
			System.out.println(n);
			if(n == 5) {
				break;
			}
			n++;
		}
			for(int i = 2; i <= 9; i++) {
				for(int j = 1; j <= 9; j++) {
					System.out.println(i + " X " + j + " = " + (i * j));
					if(j == 5) {
						break;
					}
				}
		}
	}

}
