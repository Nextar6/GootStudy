package edu.java.inherit08;

public class EmployeeUtill {
	// employee 객체를 전송할 예정
//	employee 객체 일 수 있고, manager 객체 일 수도 있다.
//	이게 가능한 이유는 employee와 manager가 부모 자식 관계이기 때문이다.
//	그래서 이 두가지 타입의 인스턴스가 오기 때문에 
//	조건문과 instanceof를 이용하여 인스턴스에 따라 다르게 처리해야 한다.
	
	public void printEmpInfo(Employee emp) {
		if(emp instanceof Manager) { // emp의 인스턴스가 Manager인 경우
			Manager m = (Manager) emp; // 강제 형 변환(casting)
			System.out.println("이름 : " + m.getName());
			System.out.println("직책 : " + m.getType());
			
		} else if(emp instanceof Employee) { // 인스턴스가 Employee 인 경우
			System.out.println("이름 : " + emp.getName());
		} else { // 둘다 아닌 경우
			System.out.println("직원이 아닙니다.");
			
			
		}
		
	}

}
