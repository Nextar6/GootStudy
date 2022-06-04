package edu.java.homework;

public class Contact {
	String name;
	int phon;
	String email;
	public Contact(String name, int phon, String email) {
		super();
		this.name = name;
		this.phon = phon;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhon() {
		return phon;
	}
	public void setPhon(int phon) {
		this.phon = phon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phon=" + phon + ", email=" + email + "]";
	}

}
