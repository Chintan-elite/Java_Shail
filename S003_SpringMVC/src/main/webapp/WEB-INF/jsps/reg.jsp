<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Index</h1>
	
	
	<form:form action="adduser" modelAttribute="user">
	
	<form:label path="uname">username</form:label>
	<form:input path="uname"/>
	
	<form:label path="email">Email</form:label>
	<form:input path="email"/>
	
	<form:label path="pass">Password</form:label>
	<form:password path="pass"/>
	
	<input type="submit">
	
	</form:form>
	
	
</body>
</html>