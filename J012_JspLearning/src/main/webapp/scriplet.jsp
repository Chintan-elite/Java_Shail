<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			
			<%!
			
				public int a = 50;
			%>
			
			<%
				int k;
				k=50;
				int a = 10;
				int b = 20;
				int c  =a+b+k;
				out.print(c);
			%>
			
			<%
				int result = k+a+b;
				out.print(result);
			%>
			
			<%=k%>
		
</body>
</html>