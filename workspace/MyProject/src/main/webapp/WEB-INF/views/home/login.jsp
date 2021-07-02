<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	
	
	</script>
	<style>
		body {
			margin: 0 auto;
		}		
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 150px;
			border: 1px solid red;
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
		<h2>로그인</h2>
		<div class="login">
			<form id="f" method="post">
					<div class="login_box">
						<label>아이디</label>
						<input type="text" class="int" name="id" id="id"><br>
					</div>
					<div class="login_box">			
						<label>비밀번호</label>
						<input type="password"  class="int" name="pw" id="pw">
					</div>			
			</form>
		</div>
		<div class="login_bottom">
			<div class="find_click">
				<a href="#">아이디 찾기</a>&nbsp;&nbsp;
				<a href="#">비밀번호 찾기</a>		
			</div>
			<div class="join_click">
				<a href="joinPage.do">회원가입</a>
			</div>
		</div>
	</div>

</body>
</html>