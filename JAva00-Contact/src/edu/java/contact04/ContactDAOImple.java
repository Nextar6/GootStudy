package edu.java.contact04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO {

	// Singleton 패턴 적용
	// 1. private static 자기자신 타입 멤버 변수 선언
	private static ContactDAOImple instance = null; //3
	

	// 2. private 생성자
	private ContactDAOImple() {
		System.out.println("ContactDAOImple()생성자 [4] ");
		initDataDir();
		initDataFile();
	}

	// 3. public static 자기자신을 리턴하는 메소드
	public static ContactDAOImple getInstance() {
		System.out.println("겟인스턴스 호출 instace = 0 [3.5]");
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	// 데이터 폴더의 파일을 사용하는 File 객체 선언
	private File dataDir;
	private File dataFile;

	// 연락처 저장 list
	public static ArrayList<ContactVO> contactList;

	// 데이터 폴더가 있는지 검사하고, 없으면 새로 생성하는 함수
	private void initDataDir() {
		System.out.println("initDataDir() 호출 [5] ");
		dataDir = new File(DATA_DIR);
		System.out.println("폴더 경로 : " + dataDir.getPath());
		System.out.println("절대 경로 : " + dataDir.getAbsolutePath());

		if (!dataDir.exists()) { // 폴더가 없으면
			if (dataDir.mkdir()) { // 폴더 생성
				System.out.println("<폴더 생성 성공>");

			} else {
				System.out.println("<폴더 생성 실패>");
			}

		} else {
			System.out.println("<폴더가 이미 존재>");
		}
	} // end initdataDir()

//	데이터 파일이 있는지 검사하고, 없는경우 - ArrayList<ContactVO> 인스턴스를 생성
//				있는 경우 - 파일에서 데이터를 읽어서 ArrayList를 채움

	private void initDataFile() {
		System.out.println("initDataFile() 호출 [5] ");
		String filePath = DATA_DIR + File.separator + DATA_FILE;
		dataFile = new File(filePath);
		System.out.println("파일경로 : " + dataFile.getPath());
		System.out.println("절대경로 : " + dataFile.getAbsolutePath());

		if (!dataFile.exists()) { // 데이터 파일이 없으면
			try {
				if (dataFile.createNewFile()) {
					System.out.println("<새로운 데이터파일 생성>");
					contactList = new ArrayList<ContactVO>();
					
					
				} else {
					System.out.println("<파일 생성 실패>");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 데이터파일이 있으면
			System.out.println("<기존 데이터 있음>");
			readDataFromFile();

		}

	} // end initDataFile()
// 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
//	메소드 완성 후에 insert(),update(), delete()에서 호출

	private void writeDataToFile() {
		System.out.println("writeDataToFile() 호출 ");
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		

		try {
			out = new FileOutputStream(dataFile);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			oout.writeObject(contactList);
			System.out.println("데이터 저장 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

//	 data/contact.data 파일에서 ArrayList 객체를 읽어와서 
//	멤버변수 contactList에 저장

	private void readDataFromFile() {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream(dataFile);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);

			contactList = (ArrayList<ContactVO>) oin.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	} // end readDatafromFile()

	public int getSize() {
		return contactList.size();
	}

	@Override
	public int insert(ContactVO vo) {
		System.out.println("insert() 호출 : vo = " + vo);
		contactList.add(vo);
		writeDataToFile();
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
		writeDataToFile();
		return 1;
	}

	@Override
	public int delete(int index) {
		contactList.remove(index);
		writeDataToFile();
		return 1;
	}

}
