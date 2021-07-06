<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
	<script>
	$(document).ready(function(){
		fn_login();
	})
	
	// 로그인
	function fn_login() {
		$('#f').submit(function(event){
			if ($('#id').val() == '' || $('pw').val() == '') {
				alert('아이디와 비밀번호는 필수입니다.');
				event.preventDefault();
				return false;
			} 
		})
	}
	
	
	</script>
	<style>
		body {
			margin: 0 auto;
			background-color: #FEEEF5
		}		
		
		.home_icon {
			width: 85%;
			text-align: right;
			padding: 20px;
		}
		
		.home_icon > a {
			color: #6FF3A4;
		}
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 150px;
		}		
		h2 {
			text-align: center;		
		}	
		
		.login {		
			text-align: center;
			margin: 30px;
		}	
		
		.int {		
			height: 30px;		
		}
		
		.login_box {		
			margin: 20px;		
		}
		
		a {
			text-decoration: none;
			color: gray;
		}
		
		.login_bottom {
			width: 80%;
			margin: 0 auto;
			position: relative;
		}
		
		.login_bottom > div {
			position: absolute;
		}
		
		.login_btn {
			border: none;
			background-color: #FEEEF5;
		}
		
		.login_btn:hover {
			color: #B152FB;
			cursor: pointer;
		}
		
		
		.find_click {
			top: 10px;
			left: 20px;
		}
		
		.join_click {
			top: 10px;
			right: 20px;
		}
		
		
		
		
	
	</style>
	
</head>
<body>
	
	<div class="outer">
		<%-- home 아이콘 --%>
		<div class="home_icon">
			<a href="index.do">Home<i class="fas fa-home fa-2x"></i></a>	
		</div>
		
		<h2>로그인</h2>
		<div class="login">
			<form id="f" action="login.do" method="post">
					<div class="login_box">
						<label>아이디</label>
						<input type="text" class="int" name="id" id="id"><br>
					</div>
					<div class="login_box">			
						<label>비밀번호</label>
						<input type="password"  class="int" name="pw" id="pw">
					</div>	
					<button class="login_btn">login<i class="far fa-hand-point-up fa-2x"></i></button>		
			</form>
		</div>
		<div class="login_bottom">
			<div class="find_click">
				<a href="findIdPage.do">아이디 찾기</a>&nbsp;&nbsp;
				<a href="findPwPage.do">비밀번호 찾기</a>		
			</div>
			<div class="join_click">
				<a href="joinPage.do">회원가입</a>
			</div>
		</div>
	</div>

</body>
</html>