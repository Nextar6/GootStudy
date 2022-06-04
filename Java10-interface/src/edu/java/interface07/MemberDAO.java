package edu.java.interface07;
// 인터페이스 DAO 함수 설계 방식
//	함수의 리턴 타입 : 돌려주는 데이터 형태에 따라
//	함수의 매개변수 : 전송되는 데이터 형태에 따라

public interface MemberDAO {

	
	public abstract int insert(MemberVO vo);
	// 회원 전체리스트 검색
	public abstract MemberVO[] select();
	
	// 회원 한명에 대한 상세 정보 검색
	public abstract MemberVO select(int index);
	
	// 회원 한명에 대한 정보 수정
	public abstract int update(int index, MemberVO vo);
	
	
} // 종료