package alo.java.test02;

public class OracleDatabase implements DataBaseQ{

	@Override
	public int insert(String id, String pw) {
		System.out.println("오라클 DB연결");
		System.out.println("SQL 문장 작성/실행");
		System.out.println("SQL 실행결과 처리");
		return 1;
	}

}
