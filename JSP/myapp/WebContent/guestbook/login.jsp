<%@page contentType="text/html;charset=EUC_KR"%>
<jsp:useBean id="login" class="guestbook.JoinBean" scope="session"/>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("idKey");
		String url = request.getParameter("url");
%>
<title>�α���</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<body bgcolor="#996600">
<br><br>
<div align="center">
<%
		if(id!=null){
			%>
				<b><%=login.getName()%></b>�� ȯ���մϴ�.<br>
				<a href="showGuestBook.jsp" >���� </a>&nbsp;
				<a href="logout.jsp" >�α׾ƿ�</a>
			<%
		}else{
%>
<h2>GuestBook �α���</h2>
<FORM METHOD="POST" ACTION="loginProc.jsp?url=<%=url%>"><!-- get��İ� post��� ���ÿ� -->
<table border="1">
	<tr>
		<td>id</td>
		<td> <input name="id" value="aaa">
		</td>
	</tr>
	<tr>
		<td>pwd</td>
		<td><input name="pwd" value="1234"></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		<INPUT TYPE="submit" value="�α���">
		</td>
	</tr>
</table>
<input type="hidden" name="url" value="<%=url%>">
</FORM>
<%}%>
</div>
</body>