package edu.web.member;

public interface MemberDAO {
	public abstract int insert(MemberVO vo);
	
	public abstract MemberVO select(String userid);
	
	public abstract String select(String userid,String password);
	
	public abstract int update(MemberVO vo);
			
	

}
