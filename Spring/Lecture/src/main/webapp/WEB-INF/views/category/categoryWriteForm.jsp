<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="container">
	<form method="get" action="categoryInsert">
		<select class="custom-select" name="ctGubun1">
			<option value="1">웹언어</option>
			<option value="2">언어</option>
			<option value="3">사물인터넷</option>
			<option value="4">API기술</option>
		</select> 
		<input type="text" class="form-control" name="ctGubun2" placeholder="강의명을 입력하세요." required>
		<input type="submit" class="form-control foode-btn" value="생성">
	</form>
</div>
<%@include file="../include/footer.jsp"%>
</body>
</html>

