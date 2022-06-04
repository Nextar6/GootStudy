<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<!-- TODO 비밀번호 일치 하지않으면 제출불가능하게 하기 -->
	<h2>회원가입</h2>
	<form action="register.do" method="post">
		<p>아이디</p>
		<input type="text" name="userid" id="userid" maxlength="16"placeholder="아이디 입력" required>
		<br> <span id="idMsg"></span>
		<p>패스워드</p>
		<input type="password" name="password" id="password"
			placeholder="비밀번호 입력" maxlength="16" required><span id="pwMsg"></span>
		<p>패스워드 확인</p>
		<input type="password" name="passwordConfirm" placeholder="비밀번호 확인"required>
		<span id="pwConfirmMsg"></span> <br> <input type="submit"
			value="전송">
	</form>
	<script type="text/javascript">
		var inputId = document.getElementById('userid');
		var inputPw = document.getElementById('password');

		inputId.onblur = function() {
			var id = inputId.value; // 입력한 데이터 값
			console.log(id.length);
			console.log(id);
			if (id.length < 5) {
				idMsg.innerHTML = "아이디는 5 ~ 20자로 제한합니다.";
				idMsg.style.color = 'red';
			} else if (id == "test1") {
				idMsg.innerHTML = "이미 사용중이거나 탈퇴한 아이디입니다."
				idMsg.style.color = 'red';
			} else {
				idMsg.innerHTML = "멋진 아이디이군요 !!!"
				idMsg.style.color = 'blue';
			}
		};
		inputPw.onblur = function() {
			var pw = inputPw.value; // 입력한 데이터 값
			console.log(pw);

			if (pw.length < 8) {
				pwMsg.innerHTML = "비밀번호는 8 ~ 16자로 제한합니다.";
				pwMsg.style.color = 'red';
			} else {
				pwMsg.innerHTML = "가능한 비밀번호입니다.";
				pwMsg.style.color = 'blue';
			}
		};

		// 3 - 11 비밀번호 확인 다른건확인 if문으로 할때 하나 선택되면 일치까지 +해야함  
		inputPwConfirm.onblur = function() {
			var pwConfirm = inputPwConfirm.value; // 입력한 데이터 값
			console.log(inputPwConfirm);

			if (pwConfirm.length < 8) {
				pwConfirmMsg.innerHTML = "비밀번호는 8 ~ 16자로 제한합니다.";
				pwConfirmMsg.style.color = 'red';
			} else if (pwConfirm == pw) {
				pwMsg.innerHTML = "가능한 비밀번호입니다.";
				pwMsg.style.color = 'blue';
			} else {
				pwConfirmMsg.innerHTML = "비밀번호가 일치하지 않습니다"
				pwConfirmMsg.style.color = 'red';
			}
		};
	</script>

</body>
</html>