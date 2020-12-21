<%@page import="java.util.Vector"%>
<%@page import="board2.BCommentMgr"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="board2.UtilMgr"%>
<%@page import="board2.BoardBean"%>
<%@page import="board2.BCommentBean"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="board2.BoardMgr" />
<jsp:useBean id="cmgr" class="board2.BCommentMgr" />
<%
		request.setCharacterEncoding("EUC-KR");
		String nowPage = request.getParameter("nowPage");	
		String numPerPage = request.getParameter("numPerPage");	
		String keyField = request.getParameter("keyField");	
		String keyWord = request.getParameter("keyWord");	
		int num = UtilMgr.parseInt(request, "num");
		
		String flag = request.getParameter("flag");
		if(flag!=null){
			if(flag.equals("insert")){
				//댓글을 쓰는경우는 조회수 증가 x
				BCommentBean cbean = new BCommentBean();
				cbean.setNum(num);//어떤게시물
				cbean.setName(request.getParameter("cName"));
				cbean.setComment(request.getParameter("comment"));
				cmgr.insertBComment(cbean);
			}else if(flag.equals("del")){
				//댓글삭제
				cmgr.deleteBComment(UtilMgr.parseInt(request, "cnum"));
			}
			
		}else{
			//list.jsp 에서 넘어오는 경우는 조회수 증가
			//조회수 증가
			mgr.upCount(num);
		}
		
		//게시물 읽기
		BoardBean bean = mgr.getBoard(num);
		String name = bean.getName();
		String subject = bean.getSubject();
		String regdate = bean.getRegdate();
		String content = bean.getContent();
		String filename = bean.getFilename();
		int filesize = bean.getFilesize();
		String ip = bean.getIp();
		int count = bean.getCount();
		
		//읽어온 게시물을 수정 및 삭제를 위해 세션에 저장
		session.setAttribute("bean", bean);
%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Board</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function down(filename) {
		document.downFrm.filename.value=filename;
		document.downFrm.submit();
	}
	function list() {
		document.listFrm.action = "list.jsp";
		document.listFrm.submit();
	}
	function cInsert() {
		if(document.cFrm.comment.value==""){
			alert("댓글을 입력하세요.");
			document.cFrm.comment.focus();
			return;
		}
		document.cFrm.submit();
	}
	function cDel(cnum) {
		document.cFrm.cnum.value=cnum;
		document.cFrm.flag.value="del";
		document.cFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
<br/><br/>
<table align="center" width="600" cellspacing="3">
 <tr>
  <td bgcolor="#9CA2EE" height="25" align="center">글읽기</td>
 </tr>
 <tr>
  <td colspan="2">
   <table cellpadding="3" cellspacing="0" width="100%"> 
    <tr> 
  <td align="center" bgcolor="#DDDDDD" width="10%"> 이 름 </td>
  <td bgcolor="#FFFFE8"><%=name%></td>
  <td align="center" bgcolor="#DDDDDD" width="10%"> 등록날짜 </td>
  <td bgcolor="#FFFFE8"><%=regdate%></td>
 </tr>
 <tr> 
    <td align="center" bgcolor="#DDDDDD"> 제 목</td>
    <td bgcolor="#FFFFE8" colspan="3"><%=subject%></td>
   </tr>
   <tr> 
     <td align="center" bgcolor="#DDDDDD">첨부파일</td>
     <td bgcolor="#FFFFE8" colspan="3">
    	<%if(filename!=null&&!filename.equals("")){ %>
    	<a href="javascript:down('<%=filename %>')"><%=filename %></a>
    	<font color="blue">(<%=UtilMgr.intFormat(filesize) %>bytes)</font>
    	<%}else{out.println("첨부된 파일이 없습니다.");} %>
     </td>
   </tr>
   <tr> 
    <td colspan="4"><br/><pre><%=content%></pre><br/></td>
   </tr>
   <tr>
    <td colspan="4" align="right">
     <%=ip%>로 부터 글을 남기셨습니다./  조회수  <%=count%>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align="center" colspan="2">
  <!-- 댓글 입력폼 Start -->
    <form method="post" name="cFrm">
		<table>
			<tr  align="center">
				<td width="50">이 름</td>
				<td align="left">
					<input name="cName" size="10" value="aaa">
				</td>
			</tr>
			<tr align="center">
				<td>내 용</td>
				<td>
				<input name="comment" size="50"> 
				<input type="button" value="등록" onclick="cInsert()"></td>
			</tr>
		</table>
	 <input type="hidden" name="flag" value="insert">	
	 <input type="hidden" name="num" value="<%=num%>">
	 <input type="hidden" name="cnum">
    <input type="hidden" name="nowPage" value="<%=nowPage%>">
    <input type="hidden" name="numPerPage" value="<%=numPerPage%>">
   <%if(!(keyWord==null||keyWord.equals(""))){ %>
    <input type="hidden" name="keyField" value="<%=keyField%>">
    <input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
	</form>
  <!-- 댓글 입력폼 End -->
 <hr/>
 <!-- 댓글 List Start -->
<%
		Vector<BCommentBean> cvlist = cmgr.getBComment(num);
		if(!cvlist.isEmpty()){
			out.println(cvlist.size()	);
%>
<table>

<%
			for(int i =0;i<cvlist.size();i++){
				BCommentBean cbean = cvlist.get(i);
				int cnum=cbean.getCnum();
				String cname = cbean.getName();
				String comment = cbean.getComment();
				String cregdate = cbean.getRegdate();
				
			%>
			<tr>
			<td colspan="3" width="600"><b><%=cname%></b></td>
		</tr>
		<tr>
			<td>댓글:<%=comment%></td>
			<td align="right"><%=cregdate%></td>
			<td align="center" valign="middle">
			<input type="button" value="삭제" onclick="cDel('<%=cnum%>')">
			</td>
		</tr>
		<tr>
			<td colspan="3"><br></td>
		</tr>
			<%}//--for%>
</table>
<hr>
<%}//--if %>
 <!-- 댓글 List End -->
 
 [ <a href="javascript:list()" >리스트</a> | 
 <a href="update.jsp?nowPage=<%=nowPage%>&num=<%=num%>&numPerPage=<%=numPerPage%>" >수 정</a> |
 <a href="reply.jsp?nowPage=<%=nowPage%>&numPerPage=<%=numPerPage%>" >답 변</a> |
 <a href="delete.jsp?nowPage=<%=nowPage%>&num=<%=num%>">삭 제</a> ]<br/>
  </td>
 </tr>
</table>
<form method="post" name="downFrm" action="download.jsp">
	<input type="hidden" name="filename">
</form>

<form name="listFrm">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<%if(!(keyWord==null||keyWord.equals(""))){%>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
</form>
</body>
</html>
