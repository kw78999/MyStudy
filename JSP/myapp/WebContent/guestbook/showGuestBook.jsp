<%@page import="guestbook.CommentBean"%>
<%@page import="guestbook.GuestbookBean"%>
<%@page import="java.util.Vector"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<%request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("idKey");
		if(id==null){
		 StringBuffer url = request.getRequestURL();//���� ���ӵ� url�� 
		 response.sendRedirect("login.jsp?url="+url);
		 return;//���Ŀ� jsp �ڵ� ���� �ȵ� 
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
			alert("������ �Է��ϼ���.");
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
		e.style.display = 'block'; //���̰� �ϱ� 
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
		<td align="right"><a href="logout.jsp">�α׾ƿ�</a>  </td>
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
				<td>��ϵ� ���� �����ϴ�.</td>
			</tr>
		</table>
<% 
		}else{
			for(int i =0;i<vlist.size();i++){   //���� �� ��������
				GuestbookBean bean = vlist.get(i);
			//���� �۾��� ��������
			JoinBean writer = mgr.getJoin(bean.getId());
%>
			<table  width="520" border="1" bordercolor="#000000" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table bgcolor="#F5F5F5">
				<tr>
					<td width="225">NO : <%=vlist.size()-i%></td>					
					<td width="225">
						<img src="img/face.bmp" border="0" alt="�̸�">
						<%=writer.getName() %>
					</td>					
					<td width="150" align="center">
						<%if(writer.getHp()==null||writer.getHp().equals("")){%>
							Ȩ�������� ���׿�.
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
						//����,���� �α��� id�� �۾���id�� ������ ��� Ȱ��ȭ 
						//������ �����ڸ� 
						//��б��� ���ΰ� ������ 
						boolean chk=login.getId().equals(writer.getId());
						if(chk||login.getGrade().equals("1")){
							if(chk){
								%>
									<a href="javascript:updateFn('<%=bean.getNum()%>')">[����]</a>
								<%}  //if2%>
								 <a href="deleteGuestBook.jsp?num=<%=bean.getNum()%>">[����]</a>
								<%if(bean.getSecret().equals("1")){%>
								��б�
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
							<!-- ������ �α��� ���̵�� �Է� id�� ������ ��쿡�� �������� -->
							<%if(login.getId().equals(cbean.getCid())){ %>
							<a href="commentProc.jsp?flag=delete&cnum=<%=cbean.getCnum()%>">[����]</a>
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
		<button onclick="disFn('<%=bean.getNum()%>')">���<%=cvlist.size()>0?cvlist.size():"" %></button>
	</td></tr>
</table>
<!-- Comment Form Start -->
<form name="cFrm" method="post" action="commentProc.jsp">
<table>
	<tr>
		<td>
			<textarea placeholder="����Է�..." name="comment" rows="2" 
			cols="65" maxlength="1000"></textarea>
		</td>
		<td>
			<input type="button" value="���" onclick="commentFn(this.form)">
			<input type="hidden" name="flag" value="insert">
			<!-- ���� �۹�ȣ -->
			<input type="hidden" name="num" value="<%=bean.getNum()%>">
			<!-- �α��� id -->
			<input type="hidden" name="cid" value="<%=login.getId()%>">
			<!-- ��� �Է� ip �ּ� -->
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