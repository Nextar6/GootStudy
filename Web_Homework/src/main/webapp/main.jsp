<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<%
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String  intresting= request.getParameter("interesting");
	%>
 <h2>로그인 화면</h2>
  <form action="login.do" method="post">
    <p>아이디</p>
    <input type="text" name="userid" placeholder="아이디 입력" required>
    <p>패스워드</p>
    <input type="password" name="password" placeholder="비밀번호 입력" required><br>
    <input type="submit" value="로그인">
    </form>
    
</body>
</html>