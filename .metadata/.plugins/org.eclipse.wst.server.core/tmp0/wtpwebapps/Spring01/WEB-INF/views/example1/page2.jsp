<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 2</title>
</head>
<body>
	<h1>page2.jsp</h1>
	<form action="/ex01/example2/send" method="post">
		이름 : <input type="text" name="name">
		나이 : <input type="number" name="age">
		<input type="submit" value="전송">
	</form>
</body>
</html>