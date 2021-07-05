<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	
	
	</script>
	
	<style>			
		body {
			margin: 0 auto;
			background-color: #FEEEF5
		}		
		.outer {
			width: 700px;
			margin: 0 auto;
			padding: 30px;
		}		
		h1 {
			text-align: center;		
		}				
		nav > ul {		
			list-style-type: none;
			display: flex;	
			justify-content: center;
			padding: 30px;
			border-top: 1px solid gray;
		}
			
		ul > li:nth-of-type(1) {
			padding-right: 70px;
		}		
		ul > li:nth-of-type(2) {
			padding-left: 100px;
		}
		ul > li:nth-of-type(3) {
			padding-left: 200px;
		}
		
		li > a {
			text-decoration: none;
			font-weight: 600;
			color: #FF3C91;
		}
		
		a:hover {
			color: white;
			background-color: #FFD2EE;
			border-radius: 3px;
		}
		
		.welcome_font {
			text-align: right;
		}
		
	
	</style>
</head>
<body>
	<div class="outer">		
		<header>				
				<h1>My Home</h1>
				<c:if test="${loginUser != null}">
					<p class="welcome_font">${loginUser.name}님 환영합니다♥</p>
				</c:if>					
			<nav>
				<ul>
					<li><a href="#">갤러리 게시판</a></li>
					<li><a href="#">자유 게시판</a></li>
					
					<c:if test="${loginUser == null}">
						<li><a href="loginPage.do">로그인</a></li>						
					</c:if>				
					<c:if test="${loginUser != null}">
						<li><a href="logout.do">로그아웃</a></li>	
					</c:if>
				</ul>
			</nav>		
		</header>
		
		<section>
		
		</section>
	</div>
	
	

</body>
</html>