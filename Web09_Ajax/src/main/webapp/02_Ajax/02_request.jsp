<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XMLHttpRequest</title>
</head>
<body>
	<h2>XMLHttpRequest 요청</h2>
	<button type="button" onclick="loadDocGet()">get 데이터 요청</button>
	<button type="button" onclick="loadDocPost()">Post 데이터 요청</button>
	
	<p id="output"></p>
	<script type="text/javascript">
		function loadDocGet(){
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if(this.readyState == 4 && this.status == 200){
						document.getElementById("output").innerHTML = this.responseText;
					
				}
			};
			xhttp.open("GET", "02_date.jsp?method=get&content=Hello","True");
			xhttp.send();
		} // loadDocGet() 
		
			function loadDocPost() {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if(this.readyState == 4 && this.status == 200) {
							document.getElementById("output").innerHTML = this.responseText;
						
					}
				};
				xttp.open("POST", "02_date.jsp", true);
				// setRequestHeader() : 헤더 정보추가 post방식 필수
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.send("method=post&content=Hello");
			} // end loadDocPost()
		
	</script>
</body>
</html>