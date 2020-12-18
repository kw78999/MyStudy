<%@page import="guestbook.CommentBean"%>
<%@page import="guestbook.GuestbookBean"%>
<%@page import="java.util.Vector"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<%request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("idKey");
		if(id==null){
		 StringBuffer url = request.getRequestURL();//현재 접속된 url값 
		 response.sendRedirect("login.jsp?url="+url);
		 return;//이후에 jsp 코드 실행 안됨 
		}
%>
<html>
<title>GuestBook</title>
<script type="text/javascript">
	function updateFn(num) {
		url = "updateGuestBook.jsp?num="+num;
		window.open(url,"GuestBook Update","width=520,height=300");
	}
	function commentFn(frm) { //this.form
		if(frm.comment.value==""){
			alert("내용을 입력하세요.");
			frm.comment.focus();
			return;
		}
		frm.submit();
	}
	function disFn(num) {
	var v = "cmt"+num;
	//alert(v);
	var e = document.getElementById(v)	;
	if(e.style.display=='none'){
		e.style.display = 'block'; //보이게 하기 
	}else{
		e.style.display = 'none';
	}
}
</script>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#996600">
<div align="center">
<%@include file="postGuestBook.jsp" %>
<table width="520" cellspacing="0" cellpadding="3">
	<tr bgcolor="#f5f5f5">
		<td><b><%=login.getName() %></b>  </td>
		<td align="right"><a href="logout.jsp">로그아웃</a>  </td>
	</tr>
</table>
<!-- GuestBook List Start -->
<%
		Vector<GuestbookBean> vlist = mgr.listGuestBook(id,login.getGrade());
		//out.print(vlist.size());
		if(vlist.isEmpty()){
			%>
			<table width="520" cellspacing="0" cellpadding="7">
			<tr>
				<td>등록된 글이 없습니다.</td>
			</tr>
		</table>
<% 
		}else{
			for(int i =0;i<vlist.size();i++){   //방명록 글 가져오기
				GuestbookBean bean = vlist.get(i);
			//방명록 글쓴이 가져오기
			JoinBean writer = mgr.getJoin(bean.getId());
%>
			<table  width="520" border="1" bordercolor="#000000" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table bgcolor="#F5F5F5">
				<tr>
					<td width="225">NO : <%=vlist.size()-i%></td>					
					<td width="225">
						<img src="img/face.bmp" border="0" alt="이름">
						<%=writer.getName() %>
					</td>					
					<td width="150" align="center">
						<%if(writer.getHp()==null||writer.getHp().equals("")){%>
							홈페이지가 없네요.
						<%}else{%>
						
							
						
						<%}%>
					</td>					
				</tr>
				<tr>
					<td colspan="3"><%=bean.getContents() %></td>					
				</tr>
				<tr>
					<td>IP : <%=bean.getIp()%></td>					
					<td><%=bean.getRegdate()+" "+bean.getRegtime()%></td>					
					<td>
					<%
						//수정,삭제 로그인 id와 글쓴이id가 동일할 경우 활성화 
						//삭제는 관리자만 
						//비밀글은 본인과 관리자 
						boolean chk=login.getId().equals(writer.getId());
						if(chk||login.getGrade().equals("1")){
							if(chk){
								%>
									<a href="javascript:updateFn('<%=bean.getNum()%>')">[수정]</a>
								<%}  //if2%>
								 <a href="deleteGuestBook.jsp?num=<%=bean.getNum()%>">[삭제]</a>
								<%if(bean.getSecret().equals("1")){%>
								비밀글
								<%
								}}// if1
					%>
					</td>						
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Comment List Start -->
<div id="cmt<%=bean.getNum()%>" style="display:none">
<%
		Vector<CommentBean> cvlist = mgr.listComment(bean.getNum());
		//out.print(cvlist.size());
		if(!cvlist.isEmpty()){
%>
		<table width="500" bgcolor="#F5F5F5">
<%
		for(int j =0;j<cvlist.size();j++){
				CommentBean cbean = cvlist.get(j);
%>
			<tr>
				<td>
					<table width="500">
						<tr>
							<td><b><%=cbean.getCid()%></b>	</td>
							<td align="right">
							<!-- 삭제는 로그인 아이디와 입력 id가 동일한 경우에만 삭제가능 -->
							<%if(login.getId().equals(cbean.getCid())){ %>
							<a href="commentProc.jsp?flag=delete&cnum=<%=cbean.getCnum()%>">[삭제]</a>
							<%} %>
							</td>
						</tr>
						<tr>
							<td colspan="2"><%=cbean.getComment() %></td>
						</tr>
						<tr>
							<td><%=cbean.getCip()%></td>
							<td align="right"><%=cbean.getCregdate()%></td>
						</tr>
					</table>
				<hr>	
				</td>
			</tr>
<%				
		   }
%>
		</table>
<%
	     }
%>
</div>


<!-- Comment List End -->
<table width="500">
	<tr><td>
		<button onclick="disFn('<%=bean.getNum()%>')">댓글<%=cvlist.size()>0?cvlist.size():"" %></button>
	</td></tr>
</table>
<!-- Comment Form Start -->
<form name="cFrm" method="post" action="commentProc.jsp">
<table>
	<tr>
		<td>
			<textarea placeholder="댓글입력..." name="comment" rows="2" 
			cols="65" maxlength="1000"></textarea>
		</td>
		<td>
			<input type="button" value="댓글" onclick="commentFn(this.form)">
			<input type="hidden" name="flag" value="insert">
			<!-- 방명록 글번호 -->
			<input type="hidden" name="num" value="<%=bean.getNum()%>">
			<!-- 로그인 id -->
			<input type="hidden" name="cid" value="<%=login.getId()%>">
			<!-- 댓글 입력 ip 주소 -->
			<input type="hidden" name="cip" value="<%=request.getRemoteAddr()%>">
		</td>
	</tr>
</table>	
</form>


<!-- Comment Form End -->
		<%
		} //  for
	}   //else
	%>



<!-- GuestBook List End -->
</div>
</body>
</html>