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
		
		
		제목 : ${board.title}<br><br>
		내용 : ${board.content}<br><br>
		작성자 : ${board.member}<br><br>
		작성자 : ${board.member.getId()}<br><br>
		
		<a href="javascript:history.back()"><button>돌아가기</button></a>
</body>
</html>