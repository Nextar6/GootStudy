package edu.java.inherit04;

public class InheritMain04 {

	public static void main(String[] args) {
		Animal animal = new Animal("동물");
				animal.speak();
		System.out.println();
		Dog dog = new Dog("백구", "진돗개");
		dog.speak();
		
		Cat cat = new Cat();
		cat.speak();
		
		
	} // end main()

} // end InheritMain04
