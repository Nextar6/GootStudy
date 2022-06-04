package edu.web.memberAnswer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static MemberDAO dao;
   
    public SelectServlet() {
       dao = MemberDAOImple.getInstance();
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userid = request.getParameter("userid");
      if(userid != null) {
         MemberVO vo = dao.select(userid);
         System.out.println(vo);
         
         RequestDispatcher dispatcher = 
               request.getRequestDispatcher("member-result.jsp");
         request.setAttribute("vo", vo);
         dispatcher.forward(request, response);
      }
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

}




