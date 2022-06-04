package hw.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OracleDriver;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = RegisterServlet.class.getName();
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER ="scott";
	public static final String PASSWORD = "tiger";
	public static final String TABLE_NAME = "MEMBER";
	public static final String SQL_INSERT = "insert into " + TABLE_NAME + " values (member_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
	private static RegisterServlet instance = null;
	public static RegisterServlet getInstancet() {
		if (instance == null) {
			instance = new RegisterServlet();
		}
		return instance;
	}

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME  + " doPost() 호출 ");
		request.setCharacterEncoding("UTF-8"); // 한글 처리
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String introduce = request.getParameter("introduce");
		String interesting = Arrays.toString(interest);
		
			System.out.println("아이디 :" + userid);
			System.out.println("비밀번호 :" + password);
			System.out.println("핸드폰 : " + phone);
			System.out.println("이메일 :" + email);
			System.out.println("이메일수신 :" + emailAgree);
			
			System.out.println(interesting);
			
			System.out.println("자기소개 : " + introduce);
			
			String path = request.getContextPath();
			
			if(userid != "" && password != "" && email != "" && phone != "" && emailAgree != "" && introduce != "") {
				System.out.println("있는 상태");
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					DriverManager.registerDriver(new OracleDriver());
					System.out.println("드라이버 등록성공");
					
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					System.out.println("DB연결");
					
					pstmt = conn.prepareStatement(SQL_INSERT);
					
					pstmt.setString(1, userid);
					pstmt.setString(2, password);
					pstmt.setString(3, phone);
					pstmt.setString(4, email);
					pstmt.setString(5, emailAgree);
					pstmt.setString(6, interesting);
					pstmt.setString(7, introduce);
					pstmt.executeUpdate();
					System.out.println("행 등록");
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  finally {
					try {
						pstmt.close();
						conn.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				response.sendRedirect(path + "/main.jsp");
			} else {
				System.out.println("없는 상태");
				response.sendRedirect(path + "/member-register.jsp");
			}
			
			
//			response.sendRedirect(location);
			
//			response.sendRedirect(path+"/member-register.jsp");
			
			
		
	}

}
