package edu.web.servlet04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwordTestServlet
 */
@WebServlet("/forward")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = ForwardTestServlet.class.getName();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForwardTestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// forward : URL 주소 유지. request/response 객체유지
	// - 같은 웹 서버 내에 있는 경로들로만 이동이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(CLASSNAME + " : doGet() 호출");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		
		System.out.println("이름 : " + name + ", 나이 : " + age + ", 이메일 : " + email);
		/*
		  존재하는 페이지에 데이터를 보내는 방식
		  info.html -> ForwardTestServlet.java(forward) -> result.jsp
		  html은 데이터를 읽어오는 동적 기능이 없기 때문에 jsp로 데이터를 받아와야함
		  
		  forward 방식에서 페이지를 이동할 때는 
		  RequestDispatcher 인터페이스의 forward(request,response)메소드를 사용
		  이때 url은 변경되지 않음
		 
		 */
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
		
		// request에 있는 데이터를 jsp에 전달
		dispatcher.forward(request, response);
		// result.jsp에 request 객체를 전달하고
		// 전달 받은 request에서 parameter를 꺼내는 방식
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
