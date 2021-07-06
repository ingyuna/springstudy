<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 변경하기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){
			fn_changePw();
		});
		
		function fn_changePw() {
			$('#change_pw_btn').click(function(){
				var regPw = /^[0-9]{1,4}$/;
				if ( !regPw.test($('#pw').val()) ) {
					alert('비밀번호는 숫자 4자리입니다.');
					$('#pw').focus();
					return false;				
				} else if ($('#pw').val() != $('#pw2').val() ) {
					alert('비밀번호가 일치하지 않습니다.');
					return false;
				} else {
					$('#f').attr('action', 'changePw.do');
					$('#f').submit();
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
			padding: 150px;
			text-align: center;
		}	
		
		.input_box {
			margin: 25px;
		}
		
		.int {
			height: 25px;
		}
	
	</style>
</head>
<body>

	<div class="outer">
	
		<h2>비밀번호 변경하기</h2>
	
		<form id="f" method="post">
			<input type="hidden" name="id" value="${id}">
			<input type="hidden" name="email" value="${email}">
			
			<div class="input_box">
				<label>새 비밀번호</label>
				<input type="password" id="pw" name="pw" class="int">
			</div>
			
			<div class="input_box">
				<label>비밀번호 확인</label>
				<input type="password" id="pw2" name="pw2" class="int">
			</div>
			
			<input type="button" value="비밀번호 변경" id="change_pw_btn">
			<input type="button" value="돌아가기" onclick="location.href='index.do'">
		
		
		</form>
	</div>

</body>
</html>