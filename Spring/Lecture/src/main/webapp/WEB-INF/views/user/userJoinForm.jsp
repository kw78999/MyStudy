<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="container">
	<div class="section-heading">
		<h2>회원가입</h2>
	</div>
	<form method="post" action="userJoin">
		<input type="text" class="form-control" name="userID" placeholder="ID" required>
		<input type="password" class="form-control" name="userPW" placeholder="Password" required>
		<input type="password" class="form-control" name="userPW_Confirm" placeholder="Password Confirm" required>
		<input type="text" class="form-control" name="userName" placeholder="Name" required>
		<input type="email" class="form-control" name="userEmail" placeholder="Email" required>
		<input type="submit" class="form-control foode-btn" value="가입하기">
	</form>
</div>
<%@include file="../include/footer.jsp"%>
</body>
</html>

