<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title }</title>
<style type="text/css">
table, th, td {
	border-style: ${param.boardStyle
}
;
border-color


 


:


 


${
param




.boardColor




}
;
border-width


 


:


 


1px




;
font-size


 


:


 


${
param




.fontSize




}
;
color


 


:


 


${
param




.fontColor




}
;
}
</style>
</head>
<body>
	<h2>${param.title }</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>링크 주소</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<%
			String[] linkList = request.getParameterValues("link");
			%>
			<%
			for (int i = 0; i < linkList.length; i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=linkList[i]%></td>
				<td>-</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<!--  el 및 jstl을 이용하여 테이블에 link된 데이터 출력 + 각 링크 주소를 누르면 이동가능하게 -->
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>링크 주소</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="link" items="${paramValues.link }" varStatus="s">
				<tr>
					<td>${s.count }</td>
					<td><a href="${link }">${link }</a></td>
					<td>-</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>