<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 보기</title>
</head>
<body>
	<!-- 서버에 저장된 이미지 출력하기 -->
	<%
		String fileName = (String) session.getAttribute("fileName");
	%>
	<img alt="곰돌이" src="images/<%=fileName %>" width="200" height="200">	

</body>
</html>