package edu.java.jdbc08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.OracleDriver;

public class JDBCMain08 {
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER ="scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "EX_PRODUCT";
	public static final String COL_PNO = "pno";
	public static final String COL_PNAME = "pname";
	public static final String COL_PPRICE = "pprice";
	public static final String COL_PCOUNT = "pcount";
	public static final String COL_PSELLER = "pseller";
	public static final String COL_PDATE = "pdate";
	
	// insert into ex_produc (pno, pname ,pprice, pcount, pseller)
	// values (product_seq.nextval, ?, ?, ?, ?)
	
	// 제품 이름으로 검색
	// selelct * from ex_product where pname like ?
	
	public static final String SQL_SELECT_BY_PNAME =
			"select * from " +TABLE_NAME +
			" where " + COL_PNAME + " like ?";
			
			

	public static void main(String[] args) {
		
		
		System.out.println("JDBC 8 - select by index");
		Scanner sc = new Scanner(System.in);
		
		// prepared statement로 변경
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
		pstmt = conn.prepareStatement(SQL_SELECT_BY_PNAME);
		
		System.out.println("검색할 상품 키워드 입력>");
		String keyword = sc.nextLine();

		pstmt.setString(1, "%" + keyword + "%");
		
		rs = pstmt.executeQuery(); // 넣을 필요가없음
		
//		7. 서버가 보낸 결과 확인/처리
//		Result.next() : 
//		ResultSet에서 다음 행 (row, record)이 있으면
//		true를 리턴후, ResultSet이 가리키는 위치를 다음 위치로 변경.
		while(rs.next()) {
			int pno = rs.getInt(COL_PNO);
			String pname = rs.getString(COL_PNAME);
			int pprice = rs.getInt(COL_PPRICE);
			int pcount = rs.getInt(COL_PCOUNT);
			String pseller = rs.getString(COL_PSELLER);
			Timestamp ts = rs.getTimestamp(COL_PDATE);
			// Timestamp 를 데이트 타입으로 변환 !! 
			Date pdate = new Date(ts.getTime());
			ProductVO vo = new ProductVO(pno, pname, pprice, pcount, pseller, pdate);
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


}
