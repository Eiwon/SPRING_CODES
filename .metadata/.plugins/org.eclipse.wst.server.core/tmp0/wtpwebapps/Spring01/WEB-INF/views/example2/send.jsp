<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송 실습</title>
</head>
<body>
	<form action="send" method="post">
		이름 : <input type="text" name="name">
		나이 : <input type="number" name="age">
		<input type="submit" value="전송">
	</form>
</body>
</html>