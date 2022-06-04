<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 계산 결과</title>
</head>
<body>
	<%

	String monthMoney = request.getParameter("monthMoney");
	String period = request.getParameter("period");
	String interestRate = request.getParameter("interestRate");

	int inputMoney = Integer.parseInt(monthMoney);
	int iperiod = Integer.parseInt(period);
	double interest = Double.parseDouble(interestRate);

	int totalInputMoney = inputMoney * iperiod;
	double totalInterest = totalInputMoney * interest / 100;
	double totalReceiveMoney = totalInterest + totalInputMoney;

	DecimalFormat df = new DecimalFormat("￦###,###,###");
	%>

	<h1>적금 계산</h1>
	<h2>입력받은 정보</h2>
	<p>
		월 금액 :
		<%=df.format(inputMoney)%></p>
	<p>
		적금 기간 :
		<%=period%></p>
	<p>
		년 이자 :
		<%=interest%></p>
	<hr>
	<p>
		총 납입 금액 :
		<%=df.format(totalInputMoney)%></p>
	<p>
		발생 이자 :
		<%=df.format(totalInterest)%></p>
	<p>
		총 수령액 :
		<%=df.format(totalReceiveMoney)%></p>




</body>
</html>