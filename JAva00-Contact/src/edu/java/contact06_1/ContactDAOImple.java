package edu.java.contact06_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import oracle.jdbc.OracleDriver;


public class ContactDAOImple implements ContactDAO, OracleQuery {

	

	// Singleton 패턴 적용
	// 1. private static 자기자신 타입 멤버 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {
		System.out.println("ContactDAOImple() 생성자");
	}

	// 3. public static 자기자신을 리턴하는 메소드
	public static ContactDAOImple getInstance() {
		System.out.println("getInstance() 호출 : instance = " + instance);
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(ContactVO vo) {
		System.out.println("insert() 호출 : vo = " + vo);
		// TODO : vo 데이터를 DB에 저장하고 결과(result)를 return
		int result = 0;

		Connection conn = null;
	
		PreparedStatement pstmt = null;


		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_INSERT);

			// SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	@Override
	public ArrayList<ContactVO> select() {
		System.out.println("select() 호출");
		// TODO : DB에 전체 데이터를 검색하여 return
		ArrayList<ContactVO> list = new ArrayList<ContactVO>();


		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		2. Oracle JDBC 드라이버를 메모리에 로드 괄호확인주의
		try {
			DriverManager.registerDriver(new OracleDriver());
			
//		3. DB와 Connection(연결)을 맺음
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");

		
//		4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
		pstmt = conn.prepareStatement(SQL_SELECT);
		
		System.out.println(SQL_SELECT);
		
//		6. SQL 문장 실행(DB 서버로 SQL 전송) result로 객체만들고 꺼내쓰는형태 -> ResultSet rs = null;
		rs = pstmt.executeQuery(); // * 지워야함!!! *
		
		
		while(rs.next()) {
			int cid = rs.getInt(1); // cid 컬럼 명시 데이터베이스내에서. int *타입통일!* 
			String name = rs.getString(2); // name 컬럼 String 타입 주의
			String phone = rs.getString(3); // phone 컬럼
			String email = rs.getString(4); // email 컬럼
			
			ContactVO vo = new ContactVO(cid, name, phone, email);
			list.add(vo);
		}
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ContactVO select(int index) {
		// TODO : DB에서 인덱스 검색 데이터를 리턴
		ContactVO vo = new ContactVO();
		// index - cid 에 매칭
		// update set 
		// where cid = ? < - index
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		2. Oracle JDBC 드라이버를 메모리에 로드 괄호확인주의
		try {
			DriverManager.registerDriver(new OracleDriver());
			
//		3. DB와 Connection(연결)을 맺음
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");
		
//		4. Connection 객체를 사용하여 preparedStatement 객체를 생성
		pstmt = conn.prepareStatement(SQL_SELECT_BY_CID);
		
		
		pstmt.setInt(1, index);
		
	
		
	
//		6. SQL 문장 실행(DB 서버로 SQL 전송) result로 객체만들고 꺼내쓰는형태 -> ResultSet rs = null;
		rs = pstmt.executeQuery(); // 넣을 필요가없음 excuteupdate(); 와 주의
		
//		7. 서버가 보낸 결과 확인/처리
//		Result.next() : 
//		ResultSet에서 다음 행 (row, record)이 있으면
//		true를 리턴후, ResultSet이 가리키는 위치를 다음 위치로 변경.
		
		if(rs.next()) {
			index = rs.getInt(1); // 위에이미 선언하며 값받았으니 int 빼주기. cid 컬럼 
			String name = rs.getString(2); // name 컬럼 String 타입 주의
			String phone = rs.getString(3); // phone 컬럼
			String email = rs.getString(4); // email 컬럼
			
			vo = new ContactVO(index, name, phone, email);
			System.out.println(vo);
		}
		
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return vo;
	}

	@Override
	public int update(int index, ContactVO vo) {
		// TODO: 특정 인덱스의 데이터를 변경하고 결과(result)를 리턴

		Connection conn = null;
		int result = 0;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
//									statement와 상속관계
//									preparedStatement 가 Statement 보다 성능이 좋음
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_UPDATE);


			// SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, index);
			result = pstmt.executeUpdate();
			
			// SQL 쿼리의 ? 순서와 parameteIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameteIndex = 1
			
//			* 타입 실수 주의 *
			// setInt() : DB의 Number 타입
			// SetString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return result ;

		
	}

	@Override
	public int delete(int index) {
		// TODO: 특정 인덱스의 데이터를 삭제하고 결과(result)를 리턴
		
		Connection conn = null;
		int result = 0;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
//									statement와 상속관계
//									preparedStatement 가 Statement 보다 성능이 좋음
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_DELETE);


			// SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			
		
			pstmt.setInt(1, index);
			result = pstmt.executeUpdate();
			
			// SQL 쿼리의 ? 순서와 parameteIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameteIndex = 1
			
//			* 타입 실수 주의 *
			// setInt() : DB의 Number 타입
			// SetString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return result ;

		
	}
		

}