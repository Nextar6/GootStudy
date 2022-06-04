<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="login_auth.do" method="post">
		<h1>로그인</h1>
		아이디 : <input type="text" name="userid" required="required"placeholder="아이디 입력" ><br>
		비밀번호 : <input type="password" name="password" placeholder="비밀번호 입력" required="required"><br>
		<input type="submit" value="로그인">
	</form>

	<a href=" member-register.jsp" title="회원가입"><button>회원가입</button></a>
</body>
</html>