package edu.web.servlet02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet(urlPatterns = "/LifeCycleServlet", loadOnStartup = 1)
// loadOnstartup :
// - 서버가 실행 될 때 서블릿 인스턴스를 메모리에 로드하는 우선순위를 설정
// - 숫자가 작을수록 init() 함수가 실행되는 순서가 빠름 보통초기화 할때 씀


public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = LifeCycleServlet.class.getName();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
       System.out.println(CLASSNAME + " : LifeCycleServlet 생성자 호출");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println(CLASSNAME + " : init() 호출");
    	super.init();
    }
    
    // service() : 외부에서 Servlet으로 특정 HTTP 요청(Get, Post)을 처리하는 생명 주기 메소드
    // - doGet()과 doPost()가 Service()의 역할을 분할해서 담당
    
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(arg0, arg1);
    	System.out.println(CLASSNAME + " : service() 호출");
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// destroy() : Servlet이 종료 될 때 호출 되는 생명 주기 메소드,
	@Override
	public void destroy() {
		System.out.println(CLASSNAME + " : destroy() 호출");
		super.destroy();
	}

}
