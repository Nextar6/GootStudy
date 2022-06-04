package edu.web.memberAnswer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private static MemberDAO dao;   

    public DeleteServlet() {
        dao = MemberDAOImple.getInstance();
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userid = request.getParameter("userid");
      
      if(userid != null) {
         int result = dao.delete(userid);
         if(result == 1) {
            response.sendRedirect("/Homepage/login.jsp");
         }
      }
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

}




