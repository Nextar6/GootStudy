package edu.java.contact06_1;

// JDBC에서 사용될 상수들, SQL 문장들을 정의

public interface OracleQuery {
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER ="scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CID = "cid";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values (contact_seq.nextval, ?, ?, ?)";
	// 입력
	
	public static final String SQL_SELECT_BY_CID =
			"select * from " + TABLE_NAME
			+ " where " + COL_CID + " = ?";
	
	// 검색
	public static final String SQL_UPDATE = 
			"update " + TABLE_NAME + " set " +
			COL_NAME + " = ?, " + COL_PHONE + " = ?, "
			+ COL_EMAIL + " = ?" + " where " + COL_CID + " = ?";
	
	//수정
	public static final String SQL_DELETE =
			"delete " + TABLE_NAME + " where " + COL_CID + " = ?";
	
	//삭제
	
	public static final String SQL_SELECT = 
			"select * from " + TABLE_NAME + " order by " + COL_CID;
	// 전체검색
	

} // end OracleQuery
