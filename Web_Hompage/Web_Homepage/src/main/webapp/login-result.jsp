<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>
	<%
	String userid = (String) session.getAttribute("userid");
	%>
	<h2><%=userid%>님, 환영합니다!
	</h2>
	<button onclick="location.href='select.do?userid=<%=userid%>'">회원정보</button>
	<button onclick="location.href='logout.do?userid=<%=userid%>'">로그아웃</button>
	<!-- 
        get 방식으로 전송
        location.href=''
   -->
</body>
</html>