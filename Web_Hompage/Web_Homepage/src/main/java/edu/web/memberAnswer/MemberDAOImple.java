package edu.web.memberAnswer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements DBConnectionQuery, MemberDAO{
   private static MemberDAOImple instance = null;
   private static final String CLASSNAME = MemberDAOImple.class.getName();
   
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
      System.out.println(CLASSNAME + " : insert() 호출");
      int result = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("오라클 연결 성공");
         pstmt = conn.prepareStatement(SQL_INSERT);
         pstmt.setString(1, vo.getUserid());
         pstmt.setString(2, vo.getPassword());
         pstmt.setString(3, vo.getEmail());
         pstmt.setString(4, vo.getEmailAgree());
         // interest 배열을 문자열로 연결하여 전송
         pstmt.setString(5, vo.getInterestJoin());
         pstmt.setString(6, vo.getPhone());
         pstmt.setString(7, vo.getIntroduce());
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return result;
   }

   @Override
   public MemberVO select(String userid) {
      System.out.println(CLASSNAME + " : select() 호출");
      MemberVO vo = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("오라클 연결 성공");
         pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            userid = rs.getString(COL_USERID);
            String password = rs.getString(COL_PASSWORD);
            String email = rs.getString(COL_EMAIL);
            String emailAgree = rs.getString(COL_EMAIL_AGREE);
            String[] interest = null;
            if(rs.getString(COL_INTEREST) != null) {
               interest = rs.getString(COL_INTEREST).split(",");
            }
            String phone = rs.getString(COL_PHONE);
            String introduce = rs.getString(COL_INTRODUCE);
            vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return vo;
   }

   @Override
   public int update(MemberVO vo) {
      System.out.println(CLASSNAME + " : update() 호출");
      int result = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("오라클 연결 성공");
         pstmt = conn.prepareStatement(SQL_UPDATE_BY_USERID);
         pstmt.setString(1, vo.getPassword());
         pstmt.setString(2, vo.getEmail());
         pstmt.setString(3, vo.getEmailAgree());
         pstmt.setString(4, vo.getInterestJoin());
         pstmt.setString(5, vo.getPhone());
         pstmt.setString(6, vo.getIntroduce());
         pstmt.setString(7, vo.getUserid());
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return result;
   }

   @Override
   public int delete(String userid) {
      System.out.println(CLASSNAME + " : delete() 호출");
      int result = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("오라클 연결 성공");
         pstmt = conn.prepareStatement(SQL_DELETE_BY_USERID);
         pstmt.setString(1, userid);
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return result;
   }

   @Override
   public String select(String userid, String password) {
      System.out.println(CLASSNAME + " : select() 호출");
      String returnid = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("오라클 연결 성공");
         pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID_PASSWORD);
         pstmt.setString(1, userid);
         pstmt.setString(2, password);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            returnid = rs.getString(COL_USERID);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return returnid;
   }

}











