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
background: url("img/naver2.png");
background-size:90px 30px;
margin-left: 300px;
margin-top:30px;
}
#nlogin{
border:0;
outline:0;
width:250px;height:60px;
background: url("img/nlogin.png");
background-size:250px 60px;
    cursor: pointer;
}
#toon{
border:0;
outline:0;
width:170px;height:40px;
background: url("img/toon.png");
background-size:170px 40px;
 position: absolute;
  top: -162px;
    left: 148px;
    cursor: pointer;
}
#reserv{
border:0;
outline:0;
width:170px;height:40px;
background: url("img/reserv.png");
background-size:170px 40px;
 position: absolute;
    top: -162px;
    left: 148px;
    cursor: pointer;
}
#pay{
border:0;
outline:0;
width:170px;height:40px;
background: url("img/pay.jpg");
background-size:170px 40px;
 position: absolute;
   top: -162px;
    left: 148px;
    cursor: pointer;
}
#nain{
border:0;
outline:0;
width:160px;height:40px;
background: url("img/nain1.jpg");
background-size:160px 40px;
 position: absolute;
    top: -162px;
    left: 158px;
    cursor: pointer;
}
.in{
cursor:pointer;
border:0;
outline:0;
width:70px;height:30px;
background: url("img/naver.png");
background-size:70px 30px;
}
.text{
width:200px;
height:25px;
border-color: #00d205;
 position: absolute;
    top: 10px;
    left: 480px;
        border-style: solid;
     outline-color :#00d205  !important;
     outline-style: solid;
}
.text:focus{
border-color:#00d205;
}
.search{
cursor:pointer;
border:0;
outline:0;
width:35px;
height:27px;
 position: absolute;
    top: 42px;
    left: 650px;
background: url("img/search.png");
background-size:35px 27px;
}
#loginset{
position : relative;
}
.login{
cursor:pointer;
border:1;
outline:none;
border-color:#BBBBBB;
width:70px;
height:30px;
margin-left: 1000px;
background-color: white;
border-style: solid;
}
.menubar{
cursor:pointer;
border:0;
outline:0;
width:30px;height:30px;
background: url("img/menubar.png");
background-size:30px 30px;
 position: absolute;
    top: -5px;
    left: 1080px;
}
.submenubar{
margin-left: 260px;
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
#tdbtn{
position : relative;
}
#write{
cursor:pointer;
border:0;
outline:0;
width:30px;
height:30px;
position: absolute;
    top: 11px;
    left: 6px;
background: url("img/write.png");
background-size:30px 30px;
}
#naver1{
cursor:pointer;
border:0;
outline:0;
width:70px;height:20px;
background: url("img/naver2.png");
background-size:70px 20px;
padding-top: 20px;
}
.test{
border:0;
outline:0;
background:url('img/main.png');
width:100%;
height:700px;
background-size:100% 700px;
}
#footer{
color: #cccccc;
}
.footerText{
color:#444444;
}
.footerText:hover{
color:#40c700;
cursor: pointer;
text-decoration: underline;
}
video#bgvid {
width: 318px;
   border-radius: 30px;
    }
#body{
 background-color: #eeeeee;
 }
.relative{
position : relative;
}
#margin{
 margin-left: 300px;
 }
 #menutable{
  position: absolute;
    top: 80px;
    left: 1310px;
    background-color: white;
    border:2px solid #dddddd;
    border-collapse: collapse;
 }
 #menutable th{
 border-bottom: 2px solid #dddddd;
 padding-bottom: 5px;
 color:#40c700;
  font-size:25px;
 }
  #menutable th:hover{
  color:white;
  background-color:#40c700;
  font-size:25px;
  }
 #menutable tr{
 padding-top:10px;
 }
  #menutable td:hover{
  text-decoration: underline;
  }
 #menutable td{
 cursor:pointer;
 padding:8px 8px 8px 8px;
 border-right: 1px solid #dddddd;
 font-size: 14px;
 align:left;
 }
 #mainboard{
 border: 1px solid #aaaaaa;
 width:940px;
 height:1000px;
 float: left;
 background-color: white;
 margin-left: 20px;
 }
 #profile{
 width:310px;
 height:1000px;
 border:1px solid #aaaaaa;
 float:right;
 background-color: white;
 }
 #maincontent{
 width:1300px;
 height:1100px;
 margin: 30px auto;
 }
 #sidebar{
 float:left;
 width:200px;
 border-right: 1px solid #cccccc;
 }
 #sidebar li{
 	list-style: none;
 	padding-top: 12px;
 	cursor: pointer;
 }
 #sidebar li:hover{
 color:#40c700;
}
 #board{
 float:left;
 width:73%;
 }
 #boardtable{
 width:100%;
 }
 #boardtable td{
 border-bottom:2px solid #dddddd;
 font-size: 15px;
 height:50px;
 }
 #boardtable tr:hover{
 background-color: aliceblue;
 }
 #boardbar{
 width:95%;
 height:30px;
 text-align: right;
 }
 #boardbar li{
 float: left;
 margin-left: 30px;
 font-size: 18px;
 color:#aaaaaa;
 cursor: pointer;
 }
 #boardbar li:hover{
 color:#40c700;
 }
 #new:hover{
 text-decoration: underline;
 }
 .tag{
 background-color:#aad0e8;
 margin-right: 20px;
 margin-bottom:20px;
 }
