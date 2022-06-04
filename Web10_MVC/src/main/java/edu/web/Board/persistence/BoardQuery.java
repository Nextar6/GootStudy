package edu.web.Board.persistence;

public interface BoardQuery {
	public static final String TABLE_NAME = "BOARD";
	public static final String COL_BNO = "BNO";
	public static final String COL_TITLE = "TITLE";
	public static final String COL_CONTENT = "CONTENT";
	public static final String COL_USERID = "USERID";
	public static final String COL_CDATE = "CDATE";

	// 게시글 등록
	// insert into BOARD values
	// (BOARD_SEQ.next, ?, ?, ?, ?, to_char(sysdate, 'YYY-MM-DD HH:MI:SS'))
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values "
			+ "(BOARD_SEQ.nextval,  ?, ?, ?, to_char(sysdate, 'YYYY-MM-DD HH:MI:SS'))";

	// 전체 게시글 가져오기
	// select * from BOARD order by BNO desc;
	public static final String SQL_SELECT_ALL = "select * from " + TABLE_NAME + " order by " + COL_BNO + " desc";

	// 게시글 하나 선택하기
	// select * from BOARD where bno = ?
	public static final String SQL_SELECT_BY_BNO = "select * from " + TABLE_NAME + " where " + COL_BNO + " = ?";

	// 게시글 하나 수정하기
	// update BOARD set
	// TITLE = ?, CONTENT = ?, CDATE = to_char(sysdate, 'YYYY-MM-DD HH:MI:SS')
	// where BNO = ?
	public static final String SQL_UPDATE = "update " + TABLE_NAME + " set " + COL_TITLE + " = ?, " + COL_CONTENT
			+ " = ?, " + COL_CDATE + " = to_char(sysdate, 'YYYY-MM-DD HH:MI:SS')" + " where " + COL_BNO + " = ?";

	// 게시글 하나 삭제하게
	// delete from BOARD where BNO = ?
	public static final String SQL_DELETE = " delete from " + TABLE_NAME + " where " + COL_BNO + " = ?";

	// 게시글 페이징 처리 검색
//	select b.bno, b.title, b.content, b.userid, b.cdate from(
//		    select rownum rn, a.* from(
//		    	      select * from board order by bno desc
//		    	)a
//		    	)b where rn BETWEEN ? and ?;
	public static final String SQL_SELECT_PAGESCOPE = "select b." + COL_BNO + ", b." + COL_TITLE + ", b." + COL_CONTENT + ", b." + COL_USERID + ", b." + COL_CDATE + " from("
			+ "select rownum rn, a.* from("
			+ "select * from " + TABLE_NAME + " order by " + COL_BNO + " desc"
			+ ")a"
			+ ")b where rn between ? and ?";
	
	// select count(*) total_cnt from board;
	public static final String SQL_TOTAL_CNT =
			"select count(*) total_cnt from " + TABLE_NAME;
}
