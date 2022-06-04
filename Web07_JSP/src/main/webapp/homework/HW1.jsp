<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 계산기</title>
</head>
<body>
	<h1>적급 계산기</h1>
<!-- 
	JSP 파일 생성 (적금 계산 결과 페이지)
	1. 월 적금액, 기간, 이자율을 전송하는 form 만들기(HW1.jsp)
	- <form action="HW1_result.jsp" method="get">
	2. 월 적금액, 기간, 이자율을 HW1.jsp로 부터 받아와서 계산 및 출력하는 jsp 파일 작성(HW1_result.jsp)
 -->
 
 	<form action="HW1_result.jsp" method="get">
 		월 적금액 : <input type="number" name="monthMoney"><br>
 		기간 : <input type="number" name="period"><br>
 		이자율 : <input type="number" name="interestRate" step="0.1"><br>
 		<input type="submit" value="제출">
 		
 	</form>
 

</body>
</html>