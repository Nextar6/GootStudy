<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Cookie</title>
</head>
<body>
	<h1>쿠키 가져오기(Get)</h1>
	<%
		Cookie cookie = null;
		Cookie[] cookies = null;
		
		// 이 도메인(어플리케이션)과 관련 있는 쿠키의 값들(배열) 가져오기
		cookies = request.getCookies();
		
		if(cookies != null){ // 쿠키가 존재하는 경우
			out.println("<h2>모든 쿠키의 이름과 값 찾기</h2>");
		for(int i =0 ; i < cookies.length; i++){
			cookie = cookies[i];
			out.println("Name: " + cookie.getName() + "<br>");
			out.println("Value: " + cookie.getValue() + "<br>");
		}
		} else {
			out.println("<h2>쿠키를 찾지 못했습니다.</h2>");
		}
		
	%>
	
	
	

</body>
</html>