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
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public static final String COL_INTEREST = "INTEREST";
	public static final String COL_INTRODUCE = "INTRODUCE";

	// insert into MEMBER values
	// (?, ?, ?, ?, ?, ?, ?)
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values (?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_SELECT_BY_USERID = "select * from " + TABLE_NAME + " where " + COL_USERID + " = ?";

	public static final String SQL_SELECT_BY_USERID_PASSWORD = "select " + COL_USERID + " from " + TABLE_NAME
			+ " where " + COL_USERID + " = ?" + " and " + COL_PASSWORD + " = ?";
	
	public static final String SQL_UPDATE_BY_USERID = "update " + TABLE_NAME + " set " + COL_PASSWORD + " = ?, "
			 + COL_EMAIL + " = ?, " + COL_EMAIL_AGREE + " = ?, " + COL_INTEREST + " = ?, " + COL_PHONE +" = ?, "
			+ COL_INTRODUCE + " = ? " + "where " + COL_USERID + " =?";

}
