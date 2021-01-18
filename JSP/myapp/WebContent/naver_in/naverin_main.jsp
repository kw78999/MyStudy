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
	
  int totalRecord = 0;//�ѰԽù���
	int numPerPage = 10;//�������� ���ڵ� ����(5,10,15,30)
	int pagePerBlock = 10;//���� ������ ����
	int totalPage = 0;//�� ������ ���� 
	int totalBlock =0;//�� �� ����
	int nowPage = 1;//���� ������ 
	int nowBlock = 1;//���� ��
	
	
	String dir="��ü";
	if(request.getParameter("dir")!=null){
		dir = request.getParameter("dir");
	}
	
	int where=9;
	if(request.getParameter("where")!=null){
		where = Integer.parseInt(request.getParameter("where"));
	}
	
	
	totalRecord = mgr.getTotalCount(dir);
	
	//��û�� numPerPage ó��
	if(request.getParameter("numPerPage")!=null){
		//Integer.parseInt(request.getParameter(name));
		numPerPage = UtilMgr.parseInt(request, "numPerPage");
	}
	
	if(request.getParameter("nowPage")!=null){
		nowPage = UtilMgr.parseInt(request, "nowPage");
	}
	
//sql���� ���� start,cnt���� 
		int start =  (nowPage*numPerPage)-numPerPage;
		int cnt = numPerPage;
		
		//��ü������ ����
		totalPage = (int)Math.ceil((double)totalRecord/numPerPage);
		//��ü�� ����
		 totalBlock = (int)Math.ceil((double)totalPage/pagePerBlock);
		//�����
		nowBlock = (int)Math.ceil((double)nowPage/pagePerBlock);
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���̹� ����iN</title>
<link href="header.css" rel="stylesheet" type="text/css">
<style>

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
	 let year = today.getFullYear(); // ����⵵
	 let month = today.getMonth() + 1;  // �����
	 let date = today.getDate();  // ���糯¥
	 var nymd = year+"."+month+"."+date;  //���� �����
	 return nymd;
}
 function Cal(boardDate) {
	 let today = new Date();   
	 let year = today.getFullYear(); // ����⵵
	 let month = today.getMonth() + 1;  // �����
	 let date = today.getDate();  // ���糯¥
	 let hours = today.getHours(); // �����
	 let minutes = today.getMinutes();  // �����
	 let seconds = today.getSeconds();  // ������
	 
	 let y = boardDate.substring(0,4); //�Խñ� �⵵
	 let mon ="";                     //�Խñ� ��
	 let d ="";                     //�Խñ� ��
	 
	 if(boardDate.substring(5,6)==0){     //���ڸ� ����� 0 ����
		 mon = boardDate.substring(6,7);
	 }else{
		 mon = boardDate.substring(5,7);
	 }
	 
	 if(boardDate.substring(8,9)==0){     //���ڸ� ����� 0 ����
		 d = boardDate.substring(9,10);
	 }else{
		 d = boardDate.substring(8,10);
	 }

	 let h = boardDate.substring(10,13);//�Խù� ��
	 let m = boardDate.substring(14,16);//�Խù� ��
	 let s = boardDate.substring(17,19);//�Խù� ��
	 
	 if(s.substring(0,1)==0)  //���ڸ������ ���� 0�ڸ���
		 s=s.substring(1,2);
	 
	 var nymd = year+"-"+month+"-"+date;  //���� �����
	 var bymd = y+"-"+mon+"-"+d;  //�Խñ� �����
	 
	 if(nymd!=bymd){
	    return bymd;
	 }else if(hours-h>=2){
		return hours-h+"�ð���";
	 }else if(hours-h==1){
		 return m-minutes<=0?"1�ð���":minutes+60-m+"����";
	 }else if(hours==h){
		 return minutes==m?seconds-s+"����":minutes-m+"����";
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


<!-- ���� ������ -->
<div id="maincontent">

<!-- ���� �Խ��� -->
<div id="mainboard">
<h2 align="center" style="color:#888;" onclick="Cal(12)" >�亯�� ��ٸ��� ����</h2>
<hr style="width:90%;margin-bottom: 20px;">
<!-- ���̵� �޴��� -->
<div id="sidebar">
<form method="post" name="diFrm">
	<ul>
		<li onclick="boardevent('��ü')" id="��ü">��ü</li>
		<li onclick="boardevent('����,�й�')" id="����,�й�">����,�й�</li>
		<li onclick="boardevent('��ǻ�����')" id="��ǻ�����">��ǻ�����</li>
		<li onclick="boardevent('����')" id="����">����</li>
		<li onclick="boardevent('�������̸�Ʈ,����')" id="�������̸�Ʈ,����">�������̸�Ʈ,����</li>
		<li onclick="boardevent('��Ȱ')" id="��Ȱ">��Ȱ</li>
		<li onclick="boardevent('�ǰ�')" id="�ǰ�">�ǰ�</li>
		<li onclick="boardevent('��ȸ,��ġ')" id="��ȸ,��ġ">��ȸ,��ġ</li>
		<li onclick="boardevent('����')" id="����">����</li>
		<li onclick="boardevent('����')" id="����">����</li>
		<li onclick="boardevent('������,����')" id="������,����">������,����</li>
		<li onclick="boardevent('����')" id="����">����</li>
	</ul>
	<hr style="width:80%; margin-top: 30px;margin-bottom: 30px;">
	<ul style="padding-bottom: 30px;">
		<label style="font-weight: bold;">��õ�о�</label>
		<li onclick="boardevent('����,��ȥ')" id="����,��ȥ">����,��ȥ</li>
		<li onclick="boardevent('�ڵ���')" id="�ڵ���">�ڵ���</li>
		<li onclick="boardevent('����,���')" id="����,���">����,���</li>
		<li onclick="boardevent('�ȵ���̵���')" id="�ȵ���̵���">�ȵ���̵���</li>
		<li onclick="boardevent('����� �׷�')" id="����� �׷�">����� �׷�</li>
		<li onclick="boardevent('���� �Խ�,����')" id="���� �Խ�,����">���� �Խ�,����</li>
		<li onclick="boardevent('�ڵ�������')" id="�ڵ�������">�ڵ�������</li>
		<li onclick="boardevent('����ϰ���')" id="����ϰ���">����ϰ���</li>
		<li onclick="boardevent('���� ����,����')" id="���� ����,����">���� ����,����</li>
		<li onclick="boardevent('����Ʈ��')" id="����Ʈ��">����Ʈ��</li>
	</ul>
	</form>
	<script>
	var e = document.getElementById('<%=dir%>');
			e.style.color='#40c700';
			e.style.fontWeight='bold';
	</script>
</div>
<!-- �Խ��� -->
<div id="board" style="margin-left: 30px;">
<h2><%=dir%></h2>
<ul id="boardbar">
	<li style="margin-left: -35px; list-style:none;">
	        <form name="npFrm" method="post">
				<select  name="numPerPage" size="1" 
				onchange="numPerFn(this.form.numPerPage.value)">
    				<option value="5">5�� ����</option>
    				<option value="10" selected>10�� ����</option>
    				<option value="15">15�� ����</option>
   				</select>
   				</form>
   				<script>document.npFrm.numPerPage.value=<%=numPerPage%></script>
   			</li>
   			<form name = "whereFrm" method="post">
	<li id="9"  style="margin-left: 320px" onclick="boardlist(9)">�ֽż�</li>
	<li id="7" onclick="boardlist(7)">�亯������</li>
	<li id="6" onclick="boardlist(6)">����������</li>
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
		<td width="50px" style="color:#888;">�亯<%=bean.getAnswer_count() %></td>
		<td width="110px" style="color:#888;"><%=bean.getDirectory() %></td>
		<td width="80px" style="text-align: right;color:#888;" id="test">
		<script>
			document.write(Cal('<%=bean.getDate()%>'));  //��¥����Լ�
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
<!-- ����¡ �� �� Start -->
		<!-- ������ -->
		<%if(nowBlock>1){%>
		<a id="page" href="javascript:block('<%=nowBlock-1 %>')"><%="< "%>����</a>
			<%} %>
			<!-- ����¡ -->
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
		<!-- ������ -->
			<%if(totalBlock>nowBlock){%>
			
			<a id="page" href="javascript:block('<%=nowBlock+1 %>')">���� ></a>
			<%} %>
		<!-- ����¡ �� �� End -->
			</td>
</tr>
</table>
</div><!-- board -->

</div><!-- mainboard -->

<!-- ������ -->
<div id="profile">
<%if(id==null){ %>
<div style="padding-top: 20px;padding-left: 30px;background-color:aliceblue;height: 169px;">
<p style="color:#888;">������ �亯�� �ϰ�ʹٸ�,</p>
<button id="nlogin" type="button" onclick="location.href='../member/login.jsp?returnPage=../in/naverin_main.jsp' "/><br><br><br><br><br>
<a id="new" style="margin-left:190px;color:#888;text-align: right;font-size: 15px;" href="../member/member.jsp">ȸ������</a>
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
<td align="right" width="120px"><input type="submit" value="�α׾ƿ�"></td></tr>
</form>
<tr>
<td style="font-weight: bold;padding-top: 10px;padding-bottom: 10px;">���� ����iN</td>
</tr>
<%MemberBean mbean = mgr.memberRead(id);%>
<tr><td colspan="2">���� ���� :  <%=mbean.getQuestionCnt()%> ��</td></tr>
<tr><td colspan="2">���� �亯 : <%=mbean.getAnswerCnt() %> ��</td></tr>
<tr><td colspan="2">���� ���� : <%=mbean.getInPoint() %> ��</td></tr>
<tr><td colspan="2">���� ��ŷ : <%=mbean.getGender() %> �� </td></tr>
</table>
</div>
<hr style="margin-top:0px;">
<%} %>
<div style="padding-top: 20px;padding-left: 20px;padding-right: 20px;height: 230px;width: 300px;">
<p style="font-weight: bold">����iN �α��±�</p>
<div style="margin-left: -60px;margin-top: -10px;">
<ul style="list-style: none;" class="ultag">
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=����ڵ����"><b>#</b>����ڵ����</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=����"><b>#</b>����</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=����"><b>#</b>����</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=Ʈ��ġ"><b>#</b>Ʈ��ġ</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=û�����"><b>#</b>û�����</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=������"><b>#</b>������</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=�ڷγ�"><b>#</b>�ڷγ�</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=����Ȱ��"><b>#</b>����Ȱ��</a></li>
<li class="taglim"><a class = "tagA" href="searchList.jsp?searchKey=�ڱ�Ұ���"><b>#</b>�ڱ�Ұ���</a></li>
</ul>
</div>
</div>
<hr>
<div style="padding-left: 30px;">
<h4>������ ������ �亯</h4>
<span id="total"><%=amgr.getQuestionCnt()%>/<%=amgr.getAnswerCnt()%></span><br>
<span  id="total_date"><script>document.write(sysdate())</script></span>
<h4>���� �亯��</h4>
<span id="total"><%=amgr.getAllAnswerCnt() %></span><br>
<span id="total_date">since 2002</span>
</div>

 <canvas width='300' height='300' id='canvas'></canvas>

<script>    
 const canvas = document.getElementById('canvas');
 const ctx = canvas.getContext('2d');

 var width = canvas.clientWidth;
 var height = canvas.clientHeight;

 var value = [
     {number : 2100, text : '������'},
     {number : 1350, text : '����'},
     {number : 2180, text : '��û��'},
     {number : 1440, text : '����'},
     {number : 1160, text : '���'}
 ];
 var degree = 360;
 var radius = width * 0.7 / 2;  //������ ���� �ο�

 if(radius > height * 0.7 / 2){  //ĵ������ ���̿� ���̸� ����Ͽ� �ּ�ũ�� ����
     radius = height * 0.7 / 2;
 }

 const colorArray = ['#f5444e', '#4bbfbc', '#fcb362','#949fb0','#c4c24a','#6faab0'];  //����迭(������ 6��..)

 var sum = 0;
 value.forEach( arg=> sum+= arg.number);

 var conv_array = value.slice().map((data)=>{  //������ ����ִ� �迭
     var rate = data.number / sum;
     var myDegree = degree * rate;
     return myDegree;
 });

 degree = 0;
 var event_array = value.slice().map( arg=> []);  //�̺�Ʈ(���� ������ �ִ�)�� �迭


 var current = -1;  //���� ������ �ε���
 var zero = 0;   //��(degree)�� ���ؼ� �����ϴ� ��

 //���� �ε� �̺�Ʈ(�� 1���� ���� �����ϸ� �׸����Լ�)   -> ����ؼ� �����⸦ �ϹǷ� ����� ������� �ʴ�.(���߿� �����Ͽ�����.)
 var clr = setInterval(() => {
     for(var i=0;i < conv_array.length;i++){
         var item = conv_array[i];
         if(current == -1|| current == i){
             current = i;
             if(zero < item){ //��
                 if(i == 0){
                     arcMaker(radius, 0, zero, colorArray[i]);
                 } else {
                     arcMaker(radius, degree, degree+zero, colorArray[i]);
                 }
                 zero+=3;             
             } else {
                 current = i+1;
                 zero = 0;
                 if(i != 0){
                     arcMaker(radius, degree, degree + item, colorArray[i]);
                     event_array[i] = [degree, degree+item];
                     degree =  degree + item;     
                 } else {
                     arcMaker(radius, 0, item, colorArray[i]);
                     degree = item;
                     event_array[i] = [0, degree];
                 }
             }                               
         } else if (current == conv_array.length){
             clearInterval(clr);
             makeText(-1);
         } 
     }
 }, 1);

 //�׸��� ��� �и�(���� ������ ��� �����Ƿ� �и�)
 function arcMaker(radius, begin, end, color){
     ctx.save();
     ctx.lineJoin = 'round'; //���̸��� ���̴� �κж����� �ο�(���������� ���� ����)
     ctx.lineWidth = 4; 
     ctx.beginPath();
     ctx.moveTo(width/2, height/2);                           
     ctx.arc(width/2, height/2, radius, (Math.PI/180)*begin, (Math.PI/180)* end , false);
     ctx.closePath();
     ctx.fillStyle = color;
     ctx.strokeStyle = 'white';
     ctx.fill();
     ctx.stroke();
     ctx.restore();        
     middelMaker();  //��� �����׸��� �Լ� �߰�
 }

 //���콺 ������ �̺�Ʈ ������
 var drawed = false;
 canvas.addEventListener('mousemove', function (event) {
     var x1 = event.clientX - canvas.offsetLeft;
     var y1 = event.clientY - canvas.offsetTop;
     var inn = isInsideArc(x1, y1);
     if(inn.index > -1){  //����� ������
    	 alert("test");
         drawed = true;
         hoverCanvas(inn.index);
         makeText(inn.index);
     } else {  //����� �ƴϸ�
         if(drawed){  //����̿��ٰ� ����� ���� �ƴϸ�
             hoverCanvas(-1);
             makeText(-1);
         }
         drawed = false;
     }
 }); 

 //���� + ������ ������ Ȯ���ϴ� �Լ�
 function isInsideArc(x1, y1){
     var result1 = false;
     var result2 = false;
     var index = -1;
     var circle_len = radius;
     var x = width/2 - x1;
     var y = height/2 - y1;
     var my_len = Math.sqrt(Math.abs(x * x) + Math.abs(y * y));  //�ﰢ�Լ�
     if(circle_len >= my_len){
         result1 = true;
     }            
     var rad = Math.atan2(y, x);
     rad = (rad*180)/Math.PI;  //������ ���´�
     rad += 180;  //ĵ������ ������ ����
     if(result1){
         event_array.forEach( (arr,idx) => {   //���� ������ �ش��ϴ��� Ȯ��
             if( rad >= arr[0] && rad <= arr[1]){
                 result2 = true;
                 index = idx;
             }
         });
     }
     return {result1:result1, result2:result2 ,index:index, degree : rad};
 }

 
 //���콺 ����ȿ��
 function hoverCanvas(index){
     ctx.clearRect(0,0,width, height);
     for (var i = 0; i < conv_array.length; i++) {
         var item = conv_array[i];
         var innRadius = radius;
         if(index == i){  
             innRadius = radius * 1.1;  //����� ������ 1.1�� ũ�� Ű���.
         }
         if (i == 0) {
             arcMaker(innRadius, 0, item, colorArray[i])
             degree = item;
         } else {
             arcMaker(innRadius, degree, degree + item, colorArray[i])
             degree = degree + item;
         }
     }
 }


 //��(degree)�� ����(radian)���� �ٲٴ� �Լ�
 function degreesToRadians(degrees) {
     const pi = Math.PI;
     return degrees * (pi / 180);
 }

 //�ؽ�Ʈ�Լ�
 function makeText(index){
     event_array.forEach((itm, idx) => {
         var half = (itm[1] - itm[0]) / 2;
         var degg = itm[0] + half;
         var xx = Math.cos(degreesToRadians(degg)) * radius * 0.7 + width / 2;
         var yy = Math.sin(degreesToRadians(degg)) * radius * 0.7 + height / 2;

         var txt = value[idx].text + '';
         var minus = ctx.measureText(txt).width / 2;  //�ؽ�Ʈ ���ݱ���
         ctx.save();
         if(index == idx){
             ctx.font = "normal bold 18px sans-serif";
             ctx.fillStyle = 'blue';
         } else {
             ctx.font = "normal 14px sans-serif";
             ctx.fillStyle = 'white';
         }
         ctx.fillText(txt, xx - minus, yy);
         var txt2 = value[idx].number;
         ctx.fillText(txt2, xx - ctx.measureText(txt2).width / 3, yy + 16);
         ctx.restore();
     });
 }

 //�߾� ����(��)�� ����� �Լ�
 function middelMaker(){
     ctx.save();
     ctx.fillStyle='white';
     ctx.strokeStyle='white';
     ctx.lineJoin = 'round'; //���̸��� ���̴� �κж����� �ο�(���������� ���� ����)
     ctx.lineWidth = 1; 
     ctx.beginPath();
     ctx.moveTo(width/2, height/2);
     ctx.arc(width/2, height/2, radius/3, (Math.PI/180)*0, (Math.PI/180)* 360 , false);
     ctx.fill();
     ctx.stroke();
     ctx.closePath();
     ctx.restore();

     var total = 0;
     value.forEach( (arg)=> total+=arg.number);
     var minus = ctx.measureText(total).width; 
     ctx.save();
     ctx.font = "normal 20px sans-serif";
     ctx.fillStyle = '#656565';
     ctx.fillText("Total", width/2 - ctx.measureText("Total").width/2, height/2);
     ctx.fillText(total, width/2 - minus, height/2 * 1.1);
     ctx.restore();
 }
  
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
			<td>ī��</td>
			<td>��α�</td>
			<td>����</td>
			<td>����</td>
		</tr>
		<tr>
			<td>����</td>
			<td>����</td>
			<td>����Ʈ</td>
			<td>����</td>
		</tr>
		<tr>
			<td>����</td>
			<td>��ȭ</td>
			<td>����</td>
			<td>�ε���</td>
		</tr>
		<tr>
			<td>����</td>
			<td>����</td>
			<td>å</td>
			<td>������</td>
		</tr>
		<%if(id!=null){ %>
		<tr>
		<td colspan="4" align="center" style="border-top: 1px solid #888;" onclick="location.href='logout.jsp'">�α׾ƿ�</td>
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