package edu.web.memberAnswer;

public interface MemberDAO {
	// 회원가입
	public abstract int insert(MemberVO vo);
	// 회원 한명 정보 검색
	public abstract MemberVO select(String userid);
	// 회원 정보 수정
	public abstract int update(MemberVO vo);
	// 회원 정보 삭제
	public abstract int delete(String userid);
	// 로그인 확인 : 아이디/비밀번호가 일치하는지 확인
	// - 입력된 아이디와 비밀번호가 MEMBER 테이블의 데이터와 일치하면 아이디 값만 리턴
	public abstract String select(String userid, String password);
	

}
