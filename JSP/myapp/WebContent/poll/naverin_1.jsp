<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>네이버 지식iN</title>
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
.menubar{
margin-left: 160px;
margin-top:0px;
border-spacing:40px 0px;
}
.td{
color:#666666;
margin-left: 50px;
padding-bottom: 15px;
padding-top:15px;
border-bottom:3px solid white;
}
.td:hover{
border-bottom:3px solid #00d205;
cursor:pointer;
color: #00d205;
}
hr{
background-color: #dddddd;
height:1px;
border:0px;
}
#write{
cursor:pointer;
border:0;
outline:0;
width:30px;
height:30px;
position: absolute;
    top: 105px;
    left: 1370px;
background: url("write.png");
background-size:30px 30px;
}
ul {
    list-style:none;
    margin-top:30px;
    margin-left:370px;
}
li {
	font-size:14px;
    margin-right:30px;
    float: left;
}
li:hover{
text-decoration: underline;
color:#40c700;
cursor: pointer;
}
#naver1{
cursor:pointer;
border:0;
outline:0;
width:60px;height:20px;
background: url("naver2.png");
background-size:60px 20px;
padding-top: 20px;
}
.test{
border:0;
outline:0;
background:url('main.png');
width:100%;
height:700px;
background-size:100% 700px;
}
</style>
</head>
<body>
<!--메인 배너-->
<form>
<div>
<input type="button" class="naver" onclick="location.href='naver.com' ">
<input type="button" class="in" onclick="location.href='naverin.jsp' ">
<input type="text" class="text" style="margin-top: 30px">
<input type="submit" class="search" value="">
<hr style="margin-top: 20px;margin-bottom:0px;">
</div>
</form>
<!--메뉴바 -->
<div>
<table class="menubar">
	<tr>
		<td class="td" align="center" width="20px">홈</td>
		<td class="td" align="center" width="40px">Q&A</td>
		<td class="td" align="center" width="70px">답변하기</td>
		<td class="td" align="center" width="50px">베스트</td>
		<td class="td" align="center" width="90px">명예의 전당</td>
		<td style="border-left: 1px solid #cccccc;"></td>
		<td class="td" align="center" width="50px">프로필</td>
		<td width="500px"></td>
		<td align="right" width="100px" style="padding-right:25px;
		background-color:#40c700;color:white;cursor:pointer;">
		질문하기</td>
	</tr>
</table>
<button id="write"></button>
</div>
<hr style="margin-top:0px">
</body>
<button class="test"></button>
<footer>
<hr>
	<ul>
		<li>네이버 이용약관   |</li>
		<li>지식iN 서비스 운영정책</li>
		<li><strong>개인정보 처리방침</strong></li>
		<li>게시중단요청서비스</li>
		<li>지식iN 고객센터</li>
	</ul><br><br>
	<div align="center" style="font-size:12px;">
	<button id="naver1"></button>
	Copyright  <strong>NAVER Corp.</strong> All Rights Reserved.</div>
	<br><br>
</footer>
</html>