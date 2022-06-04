<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("test") && pw.equals("1234")) {
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setMaxInactiveInterval(300);
		out.print("<script>alert('로그인 성공')</script>");
		out.print("<script>location.href='HW4_login_result.jsp'</script>");
	} else {
		out.print("<script>alert('아이디 비밀번호를 확인해주세요.')</script>");
		out.print("<script>location.href='HW4.jsp'</script>");
		
		
	}
	
	%>
</body>
</html>