</style>
<script>
 function dismenu() {
	var e = document.getElementById("menutable");
	if(e.style.display=='none'){
		e.style.display='block';
	}else{
		e.style.display='none';
	}
}
 function boardevent(num) {
	var e = document.getElementById(num);
	e.style.color='#40c700';
	return;
}
	window.onload = function() {
		boardevent(1);
		boardevent(101);
	}
	
</script>
</head>
<!--메인 배너-->

<form>
<div id="mainbanner">
<input type="button" class="naver" onclick="location.href='naver.com' ">
<input type="button" class="in" onclick="location.href='naverin.jsp' ">
<input type="text" class="text" style="margin-top: 30px">
<input type="submit" class="search" value="">
<span id="loginset">
<button class="login">로그인</button>
<input type="button" class="menubar" onclick="dismenu()">
</span>
<hr style="margin-top: 20px;margin-bottom:0px;">
</div>
</form>

<!--메뉴바 -->
<div>
<table class="submenubar">
	<tr>
		<td class="td" align="center" width="20px">홈</td>
		<td class="td" align="center" width="40px">Q&A</td>
		<td class="td" align="center" width="70px">답변하기</td>
		<td class="td" align="center" width="50px">베스트</td>
		<td class="td" align="center" width="90px">명예의 전당</td>
		<td style="border-left: 1px solid #cccccc;"></td>
		<td class="td" align="center" width="50px">프로필</td>
		<td width="500px"></td>
		<td id="tdbtn" align="right" width="100px" style="padding-right:25px;
		background-color:#40c700;color:white;cursor:pointer;">
		<button id="write"></button>질문하기</td>
	</tr>
</table>
</div>

<body>
<div id="body">
<hr style="margin-top:0px">

<span class="relative" id="margin">
<video autoplay loop muted  id="bgvid">
        <source src="img/read.mp4" type="video/mp4">
    </video>
    <button id="nain"></button>
    </span>
    
  <span class="relative">  
<video autoplay loop muted  id="bgvid">
        <source src="img/toon.mp4" type="video/mp4">
    </video>
<button id="toon"></button>
</span>

<span class="relative">
<video autoplay loop muted  id="bgvid">
        <source src="img/reserv.mp4" type="video/mp4">
    </video>
<button id="reserv"></button>
</span>

<span class="relative">
<video autoplay loop muted  id="bgvid">
        <source src="img/food.mp4" type="video/mp4">
    </video>
<button id="pay"></button>
</span>


<!-- 메인 컨텐츠 -->
<div id="maincontent">

<!-- 메인 게시판 -->
<div id="mainboard">
<h2 align="center" style="color:#888;">답변을 기다리는 질문</h2>
<hr style="width:90%;margin-bottom: 20px;">
<!-- 사이드 메뉴바 -->
<div id="sidebar">
	<ul>
		<li onclick="boardevent(1)" id="1">전체</li>
		<li onclick="boardevent(2)" id="2">교육,학문</li>
		<li onclick="boardevent(3)" id="3">컴퓨터통신</li>
		<li onclick="boardevent(4)" id="4">게임</li>
		<li onclick="boardevent(5)" id="5">엔터테이먼트,예술</li>
		<li onclick="boardevent(6)" id="6">생활</li>
		<li onclick="boardevent(7)" id="7">건강</li>
		<li onclick="boardevent(8)" id="8">사회,정치</li>
		<li onclick="boardevent(9)" id="9">경제</li>
		<li onclick="boardevent(10)" id="10">여행</li>
		<li onclick="boardevent(11)" id="11">스포츠,레저</li>
		<li onclick="boardevent(12)" id="12">쇼핑</li>
	</ul>
	<hr style="width:80%; margin-top: 30px;margin-bottom: 30px;">
	<ul style="padding-bottom: 30px;">
		<li onclick="boardevent(13)" id="13">추천분야</li>
		<li onclick="boardevent(14)" id="14">연애,결혼</li>
		<li onclick="boardevent(15)" id="15">자동차</li>
		<li onclick="boardevent(16)" id="16">직업,취업</li>
		<li onclick="boardevent(17)" id="17">안드로이드폰</li>
		<li onclick="boardevent(18)" id="18">사람과 그룹</li>
		<li onclick="boardevent(19)" id="19">대학 입시,진학</li>
		<li onclick="boardevent(20)" id="20">자동차구입</li>
		<li onclick="boardevent(21)" id="21">모바일게임</li>
		<li onclick="boardevent(22)" id="22">영어 공부,시험</li>
		<li onclick="boardevent(23)" id="23">스마트폰</li>
	</ul>
