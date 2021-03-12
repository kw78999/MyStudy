<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/header_login.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<Style>
.login{
min-width:480px;
width:50%;
height: 700px;
margin: auto;
margin-top:70px;
border: 3px solid silver;
}
.login h3{
text-align: center;
font-size: 2rem;
}
.login_form{
width: 400px;
margin: auto;
height: 550px;
font-size: 1.5rem;
border: 1px solid red;
font-weight: bold;
}
.login_form input{
margin-bottom: 20px;
}
.textfield{
width: 95%;
height: 40px;
border: 5px solid olive;
}
</Style>
</head>
<body>

<div class="login">
<h3>Login</h3>
	<div class="login_form">
		<form action="login" method="get">
			<label for="id">ID</label><br>
			<input id="id" name="id"class="textfield"><br>
			<label for="pwd">Password</label><br>
			<input id="pwd" name="pwd"class="textfield">
		</form>
	</div>
</div>

<%@include file="../Include/footer.jsp" %>
</body>
</html>







