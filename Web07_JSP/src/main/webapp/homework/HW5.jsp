<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- 
	    * HW5 과제
		1. Dynamic Web Project 생성 : 프로젝트 이름(Homepage)
		- DB 연동에 필요한 설정 적용
		2. 회원 가입, 회원 정보 수정, 회원 탈퇴, 회원 정보 보기. 페이지 만들기
		3. 로그인(아이디 & 패스워드 확인 기능), 로그아웃, 로그인 결과 확인 페이지 만들기
		4. 로그인 성공하면 세션으로 로그인 상태 유지
		
		* 작성할 jsp 및 servlet
		1. login.jsp : 
		- 로그인 페이지.
		- LoginServlet으로 아이디, 비밀번호를 전송
		- form action="login_auth.do" method="post"
		- a 태그를 이용하여 member-register.jsp 페이로 이동하는 링크 생성
		
		2. member-register.jsp 
		- 회원가입 페이지
		- RegisterServlet으로 회원정보를 전송
		- form action="register.do" method="post"
		
		3. RegisterServlet.java
		- 회원정보 저장 
		- member-register.jsp에서 전송된 데이터를 DB에 저장
		- 저장에 완료되면 login.jsp 페이지로 이동
		
		4. LoginServlet.java
		- login.jsp에서 전송된 데이터를 확인하여 가입된 아이디/비밀번호가 일치하는지 체크
		- 아이디/비밀번호가 일치하면 userid 세션을 생성하고 login-result.jsp로 이동
		- 일치하지 않으면 login.jsp로 이동
		
		5. login-result.jsp
		- 로그인 결과 페이지
		- 세션에서 userid를 가져와서 ~님, 환영합니다!를 출력
		- 아래 두 개의 버튼을 생성
		- 두 버튼은 세션에서 가져온 userid를 이용하여 servlet으로 이동
		- location.href='' (get 방식으로 이동함)
		- <button onclick="location.href='select.do?userid=<%=userid%>'">회원정보</button>
  		- <button onclick="location.href='logout.do?userid=<%=userid%>'">로그아웃</button>
  		
  		6. SelectServlet.java
  		- select.do 경로
  		- login-result에서 전송된 userid를 저장하여 DB에서 MemberVO 데이터를 선택
  		- 선택된 vo 데이터를 member-result.jsp로 전송		
  		
  		7. member-result.jsp
  		- 전송된 vo 데이터를 출력하는 페이지
  		- 모든 정보를 출력
  		- a 태그를 이용하여 member-update.jsp로 이동
  		
  		8. member-update.jsp
  		- 회원정보를 수정하는 페이지
  		- 세션에서 userid를 가져와서 아이디 정보만 출력
  		- form action="update.do" method="post"
  		- 회원정보 수정은 모든 정보를 입력
  		- update.do로 변경된 회원정보를 전송
  		- a태그를 이용하여 회원 탈퇴 링크 생성
  		<a href="delete.do?userid=<%=userid%>"><input type="button" value="회원탈퇴"></a>
  		
  		9. UpdateServlet.java
  		- update.do로 전송된 회원정보를 이용하여 회원의 정보를 수정
  		- 회원정보 수정이 완료되면 vo 데이터를 member-result.jsp로 전송
  		
  		10. DeleteServlet.java
  		- delete.do로 전송된 userid를 이용하여 회원 탈퇴(DB에서 삭제)
  		- 삭제가 완료되면 login.jsp페이지로 이동
  		
  		11. LogoutServlet.java
  		- logout.do로 이동한 경로
  		- 전송된 userid를 이용하여 세션 제거
  		- login.jsp로 이동
  		
  		12. CharFilter/LoginSessionFilter는 보너스 문제(해도 되고, 안해도 됨)
  		- CharFilter : 한글 처리 인코딩 필터
  		- LoginSessionFilter : 로그인을 해야 접속할 수 있는 페이지에 필터 적용
  		  (로그인이 되지 않으면 접근 x)
  		
  		13. DB 테이블은 MEMBER 테이블을 사용하고, DAO는 스스로 작성해 볼 것! 
  		
	 -->

</body>
</html>