</div>
<!-- 게시판 -->
<div id="board" style="margin-left: 30px;">
<h2 align="left">전체</h2>
<ul id="boardbar">
	<li style="margin-left: -35px; list-style:none;"><form name="npFrm" method="post">
				<select  name="numPerPage" size="1" 
				onchange="numPerFn(this.form.numPerPage.value)">
    				<option value="5">5개 보기</option>
    				<option value="10" selected>10개 보기</option>
    				<option value="15">15개 보기</option>
    				<option value="30">30개 보기</option>
   				</select>
   			</form></li>
	<li id="101" style="margin-left: 220px" onclick="boardevent(101)">답변적은순</li>
	<li id="102" onclick="boardevent(102)">첫질문</li>
	<li id="103" onclick="boardevent(103)">최신순</li>
	<li id="104" onclick="boardevent(104)">내공높은순</li>
</ul>
<hr style="margin-bottom:0px;">
<table id="boardtable">
<%
	for(int i=0;i<10;i++){
	%>
	<tr>
	<td style="font-weight:bold;font-size: 18px;">질문입니다.어떻게할까요??</a></td>
	<td width="50px" style="color:#888;">답변0</td>
	<td width="130px" style="color:#888;">엔터테이먼트,예술</td>
	<td style="text-align: right;color:#888;">방금</td>
	</tr>
	<%
	}
%>
</table>

</div><!-- board -->

</div><!-- mainboard -->

<!-- 프로필 -->
<div id="profile">

<div style="padding-top: 20px;padding-left: 30px;background-color:aliceblue;height: 169px;">
<p style="color:#888;">질문과 답변을 하고싶다면,</p>
<button id="nlogin"/><br><br><br><br>
<p id="new" style="color:#888;text-align: right;font-size: 15px;">회원가입</p>
</div>
<hr style="margin-top:0px;">

<div style="padding-top: 20px;padding-left: 20px;padding-right: 20px;">
<p style="font-weight: bold">지식iN 인기태그</p>
<p><span class="tag">#사업자등록증</span>
<span class="tag">#수입</span>
<span class="tag">#트위치</span></p>
<a class="tag">#수능</a>
<a class="tag">#청년대출</a>
<a class="tag">#유투브</a>
<a class="tag">#코로나</a>
<a class="tag">#봉사활동</a>
<a class="tag">#자기소개서</a>
</div>
</div>




</div><!-- maincontent -->
</div><!-- body -->
</body>


<!-- my menu -->
<span id="menutable" style="display:none" >
	<table>
	<tr>
	<th colspan="4" align="left" height="10px" width="280px">
	My Menu</th>
	</tr>
		<tr>
			<td>카페</td>
			<td>블로그</td>
			<td>메일</td>
			<td>쇼핑</td>
		</tr>
		<tr>
			<td>뉴스</td>
			<td>지도</td>
			<td>포스트</td>
			<td>증권</td>
		</tr>
		<tr>
			<td>웹툰</td>
			<td>영화</td>
			<td>사전</td>
			<td>부동산</td>
		</tr>
		<tr>
			<td>게임</td>
			<td>날씨</td>
			<td>책</td>
			<td>스포츠</td>
		</tr>
	</table>
</span>
<footer>
<hr style="margin-top:50px;">
	<br><span id="footer" style="margin-left: 550px;font-size: 14px;">
	<a class="footerText">네이버 이용약관</a> &nbsp;&nbsp;&nbsp;|
	&nbsp;&nbsp;&nbsp;<a class="footerText"> 지식iN 서비스</a> &nbsp;&nbsp;&nbsp;|
	&nbsp;&nbsp;&nbsp; <a class="footerText">운영정책개인정보 </a>&nbsp;&nbsp;&nbsp;| 
	&nbsp;&nbsp;&nbsp;<a class="footerText">처리방침게시중단요청서비스</a>&nbsp;&nbsp;&nbsp; |
	&nbsp;&nbsp;&nbsp;<a class="footerText"> 지식iN 고객센터</a>
	</span>
	<br><br>
	<span align="center" style="font-size:12px;display: flex;margin-left: 750px; ">
	<button id="naver1"></button>
	 &nbsp;Copyright  &nbsp; <strong>NAVER Corp.</strong>  &nbsp;All Rights Reserved.</span>
	<br><br><br>
</footer>
</html>