<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Request</title>
</head>
<body>
	<%--
	* Request
	- 요청한 HTTP의 객체(ip 주소, 파라미터 등) 을 갖고 있는 객체(servlet의 HttpServletRequest와 동일)
	- 요청한 객체(A -> B로의 요청)만 가지고 있음(요청 위치를 벗어나면 사라짐)
	 --%>

	<%
	out.println("당신의 IP 주소 : " + request.getRemoteAddr() + "<br>");
	out.println("당신의 Host Name : " + request.getHeader("host") + "<br>");
	out.println("당신의 쿠키 : " + request.getHeader("cookie") + "<br>");
	out.println("당신의 servlet 경로 : " + request.getServletPath() + "<br>");

	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");

	// get ParameterValeus() : form에서 보낸 name 이 2개 이상인 경우
	// 배열 형태로 받아오기 위해서 이 메소드를 사용
	String[] interest = request.getParameterValues("interest");
	%>

	<h1>결과 페이지</h1>
	<p>
		제 이름은
		<%=firstName + lastName%></p>
	<%
	for (int i = 0; i < interest.length; i++) {
	%>
	<p>
		제 취미는
		<%=interest[i]%>
		입니다
	</p>
	<%
	}
	%>

</body>
</html>