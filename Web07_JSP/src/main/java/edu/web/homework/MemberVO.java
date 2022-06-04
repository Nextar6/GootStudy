package edu.web.homework;

import java.util.Arrays;

public class MemberVO {
	String userid;
	String password;
	String phone;
	String email;
	String emailAgree;
	String[] interest;
	String introduce;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자");
	}
	
	public MemberVO(String userid, String password, String phone, String email, String emailAgree, String[] interest,
			String introduce) {
		super();
		this.userid = userid;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.emailAgree = emailAgree;
		this.interest = interest;
		this.introduce = introduce;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmailAgree() {
		return emailAgree;
	}
	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", emailAgree=" + emailAgree + ", interest=" + Arrays.toString(interest) + ", introduce=" + introduce
				+ "]";
	}
	
	
}