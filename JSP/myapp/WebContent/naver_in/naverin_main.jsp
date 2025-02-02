<%@page import="member.MemberBean"%>
<%@page import="in.UtilMgr"%>
<%@page import="in.QuestionBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <jsp:useBean id="mgr" class="in.QuestionMgr" />
    <jsp:useBean id="amgr" class="in.AnswerMgr" />
  <%
	request.setCharacterEncoding("EUC-KR");
	String id = (String)session.getAttribute("id");
	
  int totalRecord = 0;//총게시물수
	int numPerPage = 10;//페이지당 레코드 개수(5,10,15,30)
	int pagePerBlock = 10;//블럭당 페이지 개수
	int totalPage = 0;//총 페이지 개수 
	int totalBlock =0;//총 블럭 개수
	int nowPage = 1;//현재 페이지 
	int nowBlock = 1;//현재 블럭
	
	
	String dir="전체";
	if(request.getParameter("dir")!=null){
		dir = request.getParameter("dir");
	}
	
	int where=9;
	if(request.getParameter("where")!=null){
		where = Integer.parseInt(request.getParameter("where"));
	}
	
	
	totalRecord = mgr.getTotalCount(dir);
	
	//요청된 numPerPage 처리
	if(request.getParameter("numPerPage")!=null){
		//Integer.parseInt(request.getParameter(name));
		numPerPage = UtilMgr.parseInt(request, "numPerPage");
	}
	
	if(request.getParameter("nowPage")!=null){
		nowPage = UtilMgr.parseInt(request, "nowPage");
	}
	
//sql문에 들어가는 start,cnt선언 
		int start =  (nowPage*numPerPage)-numPerPage;
		int cnt = numPerPage;
		
		//전체페이지 개수
		totalPage = (int)Math.ceil((double)totalRecord/numPerPage);
		//전체블럭 개수
		 totalBlock = (int)Math.ceil((double)totalPage/pagePerBlock);
		//현재블럭
		nowBlock = (int)Math.ceil((double)nowPage/pagePerBlock);
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>네이버 지식iN</title>
<link href="header.css" rel="stylesheet" type="text/css">
<style>
#chartdiv {
margin-top:50px;
  width: 90%;
  height: 300px;
}

.tagA{
text-decoration: none;
color:#555;
}
.tagA:visited{
color:white;
}

.tagul{
margin-left: 0px;
}
.taglim{
float: left;
margin-left: 20px;
margin-top: 20px;
background-color: rgb(119,188,215,0.3);
}
.test{
border:0;
outline:0;
background:url('img/main.png');
width:100%;
height:700px;
background-size:100% 700px;
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

video#bgvid {
width: 318px;
   border-radius: 30px;
    }

.relative{
position : relative;
}
#margin{
 margin-left: 300px;
 }
 #nlogin{
border:0;
outline:0;
width:270px;height:60px;
background: url("img/nlogin.png");
background-size:270px 60px;
    cursor: pointer;
    margin-left: -10px;
}
#body{
 background-color: #eeeeee;
 padding-bottom: 30px;
 height: 100%;
 }
 #mainboard{
 border: 1px solid #aaaaaa;
 width:970px;
 height:1200px;
 float: left;
 background-color: white;
 margin-left: 0px;
 }
 #maincontent{
 width:1300px;
 margin: 50px auto;
 padding-bottom:1150px;
 }
 #profile{
 width:310px;
 height:1200px;
 border:1px solid #aaaaaa;
 float:right;
 background-color: white;
 }
 #board{
 float:left;
 width:73%;
 height: 100%;
 margin-bottom: 100px;
 }
  #boardtable{
 margin-bottom: 50px;
 width: 720px;
  border-spacing: 0px;
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



 #boardtable td{
 font-size: 15px;
 height:50px;
 border-bottom:2px solid #dddddd;
 }
 #boardtable tr:hover{
 background-color: aliceblue;
 cursor: pointer;
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
 background-color:rgb(119,188,215,0.3);
 margin-right: 20px;
 margin-bottom:20px;
 }
 #total{
 color:#40c700;
 font-size: 20px;
 font-weight: 900;
 }
 #total_date{
 font-size: 12px;
 color:#888;
 }
 #page{
 width: 70px;
 height: 50px;
 padding:7px;
 border: 1px solid white;
 text-decoration: none;
 color:#888;
 }
#page:hover{
border: 1px solid #ccc;
color:blue;
cursor: pointer;
}
#id{
font-weight: bold;
}

