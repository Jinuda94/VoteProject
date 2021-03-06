<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<head>
<link rel="stylesheet" href="${root}/css/style.css">
<title>20대 대선 투표</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
	<c:if test="${alertflag eq '1'}">
		<script>
			$().ready(function() {
				Swal.fire({
					icon : 'error',
					title : '정보가 일치하지 않습니다.',
				});
			});
		</script>
	</c:if>
	<c:if test="${alertflag eq '2'}">
		<script>
			$().ready(function() {
				Swal.fire({
					icon : 'warning',
					title : '이미 투표를 완료하였습니다.',
				});
			});
		</script>
	</c:if>
	<c:if test="${alertflag eq '10'}">
		<script>
			$().ready(function() {
				Swal.fire({
					icon : 'success',
					title : '투표가 완료되었습니다.',
				});
			});
		</script>
	</c:if>
	<div id="back"></div>
	<div id="ti">
		<h1>제 20대 대선</h1>
	</div>
	<div id="sform">
		<form method="post" action="${root}/vote/votecheck">

			<div class="input-box">
				<input id="username" type="text" name="name" placeholder="이름" style="color: white;">
				<label for="username">이름</label>
			</div>

			<div class="input-box">
				<input id="password" type="text" name="se_num"
					placeholder="비밀번호" style="color: white;"> <label for="password">휴대폰번호</label>
			</div>

			<input type="submit" value="투표하러 가기"
				style="background-color: transparent; border: 0px transparent solid;" />
		</form>
		<div style="text-align: right;">
			<a onclick="result(${vt.getVote1()},${vt.getVote2()},${vt.getVote3()});" style="color:white; text-decoration:none;" >결과보기</a> 
		</div>
	</div>
	<script>
		function result(a,b,c){
			$().ready(function() {
				Swal.fire({
					icon : 'success',
					title : "1번 후보: "+ a+"\n2번 후보: "+b+"\n3번 후보: "+c,
				});
			});
			
		}
	</script>
</body>