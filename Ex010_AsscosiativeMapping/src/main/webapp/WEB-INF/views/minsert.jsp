<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>* 회원가입 완료 * </h1><br><br>
	
	id : ${member.id}<br><br>
	name : ${member.name}<br><br>
	가입날짜 : ${member.createdAt}<br><br>
	
	<a href="javascript:history.back()"><button>돌아가기</button></a>
</body>
</html>