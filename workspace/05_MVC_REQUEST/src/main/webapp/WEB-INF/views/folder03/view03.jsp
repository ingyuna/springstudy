<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>view03.jsp</h1>
	${person1.name}<br>		<!--  Model로 넘긴 값(attribute) : request로 넘어온다. -->
	${person1.age}<br>
	${person1.hobbies}<br>
</body>
</html>