</style>
<script type="text/javascript">
function titleSub(con) {
	if(con.length>17){
		return con.substring(0,17)+"...";
	}else{
		return con;
	}
}
function sysdate() {
	 let today = new Date(); 
	 let year = today.getFullYear(); // 현재년도
	 let month = today.getMonth() + 1;  // 현재월
	 let date = today.getDate();  // 현재날짜
	 var nymd = year+"."+month+"."+date;  //현재 년월일
	 return nymd;
}
 function Cal(boardDate) {
	 let today = new Date();   
	 let year = today.getFullYear(); // 현재년도
	 let month = today.getMonth() + 1;  // 현재월
	 let date = today.getDate();  // 현재날짜
	 let hours = today.getHours(); // 현재시
	 let minutes = today.getMinutes();  // 현재분
	 let seconds = today.getSeconds();  // 현재초
	 
	 let y = boardDate.substring(0,4); //게시글 년도
	 let mon ="";                     //게시글 월
	 let d ="";                     //게시글 일
	 
	 if(boardDate.substring(5,6)==0){     //한자리 수라면 0 제거
		 mon = boardDate.substring(6,7);
	 }else{
		 mon = boardDate.substring(5,7);
	 }
	 
	 if(boardDate.substring(8,9)==0){     //한자리 수라면 0 제거
		 d = boardDate.substring(9,10);
	 }else{
		 d = boardDate.substring(8,10);
	 }

	 let h = boardDate.substring(10,13);//게시물 시
	 let m = boardDate.substring(14,16);//게시물 분
	 let s = boardDate.substring(17,19);//게시물 초
	 
	 if(s.substring(0,1)==0)  //한자리수라면 앞의 0자르기
		 s=s.substring(1,2);
	 
	 var nymd = year+"-"+month+"-"+date;  //현재 년월일
	 var bymd = y+"-"+mon+"-"+d;  //게시글 년월일
	 
	 if(nymd!=bymd){
	    return bymd;
	 }else if(hours-h>=2){
		return hours-h+"시간전";
	 }else if(hours-h==1){
		 return m-minutes<=0?"1시간전":minutes+60-m+"분전";
	 }else if(hours==h){
		 return minutes==m?seconds-s+"초전":minutes-m+"분전";
	 }
}
	 function boardevent(dir) {
		document.readFrm.dir.value = dir;
		document.readFrm.nowPage.value= 1;
		document.readFrm.submit();
	}
	 function boardlist(where) {
			document.readFrm.where.value = where;
			document.readFrm.submit();
		}
	function numPerFn(numPerPage) {
		document.readFrm.numPerPage.value=numPerPage;
		document.readFrm.submit();
	}
	function pageing(page) {
		document.readFrm.nowPage.value=page;
		document.readFrm.submit();
	}
	function block(block) {
		document.readFrm.nowPage.value=<%=pagePerBlock%>*(block-1)+1;
		document.readFrm.submit();
	}
	
	function boardRead(qnum) {
		document.readFrm.qnum.value = qnum;
		document.readFrm.action = "boardRead.jsp";
		document.readFrm.submit();
	}
</script>
</head>
 
    
<body>
<%@ include file="header.jsp" %> 
<div id="body">
<hr style="margin-top:0px;margin-bottom: 20px;">
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
<h2 align="center" style="color:#888;" onclick="Cal(12)" >답변을 기다리는 질문</h2>
<hr style="width:90%;margin-bottom: 20px;">
<!-- 사이드 메뉴바 -->
<div id="sidebar">
<form method="post" name="diFrm">
	<ul>
		<li onclick="boardevent('전체')" id="전체">전체</li>
		<li onclick="boardevent('교육,학문')" id="교육,학문">교육,학문</li>
		<li onclick="boardevent('컴퓨터통신')" id="컴퓨터통신">컴퓨터통신</li>
		<li onclick="boardevent('게임')" id="게임">게임</li>
		<li onclick="boardevent('엔터테이먼트,예술')" id="엔터테이먼트,예술">엔터테이먼트,예술</li>
		<li onclick="boardevent('생활')" id="생활">생활</li>
		<li onclick="boardevent('건강')" id="건강">건강</li>
		<li onclick="boardevent('사회,정치')" id="사회,정치">사회,정치</li>
		<li onclick="boardevent('경제')" id="경제">경제</li>
		<li onclick="boardevent('여행')" id="여행">여행</li>
		<li onclick="boardevent('스포츠,레저')" id="스포츠,레저">스포츠,레저</li>
		<li onclick="boardevent('쇼핑')" id="쇼핑">쇼핑</li>
	</ul>
	<hr style="width:80%; margin-top: 30px;margin-bottom: 30px;">
	<ul style="padding-bottom: 30px;">
		<label style="font-weight: bold;">추천분야</label>
		<li onclick="boardevent('연애,결혼')" id="연애,결혼">연애,결혼</li>
		<li onclick="boardevent('자동차')" id="자동차">자동차</li>
		<li onclick="boardevent('직업,취업')" id="직업,취업">직업,취업</li>
		<li onclick="boardevent('안드로이드폰')" id="안드로이드폰">안드로이드폰</li>
		<li onclick="boardevent('사람과 그룹')" id="사람과 그룹">사람과 그룹</li>
		<li onclick="boardevent('대학 입시,진학')" id="대학 입시,진학">대학 입시,진학</li>
		<li onclick="boardevent('자동차구입')" id="자동차구입">자동차구입</li>
		<li onclick="boardevent('모바일게임')" id="모바일게임">모바일게임</li>
		<li onclick="boardevent('영어 공부,시험')" id="영어 공부,시험">영어 공부,시험</li>
		<li onclick="boardevent('스마트폰')" id="스마트폰">스마트폰</li>
	</ul>
	</form>
	<script>
	var e = document.getElementById('<%=dir%>');
			e.style.color='#40c700';
			e.style.fontWeight='bold';
	</script>
