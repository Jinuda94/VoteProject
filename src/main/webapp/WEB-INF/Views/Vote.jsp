<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${root}/css/style2.css">
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<body>
	<c:if test="${empty sessionScope.name}">
		<jsp:forward page="vote/index"></jsp:forward>
	</c:if>
	<div id="back">
	<div id="ti">
		<h1>제 20대 대선</h1>
	</div>
	<div id="sform">
		<form id="voteForm" method="post" action="${root}/vote/voteinsert">
			<div class="input-box" >
				<label for="radio1">홍준표</label>
				<input id="radio1" type="radio" value="1" name="voteRadio" onclick="a('홍준표');"  checked  />
			</div>
			
			<div class="input-box" >
				<label for="radio2">이재명</label>
				<input id="radio2" type="radio" value="2" name="voteRadio" onclick="a('이재명');"  checked  />
			</div>
			<div class="input-box" >
				<label for="radio3">심상정</label>
				<input id="radio3" type="radio" value="3" name="voteRadio" onclick="a('심상정');"  checked  />
			</div>
			<div class="input-box">
			<input type="button" value="투표하기" onclick="d();"
				style="background-color: transparent; border: 0px transparent solid; color: white;" />
			<a href='${root}/vote/index' style="text-decoration: none; color: #ffffff;">뒤로가기</a>
			</div>
		</form>
	</div>
	</div>
	
	
	<script>
		function abc(){
			alert('abc');
		}
		
		function a(num) {
			alert(num + " 후보를 선택하셨습니다");
			
		}
		
		var b = function(num){
			var Choice = document.getElementById('choice');
			var strHTML = "";
			var candidate = "";
			switch (num) {
			case 1:
				candidate = "홍준표";
				break;
			case 2:
				candidate = "이재명";
				break;
			case 3:
				candidate = "심상정";
				break;
			}
			strHTML += "<div>"+candidate+"</div>";
			strHTML += "<div>"+candidate+" 사진</div>";
			strHTML += "<div>"+candidate+" 공약</div>";
			Choice.innerHTML = strHTML;
		}
		
		var c = function(){
			var Choice = document.getElementById('choice');
			var strHTML = "후보자 정보";
			Choice.innerHTML = strHTML;
		}
		
		var d = function(){
			
			var finalChoice;
			var name;
			var radioList = document.getElementsByName('voteRadio');
			
			radioList.forEach((node)=>{
				if(node.checked){
					finalChoice = node.value;
				}
			})
			if(finalChoice == 1){
				name = "홍준표";
			} else if(finalChoice == 2){
				name = "이재명";
			} else{
				name = "심상정";
			}
			
			var lastVote = confirm(name + " 후보에게 투표하시겠습니까?");
			if(lastVote){
				document.getElementById('voteForm').submit();
			} else{
				alert("다시 한번 선택해주세요.");
			}
			
		}
	</script>
</body>
</html>