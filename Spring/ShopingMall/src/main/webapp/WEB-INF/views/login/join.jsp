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
width: 70%;
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
		<td class="joinName" style="border: 1px solid #40c700;" id="tr_id">아이디</td>
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
		<td class="join_single_form"><input type="text" name="birth1" class="signInput_3" placeholder="년" autocomplete="off" onblur="yyyyCheck()">
		<select name="birth2" class="signInput_select" onblur="mmCheck()">
		<option value="1">1월<option value="2">2월<option value="3">3월<option value="4">4월<option value="5">5월<option value="6">6월
		<option value="7">7월<option value="8">8월<option value="9">9월<option value="10">10월<option value="11">11월<option value="12">12월
		</select><input type="text" name="birth3" class="signInput_3" placeholder="일" autocomplete="off" onblur="ddCheck()">
		<div id="bdiv" class="cdiv"></div>
		</td>
		</tr>
		<tr>
		<td class="joinName">주소</td>
		<td class="join_single_form">
		<input type="text" disabled="disabled" placeholder="우편번호" id="zip1" class="zipCode">
		<button type="button" onclick="execPostcode()">우편번호 찾기</button><br>
		<input type="text" disabled="disabled" placeholder="주소" id="zip2" class="zipCode"><br>
		<input type="text" placeholder="상세 주소" id="zip3" class="zipCode">
		<input type="hidden" placeholder="참고 항목" id="zip4" class="zipCode">
		
		
		
		</td>	
		</tr>
		<tr>
		<td class="joinName">이메일</td>
		<td class="join_single_form"><input type="text" class="signInput_email"  autocomplete="off" onblur="">
		@ <select name="emailSelect" class="signInput_email_select">
		 <option value="gmail.com">gmail.com
		 <option value="naver.com">naver.com
		 <option value="daum.com">daum.com
		 </select>
		</td>
		</tr>
		<tr>
		<td class="joinName">핸드폰</td>
		<td class="join_single_form"><input type="text" class="signInput_3" value="010" disabled="disabled"> -
		<input type="text" class="signInput_3" onblur="phoneCheck()" name="phone1"> - 
		<input type="text" class="signInput_3" onblur="phoneCheck2()" name="phone2">
		<div id="pndiv" class="cdiv"></div>
		</td>
		</tr>
		
	</table>
	
	
	
		<input type="submit" value="회원가입">
		<c:forEach items="${list}" var="i">
		${i }<br>
		</c:forEach>
		<input type="hidden" id="idList" value="<c:out value="${list }"/>">
</form>
<script type="text/javascript">

