<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gallery_Board</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
	<script>
		$(document).ready(function(){
			$('#insert_btn').click(function(){
				location.href = 'insertGalleryBoardPage.do';
			});
		});
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
		
		.board_search_box {
			text-align: center;
			margin: 50px;
		}
		
		table {
			margin: 0 auto;
			width: 500px;
			text-align: center;
		}
		
		.insert_box {
			text-align: center;
			margin: 50px;
		}
		
		#insert_btn, .login_insert_btn {
			border: none;
			height: 30px;
			border-radius: 5px;
			background-color: #FCFCED
		}
		#insert_btn:hover, .login_insert_btn:hover {
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
		
		<h2>Gallery_Board</h2>
		
		<!-- 게시글 검색 -->
		<div class="board_search_box">
			<form method="get" id="f">
				<select id="column" name="column">
					<option value="">:::::선택:::::</option>
					<option value="WRITER">작성자</option>
					<option value="TITLE">제목</option>
				</select>
				<input type="text" id="query" name="query">
				<input type="button" value="검색" id="search_btn">
				<input type="button" value="초기화" id="init_btn">
			</form>
		</div>

		<!-- 게시글 목록 -->
		<table border="1">
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="4">작성된 게시글이 없습니다.</td>
					</tr>			
				</c:if>
				<c:if test="${not empty list}">
					<c:forEach var="GalleryBoard" items="${list}">
						<tr>
							<td>${GalleryBoard.no}</td>
							<td>${GalleryBoard.writer}</td>
							<td><a href="selectBoardByNo.do?no=${GalleryBoard.no}">${GalleryBoard.title}</a></td>
							<td>${GalleryBoard.postdate}</td>			
						</tr>				
					</c:forEach>
				</c:if>	
			</tbody>
		</table>
		
		<!-- 로그인을 해야만 게시글 작성 가능 -->
		<div class="insert_box">
			<%-- 로그인 했을때 --%>
			<c:if test="${loginUser != null}">
				<input type="button" value="새 글 작성하기" id="insert_btn">
			</c:if>
			
			<%-- 로그인 안 했을때 --%>
			<c:if test="${loginUser == null}">
				<input type="button" value="로그인하고 새 글 작성하기" onclick="location.href='loginPage.do'" class="login_insert_btn">
			</c:if>
			
		</div>
	
	</div>

</body>
</html>