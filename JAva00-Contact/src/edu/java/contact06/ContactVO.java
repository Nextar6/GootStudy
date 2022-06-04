package edu.java.contact06;

// 데이터 클래스(번호, 이름, 연락처, 이메일)
public class ContactVO {
	// 멤버 변수 (필드, 프로퍼티)
	private int cid;
	private String name;
	private String phone;
	private String email;
	
	// 기본 생성자
	ContactVO() {}

	public ContactVO(int cid, String name, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactVO [cid=" + cid + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	

} // end contactVO
