package edu.web.memberAnswer;

public interface DBConnectionQuery {
   // DB 접속에 필요한 상수 정의
   public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
   public static final String USER = "scott";
   public static final String PASSWORD = "tiger";
   
   // DB 테이블 컬럼 상수 정의
   public static final String TABLE_NAME = "MEMBER";
   public static final String COL_USERID = "USERID";
   public static final String COL_PASSWORD = "PASSWORD";
   public static final String COL_EMAIL = "EMAIL";
   public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
   public static final String COL_INTEREST = "INTEREST";
   public static final String COL_PHONE = "PHONE";
   public static final String COL_INTRODUCE = "INTRODUCE";
   
   // insert into MEMBER values
   // (?, ?, ?, ?, ?, ?, ?)
   public static final String SQL_INSERT = "insert into " + TABLE_NAME
         + " values (?, ?, ?, ?, ?, ?, ?)";
   
   // select * from MEMBER where userid = ?
   public static final String SQL_SELECT_BY_USERID = 
         "select * from " + TABLE_NAME + 
         " where " + COL_USERID + " = ?";
   
   // update MEMBER set
   // password = ?, email = ?, email_agree = ?
   // interest = ?, phone = ?, introduce = ?
   // where userid = ?
   public static final String SQL_UPDATE_BY_USERID = 
         "update " + TABLE_NAME + " set " +
               COL_PASSWORD + " = ?, " +
               COL_EMAIL + " = ?, " + 
               COL_EMAIL_AGREE + " = ?, " + 
               COL_INTEREST + " = ?, " +
               COL_PHONE + " = ?, " +
               COL_INTRODUCE + " = ? " +
               " where " + COL_USERID + " = ?";
   
   // delete from MEMBER where userid = ?
   public static final String SQL_DELETE_BY_USERID = 
         "delete from " + TABLE_NAME + " where " + COL_USERID + " = ?";

   // select userid from MEMBER
   // where userid = ? and password = ?
   public static final String SQL_SELECT_BY_USERID_PASSWORD = 
         "select " + COL_USERID + " from " + TABLE_NAME + " where " 
         + COL_USERID + " = ?" + " and " + COL_PASSWORD + " = ?";
   
}






















