<%@page import="poll.PollListBean"%>
<%@page import="java.util.Vector"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="poll.PollMgr" />
<%request.setCharacterEncoding("EUC-KR");%>
<html>
<head>
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
<div align="center">
<h2>��ǥ ���α׷�</h2>
<hr width="60%">
<jsp:include page="pollForm.jsp"/>
<b>���� ����Ʈ</b>
<table>
	<tr>
		<td>
		<table  border="1">
			<tr>
				<th width="50">��ȣ</th>
				<th width="250" align="left">����</th>
				<th width="200">������~������</th>
			</tr>
			<%
					Vector<PollListBean> vlist = mgr.getPollList();
					for(int i=0;i<vlist.size();i++){
						PollListBean plBean = vlist.get(i);
						int num = plBean.getNum();
						String question = plBean.getQuestion();
						String sdate = plBean.getSdate();
						String edate = plBean.getEdate();
			%>
			<tr>
				<td align="center"><%=vlist.size()-i%></td>
				<td><a href="pollList.jsp?num=<%=num%>"><%=question%></a></td>
				<td align="center"><%=sdate+"~"+edate%></td>
			</tr>
			<%}//---for%>
		</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="pollInsert.jsp">�����ۼ��ϱ�</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>