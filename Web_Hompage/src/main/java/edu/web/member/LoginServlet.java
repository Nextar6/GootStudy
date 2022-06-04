package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public LoginServlet() {
		dao = MemberDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String checkUser = dao.select(userid, password);
		System.out.println("checkUser : " + checkUser);
		System.out.println(userid);
		System.out.println(password);

		PrintWriter out = response.getWriter();

		if (checkUser != null) { // 아이디& 패스워드 일치 : 로그인성공
			HttpSession session = request.getSession();
			session.setAttribute("userid", checkUser);
			session.setMaxInactiveInterval(60);
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('로그인 성공!');</script>");
			out.print("<script>location.href='login-result.jsp';</script>");
			out.print("</head>");

		} else {
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('로그인 실패!');</script>");
			out.print("<script>location.href='login.jsp';</script>");
			out.print("</head>");
			System.out.println("로그인 실패");
		}

	}

}
