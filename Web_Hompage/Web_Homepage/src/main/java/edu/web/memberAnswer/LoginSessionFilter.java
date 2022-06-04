package edu.web.memberAnswer;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSessionFilter implements Filter {

    public LoginSessionFilter() {
    }

   public void destroy() {
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      // 세션에서 데이터를 가져와서 세션 정보(userid)가 없으면 페이지 접근을 막는 역할
      HttpServletRequest req = (HttpServletRequest) request;  // 다향성
      // 세션에 접근하기 위해 request를 HttpServletRequest로 변환
      HttpSession session = req.getSession();
      String userid = (String)session.getAttribute("userid");
      
      if(userid == null) { // userid세션이 없으면(로그인이 되어 있지 않으면)
         HttpServletResponse res = (HttpServletResponse) response;
         res.sendRedirect("/Homepage/login.jsp");
         return; // 종료
      }
      
      chain.doFilter(request, response);
   }

   public void init(FilterConfig fConfig) throws ServletException {
   }

}