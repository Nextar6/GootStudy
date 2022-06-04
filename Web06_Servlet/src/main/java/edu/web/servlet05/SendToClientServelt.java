package edu.web.servlet05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendToClientServelt
 */
@WebServlet("/send")
public class SendToClientServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendToClientServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* request.setAttribute / request.getAttribute
		  - 데이터를 key-value 형식으로 전송하는 방식
		  - 문자열 뿐만 아니라, 다양한 변수 및 객체를 전송할 수 있음
		  - attribute와 parameter의 차이점
		  - parameter는 html form태그를 통해 데이터를 전송
		  ***********(form 외의 위치에서 데이터 추가 불가능)*************
		  - parameter는 String형태의 값만 전송
		  - attribute는 client/server에서 생성하여 전송가능
		  - attribute는 문자열 뿐만 아니라, 다양한 변수 및 객체를 전송 가능
		 */
		
		request.setAttribute("name", "고길동");
		request.setAttribute("lived", "서울 강남");
		request.setAttribute("age", 40);
		request.setAttribute("vo", new InfoVO());
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/my_info.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
