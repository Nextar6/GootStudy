package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static MemberDAO dao;

	public UpdateServlet() {
		dao = MemberDAOImple.getInstance();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String introduce = request.getParameter("introduce");
		System.out.println(userid + "서블릿 세션");
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);

		int result = dao.update(vo);
		System.out.println(result);
		if (result == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member-result.jsp");
			request.setAttribute("vo", vo);
			dispatcher.forward(request, response);
			System.out.println(vo);
			
		}

	}

}
