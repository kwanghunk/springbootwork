<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="minsert" method="post">
		ID : <input name="id"><br><br>
		Name : <input name="name"><br><br>
		PASSWORD : <input name="password" type="password"><br><br>
		<button>회원가입</button>
	</form>
	
	<br><br><br>
	
	<form action="binsert" method="post">
		제목 : <input name="title"><br><br>
		내용 : <input name="content"><br><br>
		<button>게시글 작성</button>
	</form>
	
	<hr><br>
	
	<a href="mupdate?id=user01&name=김수정">멤버이름수정</a>
</body>
</html>