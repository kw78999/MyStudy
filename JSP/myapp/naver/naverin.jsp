<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.naver{
cursor:pointer;
border:0;
outline:0;
width:90px;height:30px;
background: url("naver2.png");
background-size:90px 30px;
margin-left: 200px;
margin-top:30px;
}
.in{
cursor:pointer;
border:0;
outline:0;
width:70px;height:30px;
background: url("naver.png");
background-size:70px 30px;
}
.text{
width:200px;
height:25px;
border-color: #00d205;
 position: absolute;
    top: 10px;
    left: 380px;
}
.text:focus{
border-color:#00d205;
}
.search{
cursor:pointer;
border:0;
outline:0;
width:40px;
height:27px;
 position: absolute;
    top: 42px;
    left: 540px;
background: url("search.png");
background-size:40px 27px;
}
</style>
</head>
<body>
<form>
<input type="button" class="naver" onclick="location.href='naver.com' ">
<input type="button" class="in" onclick="location.href='naverin.jsp' ">
<input type="text" class="text" style="margin-top: 30px">
<input type="button" class="search">
<table>
<tr>

</tr>
</table>
</form>
<hr style="margin-top: 20px">

</body>
</html>