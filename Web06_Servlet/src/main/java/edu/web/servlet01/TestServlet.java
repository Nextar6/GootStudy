package edu.web.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

/* 서블릿(Servlet)
 - 자바를 이용하여 웹페이지를 동적으로 생성하는 server-side프로그램
 - 웹서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종
 - 서블릿은 자바 코드 안에 HTML을 포함
 - JSP는 HTML 문서 안에서 자바 코드를 포함
 - JSP는 최종적으로 서블릿 형태로 실행됨
 
 * 서블릿의 서버 경로 사용 방법
 * 1. Annotation 방식 : Servlet 3.0 버전 이후부터 적용
 * @WebServlet(name = "", urlPatterns = {})
 */
@WebServlet(name="/TestServlet",urlPatterns = {"/test","/hello"}, loadOnStartup = 2)

/*2. 배포 관리자(deployment descriptor)를 사용
 * <web.xml 생성방법>
 * - 프로젝트 마우스 오른쪽 클릭 - Java EE Tools - Generate Deployment Descriptor Stub
 * - WEB-INF -> web.xml 수정
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = TestServlet.class.getName();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        System.out.println(CLASSNAME + " : TestServlet 생성자 호출");
        
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	System.out.println(CLASSNAME + " : init()");
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(CLASSNAME + " doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
