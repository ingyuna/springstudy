<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 보기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
	<script>
		$(function(){
			fn_update();
			fn_delete()
		});
		
		// 수정하기
		function fn_update(){
			$('#update_btn').click(function(){
				$('#f').attr('action', 'updateBoard.do');
				$('#f').submit();
			});
		}
		
		// 삭제하기
		function fn_delete(){
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					$('#f').attr('action', 'deleteGalleryBoard.do');
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
			color: #FC5DD5;
			text-decoration: none;
		}
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 50px;
		}		
		h2 {
			text-align: center;		
		}	
	
	</style>
</head>
<body>

	<div class="outer">
	
		<%-- home 아이콘 --%>
		<div class="home_icon">
			<a href="index.do">Home<i class="fas fa-home fa-2x"></i></a>	
		</div>

		<h2>게시글 보기</h2>
	
		<form id="f" method="post" enctype="multipart/form-data">
		      
		    <input type="button" value="수정하기" id="update_btn">
		    <input type="button" value="삭제하기" id="delete_btn"><br><br>	     
		    
		    <input type="hidden" name="no" value="${board.no}">		
		    <input type="hidden" name="filename1" value="${filename}">	
		      
			작성자<br>
			${board.id}<br><br>
			
			제목<br>
			<input type="text" name="title" value="${board.title}"><br><br>
			
			내용<br>
			<input type="text" name="content" value="${board.content}"><br><br>
			
			첨부 변경<br>
			<input type="file" name="filename2"><br><br>		
			
			첨부 이미지<br>
			<img alt="${filename}" src="resources/archive/${filename}" style="width: 300px;">
			
		</form>
	</div>
	
	
	<!-- 갤러리 댓글 게시판 -->
	<div class="reply_box">
	
	
	
	</div>

</body>
</html>