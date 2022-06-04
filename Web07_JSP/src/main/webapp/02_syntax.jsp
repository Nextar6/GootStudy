<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
// 멤버변수, 전역 변수
int fontSize;
int day =3;

%>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구문</title>
</head>
<body>
	<%
		if(day == 1 || day == 7) {
	%>
		<p>오늘은 주말입니다.</p>
	<%
		} else {
	%>
		<p>오늘은 평일입니다.</p>
	<%
		}
	%>
		<%-- 
			JSP 태그는 HTML 내에서 어느 위치든 사용할 수 있음
		--%>
		<%
		for(fontSize = 1; fontSize <=3; fontSize++){
		%>
		<font color="green" size="<%=fontSize%>">JSP 구문 연습 중</font><br>
		<%
		}
		%>
</body>
</html>