var frm = document.joinfrm;



	
	function pwCheck() {
		pwd=frm.pwd.value;
		var idcc=/^[0-9a-zA-Z]{8,12}$/;
		
		var pw1 = document.getElementById("pw1");
		
		if(pwd.length<8||pwd.length>12){
			pw1.style.color="red";
			pw1.innerHTML="비밀번호 길이는 8~12자로 해주세요.";
			return false;
		}else{
			if(idcc.test(pwd)){
				pw1.style.color="#40c700";
				pw1.innerHTML="사용가능";
				return true;
			}else{
				pw1.style.color="red";
				pw1.innerHTML="비밀번호는 영문과 숫자로만 조합하세요.";
				return false;
			}
				
		}
		
	}
	function pwCheck2() {
		pwd2=frm.pwd2.value;
		pwd=frm.pwd.value;
		
		var pw2 = document.getElementById("pw2");
		if(pwd!=pwd2){
			pw2.style.color="red";
			pw2.innerHTML="비밀번호가 다릅니다.";	
			return false;
		}else{
			pw2.style.color="#40c700";
			pw2.innerHTML="비밀번호 일치합니다.";	
			return true;
		}
	}
	
	function nameCheck() {
		var ndiv=document.getElementById("ndiv");
		var name=frm.name.value;
		var ncheck = /^[가-힝]{2,}$/;
		
		if(ncheck.test(name)){
			ndiv.style.color="#40c700";
			ndiv.innerHTML="확인";
			return true;
		}else{
			ndiv.style.color="red";
			ndiv.innerHTML="이름을 확인하세요.";
			return false;
		}
		
	}
	
	function yyyyCheck() {
		var bdiv=document.getElementById("bdiv");
		yyyy=frm.birth1.value;
		var ycheck = /^([1-2]{1})-?([0|9]{1})-?([0-9]{2})$/;
		
		if(ycheck.test(yyyy)){
			bdiv.innerHTML="";
			return true;
		}else{
			bdiv.style.color="red";
			bdiv.innerHTML="년도를 확인하세요"
				return false;
		}
	}
	
	
	function mmCheck() {
		var bdiv=document.getElementById("bdiv");
		mm=frm.birth2.value;
		
		if(mm=='월'){
			bdiv.style.color="red"
			bdiv.innerHTML="월을 확인하세요"
				return false;
		}else{
			bdiv.innerHTML=""
			return true;
		}
		
	}
	
	
	function ddCheck(){
		var bdiv=document.getElementById("bdiv");
		dd=frm.birth3.value;
		var dcheck1 = /^([1-9]{1})$/;  //한자리수 날짜
		var dcheck2 = /^([1-2]{1})-?([0-9]{1})$/;  //두자리수 1,2 로 시작하는 날짜
		var dcheck3 = /^([3]{1})-?([0-1]{1})$/;  //두자리수 3으로 시작하는 날짜
		
		if(dd.length==1){
			if(dcheck1.test(dd)){
				bdiv.style.color="#40c700"
				bdiv.innerHTML="확인"
					return true;
			}else{
				bdiv.style.color="red"
				bdiv.innerHTML="날짜를 확인하세요"
					return false;
			}
		}else if(dd.length==2){
				if(dd.substring(0,1)==3){
					if(dcheck3.test(dd)){
						bdiv.style.color="#40c700"
						bdiv.innerHTML="확인"
							return true;
					}else{
						bdiv.style.color="red"
						bdiv.innerHTML="날짜를 확인하세요"
							return false;
					}
				}else{
						if(dcheck2.test(dd)){
							bdiv.style.color="#40c700"
							bdiv.innerHTML="확인"
								return true;
						}else{
							bdiv.style.color="red"
							bdiv.innerHTML="날짜를 확인하세요"
								return false;
						}
				}
		}else{
			bdiv.style.color="red"
			bdiv.innerHTML="날짜를 확인하세요"
				return false;
		}
	}
	
	
	
	function phoneCheck() {
		var pndiv=document.getElementById("pndiv");
		p=frm.phone1.value;
		
		var pcheck = /^([0-9]{4})$/;
		
		if(pcheck.test(p)){
			pndiv.style.color="#40c700"
			pndiv.innerHTML="확인"
				return true;
		}else{
			pndiv.style.color="red"
			pndiv.innerHTML="핸드폰 번호를 확인하세요"
				return false;
		}
		
	}
	function phoneCheck2() {
		var pndiv=document.getElementById("pndiv");
		p=frm.phone2.value;
		
		var pcheck = /^([0-9]{4})$/;
		
		if(pcheck.test(p)){
			pndiv.style.color="#40c700"
			pndiv.innerHTML="확인"
				return true;
		}else{
			pndiv.style.color="red"
			pndiv.innerHTML="핸드폰 번호를 확인하세요"
				return false;
		}
		
	}
	
	function check(){
		flag = true;
		msg="가입성공";
		id = frm.id.value;
		pwd = frm.pwd.value;
		pwd2 = frm.pwd2.value;
		name = frm.name.value;
		birth1 = frm.birth1.value;
		birth2 = frm.birth2.value;
		birth3 = frm.birth3.value;
		gender = frm.gender.value;
		phone = frm.phone.value;
		
		if(id.replace(/(^\s*)|(\s*$)/, "").trim()=="") {
			msg="아이디를 입력해주세요";
			frm.id.focus();
			flag = false;
		} else if(id.length < 8 || id.length > 12) {
			msg="아이디는 8 ~ 12자 이내로 입력해주세요"; 
			frm.id.focus(); 
			flag = false;
		} else if(pwd=="") {
			msg="비밀번호를 입력하세요";
			frm.pwd.focus();
			flag = false;
		} else if(pwd.length < 8 || pwd.length > 12) {
			msg="비밀번호는 8 ~ 12자 이내로 입력해주세요";
			frm.pwd.focus();
			flag = false;
		} else if(pwd!=pwd2) {
			msg="비밀번호를 확인해주세요";
			frm.pwd2.focus();
			flag = false;
		} else if(name.replace(/(^\s*)|(\s*$)/, "").trim()==""){
			msg="이름을 입력하세요";
			frm.name.focus();
			flag = false;
		} else if(birth1.trim()==""||birth2.trim()==""||birth3.trim()==""){
			msg="생년월일을 입력하세요";
			frm.birth1.focus();
			flag = false;
		} else if(gender=="성별"){
			msg="성별을 입력하세요";
			frm.gender.focus();
			flag = false;
		} else if(phone.trim()==""){
			msg="휴대전화를 입력하세요";
			frm.phone.focus();
			flag = false;
		}else if(!idCheck()){
			msg="아이디를 확인하세요";
			frm.id.focus();
			flag = false;
		}else if(!pwCheck()){
			msg="비밀번호를 확인하세요";
			frm.pwd.focus();
			flag = false;
		}else if(!pwCheck2()){
			msg="비밀번호를 확인하세요";
			frm.pwd2.focus();
			flag = false;
		}else if(!nCheck()){
			msg="이름을 확인하세요";
			frm.name.focus();
			flag = false;
		}else if(!yyyyCheck()){
			msg="년도를 확인하세요";
			flag = false;
		}else if(!mmCheck()){
			msg="월을 확인하세요";
			flag = false;
		}else if(!ddCheck()){
			msg="날짜를 확인하세요";
			flag = false;
		}else if(!pnumCheck()){
			msg="핸드폰 번호를 확인하세요";
			frm.phone.focus();
			flag = false;
		}else if(idarr2.indexOf(id)>=0){
				msg="아이디가 이미 존재합니다"
			flag = false;
		}
		alert(msg);
		if(flag==true)
			frm.submit();
	}
