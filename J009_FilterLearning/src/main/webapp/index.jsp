<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<form action="login">
			<input type="text" name="uname">
			<span>${unameErr}</span><br>
			<input type="text" name="pass">
			<span>${passErr}</span><br>
			<input type="submit"> 
			</form> 
</body>
</html>