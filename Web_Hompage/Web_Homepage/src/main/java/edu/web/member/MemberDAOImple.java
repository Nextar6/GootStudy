package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements DBConnectionQuery, MemberDAO {

	private static MemberDAOImple instance = null;
	
	private MemberDAOImple() {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {		
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("오라클 연결 성공");
		pstmt = conn.prepareStatement(SQL_INSERT);
		pstmt.setString(1, vo.getUserid());
		pstmt.setString(2, vo.getPassword());
		result = pstmt.executeUpdate();
		
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
