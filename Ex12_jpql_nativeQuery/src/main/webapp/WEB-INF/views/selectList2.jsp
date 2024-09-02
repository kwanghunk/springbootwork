<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JPQL - Name Like</h1>
	총 레코드 수 : ${totalRecord }
	현재 페이지 : ${nowPage}<br><br><hr>
	
	<c:forEach items="${members}" var="m">
		아이디 : ${m.id}<br>
		이름 : ${m.name}<br>
		이메일 : ${m.email}<br>
		<hr>
	</c:forEach>
	
	<a href="javascript:history.back()">돌아가기</a>
</body>
</html>