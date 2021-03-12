<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="container">
	<div class="section-heading">
		<h2>로그인</h2>
	</div>
	<form method="post" action="userLogin">
		<input type="text" class="form-control" name="userID" placeholder="ID" required> 
		<input type="password" class="form-control" name="userPW" placeholder="Password" required> 
		<input type="submit" class="form-control foode-btn" value="로그인">
	</form>
</div>
<%@include file="../include/footer.jsp"%>
</body>
</html>

