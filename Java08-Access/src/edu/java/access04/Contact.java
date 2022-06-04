package edu.java.access04;

public class Contact {
	// 멤버 변수 3개
	private String name;
	private String phone;
	private String email;
	
	// 생성자
	public Contact() {}

	public Contact(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// getter/setter
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
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	// toString()
}
