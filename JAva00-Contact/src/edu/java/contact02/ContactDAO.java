package edu.java.contact02;

// 연락처 등록, 전체검색, 상세검색, 수정

public interface ContactDAO {
	// 연락처 등록
	public abstract int insert(ContactVO vo);
	
	
	// 연락처 전체 리스트 검색
	public abstract ContactVO[] select();
	// 연락처 한명에 대한 상세 정보 검색
	public abstract ContactVO select(int index);
	
	// 연락처 정보 (이름, 전화번호, 이메일) 수정
	public abstract int update(int index, ContactVO vo);
	
	

}
