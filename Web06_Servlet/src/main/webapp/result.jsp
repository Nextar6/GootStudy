<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
	<%! String name, age, email; %>
	
	<%
		// request : forward에서 넘겨받은 request 객체
		name = request.getParameter("name");
		age = request.getParameter("age");
		email = request.getParameter("email");
	%>
	
	<h1>결과 페이지</h1>
	<p>제 이름은 <%=name %>입니다.</p>
	<p>제 나이는 <%=age %>입니다.</p>
	<p>제 이메일은 <%=email %>입니다.</p>
	
</body>
</html>