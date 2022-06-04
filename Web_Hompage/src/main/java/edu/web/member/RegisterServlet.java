package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	
       
 
    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// url 로 접근할 경우 다른 경로로 이동 시킴 *다른페이지에서 접근시 최초 페이지로 이동시키는 *
		response.sendRedirect("/login.jsp");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String introduce= request.getParameter("introduce");
	
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println(result);
		// DB 저장에 성공하면 다른 페이지에 VO 데이터 전송
		if(result == 1) {
			// request 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("vo", vo); // 파라미터아님 vo 한번에 보내기
			dispatcher.forward(request, response);
		} else { // TODO 예외 제대로 처리.
			System.out.println("저장실패");
		}
		
			
			// servlet에서 세션 생성 방법
//			HttpServlet session = request.getSession(); // 세션 객체 가져오기
//			session.setAttribute("userid",userid);
//			session.setMaxInactiveInterval(60);
			
			
		
	}

}
