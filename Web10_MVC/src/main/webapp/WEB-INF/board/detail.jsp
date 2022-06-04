<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.title }</title>
</head>
<body>
	<h2>글 보기</h2>
	<div>
		<p>글 번호 : ${vo.bno }</p>
	</div>
	<div>
		<p>
			제목 <input type="text" name="title" value="${vo.title }" readonly>
		</p>
	</div>
	<div>
		<p>작성자 : ${vo.userid }</p>
		<p>작성일 : ${vo.cdate }</p>
	</div>
	<div>
		<textarea rows="20" rows="120" name="content" readonly>${vo.content }</textarea>
	</div>
	<a href="index.jsp"><input type="button" value="글 목록"></a>
	<c:if test="${vo.userid == sessionScope.userid }">
		<!-- if 세션아이디가 유저아이디랑 같으면 수정삭제 보이게 -->
		<a href="update.do?bno=${vo.bno }"><input type="button"
			value="글 수정"></a>
		<a href="delete.do?bno=${vo.bno }"><input type="button"
			value="글 삭제"></a>
	</c:if>

	<!-- POST 방식으로 데이터를 전송하려면 form을 사용해야 한다. -->

	<hr>

	<c:if test="${empty sessionScope.userid }">
		* 댓글은 로그인이 필요한 서비스입니다.
		<a href="login.go">로그인하기</a>
	</c:if>
	<c:if test="${not empty sessionScope.userid }">
		${sessionScope.userid }님, 이제 댓글을 작성할 수 있어요! <!-- 로그인하면 디테일로 이동 -->

		<div style="text-align: center">
			<input type="hidden" id="boardNo" value="${vo.bno }"> <input
				type="hidden" id="replyId" value="${sessionScope.userid }">
			<input type="text" id="replyContent" value="">
			<button id="btn_add">작성</button>

		</div>
	</c:if>




	<hr>
	<div style="text-align: center;">
		<div id="replies"></div>
	</div>
	<div>
		<br> <br> <br> <br> <br> <br> <br>
		<br>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var boardNo = $('#boardNo').val(); // 게시판 번호 값
							getAllReplies();

							$('#btn_add').click(function() {

								var replyContent = $('#replyContent').val(); // 댓글 내용
								var replyId = $('#replyId').val(); // 댓글 작성자 아이디
								var obj = {
									'boardNo' : boardNo,
									'replyContent' : replyContent,
									'replyId' : replyId
								};
								console.log(obj);
								// $.ajax로 송수신
								$.ajax({
									type : 'post',
									url : 'replies/add',
									data : obj,
									success : function(result) {
										if (result == 'success') {
											alert('댓글 입력 성공');
											getAllReplies();
										}
									}

								}); // end ajax()
							}); // end btn_add.click()

							// 게시판의 댓글 전체 가져오기
							function getAllReplies() {
								var url = 'replies/all?boardNo=' + boardNo;

								$
										.getJSON(
												url,
												function(jsonData) {
													// jsonData : 서버에서 온 list 데이터가 저장되어 있음
													console.log(jsonData);

													// 힌트1 로그인 한 사용자 아이디 값을 가져와야 함
													var list = ''; // JSON 데이터를 표현 할 문자열 변수

													// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
													$(jsonData)
															.each(
																	function() {
																		// this : 컬렉션에서 각 데이터를 꺼내서 저장
																		console
																				.log(this);
																		// 힌트2. 댓글 작성자와 로그인 한 사용자를 비교
																		console
																				.log(this.userid
																						+ this.replyId);

																		if (this.userid == this.replyId) {
																			var replyDate = new Date(
																					this.replyDate);
																			list += '<div class="reply_item">'
																					+ '<pre>'
																					+ '<input type="hidden" id="replyNo" value="' + this.replyNo + '" />'
																					+ '<input type="hidden" id="replyId" value="' + this.replyId + '" />'
																					+ this.replyId
																					+ '&nbsp;&nbsp;' // 공백
																					+ '<input type="text" id="replyContent" value="' + this.replyContent + '"/>'
																					+ '&nbsp;&nbsp;' // 공백
																					+ replyDate
																					+ '&nbsp;&nbsp;' // 공백
																					+ '<button class="btn_update">수정</button>'
																					+ '<button class="btn_delete">삭제</button>'
																					+ '</pre>'
																					+ '</div>';
																		} else {
																			var replyDate = new Date(
																					this.replyDate);
																			list += '<div class="reply_item">'
																					+ '<pre>'
																					+ '<input type="hidden" id="replyNo" value="' + this.replyNo + '" />'
																					+ '<input type="hidden" id="replyId" value="' + this.replyId + '" />'
																					+ this.replyId
																					+ '&nbsp;&nbsp;' // 공백
																					+ '<input type="text" id="replyContent" value="' + this.replyContent + '"/>'
																					+ '&nbsp;&nbsp;' // 공백
																					+ replyDate
																					+ '&nbsp;&nbsp;'
																		}

																	}); // end each()
													$('#replies').html(list);

												}); // end getJSON()
							} // end getAllReplies()

							// 수정 버튼을 클릭하면 선택된 댓글 수정 (각 댓글버튼의 클릭했을때 콘솔에 서로 다르게 구분가능)
							$('#replies').on(
									'click',
									'.reply_item .btn_update',
									function() {
										console.log(this);
										// 선택된 댓글의 replyNo, replyContent 값을 저장
										// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
										var replyNo = $(this).prevAll(
												'#replyNo').val();
										var replyContent = $(this).prevAll(
												'#replyContent').val();
										console.log('선택된 댓글 번호 : ' + replyNo
												+ ", 댓글 내용 : " + replyContent);

										// ajax 요청
										$.ajax({
											type : 'get', // 원래는 get이아님 임시적
											url : 'replies/update?replyNo='
													+ replyNo,
											data : {
												'boardNo' : boardNo,
												'replyContent' : replyContent
											},
											success : function(result) {
												console.log(result);
												if (result == 'success') {
													alert('댓글 수정 성공!');
													getAllReplies();
												}
											} // end success
										}); // end ajax
									}); // end replies.on

							$('#replies').on(
									'click',
									'.reply_item .btn_delete',
									function() {
										console.log(this);

										// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
										var replyNo = $(this).prevAll(
												'#replyNo').val();
										console.log('선택된 댓글 번호 : ' + replyNo);

										// ajax 요청
										$.ajax({
											type : 'get', // 원래는 get이아님 임시적
											url : 'replies/delete?replyNo='
													+ replyNo,
											data : {
												'boardNo' : boardNo
											},
											success : function(result) {
												console.log(result);
												if (result == 'success') {
													alert('댓글 삭제 성공!');

													getAllReplies();
												}
											} // end success
										}); // end ajax
									}); // end replies.on

						}); // end document()
	</script>


</body>
</html>