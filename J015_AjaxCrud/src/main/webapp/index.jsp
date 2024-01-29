<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Document</title>
    
    <script type="text/javascript">
    
    $(document).ready(function(){
		
    	$("#update").hide()
    	loadData();
	})	
	
	
	function adddata()
    {
		var fname = $("#fname").val()
		var lname = $("#lname").val()
		var email = $("#email").val()
		
		$.get("addStudent",{fname,lname,email},function(rt){
			alert(rt)
			loadData()
		})
		
	}
    
    function updatedata()
    {
		var id = $("#id").val()
		var fname = $("#fname").val()
		var lname = $("#lname").val()
		var email = $("#email").val()
		
		$.post("addStudent",{id,fname,lname,email},function(rt){
			alert(rt)
			loadData()
		})
		
	}
    
    function deleteData(uid)
    {
		$.get("update",{uid,action:"delete"},function(rt){
			alert(rt)
			loadData()
		})	
	}
    
    function editData(uid)
    {
    	$.get("update",{uid,action:"edit"},function(rt){

    		const data = JSON.parse(rt)
    		$("#id").val(data.id)
    		$("#fname").val(data.firstName)
    		 $("#lname").val(data.lastName)
    		$("#email").val(data.email)
    		
    		$("#update").show()
    		$("#add").hide()
    		
		})	
    }
    
    
	function loadData()
    {
	
    	$.get("display",{},function(rt){
			
    		const data = JSON.parse(rt)
    		var row;
			for(var i=0;i<data.length;i++)
			{
					row=row+"<tr><td>"+data[i].id+"</td><td>"+data[i].firstName+"</td><td>"+data[i].lastName+"</td><td>"+data[i].email+"</td><td><button class='btn btn-danger' onclick='deleteData("+data[i].id+")'>Delete</button></td><td><button class='btn btn-primary' onclick='editData("+data[i].id+")'>Edit</button></td></tr>"
			}
			$("#tdata").html(row)
		})	
    }
	
	function searchData()
    {
		var cdata =$("#search").val();
		
    	$.get("search",{cdata},function(rt){
			
    		
    		const data = JSON.parse(rt)
    		var row;
			for(var i=0;i<data.length;i++)
			{
					row=row+"<tr><td>"+data[i].id+"</td><td>"+data[i].firstName+"</td><td>"+data[i].lastName+"</td><td>"+data[i].email+"</td><td><button class='btn btn-danger' onclick='deleteData("+data[i].id+")'>Delete</button></td><td><button class='btn btn-primary' onclick='editData("+data[i].id+")'>Edit</button></td></tr>"
			}
			$("#tdata").html(row)
		})	
    }
    
    </script>
    
</head>
<body>
    
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <h1 align="center" >Student Management system</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <form action="">
                    	<input type="hidden" id="id">
                        <h2 align="center">Add Student</h2>
                        <div class="form-group">
                            <label for="">FirstName</label>
                            <input type="text" name="fname" id="fname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Lastname</label>
                            <input type="text" name="lname" id="lname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Email</label>
                            <input type="text" name="email" id="email" class="form-control">
                        </div>
                        <button class="btn btn-success" onclick="adddata()" id="add">Add</button>
                      	 <button class="btn btn-success" onclick="updatedata()" id="update">Update</button>
                      
                        <button class="btn btn-primary">Reset</button>
                    </form>
                </div>
                <div class="col-md-8">
                    <h2 align="center">Student Details</h2>
                    <div class="form-group">
                    <input type="text" name="search" id="search" class="form-control" onkeyup="searchData()" placeholder="search student">
                </div>
                    <table class="table">
                        <tr>
                            <th>Id</th>
                            <th>FirstName</th>
                            <th>Lastname</th>
                            <th>Email</th>
                            <th colspan="2">Action</th>
                        </tr>
                        <tbody id="tdata">
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	 
	

</body>
</html>