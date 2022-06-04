package edu.web.member;

public class MemberVO {
	String userid;
	String password;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자");
	}
	public MemberVO(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
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
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + "]";
	}

}
