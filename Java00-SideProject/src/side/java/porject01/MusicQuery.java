package side.java.porject01;

public interface MusicQuery {

		public static final String URL = 
				"jdbc:oracle:thin:@localhost:1521:xe";
		public static final String USER ="scott";
		public static final String PASSWORD = "tiger";
		public static final String TABLE_NAME = "MUSICLIST";
		public static final String COL_CID = "cid";
		public static final String COL_TITLE = "title";
		public static final String COL_ARTIST = "artist";
		public static final String COL_JANRE = "janre";
		public static final String COL_YEAR = "year";
		
		public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values (MUSICLIST_SEQ.nextval, ?, ?, ?, ?)";
		// 입력
		
		public static final String SQL_SELECT_BY_CID =
				"select * from " + TABLE_NAME
				+ " where " + COL_CID + " = ?";
		
		// 검색
		public static final String SQL_UPDATE = 
				"update " + TABLE_NAME + " set " +
				COL_TITLE + " = ?, " + COL_ARTIST + " = ?, "
				+ COL_JANRE + " = ?," + COL_YEAR + " = ?" + " where " + COL_CID + " = ?";
		
		//수정
		public static final String SQL_DELETE =
				"delete " + TABLE_NAME + " where " + COL_CID + " = ?";
		
		//삭제
		
		public static final String SQL_SELECT = 
				"select * from " + TABLE_NAME + " order by " + COL_CID;
		// 전체검색
		
		public static final String SQL_SELECT_KATEGORIE_JANRE = 
				"select * from " + TABLE_NAME + " where " + COL_JANRE + " =?";
		// 장르별 카테고리 검색
		
		public static final String SQL_SELECT_KATEGORIE_ARTIST =
				"select * from " + TABLE_NAME + " where " + COL_ARTIST + " = ?";
		// 가수별 검색
		
		public static final String SQL_SELECT_KATEGORIE_YEAR =
				"select * from " + TABLE_NAME + " where " + COL_YEAR + " = ?";
		// 년도별 검색
		
		

		
		// 뮤직 테이블에서 카테고리 장르 셀렉트문으로 불러오기

	} // end MusicQuery

