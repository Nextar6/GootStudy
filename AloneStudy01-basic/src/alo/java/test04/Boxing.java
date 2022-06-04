package alo.java.test04;

import java.util.Arrays;
import java.util.Random;


public class Boxing {

	public static void main(String[] args) {
		
		int[] selelctNumber =new int[6];
		Random random = new Random();
		
		for(int i = 0; i < 6 ; i++) {
			selelctNumber[i] = random.nextInt(45) + 1;
			System.out.print(selelctNumber[i] + " ");
		}
	
		System.out.println();
		
	int[] winningNum = new int[6];
	random = new Random();
	
	for(int i = 0 ; i < 6; i++) {
		winningNum[i] = random.nextInt(45) + 1;
		System.out.print(winningNum[i] + " ");
	}
	System.out.println("당첨번호");
	
	// 당첨
	Arrays.sort(selelctNumber);
	Arrays.sort(winningNum);
	boolean result = Arrays.equals(selelctNumber, winningNum);
	
	if(result) {
		System.out.println("당첨");
	}else {
		System.out.println("꽝");
	}
		
	}
	

}
