package alo.java.test03;

public class MemberDAOImple implements MemberDAO{
	public static final int MAX= 100;
	private MemberVO[] list = new MemberVO[MAX];
	private int count;
	
	public int getCount() {
		return count;
	}

	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO[] select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO select(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int index, MemberVO vo) {
		list[index].setPw(vo.getPw());
		list[index].setEmail(vo.getEmail());
		return 0;
	}

}
