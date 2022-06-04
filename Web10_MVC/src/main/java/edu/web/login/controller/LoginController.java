package edu.web.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.go")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		if (userid.equals("123") && password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			session.setMaxInactiveInterval(600);

			// 설정된 목표 url 가져오기
			String url = (String) session.getAttribute("targetURL");
			System.out.println("targetURL : " + url);
			
			if(url != null && !url.equals("")) { // targetURL이 존재하는 경우
				session.removeAttribute("targetURL");
				response.sendRedirect(url);
			}else { // targetURL이 존재하지 않는 경우
				response.sendRedirect("index.jsp");
				
			}
		} else { // 내가 알림창 뛰울려고 임의로 바꿈 원래는 센드리다이렉트 위 성공과 동일한데 주소만 
			// response.sendRedirect("login.go"); <- 원래 수업때 작성한 코드
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('로그인 실패 (비밀번호와 아이디를 확인해주세요.)');</script>");
			out.print("<script>location.href='" + "login.go" + "';</script>");
		}

	}

}
