<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.emailCheck{
width: 70%;
height: 400px;
border: 1px solid blue;
margin: auto;
text-align: center;
margin-top: 200px;
}
.CheckText{
width: 300px;
height: 50px;
}
.joinCode_btn{
width: 100px;
height: 50px;
}
</style>
<script>
function Permission() {
	btn=document.getElementById("joinCode_btn");
	text=document.getElementById("joinCode_text");
	//인증코드가 시간초과로 삭제될떄 아닐떄 JSTL문법으로 자바스크립트 제어
	<c:choose>
    <c:when test="${sessionScope.joinCode eq null}">
    	alert("시간 초과입니다.");
    </c:when>
    <c:otherwise>
	    if(text.value==${sessionScope.joinCode}){
			alert("승인");
		}else{ 
			alert("다릅니다.");
		}
    </c:otherwise>
	</c:choose>
	
	
}
</script>
</head>
<body>
<div class="emailCheck">
<h2>${memberId}님 가입을 축하합니다.</h2>
<h4>${email} 로 인증번호가 전송되었습니다.</h4>
인증번호 : <input type="text" class="joinCode_text" id="joinCode_text" maxlength="4">
<button class="joinCode_btn" onclick="Permission()" id="joinCode_btn">인증</button>






</div>





<%@include file="../Include/footer.jsp" %>
</body>
</html>