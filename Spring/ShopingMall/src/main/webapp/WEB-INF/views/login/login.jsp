<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<Style>
.video{
width: 100%;
height: 100%;
}
.login{
min-width:480px;
width:50%;
height: 900px;
margin: auto;
margin-top:70px;
border: 1px solid red;



}
.login h3{
text-align: center;
font-size: 2rem;
}
.login_form{
width: 400px;
margin: auto;
height: 750px;
font-size: 1.5rem;
font-weight: bold;
border: 1px solid blue;
}
.login_form input{
margin-bottom: 20px;
}
.textfield{
width: 95%;
height: 40px;
border: 5px solid olive;
}
.login_form_ul{
list-style-type: none;
}
.login_form_ul li{
float: left;	
}
.login_form_div{
width: 150px;
height: 150px;
background-color: red;
}
.login_btn{
width: 45%;
height: 40px;
}
.login_form_submit{
width: 100%;
text-align: center;
}
</Style>
</head>
<body>

    <div class="login">
<h3>Login</h3>
	<div class="login_form">
		<form action="newLogin" method="POST">
			<label for="id">ID</label><br>
			<input type="text" id="id" name="id"class="textfield" autocomplete="off"><br>
			<label for="pwd">Password</label><br>
			<input  type="text" id="pwd" name="pwd"class="textfield" autocomplete="off">
			<div class="login_form_submit">
				<input type="button" value="Join" class="login_btn" onclick="location.href='join'">
				<input type="submit" value="Login" class="login_btn"><br>
				<a href="">Forgot Password?</a>
			</div>
			
			
			<!-- <ul class="login_form_ul">
				<li><div class="login_form_div"></div></li>
				<li><div class="login_form_div"></div></li>
				<li><div class="login_form_div"></div></li>
				<li><div class="login_form_div"></div></li>
			</ul> -->
		
		
		
		
		
		</form>
	</div>
</div>
<%@include file="../Include/footer.jsp" %>
</body>
</html>