</div>
<!-- 게시판 -->
<div id="board" style="margin-left: 30px;">
<h2><%=dir%></h2>
<ul id="boardbar">
	<li style="margin-left: -35px; list-style:none;">
	        <form name="npFrm" method="post">
				<select  name="numPerPage" size="1" 
				onchange="numPerFn(this.form.numPerPage.value)">
    				<option value="5">5개 보기</option>
    				<option value="10" selected>10개 보기</option>
    				<option value="15">15개 보기</option>
   				</select>
   				</form>
   				<script>document.npFrm.numPerPage.value=<%=numPerPage%></script>
   			</li>
   			<form name = "whereFrm" method="post">
	<li id="9"  style="margin-left: 320px" onclick="boardlist(9)">최신순</li>
	<li id="7" onclick="boardlist(7)">답변적은순</li>
	<li id="6" onclick="boardlist(6)">내공높은순</li>
	</form>
		<script>
	var w = document.getElementById('<%=where%>');
			w.style.color='#40c700';
			w.style.fontWeight='bold';
	</script>
</ul>
<hr style="margin-bottom:0px;">
<table id="boardtable">
<%
	Vector<QuestionBean> vlist = mgr.getQuestionList(start,cnt,dir,where);
	for(int i=0;i<vlist.size();i++){
		QuestionBean bean = vlist.get(i);
	%>
	<tr id="questionBoard" onclick="boardRead('<%=bean.getQnum()%>')">
		<td style="font-weight:bold;font-size: 18px;"width="330px">
		<script>document.write(titleSub('<%=bean.getTitle() %>'));</script>
		<%if(bean.getPoint()!=0){ %>
		<span style="color:#40c700;font-weight: bold;"> [<%=bean.getPoint() %>]</span>
		<%} %> 
		<%if(bean.getFilename()!=null){ %>
		<img  src="img/down.png" style="width: 20px;height: 20px;">
		<%} %>
		</td>
		<td width="50px" style="color:#888;">답변<%=bean.getAnswer_count() %></td>
		<td width="110px" style="color:#888;"><%=bean.getDirectory() %></td>
		<td width="80px" style="text-align: right;color:#888;" id="test">
		<script>
			document.write(Cal('<%=bean.getDate()%>'));  //날짜계산함수
		</script>
		
		</td>
	</tr>
	
	<%
	}
%>


</table>
<table style="margin: 20px auto;">
<tr>
<td>
<!-- 페이징 및 블럭 Start -->
		<!-- 이전블럭 -->
		<%if(nowBlock>1){%>
		<a id="page" href="javascript:block('<%=nowBlock-1 %>')"><%="< "%>이전</a>
			<%} %>
			<!-- 페이징 -->
		<%
				int pageStart = (nowBlock-1)*pagePerBlock+1;
				int pageEnd = (pageStart+pagePerBlock/*10*/)<totalPage?
						pageStart+pagePerBlock:totalPage+1;
				for(;pageStart<pageEnd;pageStart++){
		%>
		
		<a id="page" href="javascript:pageing('<%=pageStart%>')">
			<%if(nowPage==pageStart){%><font color="blue"><%}%>
				<%=pageStart%>
			<%if(nowPage==pageStart){%></font><%}%>
		</a>
		
		<%}//--for%>
		<!-- 다음블럭 -->
			<%if(totalBlock>nowBlock){%>
			
			<a id="page" href="javascript:block('<%=nowBlock+1 %>')">다음 ></a>
			<%} %>
		<!-- 페이징 및 블럭 End -->
			</td>
</tr>
</table>
</div><!-- board -->

</div><!-- mainboard -->

