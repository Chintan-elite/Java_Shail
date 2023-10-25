/**
 * 
 */

//document.getElementsByTagName("h1")[0].style.color="red"
//document.getElementsByTagName("h1")[1].style.color="green"


function add()
{
	
 	var n1 = document.getElementById("n1").value
	var n2 = document.getElementById("n2").value
	var result = document.getElementById("result")
	
	var r =Number(n1)+Number(n2);
	
	result.innerHTML=r;
}

function mul()
{
	
 	var n1 = document.getElementById("n1").value
	var n2 = document.getElementById("n2").value
	var result = document.getElementById("result")
	
	var r =Number(n1)*Number(n2);
	
	result.innerHTML=r;
}

function div()
{
	
 	var n1 = document.getElementById("n1").value
	var n2 = document.getElementById("n2").value
	var result = document.getElementById("result")
	
	var r =Number(n1)/Number(n2);
	
	result.innerHTML=r;
}

function sub()
{
	
 	var n1 = document.getElementById("n1").value
	var n2 = document.getElementById("n2").value
	var result = document.getElementById("result")
	
	var r =Number(n1)-Number(n2);
	
	result.innerHTML=r;
}

function highlight()
{
	document.getElementById("n1").style.background="red"
	document.getElementById("n1").style.color="white"
	document.getElementById("n1").style.height="30px";	
}


