<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<c:set var="str" value="Sun risies in East"></c:set>
		
		<c:out value="${fn:toLowerCase(str) }"></c:out><br>
		<c:out value="${fn:toUpperCase(str) }"></c:out><br>
		
		<c:if test="${fn:contains(str,'ini') }">
		<c:out value="true"></c:out>
		</c:if>
		
		
</body>
</html>