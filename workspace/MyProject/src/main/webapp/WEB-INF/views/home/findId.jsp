<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
	<script>
		$(document).ready(function(){
			fn_findId();
		});
		
		function fn_findId() {
			$('#find_id_btn').click(function(){
				if($('#name').val() == '') {
					alert('이름을 입력하세요.')	
					$('#name').focus();
					return false;
				} else if($('#phone').val() == '') {
					alert('전화번호를 입력하세요.')
					$('#phone').focus();
					return false;
				} else {
					$('#f').attr('action', 'findId.do');
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
	
		<h2>아이디 찾기</h2>
		
		<form id="f" method="post">
			<div class="input_box">
				<label>이름</label>
				<input type="text" id="name" name="name" class="int">
			</div>
			<div class="input_box">
				<label>전화번호</label>
				<input type="text" id="phone" name="phone" class="int">
			</div>	
			<div>		
				<input type="button" value="아이디 찾기" id="find_id_btn">
				<input type="button" value="로그인하러 가기" onclick="location.href='loginPage.do'">
			</div>
		</form>
	</div>


</body>
</html>