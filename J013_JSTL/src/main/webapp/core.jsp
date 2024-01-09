<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<c:set var="a" value="40"></c:set>
		<c:out value="${a}"></c:out>
		<br>
		<c:if test="${a>20}">
		<c:out value="a is greater then 20"></c:out>
		</c:if>
		<br>
		<c:forEach begin="1" end="10" var="dt">
		<c:out value="${dt}"></c:out>
		</c:forEach>
		
		

</body>
</html>