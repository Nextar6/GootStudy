<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	System.out.println(name + ", " + city);
	out.write("success");
%>