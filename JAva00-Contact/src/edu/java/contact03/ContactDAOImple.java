package edu.java.contact03;

import java.util.ArrayList;
import java.util.Random;

public class ContactDAOImple implements ContactDAO {

//	 ***** singleton 패턴적용 *****
//	  1. private static 자기자신 타입 멤버 변수 
	private static ContactDAOImple instance = null;

//	 2.  private 생성자 
	private ContactDAOImple() {
	}

//	 3. public static 자기자신을 리턴하는 메소드
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	public int getSize() {
		return contactList.size();
	}

//	연락처 저장 list
	public static ArrayList<ContactVO> contactList = new ArrayList<ContactVO>();

	@Override
	public int insert(ContactVO vo) {
		contactList.add(vo);

		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() {

		return contactList;
	}

	@Override
	public ContactVO select(int index) {

		return contactList.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		contactList.set(index, vo);
		return 1;
	}

	@Override
	public int delete(int index) {
		contactList.remove(index);
		return 1;
	}

	

}
