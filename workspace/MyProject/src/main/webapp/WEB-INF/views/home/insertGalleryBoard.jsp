<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 작성</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
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
			color: #FC5DD5;
			text-decoration: none;
		}
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 100px;
			text-align: center;
		}		
		h2 {
			text-align: center;		
		}	
		
		.insert_box {
			padding: 10px;
		}
		
		.input_box {
			margin: 20px;
		}
		
		.int {
			height: 25px;
		}
		
		.int_title {
			width: 300px;
			height: 25px;
		}
		
		.save_box {
			padding: 20px;
		}
		
		#save_btn {
			border: none;
			height: 30px;
			border-radius: 5px;
			background-color: #FCFCED;
		}
		
		#save_btn:hover {
			cursor: pointer;		
			background-color: #FDF0A9;
		}
	
	</style>
</head>
<body>

	<div class="outer">
	
		<%-- home 아이콘 --%>
		<div class="home_icon">
			<a href="index.do">Home<i class="fas fa-home fa-2x"></i></a>	
		</div>
		
		<h2>게시글을 작성해주세요 :)</h2>
		
		<form action="insertGalleryBoard.do" 
	      method="post" 
	      enctype="multipart/form-data"
	      class="insert_box">
	      
	      	<div class="input_box">
			   작성자
				<input type="text" name="id" class="int" value="${loginUser.id}" readonly>
			</div>
			
			<div class="input_box">
				제목
				<input type="text" name="title" class="int_title">
			</div>
			
			<div class="input_box">
				<p>내용</p>
				<textarea rows="10" cols="50" name="content"></textarea>
			</div>
			
			<div class="input_box">
				첨부
				<input type="file" name="filename">
			</div>
			
			<div class="save_box">
				<button id="save_btn">저장하기</button>	
			</div>
	      
	    </form>
	
	</div>

	
</body>
</html>