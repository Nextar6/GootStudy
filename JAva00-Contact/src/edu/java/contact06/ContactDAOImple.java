package edu.java.contact06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class ContactDAOImple implements ContactDAO, OracleQuery {

	// Singleton 패턴 적용
	// 1. private static 자기자신 타입 멤버 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {
		System.out.println("생성자");

	}

	// 3. public static 자기자신을 리턴하는 메소드
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(ContactVO vo) { // 등록 - > 오라클 데이터베이스
		System.out.println("insert () 호출 : vo = " + vo);

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());

			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return 1;
	} // 등록 완료.

	@Override
	public ArrayList<ContactVO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactVO> list = new ArrayList<ContactVO>();

		try {
			DriverManager.registerDriver(new OracleDriver());

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT);

			System.out.println(SQL_SELECT);

//		6. SQL 문장 실행(DB 서버로 SQL 전송) result로 객체만들고 꺼내쓰는형태 -> ResultSet rs = null;
			rs = pstmt.executeQuery(); // * 지워야함!!! *


			while (rs.next()) {
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
	} // 전체검색 완료.

	@Override
	public ContactVO select(int index) {
		ContactVO vo = new ContactVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_CID);

			pstmt.setInt(1, index);

			rs = pstmt.executeQuery(); // 넣을 필요가없음

			if (rs.next()) {
				index = rs.getInt(1); // 위에이미 선언하며 값받았으니 int 빼주기. cid 컬럼
				String name = rs.getString(2); // name 컬럼 String 타입 주의
				String phone = rs.getString(3); // phone 컬럼
				String email = rs.getString(4); // email 컬럼

				vo = new ContactVO(index, name, phone, email);
				System.out.println(vo);
			}

		} catch (SQLException e) {
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
	} // 상세검색 완료

	@Override
	public int update(int index, ContactVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_UPDATE);

			

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, index);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
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
	} // 연락처 수정 완료.

	@Override
	public int delete(int index) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			DriverManager.registerDriver(new OracleDriver());
		
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_DELETE);

			pstmt.setInt(1, index);
			result = pstmt.executeUpdate();
		
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
	} // 연락처 삭제 완료 (최종완료)

} // end ContactDAOImple
