package alo.java.basic01;

public class EmMain {

	public static void main(String[] args) {
		Employee[] emps = {
				new Employee("홍길동"),
				new Manager("고길동","과장")
		};
		emps[0].test();
		emps[1].test();
		System.out.println();
		
		EmployeeUtil utill = new EmployeeUtil();
		for(Employee e : emps) {
			utill.printEmpInfo(e);
			System.out.println("------------");
		}

	}

}
