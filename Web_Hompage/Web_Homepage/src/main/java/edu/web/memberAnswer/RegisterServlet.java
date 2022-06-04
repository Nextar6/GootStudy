package edu.web.memberAnswer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static MemberDAO dao;

    public RegisterServlet() {
       dao = MemberDAOImple.getInstance();
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // url로 접근할 경우 다른 경로로 이동 시킴
      response.sendRedirect("/Homepage/login.jsp");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userid = request.getParameter("userid");
      String password = request.getParameter("password");
      String email = request.getParameter("email");
      String emailAgree = request.getParameter("emailAgree");
      String[] interest = request.getParameterValues("interest");
      String phone = request.getParameter("phone");
      String introduce = request.getParameter("introduce");
      
      MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
      System.out.println(vo);
      
      int result = dao.insert(vo);
      System.out.println(result);
      // DB 저장에 성공하면 다른 페이지에 VO 데이터 전송
      if(result == 1) {
         // request 포워딩
         RequestDispatcher dispatcher = 
               request.getRequestDispatcher("18_db_result.jsp");
         request.setAttribute("vo", vo);
         dispatcher.forward(request, response);
         
         // servlet에서 세션 생성 방법
//         HttpSession session = request.getSession(); // 세션 객체 가져오기
//         session.setAttribute("userid", userid);
//         session.setMaxInactiveInterval(60);
         
      }
      
      
   }

}






















