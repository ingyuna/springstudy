<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/assets/css/style2.css">
	
</head>
<body>
	<div class="outer">
		<form action="insertContact.do" id="f">
			<h3>연락처 등록</h3>
			이름<br>
			<input type="text" name="name" id="name"><br><br>
			전화<br>
			<input type="text" name="tel" id="tel"><br><br>
			주소<br>
			<input type="text" name="addr" id="addr"><br><br>
			이메일<br>
			<input type="text" name="email" id="email"><br><br>
			비고<br>
			<input type="text" name="note" id="note"><br><br>
			<button>연락처 저장하기</button>		
			<input type="button" value="전체연락처" id="list_btn">
		</form>
	</div>
</body>
</html>