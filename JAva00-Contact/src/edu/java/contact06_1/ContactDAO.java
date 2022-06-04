package edu.java.contact06_1;

import java.util.ArrayList;

// 연락처 등록, 전체검색, 상세검색, 수정, 삭제
public interface ContactDAO {
	// 연락처 등록
	public abstract int insert(ContactVO vo);
	// 리턴 타입 int : 데이터를 저장하고 저장에 대한 결과를 돌려받기 위해서
	//              0과 1을 저장할 수 있는 형태를 만들기 위해서 int를 선언함
	// insert : 등록하는 기능이기 때문에 insert라는 이름을 설정한다.
	// 매개변수 ContactVO : 연락처에 대한 정보를 저장하는 기능이기 때문에
	//    연락처를 묶을수 있는 VO 형태를 매개변수로 지정한다.
	
	// 연락처 전체 리스트 검색
	public abstract ArrayList<ContactVO> select();
	
	// 연락처 한명에 대한 상세 정보 검색
	public abstract ContactVO select(int index);
	
	// 연락처 한명에 대한 정보(이름, 전화번호, 이메일) 수정
	public abstract int update(int index, ContactVO vo);
	
	// 연락처 한명에 대한 정보 삭제
	public abstract int delete(int index);
	
}






