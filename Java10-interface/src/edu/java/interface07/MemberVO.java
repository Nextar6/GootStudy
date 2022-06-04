package edu.java.interface07;

// VO(value Object) : MVC 디자인 패턴에서 Model 클래스. 데이터 정보
// DTO(Date Transfer Object)
public class MemberVO {
	// 멤버 변수(필드, 프로퍼티)
	private String id;
	private String pw;
	private String email;
	
	public MemberVO(String id, String pw, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	

	
		// TODO Auto-generated method stub
		
	}


