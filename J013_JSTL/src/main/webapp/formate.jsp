
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<%-- 	<%
			Date date = new Date();
		%>
		<%=date%> --%>
		
		<c:set var="dt" value="<%=new java.util.Date()%>"></c:set>
	    <fmt:formatDate value="${dt}" type="both"  
              timeStyle="long" dateStyle="long" />  
		
		
		
		
</body>
</html>