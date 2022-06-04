<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
	<h2>글 작성 페이지</h2>
	<form action="register.do" method="POST">
		<div>
			<p>제목 : </p>
			<input type="text" name="title" placeholder="제목 입력" required>
		</div>
		<div>
			<p>작성자 : ${sessionScope.userid }</p>
			<input type="hidden" name="userid" value="${sessionScope.userid }" >
		</div>
		<br>
		<div>
			<textarea rows="20" cols="120" name="content" placeholder="내용 입력" required></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>

</body>
</html>