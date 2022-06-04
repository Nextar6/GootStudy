package edu.web.Board.persistence;

public interface ReplyQuery {
	public static final String TABLE_NAME = "REPLY";
	public static final String COL_REPLY_NO = "REPLY_NO";
	public static final String COL_BOARD_NO = "BOARD_NO";
	public static final String COL_REPLY_CONTENT = "REPLY_CONTENT";
	public static final String COL_REPLY_ID = "REPLY_ID";
	public static final String COL_REPLY_DATE = "REPLY_DATE";

	// insert into REPLY values
	// (reply_seq.nextval, ?, ?, ?, to_char(sysdate, 'YYYY-MM-DD HH:MI:SS'))
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values ("
			+ "reply_seq.nextval, ?, ?, ?, to_char(sysdate, 'YYYY-MM-DD HH:MI:SS'))";

	// TODO : 쿼리문 테스트 하기

	// select * from REPLY where board_no = ? order by reply_no desc;
	public static final String SQL_SELECT_BY_BOARD_NO = "select * from " + TABLE_NAME + " where " + COL_BOARD_NO
			+ " = ? " + "order by " + COL_REPLY_NO + " desc";

	// update reply set
	// reply_content = ?, reply_date = to_char(sysdate, 'YYYY-MM-DD HH:MI:SS')
	// where reply_no = ? and board_no = ?
	public static final String SQL_UPDATE = "update " + TABLE_NAME + " set " + COL_REPLY_CONTENT + " = ?, "
			+ COL_REPLY_DATE + " = to_char(sysdate, 'YYYY-MM-DD HH:MI:SS')" + " where " + COL_REPLY_NO + " = ? and "
			+ COL_BOARD_NO + " = ?";
	// delete from REPLY where reply_no = ? and board_no = ?
	public static final String SQL_DELETE = "delete from " + TABLE_NAME + " where " + COL_REPLY_NO + " = ? and "
			+ COL_BOARD_NO + " =?";
}
