<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 출력</title>
</head>
<body>
	<h1>회원가입 정보</h1>
	<%MemberVO vo = (MemberVO) request.getAttribute("vo");
%>
<p>아이디 : <%=vo.getUserid() %></p>
<p>비밀번호 : <%=vo.getPassword() %></p>
<p>이메일 : <%=vo.getEmail() %></p>
<p>핸드폰 : <%=vo.getPhone() %></p>
<p>이메일 수신 : <%=vo.getEmailAgree() %></p>
<p>관심사항 : <%=vo.getInterestJoin() %></p>
<p>자기소개 : <%=vo.getIntroduce() %></p>
<a href="member-update.jsp"><input type=button value="정보수정"></a>
</body>
</html>