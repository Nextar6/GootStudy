<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String str = request.getParameter("q");
System.out.println("문자열 : " + str);
String result;

if(str.charAt(0) == 'a') {
	result = "apple";
} else if(str.charAt(0) == 'b') {
	result = "banana";
} else if(str.charAt(0) == 'c')	{
	result = "coconut";
} else {
	result = "no fruits";
}
System.out.println(result);
%>
<%=result %>