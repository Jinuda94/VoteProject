<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>제 20대 대선투표 페이지</h1>
	<fieldset style="width:150px;">
		<legend>투표</legend>
		<form method="get" action="${root}/vote/voteinsert">
		<label>홍준표<input type="radio" value="1" name="voteRadio" checked/></label>
		<br/>
		<label>이재명<input type="radio" value="2" name="voteRadio"/></label>
		<br/>
		<label>심상정<input type="radio" value="3" name="voteRadio"/></label>
		<br/>
		<br/>
		<input type="submit" value="투표하기"/>
		</form>
	</fieldset>
</body>
</html>