<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	
	function hello()
	{
		var name = document.getElementById("name").value;
		
		$.get("hello",{name},function(rt){
			
			$("#display").html(rt)
		})
		
	}
	
	</script>
	
</head>
<body>
		
		<input type="text" name="name" id="name" onkeyup="hello()">
		
		<div id="display"></div>
</body>
</html>