<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
</head>
<body>
	<!-- 
	1. 로그인 정보 전송 페이지(HW4.jsp)
	- <form action="HW4_login_auth.jsp" method="post"> 태그 생성
	- id(type="text" name="id") input 태그 생성
	- pw(type="password" name="pw") input 태그 생성
	- 로그인 버튼(type="submit") input 태그 생성
	
	2. 로그인 인증 jsp 생성(HW4_login_auth.jsp)
	- 전송받은 id,pw를 확인하여 id="test", pw="1234"일 경우
	id, pw 세션을 생성(세션 attribute 이름은 본인이 알아서 작성. 세션 만료시간 5분)
	- 이후에 HW4_login_result.jsp 페이지로 이동
	-> 이동 코드 out.print("<script>location.href='HW4_login_result.jsp'</script>"
	- 전송받은 id, pw가 일치하지 않을 경우, HW4.jsp 페이지로 이동 
	
	3. 로그인 결과 jsp 생성(HW_login_result.jsp)
	- 세션에서 id값을 꺼내서 출력
	- 만약 로그인하지 않고 url 경로로 접근하는 경우 '로그인 해주세요!!' 라고 alert를 띄우고
		HW4.jsp 페이지로 이동
		- alert띄우는 방법 : 페이지 이동 전에 아래 코드를 추가
		-> out.print("<cript>alert('로그인 해주세요!!')</script>");
	 -->


	<form action="HW4_login_auth.jsp" method="post">
		<h1>로그인</h1>
		ID<br> <input type="text" name="id" required="required"><br> PW <input
			type="password" name="pw" required="required"><br>
		<input type="submit" value="로그인">

	</form>





</body>
</html>