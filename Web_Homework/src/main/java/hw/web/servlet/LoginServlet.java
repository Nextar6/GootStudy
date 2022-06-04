package hw.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = RegisterServlet.class.getName();
       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " : doPost() 호출");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		System.out.println("userid : " + userid);
		System.out.println("password : " + password);
		
		String path = request.getContextPath();
		if(userid.equals("test") && password.equals("1234")) {
			// DB를 통한 로그인
			String pageName = "/login-success.jsp";
			String location = path + pageName + "?userid=" + userid;
			response.sendRedirect(location);
					
		} else {
			String pageName = "/main.jsp";
			String location = path + pageName;
			response.sendRedirect(location);
		}

	}

}
