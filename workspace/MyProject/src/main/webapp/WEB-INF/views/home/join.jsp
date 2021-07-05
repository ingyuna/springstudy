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
			fn_join();
		 });
		 
		 
		 // 이메일 인증번호 받기
		 function fn_verify_num() {
			 $('#verify_num_btn').click(function(){
				 if ($('#email').val() == '') {
					 alert('이메일을 입력하세요.')
					 $('#email').focus();
					 return false;
				 }
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
		 	});
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
		 
		 // 회원 가입
		 function fn_join() {
			 $('#join_btn').click(function(){
				 if ( !authPass ) {
					 alert('이메일 인증을 받아야 합니다.');
				 } else {
					 $('#f').attr('action', 'join.do');
					 $('#f').submit();
					 alert('가입이 완료되었습니다.')
				 }
			 });
		 }
		 
		 
	 
	 
	</script>
	
	
	<style>
		body {
			margin: 0 auto;
			background-color: #FEEEF5
		}		
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 50px;
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
				
		<form id="f" method="post">
			
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

			<div class="join_bottom">
				<input type="button" value="가입하기" id="join_btn">			
			</div>
		</form>
		
		
	</div>
	
	
</body>
</html>