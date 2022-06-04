<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String id = (String) session.getAttribute("id");

	if (id == null) {
		out.print("<script>alert('로그인 해주세요!!')</script>");
		out.print("<script>location.href='HW4.jsp'</script>");
	}
	%>

	<h1>로그인 결과 페이지</h1>
	<h2><%=id%>님, 환영합니다!
	</h2>
</body>
</html>