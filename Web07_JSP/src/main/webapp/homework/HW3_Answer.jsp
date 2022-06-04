<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
</head>
<body>

	 <%request.setCharacterEncoding("UTF-8"); // 한글 인코딩 %>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"></jsp:useBean>
	<%-- 모든 parameter 값을 member에 저장 --%>
  	<jsp:setProperty property="*" name="member" />

  	<p>아이디 : <%=member.getUserid() %></p>
  	<p>비밀번호 : <%=member.getPassword() %></p>
  	<p>이메일 : <%=member.getEmail() %></p>
  	<%
  		String emailAgree = member.getEmailAgree();
  	%>
  	<p>이메일 수신여부 : </p> 
  	<%
  		if(emailAgree.equals("yes")) {
  	%>	
  	    <input type="radio" name="emailAgree" value="yes" checked>예
  	<% } else { %>
  		<input type="radio" name="emailAgree" value="no" checked="checked">아니오
  	<% } %>
 	<p>관심사항 : </p>
 	<%
 		String interest = null; // 관심사항 배열을 연결한 문자열을 저장할 변수
 		if(member.getInterest() == null) { // 관심사항이 아무것도 선택되지 않았을 경우 처리할 예외
 			interest = "";
 		} else {
 			interest = String.join(", ", member.getInterest());
 			// String.join(delimeter, array) : 
 			// 문자열 배열을 delimeter를 사용하여 연결해주는 함수	
 		}
 	%>
 	<p><%=interest %></p> <!-- 결과값이 interest에 들어가기 때문에 interest를 출력 -->
  	<p>핸드폰 : <%=member.getPhone() %></p>
  	<p>자기소개 : <%=member.getIntroduce() %></p> 
</body>
</html>


















