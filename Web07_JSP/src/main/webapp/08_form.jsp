<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Request</title>
</head>
<body>
	<h1>GET 방식 데이터 전송</h1>
	<!-- action에 url을 작성하는데 페이지로 이동할 경우 .jsp를 붙여야 함 -->
	<form action="08_request.jsp" method="get">
		성<br><input type="text" name="firstName"><br>
		이름<br><input type="text" name="lastName"><br>
		취미<br><input type="checkbox" name="interest" value="music">음악
		<input type="checkbox" name="interest" value="movie">영화
		<br><input type="submit" value="전송">
		
	</form>
</body>
</html>