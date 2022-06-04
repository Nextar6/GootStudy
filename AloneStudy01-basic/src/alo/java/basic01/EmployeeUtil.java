package alo.java.basic01;

public class EmployeeUtil {
	
	public void printEmpInfo(Employee emp) {
		if(emp instanceof Manager) {
			Manager m = (Manager) emp;
			System.out.println("이름 :" + m.getName());
			System.out.println("직책 :" + m.getType());
		} else if(emp instanceof Employee) {
			System.out.println("이름 : " + emp.getName());
			
		}
		
		else {
			System.out.println("직원이 아닙니다.");
		}
	}
	

}
