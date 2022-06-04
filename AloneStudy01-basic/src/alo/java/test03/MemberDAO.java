package alo.java.test03;

public interface MemberDAO {
	
	public abstract int insert(MemberVO vo);
	public abstract MemberVO[] select();
	public MemberVO select(int index);
	public abstract int update(int index,MemberVO vo);

}
