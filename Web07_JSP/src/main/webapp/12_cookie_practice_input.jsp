<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%
   Cookie[] cookies = request.getCookies();
   
   String id = "";
   
   if(cookies != null) {
      for (Cookie cookie : cookies) {
         if(cookie.getName().equals("id")){ // 쿠키의 key 이름이 "id"인 경우
            id = cookie.getValue(); // 그 쿠키의 값을 저장
         }
      }
   }
   
%>
</head>
<body>
   <form action="12_cookie_practice_result.jsp" method="post">
      아이디 <br> <input type="text" name="id" placeholder="아이디 입력" value="<%=id%>"><br>
      비밀번호 <br> <input type="password" name="pw" placeholder="비밀번호 입력"><br>
      <input type="checkbox" name="isSaveAgreed" value="agreed">아이디 저장<br><br>
      <input type="submit" value="로그인">
   </form>
</body>
</html>












