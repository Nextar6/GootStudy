package edu.java.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JDBCMain02 {
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER ="scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CID = "cid";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	public static void main(String[] args) {
		System.out.println("JDBC 2 - update");
		
		Connection conn = null;
		Statement stmt = null;
		
//		2. Oracle JDBC 드라이버를 메모리에 로드 괄호확인주의
		try {
			DriverManager.registerDriver(new OracleDriver());
			
//		3. DB와 Connection(연결)을 맺음
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");
		
//		4. Connection 객체를 사용하여 Statement 객체를 생성
		stmt = conn.createStatement();
		
/*		5. SQL 문장 작성
        update ex_contact
        set name = '둘리',
        phone = '010-2222-2222',
        email = 'dooli@test.com'
        where cid = 2;
 */

		String sql_update =
				"update " + TABLE_NAME +
				" set " + COL_NAME + " = '둘리', "
				+ COL_PHONE + " = '010-2222-2222', "
				+ COL_EMAIL + " = 'dooli@test.com'"
				+ " where " + COL_CID + " = 2";
		System.out.println(sql_update);
		
//		6. SQL 문장실행 (DB서버로 SQL 전송)
//		executeUpdate() : INSERT, UPDATE, DELETE를 처리할 때 사용 (DB에 영향을줌)
//		executeQuery() : SELECT를 처리할 때 사용 (DB에있는 자료를 가져오는것)
		int result = stmt.executeUpdate(sql_update);
		
//		7. DB 서버가 보낸 결과 확인/처리
		System.out.println(result + "행이 수정 되었습니다.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	} // end main()


} // end JDBCMain02()
