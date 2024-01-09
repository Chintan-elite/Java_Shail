<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="true" errorPage="err.jsp"%> 
<%@include file="home.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<!-- <h1>Hello</h1> -->
			<h1>Hello</h1>
			<h2>${msg}</h2>
			
			<%
				//int a = 10;
				//int b = a/0;
				//Scanner
				
				int a[] = new int[5];
				a[6] = 45;
			%>
</body>
</html>