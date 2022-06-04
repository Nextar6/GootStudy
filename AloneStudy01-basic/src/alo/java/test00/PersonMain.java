package alo.java.test00;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("박명수");
		System.out.println(p1.getName());
		System.out.println();
		GrandPerson g1 = new GrandPerson("삼송");
		g1.setName("이거니");
		System.out.println(g1.getName());
		System.out.println(g1.getCompany());
	}

}
