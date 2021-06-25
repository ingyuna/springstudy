<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			fn_login();
			fn_leave();
		})
		function fn_login() {
			$('#f').submit(function(event){
				if ($('#id').val() == '' || $('#pw').val() == '') {
					alert('아이디와 비밀번호는 필수입니다.');
					event.preventDefault();
					return false;
				}
			})
		}
		function fn_leave(){
			$('#leave_link').click(function(){
				if (confirm('탈퇴할까요?')) {
					location.href = 'leave.do';
				}
			})
		}
	</script>
	<style>
		#leave_link:hover {
			cursor: pointer;
		}
	</style>
</head>
<body>

	<h1>홈페이지</h1>	
	
	<c:if test="${loginUser != null}">
		회원번호 : ${loginUser.no}<br>
		아이디 : ${loginUser.id}<br>
		비밀번호 : ${loginUser.pw}<br>
		이름 : ${loginUser.name}<br>
		이메일 : ${loginUser.email}<br>
		가입일 : ${loginUser.regdate}<br><br>
		<a href="logout.do">로그아웃</a><br>
		<!-- <a href="leave.do">회원탈퇴</a><br> -->      <!-- session에서 꺼내쓰니까 ?로 안넘겨도 된다. -->
		<a id="leave_link">회원탈퇴</a><br>
		<a href="myPage.do">마이페이지</a><br>	
	</c:if>
	
	<c:if test="${loginUser == null}">		<!-- 로그인 못했을 때 -->
		<form action="login.do" method="post">
			아이디<br>
			<input type="text" name="id" id="id"><br><br>
			비밀번호<br>
			<input type="password" name="pw" id="pw"><br><br>
			<button>로그인</button>	  <!-- button이기 때문에 위에서 click 이벤트가 아니라 submit으로. -->
		</form>	
		<a href="joinPage.do">회원가입</a>&nbsp;&nbsp;&nbsp;
		<a href="findIdPage.do">아이디찾기</a>&nbsp;&nbsp;&nbsp;
		<a href="findPwPage.do">비밀번호찾기</a>
	</c:if>

</body>
</html>