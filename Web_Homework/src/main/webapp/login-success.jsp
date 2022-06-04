<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1>로그인 성공</h1>
	<h2>회원 정보</h2>
	<%
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String  intresting= request.getParameter("interesting");
	%>
	<p><%=userid %>님, 환영합니다.</p>
	<p><%=password %>님, 환영합니다.</p>
	<p><%=email %>님, 환영합니다.</p>
	<p><%=emailAgree %>님, 환영합니다.</p>
	

</body>
</html>