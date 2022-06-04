<%@page import="edu.web.homework.MemberVO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%!ArrayList<MemberVO> list = new ArrayList<>();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String emailAgree = request.getParameter("emailAgree");
	String[] interest = request.getParameterValues("interest");
	String introduce = request.getParameter("introduce");
	%>

	<h1>회원 정보 페이지</h1>
	<jsp:useBean id="test" class="edu.web.homework.MemberVO"></jsp:useBean>
	<%-- useBean 사용 방법1 --%>
	<jsp:setProperty property="userid" name="test" value="<%=userid%>" />
	<jsp:setProperty property="password" name="test" value="<%=password%>" />
	<jsp:setProperty property="phone" name="test" value="<%=phone%>" />
	<jsp:setProperty property="email" name="test" value="<%=email%>" />
	<jsp:setProperty property="emailAgree" name="test"
		value="<%=emailAgree%>" />
	<jsp:setProperty property="introduce" name="test"
		value="<%=introduce%>" />

	<%-- property : 클래스 변수명과 일치, name : id값과 일치, value = "적용할 값 --%>
	<p>


		아이디 :
		<jsp:getProperty property="userid" name="test" /><br> 패스워드 :
		<jsp:getProperty property="password" name="test" /><br> 핸드폰 :
		<jsp:getProperty property="phone" name="test" /><br> 이메일 :
		<jsp:getProperty property="email" name="test" /><Br> 이메일 수신 여부 :
		<jsp:getProperty property="emailAgree" name="test" /><br>취미 :
		<%
	for (int i = 0; i < interest.length; i++) {
	%>
	
	<p>
		<%=interest[i]%>
	</p>
	<%
	}
	%>
	자기소개 :
	<jsp:getProperty property="introduce" name="test" /><br>






</body>
</html>