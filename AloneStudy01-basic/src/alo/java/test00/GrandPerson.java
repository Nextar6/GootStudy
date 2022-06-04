package alo.java.test00;

public class GrandPerson extends Person{
	private String company;
	
	public GrandPerson() {
		System.out.println("Person의 자식 객체 GrandPerson");
	}

	public GrandPerson(String company) {
		super();
		this.company = company;
		System.out.println("Person의 자식 객체 GrandPerson 매개변수생성자");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	

}
