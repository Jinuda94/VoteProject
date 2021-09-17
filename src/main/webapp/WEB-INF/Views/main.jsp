<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<head>
<title>메인 페이지</title>
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
	<h1>제 20대 대선투표 페이지</h1>
	<fieldset style="width:150px;">
		<legend>투표</legend>
		<form method="get" action="${root}/vote/votecheck">
		<input type="text" placeholder="이름" name="name"/>
		<br/>
		<br/>
		<input type="text" placeholder="주민등록번호 뒷자리만" name="se_num"/>
		<br/>
		<br/>
		<input type="submit" value="투표하러 가기"/>
		</form>
	</fieldset>
</body>