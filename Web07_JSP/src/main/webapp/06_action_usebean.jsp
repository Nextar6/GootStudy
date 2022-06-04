<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP useBean</title>
</head>
<body>
	<%--
	* jsp:useBean
	- 특정 클래스 객체(object)를 쉽게 사용하기 위한 태그
	- 기본 타입
		<jsp:useBean id="name" class="package.classname.java" />
		<jsp:setProperty>
		<jsp:getProperty>
	- 속성(attributes)
		id : 빈의 이름
		class : 빈으로 사용될 클래스 위치
		scope : 빈이 사용될 범위
		property : 빈의 각 속성 이름(생성된 클래스의 변수 이름과 일치해야 함)
		value : property에 들어 갈 값(데이터)
	- 범위(scope)
		page : 생성된 페이지 내에서 사용가능
		request : 요청된 페이지 내에서 사용 가능
		session : 웹 브라우저(클라이언트)의 생명 주기 내에서 사용 가능
		application : 웹 어플리 케이션의 생명 주기 내에서 사용가능
	- scope의 포함 관계
		page < request < session < application
	 --%>
	<h1>JSP:useBean</h1>
	<jsp:useBean id="test" class="edu.web.jsp01.TestBean"></jsp:useBean>
	<%-- useBean 사용 방법1 --%>
	<jsp:setProperty property="msg" name="test" value="msg 값이 변경됨"/>
	<%-- property : 클래스 변수명과 일치, name : id값과 일치, value = "적용할 값 --%>
	<p>변경된 값 출력 : <jsp:getProperty property="msg" name="test"/></p>
	
	<%-- useBean 사용방법 2 : getter/setter 이용 --%>
	<%test.setMsg("getter/setter 사용"); %>
	<p>변경된 값 출력 : <%= test.getMsg() %>
	
	<%-- useBean 사용 방법3 : EL 표기법 사용 --%>
	${test.msg }

</body>
</html>