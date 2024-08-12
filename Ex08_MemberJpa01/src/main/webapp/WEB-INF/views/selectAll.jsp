<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #01 - selectOne</h1><br><br><br><br><br>
	
	<c:forEach var="r" items="${mList}">
		아이디 : ${r.id}<br>
		이름 : ${r.name}<br>
		날짜 : ${r.createDate}<hr>
	</c:forEach>
	
</body>
</html>