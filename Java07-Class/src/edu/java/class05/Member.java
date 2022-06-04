package edu.java.class05;

public class Member {
 
	public boolean login(String id, String password) {
		// id에는 "test"가 왔지만, 값이 온게 아니고 주소값이 왔음
		// id == "test" : 주소값 비교
		// id.equals("test") : 실제 데이터 비교
		if(id.equals("test") && password.equals("1234")) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
