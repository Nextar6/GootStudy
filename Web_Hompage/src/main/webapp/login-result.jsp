<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<p>
		<%
		String userid = (String) session.getAttribute("userid");
		%>
		<%=userid%>님 환영합니다.
		<button onclick="location.href='select.do?userid=<%=userid%>'">회원정보</button>
		<button onclick="location.href='logout.do?userid=<%=userid%>'">로그아웃</button>
		
	</p>
</body>
</html>