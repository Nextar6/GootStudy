package edu.java.jdbc06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JDBCMain06 {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// 접속할 오라클 DB경로 로컬호스트 는 아이피주소 (IPv4랑 같다)
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CID = "cid";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";

	/*
	 * 데이터 수정 update ex_contact set name = ? , phone = ? , email = ? where cid = ?
	 */
	public static final String SQL_UPDATE = 
			"update " + TABLE_NAME + " set " +
			COL_NAME + " = ?, " + COL_PHONE + " = ?, "
			+ COL_EMAIL + " = ?" + " where " + COL_CID + " = ?";
	
//	데이터 삭제
//	delete ex_contact where cid = ?
	public static final String SQL_DELETE =
			"delete " + TABLE_NAME + " where " + COL_CID + " = ?";

	public static void main(String[] args) {
		System.out.println("JDBC 6 - 입력된 데이터를 쿼리에 적용");

		Scanner sc = new Scanner(System.in);

		Connection conn = null;
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

			System.out.println("이름 입력>");
			String name = sc.nextLine();

			System.out.println("전화번호 입력>");
			String phone = sc.nextLine();

			System.out.println("이메일 입력>");
			String email = sc.nextLine();
			
			System.out.println("번호 입력>");
			int cid = sc.nextInt();

			// SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드

			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			pstmt.setInt(4, cid);
			// SQL 쿼리의 ? 순서와 parameteIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameteIndex = 1

//			* 타입 실수 주의 *
			// setInt() : DB의 Number 타입
			// SetString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입

			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
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

	} // end main()

} // end JDBCMain06