</script>


</div>




<%@include file="../Include/footer.jsp" %>
<!-- 아이디 체크를 위한 Ajax -->
<script type="text/javascript">
var idPass;
var idRegex = /^[a-zA-Z0-9]{8,12}$/;
var idc = document.getElementById("idc");

$(document).ready(function(){
	//아이디 중복체크
	$('input[name=id]').blur(function(){
		var idCheck=$('input[name=id]').val();
		if(idRegex.test(idCheck)){
			$.ajax({
				url:'idCheck?id='+idCheck,
				type:'get',
				success:function(data){
					if(data>0){
						idc.style.color="red";
						idc.innerHTML="사용 불가능한 아이디입니다.";
						tr_light("tr_id");
					
					}else{
						idc.style.color="#40c700";
						idc.innerHTML="사용 가능 합니다.";
					}
				}
			})	
		}else{
			idc.style.color="red";
			idc.innerHTML="영문과 숫자 8~12자로 해주세요.";
		}
	}); 
})
</script>
<script>
function execPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			var addr = '';
			var extraAddr = '';
			if (data.userSelectedType === 'R') {
				addr = data.roadAddress;
			} else {
				addr = data.jibunAddress;
			}
			if(data.userSelectedType === 'R'){
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				if(data.buildingName !== '' && data.apartment === 'Y'){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				if(extraAddr !== ''){
					extraAddr = ' (' + extraAddr + ')';
				}
					document.getElementById("zip4").value = extraAddr;
			} else {
				document.getElementById("zip4").value = '';
			}
			document.getElementById('zip1').value = data.zonecode;
			document.getElementById("zip2").value = addr;
			document.getElementById("zip3").focus();
		}
	}).open();
}
function tr_light(tr_id) {
	var id = document.getElementById(tr_id);
	id.style.border="1px solid red";
	
	
	
}


</script>

</body>
</html>