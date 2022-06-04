package edu.java.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

// JDBC : Java DataBase Connection
// 0. 데이터 베이스 라이브러리를 프로젝트 추가
/*			1) 프로젝트에 lib 폴더를 생성
 			2) C:\oracle\app\oracle\product\11.2.0\server\jdbc\lib (11g xe기준)
 				폴더에 있는 ojdbc6.jar 파일을 프로젝트의 lib폴더에 복사
 			3) 복사한 jar 파일(라이브러리)을 build path에 추가
 			(마우스 오른쪽 클릭 -> Build Path -> Add to Build Path)
 		1. DB와 연동하기 위해 필요한 상수들을 정의
 		2. JDBC 드라이버를 메모리에 로드
 		3. DB와 Connection (연결)을 맺음
 		4. Connection 객체를 사용하여 statement 객체를 생성
 		5. SQL 문장을 생성
 		6. Statement 객체를 사용하여 SQL문장을 실행(DB 서버로 SQL 문장을 전송)
 		7. DB 서버가 보내준 결과를 확인/처리
 */
public class JDBCMain01 {
	 // 1. DB에 사용할 상수들
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	// 접속할 오라클 DB경로 로컬호스트 는 아이피주소 (IPv4랑 같다)
	public static final String USER ="scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CID = "cid";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	
	
	
	public static void main(String[] args) {
		System.out.println("JDBC 1- insert");
		
		Connection conn = null;
		Statement stmt = null;
		
		try { // 2 . Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			// 4. Connection 객체를 사용하여 Statement 객체를 생성
			stmt = conn.createStatement();
			
			// 5. SQL 문장 작성
			// insert into ex_ contact values
			// (contact_seq.nextval, 'aaa', '010-1111-1111', 'test@test.com')
			String sql_insert = 
					"insert into " + TABLE_NAME +
					" values(contact_seq.nextval, 'aaa', '010-1111-1111', 'test@test.com')";
			System.out.println(sql_insert);
			
			// 6 . SQL 문장 실행(DB 서버로 SQL 전송)
			int result = stmt.executeUpdate(sql_insert);
			
			// 7. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삽입 되었습니다.");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); // 순서주의
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	} // end main ()

} // end JDBCMain01
