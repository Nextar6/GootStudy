package edu.java.contact02;

public class ContactDAOImple implements ContactDAO {
	
//	 ***** singleton 패턴적용 *****
//	  1. private static 자기자신 타입 멤버 변수 
	  private static ContactDAOImple instance = null;
//	 2.  private 생성자 
	 private ContactDAOImple() {}
//	 3. public static 자기자신을 리턴하는 메소드
	 public static ContactDAOImple getInstance() {
		 if(instance == null) {
			 instance = new ContactDAOImple();
		 }
		 return instance;
	 }
	 
	
	public static final int MAX = 100;
	
	public int getCount() {
		return count;
	}

//	연락처 저장 배열!!
	public static ContactVO[] contactList = new ContactVO[MAX];
	public static int count = 0; // 배열에 데이터를 저장하면 증가하는 count
	@Override
	public int insert(ContactVO vo) {
		// 배열에 저장 (인덱스 0 부터)
		contactList[count] = vo;
		count++; // 증가하며 저장
		System.out.println("count : " + count);
		return 1;
	}

	@Override
	public ContactVO[] select() {
		
		
		return contactList;
	}

	@Override
	public ContactVO select(int index) {
	
		return contactList[index];
	}

	@Override
	public int update(int index, ContactVO vo) {
		contactList[index].setName(vo.getName());
		contactList[index].setPhone(vo.getPhone());
		contactList[index].setEmail(vo.getEmail());
		return 1;
	}


}
