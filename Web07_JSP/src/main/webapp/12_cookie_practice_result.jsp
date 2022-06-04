<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
<%
   String agreed = request.getParameter("isSaveAgreed");
   // checkbox가 선택될 경우 agreed가 저장됨
   
   if(agreed != null) {
      Cookie idCookie = new Cookie("id", request.getParameter("id"));
      
      idCookie.setMaxAge(60);
      
      response.addCookie(idCookie);
   }

%>
</head>
<body>
   <h1>로그인 결과 화면</h1>
   <p><%=request.getParameter("id") %>님, 환영합니다.</p>

</body>
</html>





