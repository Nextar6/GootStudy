package edu.web.member;

public interface DBConnectionQuery {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	// DB 테이블 컬럼 상수 정의
	public static final String TABLE_NAME = "MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";

	// insert into MEMBER values , 쿼리 작성하기
	// (?, ?, ?, ?, ?, ?, ?)
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values(?, ?)";
	// select * from MEMBER where userid = ?
	public static final String SQL_SELECT_BY_USERID = "select * from " + TABLE_NAME + "where " + COL_USERID + " =?";

	// update MEMBER set
	// password = ?, email =?, emailAgree = ?, interest = ?, introduc = ?,
	// where userid = ?
	public static final String SQL_UPDATE = "update " + TABLE_NAME + "set" + COL_USERID + " =?, " + COL_PASSWORD
			+ "=?, " + "where " + COL_USERID + " =?";
	// delete from MEMBER where userid = ?
	public static final String SQL_DELETE_BY_USERID = "delete from" + TABLE_NAME + " where" + COL_USERID + " =?";
	
	// select from MEMBER where userid = ? and password = ?
	public static final String SQL_SELECT_BY_USERID_PASSWORD =
			"select " + COL_USERID + " from " + TABLE_NAME + "where" +
	 COL_USERID + "= ?" + " and " + COL_PASSWORD + " = ?";
			
}