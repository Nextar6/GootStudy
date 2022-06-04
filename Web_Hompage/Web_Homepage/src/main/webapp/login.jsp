<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.auth.do" method="post">
		<p>아이디</p>
		<input type="text" name="userid" placeholder="아이디 입력" required><br>
		<p>패스워드</p>
		<input type="password" name="password" placeholder="비밀번호 입력" required>
		<br>
		<input type="submit" value="로그인">
	</form>
	<a href="member-register.jsp"><input type="button" value="회원가입"></a>
</body>
</html>