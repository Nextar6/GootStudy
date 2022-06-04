package edu.java.jdbc07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.OracleDriver;

public class JDBCMain07 {

	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER ="scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CID = "cid";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	public static final String SQL_SELECT_BY_CID =
			"select * from " + TABLE_NAME
			+ " where " + COL_CID + " = ?"; // 쿼리
	
	public static void main(String[] args) {
		
		
				System.out.println("JDBC 7 - select by index");
				Scanner sc = new Scanner(System.in);
				
				// prepared statement로 변경
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
//				2. Oracle JDBC 드라이버를 메모리에 로드 괄호확인주의
				try {
					DriverManager.registerDriver(new OracleDriver());
					
//				3. DB와 Connection(연결)을 맺음
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB 연결 성공");
				
//				4. Connection 객체를 사용하여 preparedStatement 객체를 생성
				pstmt = conn.prepareStatement(SQL_SELECT_BY_CID);
				
				System.out.println("인덱스 입력>");
				int cid = sc.nextInt();

//				5. SQL 문장 작성
//				select * from ex_contact
//				where cid = 2;
				pstmt.setInt(1, cid);
				
			
				
			
//				6. SQL 문장 실행(DB 서버로 SQL 전송) result로 객체만들고 꺼내쓰는형태 -> ResultSet rs = null;
				rs = pstmt.executeQuery(); // 넣을 필요가없음
				
//				7. 서버가 보낸 결과 확인/처리
//				Result.next() : 
//				ResultSet에서 다음 행 (row, record)이 있으면
//				true를 리턴후, ResultSet이 가리키는 위치를 다음 위치로 변경.
				
				if(rs.next()) {
					cid = rs.getInt(1); // 위에이미 선언하며 값받았으니 int 빼주기. cid 컬럼 
					String name = rs.getString(2); // name 컬럼 String 타입 주의
					String phone = rs.getString(3); // phone 컬럼
					String email = rs.getString(4); // email 컬럼
					
					ContactVO vo = new ContactVO(cid, name, phone, email);
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
	} // end main()

} // end JDBCMain07
