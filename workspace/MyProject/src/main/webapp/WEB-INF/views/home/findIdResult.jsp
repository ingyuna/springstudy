<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FindId Result</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />	
	
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
		
		table {
			margin: 0 auto;
			width: 300px;
			height: 100px;
			background-color: white;
		}
		
		.login_btn {
			margin: 30px;
			border: none;
			background-color: #FEEEF5;
		}
		
		.login_btn:hover {
			color: #B152FB;
			cursor: pointer;
		}
		
		.find_id_btn {
			margin: 25px;
		}
		
		a {
			text-decoration: none;
			font-weight: 700;
			color: #599CFB;
		}
		
		
	
	</style>
</head>
<body>
	<div class="outer">
	
		<h2>아이디 찾기 결과</h2>
		
			<table border="1">
				<tbody>
					<%-- 정보가 틀릴 때 --%>
					<c:if test="${findUser == null}">
						<tr>			
							<td>일치하는 정보가 없습니다.</td>
						</tr>	
					</c:if>		
					
					<%-- 정보가 일치할 때 --%>	
					<c:if test="${findUser != null}">
						<tr>
							<th>아이디</th>
							<!-- <td>${findUser.id.substring(0, 3)}</td> --> <%-- 3글자만 보여주기--%>
							<td>${findUser.id}</td>
						</tr>
						<tr>
							<th>가입일자</th>
							<td>${findUser.regdate}</td>
						</tr>
					</c:if>			
				</tbody>
			</table>
			
			<c:if test="${findUser == null}">
				<div class="find_id_btn">
					<a href="findIdPage.do">아이디 찾기&nbsp;<i class="fas fa-mouse-pointer fa-2x"></i></a>
				</div>
			</c:if>
			
			<c:if test="${findUser != null}">
				<div class="login_btn">
					<a href="loginPage.do">로그인하러 가기&nbsp;<i class="far fa-hand-point-up fa-2x"></i></a>
				</div>
			</c:if>
			

	
	</div>
	

</body>
</html>