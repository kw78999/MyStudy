<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/header.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<meta charset="UTF-8">
<title>Join</title>	
<style>


.join{
width: 100%;
text-align: center;
}
.join ul{
list-style-type: none;
}
.joinTable{
width: 40%;
height: 100%;
margin: auto;
}
td{
border: 1px solid blue;
}
.signInput{
height: 60px;
}
.joinName{
text-align: left;
padding-left: 30px;
width: 150px;
}
.signInput{
width: 300px;
height: 30px;
}
.signInput_3{
width: 60px;
height: 25px;
}
.signInput_select{
width: 70px;
height: 30px;
margin-left: 5px;
margin-right: 10px;
}
.join_single_form{
text-align: left;
padding: 30px;
}
.signInput_email{
width: 100px;
height: 30px;
}
.signInput_email_select{
width:120px;
height: 30px;
}
.zipCode{
width: 320px;
height: 30px;
}
</style>
</head>
<body>
<div class="join">
<h2>Join</h2>
<form action="newJoin" method="post" name="joinfrm">
	
	<table class="joinTable">
		<tr>
		<td class="joinName" style="border: 1px solid #40c700;" id="tr_id"><span>아이디</span></td>
		<td class="join_single_form"><input type="text" name="id" class="signInput" autocomplete="off">
		<div id="idc" class="cdiv"></div></td>
		</tr>
		<tr>
		<td class="joinName">비밀번호</td>
		<td class="join_single_form"><input type="password" name="pwd" class="signInput" onblur="pwCheck()">
		<div id="pw1" class="cdiv"></div></td>
		</tr>
		<tr>
		<td class="joinName">비밀번호 확인</td>
		<td class="join_single_form"><input type="password" name="pwd2" class="signInput" onblur="pwCheck2()">
		<div id="pw2" class="cdiv"></div></td>
		</tr>
		<tr>
		<td class="joinName">이름</td>
		<td class="join_single_form"><input type="text" name="name" class="signInput" autocomplete="off" onblur="nameCheck()">
		 
		<div id="ndiv" class="cdiv"></div>
		</td>
		</tr>
		<tr>
		<td class="joinName">생년월일</td>
		<td class="join_single_form"><input type="text" name="birth1" class="signInput_3" placeholder="년" autocomplete="off" onblur="yyyyCheck()" maxlength="4">
		<select name="birth2" class="signInput_select" onblur="mmCheck()">
		<option value="1">1월<option value="2">2월<option value="3">3월<option value="4">4월<option value="5">5월<option value="6">6월
		<option value="7">7월<option value="8">8월<option value="9">9월<option value="10">10월<option value="11">11월<option value="12">12월
		</select><input type="text" name="birth3" class="signInput_3" placeholder="일" autocomplete="off" onblur="ddCheck()" maxlength="2">
		<div id="bdiv" class="cdiv"></div>
		</td>
		</tr>
		<tr>
		<td class="joinName">주소</td>
		<td class="join_single_form">
		<input type="text"  placeholder="우편번호" id="zip1" class="zipCode" name="zip1">
		<button type="button" onclick="execPostcode()">우편번호 찾기</button><br>
		<input type="text"  placeholder="주소" id="zip2" class="zipCode" name="zip2"><br>
		<input type="text" placeholder="상세 주소" id="zip3" class="zipCode" onblur="zipCheck()" name="zip3">
		<div id="zdiv" class="cdiv"></div>
		</td>	
		</tr>
		<tr>
		<td class="joinName">이메일</td>
		<td class="join_single_form"><input type="text" id="email" name="email"class="signInput_email"  autocomplete="off" onblur="emailCheck()" maxlength="15">
		@ <select name="emailSelect" class="signInput_email_select">
		 <option value="gmail.com">gmail.com
		 <option value="naver.com">naver.com
		 <option value="daum.com">daum.com
		 </select>
		 <div id="ediv" class="cdiv"></div>
		</td>
		</tr>
		<tr>
		<td class="joinName">핸드폰</td>
		<td class="join_single_form"><input type="text" class="signInput_3" value="010" disabled="disabled"> -
		<input type="text" class="signInput_3" onblur="phoneCheck()" name="phone1" maxlength="4"> - 
		<input type="text" class="signInput_3" onblur="phoneCheck2()" name="phone2" maxlength="4">
		<div id="pndiv" class="cdiv"></div>
		</td>
		</tr>
		
	</table>
		<input type="button" value="회원가입" onclick="check()">
</form>

<script type="text/javascript" src="resources/js/loginCheck.js" charset="utf-8"></script>
</div>
<%@include file="../Include/footer.jsp" %>


</body>
</html>