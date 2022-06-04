<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag 연습 2</title>
</head>
<body>
	<%!
	ArrayList<String> list;
	%>
	
	<%
	list = new ArrayList<>();
	list.add("아이언맨");
	list.add("토르");
	list.add("헐크");
	list.add("스파이더맨");
	list.remove(0);
	%>
	
	<ul>
		<li><%=list.get(0) %></li>
		<li><%=list.get(1) %></li>
		<li><%=list.get(2) %></li>
	
		
	</ul>
	
</body>
</html>