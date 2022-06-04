package side.java.porject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class MyPlayListDAOImple implements MusicDAO, MusicQuery {

	// singleton
	private static MyPlayListDAOImple instance = null;

	private MyPlayListDAOImple() {
		System.out.println("MPL 싱글톤 생성자");
	}

	public static MyPlayListDAOImple getInstance() {
		System.out.println("getInstance()호출 : instance = " + instance);
		if (instance == null) {
			instance = new MyPlayListDAOImple();
		}
		return instance;

	}

	@Override
	public int insert(MusicVO vo) {
		System.out.println("insert 호출 : vo = " + vo);
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결성공");

			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getJanre());
			pstmt.setString(4, vo.getYear());

			result = pstmt.executeUpdate();
			System.out.println(result + " 행이 등록되었습니다.");
			return result;

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

		return result;
	} // insert end !

	@Override
	public ArrayList<MusicVO> select() {
		System.out.println("select() 호출");
		ArrayList<MusicVO> list = new ArrayList<MusicVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");

			pstmt = conn.prepareStatement(SQL_SELECT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt(1);
				String title = rs.getString(2);
				String artist = rs.getString(3);
				String janre = rs.getString(4);
				String year = rs.getString(5);

				MusicVO vo = new MusicVO(cid, title, artist, janre, year);
				list.add(vo);

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
		return list;
	} // end AllList

	@Override
	public MusicVO select(int index) {
		MusicVO vo = new MusicVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CID);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				index = rs.getInt(1);
				String title = rs.getString(2);
				String artist = rs.getString(3);
				String janre = rs.getString(4);
				String year = rs.getString(5);

				vo = new MusicVO(index, title, artist, janre, year);
				System.out.println(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

	@Override
	public int update(int index, MusicVO vo) {
		Connection conn = null;
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 등록 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			pstmt = conn.prepareStatement(SQL_UPDATE);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getJanre());
			pstmt.setString(4, vo.getYear());
			pstmt.setInt(5, index);
			result = pstmt.executeUpdate();

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

		return result;

	} // end update

	@Override
	public int delete(int index) {
		Connection conn = null; // 데이터베이스와 연결변수
		int result = 0;
		PreparedStatement pstmt = null; // SQL문을 활용하기 위한 클래스

		try {
			DriverManager.registerDriver(new OracleDriver()); // 오라클 드라이버 연결 트라이캐치
			System.out.println("드라이버 등록성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // 드라이버매니저로 계정연결
			System.out.println("DB연결");
			pstmt = conn.prepareStatement(SQL_DELETE); // 쿼리 삭제문이용

			pstmt.setInt(1, index); // ? 가 첫번째 이면 1 리턴;
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; // ? 가 첫번째 이면 1 리턴;
	}

	@Override
	public ArrayList<MusicVO> selectKategorieJanre(String janre) { // 검색과....전체검색..짬뽕

		ArrayList<MusicVO> list = new ArrayList<MusicVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			pstmt = conn.prepareStatement(SQL_SELECT_KATEGORIE_JANRE);
			pstmt.setString(1, janre); // *열순서가아니라 쿼리문에서 물음표순서였다....wow!!*
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt(1);
				String title = rs.getString(2);
				String artist = rs.getString(3);
				janre = rs.getString(4);
				String year = rs.getString(5);

				MusicVO vo = new MusicVO(cid, title, artist, janre, year);
				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list; 
		
	}// end selectkategorieJanre()

	@Override
	public ArrayList<MusicVO> selectKategorieArtist(String artist) { // 가수별 검색

		ArrayList<MusicVO> list = new ArrayList<MusicVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			pstmt = conn.prepareStatement(SQL_SELECT_KATEGORIE_ARTIST);
			pstmt.setString(1, artist); // *가수별 검색*
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt(1);
				String title = rs.getString(2);
				artist = rs.getString(3);
				String janre = rs.getString(4);
				String year = rs.getString(5);

				MusicVO vo = new MusicVO(cid, title, artist, janre, year);
				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list; 
	
	}

	@Override
	public ArrayList<MusicVO> selectKategorieYear(String year) {

		ArrayList<MusicVO> list = new ArrayList<MusicVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			pstmt = conn.prepareStatement(SQL_SELECT_KATEGORIE_YEAR);
			pstmt.setString(1, year); // *년도별 검색*
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt(1);
				String title = rs.getString(2);
				String artist = rs.getString(3);
				String janre = rs.getString(4);
				year = rs.getString(5);

				MusicVO vo = new MusicVO(cid, title, artist, janre, year);
				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list; 
	}

} // END MyPalyListImple
