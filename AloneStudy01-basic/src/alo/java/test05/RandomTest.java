package alo.java.test05;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4 , 6, 67, 3};
		int rnd = new Random().nextInt(array.length);
		System.out.println(rnd);
	
		Random generator = new Random();
		int randomIndex = generator.nextInt(array.length);
		System.out.println(randomIndex);

	}

}
