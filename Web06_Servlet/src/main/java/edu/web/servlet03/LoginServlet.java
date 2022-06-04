.package edu.web.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login_test")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = LoginServlet.class.getName();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // GET 방식 : url에 query string이 나타나는 형태. (보안에 상관없는 데이터를 전송할 때 사용)
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 요청 파라미터(request parameter)의 값을 읽는 방식
		// GET 방식에서 요청 파라미터는 url
		// http://localhost:8080/Web06_Servlet/login_test?userid=test&password=1234
		// 브라우저 -> F12 -> Network 탭 -> 요청된 링크 주소로 확인가능
		// - http : 프로토콜
		// - localhost : 서버주소(도메인 이름) 아이피주소 가능
		// - 8080 : 포트번호
		// - web06_Servlet : context root(서버에서 파일을 찾아갈 최초 경로)
		// - login_test : servlet 경로(urlPattern)
		// - ?userid=test&password=1234 : query string
		System.out.println(CLASSNAME + " : doGet() 호출");
		login(request, response);
	}
	// HTTPServletRequest : 요청한 HTTP의 객체(ip 주소, 파라미터 등)을 저장하는 클래스
	// HTTPServletResponse : HTTP요청에 대응하는(보내는) 정보를 저장하는 클래스
	// * 중요 : request와 response의 객체를 생성하고 호출하는 역할은 서버에서 컨트롤
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 브라우저(form)에서 전송된 데이터를 꺼내는 코드
		String ip = request.getRemoteAddr(); // 요청한 HTTP의 IP주소를 저장
		System.out.println("[" + ip + "]");
		// 요청 파라미터(request parameter)의 값을 읽어옴
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		System.out.println("아이디 :  " + userid);
		System.out.println("비밀번호 : " + password);
	/*  새로운 페이지를 생성하는 코드
	 * 요청에 대응하는 데이터 인코딩 설정
	 */
	response.setCharacterEncoding("UTF-8");
	// PrintWriter 클래스
	// - HTML 페이지를 생성해주는 클래스
	PrintWriter out = response.getWriter();
	out.append("<!DOCTYPE html>")
		.append("<head><meta charset='utf-8'</head>")
		.append("<body>")
		.append("<h1>로그인 결과 페이지</h1>")
		.append("아이디 : " + userid + "<br>")
		.append("비밀번호 : " + password + "<br>")
		.append("</body>").append("</html>");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// POST 방식 : url에 query string이 보이지 않음. (중요한 데이터)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " : doPost() 호출");
	}
		
}