<!-- 프로필 -->
<div id="profile">
<%if(id==null){ %>
<div style="padding-top: 20px;padding-left: 30px;background-color:aliceblue;height: 169px;">
<p style="color:#888;">질문과 답변을 하고싶다면,</p>
<button id="nlogin" type="button" onclick="location.href='../member/login.jsp?returnPage=../in/naverin_main.jsp' "/><br><br><br><br><br>
<a id="new" style="margin-left:190px;color:#888;text-align: right;font-size: 15px;" href="../member/member.jsp">회원가입</a>
</div>
<hr style="margin-top:0px;">
<%}else{ %>
<div style="padding-top: 20px;padding-left: 30px;background-color:aliceblue;height: 240px;">
<table id="myprof">
<tr><td>
	<img  src="img/question.png" style="width: 40px;height: 40px;border-radius: 10px;">
	<a id="id"><%=id%></a>
</td>
<form action="logout.jsp">
<td align="right" width="120px"><input type="submit" value="로그아웃"></td></tr>
</form>
<tr>
<td style="font-weight: bold;padding-top: 10px;padding-bottom: 10px;">나의 지식iN</td>
</tr>
<%MemberBean mbean = mgr.memberRead(id);%>
<tr><td colspan="2">나의 질문 :  <%=mbean.getQuestionCnt()%> 건</td></tr>
<tr><td colspan="2">나의 답변 : <%=mbean.getAnswerCnt() %> 건</td></tr>
<tr><td colspan="2">나의 내공 : <%=mbean.getInPoint() %> 점</td></tr>
<tr><td colspan="2">나의 랭킹 : <%=mbean.getGender() %> 위 </td></tr>
</table>
</div>
<hr style="margin-top:0px;">
<%} %>
<div style="padding-top: 20px;padding-left: 20px;padding-right: 20px;height: 230px;width: 300px;">
<p style="font-weight: bold">지식iN 인기태그</p>
<div style="margin-left: -60px;margin-top: -10px;">
<ul style="list-style: none;" class="ultag">
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=사업자등록증"><b>#</b>사업자등록증</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=수입"><b>#</b>수입</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=수능"><b>#</b>수능</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=트위치"><b>#</b>트위치</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=청년대출"><b>#</b>청년대출</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=유투브"><b>#</b>유투브</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=코로나"><b>#</b>코로나</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=봉사활동"><b>#</b>봉사활동</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=자기소개서"><b>#</b>자기소개서</a></li>
</ul>
</div>
</div>
<hr>
<div style="padding-left: 30px;">
<h4>오늘의 질문과 답변</h4>
<span id="total"><%=amgr.getQuestionCnt()%>/<%=amgr.getAnswerCnt()%></span><br>
<span  id="total_date"><script>document.write(sysdate())</script></span>
<h4>누적 답변수</h4>
<span id="total"><%=amgr.getAllAnswerCnt() %></span><br>
<span id="total_date">since 2002</span>
</div>
<hr style="margin-top: 20px;">
<h4 align="center" style="color:#555;">카테고리별 TOP <font color="#40c700">5</font><h4>
<div id="chartdiv"></div>
<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>
<script>
am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
var chart = am4core.create("chartdiv", am4charts.XYChart);

// Add data
chart.data = [{
  "country": "건강",
  "visits": 202
}, {
  "country": "생활",
  "visits": 188
}, {
  "country": "게임",
  "visits": 180
}, {
  "country": "교육,학문",
  "visits": 132
}, {
  "country": "연애",
  "visits": 112
}];

// Create axes

var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "country";
categoryAxis.renderer.grid.template.location = 0;
categoryAxis.renderer.minGridDistance = 30;

categoryAxis.renderer.labels.template.adapter.add("dy", function(dy, target) {
  if (target.dataItem && target.dataItem.index & 2 == 2) {
    return dy + 25;
  }
  return dy;
});

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

// Create series
var series = chart.series.push(new am4charts.ColumnSeries());
series.dataFields.valueY = "visits";
series.dataFields.categoryX = "country";
series.name = "Visits";
series.columns.template.tooltipText = "{categoryX}: [bold]{valueY}[/]";
series.columns.template.fillOpacity = .8;

var columnTemplate = series.columns.template;
columnTemplate.strokeWidth = 2;
columnTemplate.strokeOpacity = 1;
</script>


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
		<%if(id!=null){ %>
		<tr>
		<td colspan="4" align="center" style="border-top: 1px solid #888;" onclick="location.href='logout.jsp'">로그아웃</td>
		</tr>
		<%} %>
	</table>
</span>

<form name="readFrm">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<input type="hidden" name="qnum">
	<input type="hidden" name="dir" value="<%=dir%>">
	<input type="hidden" name="where" value="<%=where%>">
</form>

<%@ include file="footer.jsp" %>

</html>