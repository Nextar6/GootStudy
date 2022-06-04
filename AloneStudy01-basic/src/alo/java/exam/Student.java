package alo.java.exam;

public class Student extends People {
	public int studentNo;
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
		System.out.println("자식 객체 생성완료.");
	}

}
