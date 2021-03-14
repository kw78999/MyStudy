<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>	
<style>
.join{
width: 100%;
text-align: center;
border: 1px solid red;
}
.join ul{
list-style-type: none;
}
</style>
<script>
function joinSuccess() {
	alert("회원가입 성공");
}
</script>
</head>
<body>
<div class="join">
<h2>Join</h2>
<form action="newJoin" method="post">
	<ul>
		<li>
		<label for="id">ID</label>
		<input type="text" id="id" name="id" >
		</li>
		<li>
		<label for="pwd">PWD</label>
		<input type="text" id="pwd" name="pwd" >
		</li>
		<li>
		<input type="submit" value="회원가입"onclick="joinSuccess()">
		</li>
	</ul>
</form>



</div>




<%@include file="../Include/footer.jsp" %>
</body>
</html>