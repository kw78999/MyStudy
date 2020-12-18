<!-- list.jsp -->
<%@page import="java.util.Vector"%>
<%@page import="board2.UtilMgr"%>
<%@page import="board2.BoardBean"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="board2.BoardMgr"/>
<%
		request.setCharacterEncoding("EUC-KR");
		int totalRecord = 0;//총게시물수
		int numPerPage = 10;//페이지당 레코드 개수(5,10,15,30)
		int pagePerBlock = 15;//블럭당 페이지 개수
		int totalPage = 0;//총 페이지 개수
		int totalBlock =0;//총 블럭 개수
		int nowPage = 1;//현재 페이지
		int nowBlock = 1;//현재 블럭
		
		//요청된 numPerPage 처리
		if(request.getParameter("numPerPage")!=null){
			//Integer.parseInt(request.getParameter(name));
			numPerPage = UtilMgr.parseInt(request, "numPerPage");
		}
		
		//검색에 필요한 변수
		String keyField = "", keyWord = "";
		if(request.getParameter("keyWord")!=null){
			keyField = request.getParameter("keyField");
			keyWord = request.getParameter("keyWord");
		}
		
		//검색 후에 다시 처음 리스트 요청
		if(request.getParameter("reload")!=null&&request.getParameter("reload").equals("true")){
			keyField =""; keyWord = ""; 
		}
		
		totalRecord = mgr.getTotalCount(keyField, keyWord);
		
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
	<title>JSP Board</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function check() {
		if(document.searchFrm.keyWord.value==""){
			alert("검색어를 입력하세요.");
			document.searchFrm.keyWord.focus();
			return;
		}
		document.searchFrm.submit();
	}
	
	function  list() {
		document.listFrm.action = "list.jsp";
		document.listFrm.submit();
	}
	function numPerFn(numPerPage) {
		//alert(numPerPage);
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
	function read(num) {
		document.readFrm.num.value = num;
		document.readFrm.action = "read.jsp";
		document.readFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC" >
<div align="center"><br/>
<h2>JSP Board</h2><br/>
<table>
	<tr>
		<td width="600">
		Total : <%=totalRecord%>Articles(<font color="red">
		<%=nowPage+"/"+totalPage%>Pages</font>)
		</td>
		<td align="right">
			<form name="npFrm" method="post">
				<select name="numPerPage" size="1" 
				onchange="numPerFn(this.form.numPerPage.value)">
    				<option value="5">5개 보기</option>
    				<option value="10" selected>10개 보기</option>
    				<option value="15">15개 보기</option>
    				<option value="30">30개 보기</option>
   				</select>
   			</form>
   			<script>document.npFrm.numPerPage.value=<%=numPerPage%></script>
		</td>
	</tr>
</table>
<table>
	<tr>
		<td align="center" colspan="2">
		<%
				Vector<BoardBean> vlist = mgr.getBoardList(keyField, keyWord, start, cnt);
				int listSize = vlist.size();//브라우저 화면에 표시될 게시물 번호
				if(vlist.isEmpty()){
					out.println("등록된 게시물이 없습니다.");
				}else{ 
					
		%>
			<table cellspacing="0">
				<tr align="center" bgcolor="#D0D0D0">
					<td width="100">번 호</td>
					<td width="250">제 목</td>
					<td width="100">이 름</td>
					<td width="150">날 짜</td>
					<td width="100">조회수</td>
				</tr>	
				<%
					for(int i = 0;i<numPerPage;i++){
						if(i==listSize)break;
						BoardBean bean = vlist.get(i);
						int num = bean.getNum();//게시물 번호
						String subject = bean.getSubject();//제목
						String name = bean.getName();//이름
						String regdate = bean.getRegdate();//날짜
						int depth = bean.getDepth();//답변의 깊이
						int count = bean.getCount();//조회수
						String filename = bean.getFilename();//첨부파일
						%>
						<tr align = "center">
							<td><%=totalRecord-start-i %></td>
							<td align="left">
							<%for(int j =0;j<depth;j++){out.println("&nbsp;&nbsp;");} %>
							<a href="javascript:read('<%=num%>')"><%=subject %></a>
							<%if(filename!=null&&!filename.equals("")){ %>
							<img src="img/icon_file.gif" align="middle">
							<%} %>
							</td>
							<td><%=name %></td>
							<td><%=regdate %></td>
							<td><%=count %></td>
						</tr>
						<%}//--for%>			
			</table>
		<%}//---if-else%>
		</td>
	</tr>
	<tr>
		<td colspan="2"><br><br></td>
	</tr>
	<tr>
		<td>
		<!-- 페이징 및 블럭 Start -->
		<!-- 이전블럭 -->
		<%if(nowBlock>1){%>
		<a href="javascript:block('<%=nowBlock-1 %>')">prev...</a>
			<%} %>
		<!-- 페이징 -->
		<%
				int pageStart = (nowBlock-1)*pagePerBlock+1;
				int pageEnd = (pageStart+pagePerBlock/*15*/)<totalPage?
						pageStart+pagePerBlock:totalPage+1;
				for(;pageStart<pageEnd;pageStart++){
		%>
		<a href="javascript:pageing('<%=pageStart%>')">
			<%if(nowPage==pageStart){%><font color="blue"><%}%>
				[<%=pageStart%>]
			<%if(nowPage==pageStart){%></font><%}%>
		</a>
		<%}//--for%>
		<!-- 다음블럭 -->
			<%if(totalBlock>nowBlock){%>
			<a href="javascript:block('<%=nowBlock+1 %>')">...next</a>
			<%} %>
		<!-- 페이징 및 블럭 End -->
		</td>
		<td align="right">
			<a href="post.jsp">[글쓰기]</a>
			<a href="javascript:list()">[처음으로]</a>
		</td>
	</tr>
</table>

<hr width="750">
<form  name="searchFrm">
	<table  width="600" cellpadding="4" cellspacing="0">
 		<tr>
  			<td align="center" valign="bottom">
   				<select name="keyField" size="1" >
    				<option value="name"> 이 름</option>
    				<option value="subject"> 제 목</option>
    				<option value="content"> 내 용</option>
   				</select>
   				<input size="16" name="keyWord">
   				<input type="button"  value="찾기" onClick="javascript:check()">
   				<input type="hidden" name="nowPage" value="1">
  			</td>
 		</tr>
	</table>
</form>

<form name="listFrm" method="post">
	<input type="hidden" name="reload" value="true">
	<input type="hidden" name="nowPage" val]ue="1">
</form>

<form name="readFrm">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<input type="hidden" name="num">
</form>
</div>
</body>
</html>








