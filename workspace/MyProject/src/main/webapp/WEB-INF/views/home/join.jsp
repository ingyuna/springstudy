<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Join</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		 
		 $(document).ready(function(){
			fn_verify_num(); 
		 });
		 
		 
		 // 이메일 인증번호 받기
		 function fn_verify_num() {
			 $('#verify_num_btn').click(function(){
				 if ($('#email').val() == '') {
					 alert('이메일을 입력하세요.')
					 $('#email').focus();
					 return false;
				 }
			 });
			 $.ajax({
				 url: 'verifyNum.do',
				 type: 'get',
				 data: 'email=' + $('#email').val(),
				 dataType: 'json',
				 success: function(resultMap) {
					 alert('인증코드가 발송되었습니다.');
					 fn_verify(resultMap.authCode);
				 },
				 error: function(xhr, textStatus, errorThrown) {
					 
				 }
			 })		 
		 }
		 
		 // 이메일 인증번호 확인
		 var authPass = false;
		 function fn_verify(authCode) {
			 $('#verify_btn').click(function(){
				 if(authCode == $('#user_key').val()) {
					 alert('인증되었습니다.');
					 authPass = true;
				 } else {
					 alert('인증에 실패했습니다.')
					 authPass = false;
				 }
			 });
		 }
		 
	 
	 
	</script>
	
	
	<style>
		body {
			margin: 0 auto;
		}		
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 50px;
			border: 1px solid red;
			text-align: center;
		}		
		
		.join_form {
			margin: 20px;
		}		
		.int {
			height: 25px;	
		}
		
		.join_bottom {
			margin: 40px;
		}
		
		.join_btn {
			border-style: none;
			font-size: 18px;	
			background-color: lightyellow;
			font-weight: 500;
			border: 1px solid yellow;
			border-radius: 5px;
			padding: 10px;
		}
		
		.join_btn:hover {
			cursor: pointer;
			background-color: orange;
			
		}
		
		
		
	</style>
</head>
<body>
	<div class="outer">
	
		<h2>회원가입</h2>	
				
		<form method="post">
			
			<div class="join_form">
				<label>아이디</label>
				<input type="text" name="id" class="int">
			</div>
			
			<div class="join_form">
			<label>비밀번호</label>
			<input type="password" name="pw" class="int">
			</div>
			
			<div class="join_form">
			<label>이름</label>
			<input type="text" name="name" class="int">
			</div>
			
			<div class="join_form">
			<label>연락처</label>
			<input type="text" name="phone" class="int">
			</div>
			
			<div class="join_form">
			<label>이메일</label>
			<input type="text" name="email" id="email" class="int">
			<!-- 이메일 인증 -->
			<input type="button" value="인증번호받기" id="verify_num_btn">
			</div>
			
			<div class="join_form">
			<input type="text" name="user_key" id="user_key" class="int">
			<input type="button" value="인증하기" id="verify_btn" class="int"> 
			</div>
			
			<div class="join_form">
			<label>주소</label>
			<input type="text" name="address" class="int"> 
			</div>
		</form>
		
		<div class="join_bottom">
			<button class="join_btn">가입하기</button>			
		</div>
		
	</div>
	
	
</body>
</html>