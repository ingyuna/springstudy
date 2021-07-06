<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 찾기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
	<script>
		$(document).ready(function(){
			fn_findPw();
			fn_verify_num();
		});
		
		function fn_findPw() {
			$('#find_pw_btn').click(function(){
				if($('#id').val() == '') {
					alert('아이디를 입력하세요.')	
					$('id').focus();
					return false;
				} else if($('#email').val() == '') {
					alert('이메일을 입력하세요.')
					$('#email').focus();
					return false;
				} else {
					$('#f').attr('action', 'findPw.do');
					$('#f').submit();
				}
			});		
		}
		
		// 이메일 인증번호 받기
		 function fn_verify_num() {
			 $('#verify_num_btn').click(function(){
					if ($('#email').val() == '') {
						alert('이메일을 입력하세요');
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
						}
					});
				});
		 }
		 
		 // 이메일 인증번호 확인
		 function fn_verify(authCode) {
			$('#verify_btn').click(function(){
				if (authCode == $('#user_key').val()) {
					alert('인증되었습니다. 비밀번호 변경 페이지로 이동합니다.');
					$('#f').attr('action', 'changePwPage.do');	
					$('#f').submit();
				} else {
					alert('인증이 실패했습니다.');
					history.back();
				}
			});
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
			text-decoration: none;
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
		<%-- home 아이콘 --%>
		<div class="home_icon">
			<a href="index.do">Home<i class="fas fa-home fa-2x"></i></a>	
		</div>
	
		<h2>비밀번호 찾기</h2>
		
		<form id="f">
			<div class="input_box">
				<label>아이디</label>
				<input type="text" id="id" name="id" class="int">
			</div>
			<div class="input_box">
				<label>이메일</label>
				<input type="text" id="email" name="email" class="int">
				<!-- 이메일 인증 -->
				<input type="button" value="인증번호받기" id="verify_num_btn">
			</div>	
			
			<div class="input_box">
			<input type="text" name="user_key" id="user_key" class="int">
			<input type="button" value="인증하기" id="verify_btn" class="int"> 
			</div>
			
			<div>		
				<input type="button" value="비밀번호 찾기" id="find_pw_btn">
				<input type="button" value="로그인하러 가기" onclick="location.href='loginPage.do'">
			</div>
		</form>
	</div>
	
</body>
</html>