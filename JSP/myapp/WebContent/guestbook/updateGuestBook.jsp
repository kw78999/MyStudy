<%@page import="guestbook.JoinBean"%>
<%@page import="guestbook.GuestbookBean"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<jsp:useBean id="login" scope="session" class="guestbook.JoinBean" />
<%
		request.setCharacterEncoding("EUC-KR");
		int num=0;
		GuestbookBean bean = null;
		if(request.getParameter("num")!=null){
			num = Integer.parseInt(request.getParameter("num"));
			bean=mgr.getGuestBook(num);
		}
%>
<html>
<head>
<title>GuestBook</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div align="center">
		<table width="500" cellspacing="0" cellpadding="3">
			<tr>
				<td bgcolor="#F5F5F5"><font size="4"><b>�ۼ����ϱ�</b></font></td>
			</tr>
		</table>
		<form method="post" action="updateGuestBookProc.jsp?num=<%=num%>">
			<table width="500" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table>
							<tr>
								<td height="40" align="center">
									<img src="img/face.bmp" border="0" alt="����"> 
									<input name="name" size="9" value="<%=login.getName()%>" readonly> 
									<img src="img/email.bmp" border="0" alt="����"> 
									<input name="email" size="20" value="<%=login.getEmail()%>"> 
									<img src="img/hp.bmp" border="0" alt="Ȩ������"> 
									<input title="Ȩ�������� ������ �˷��ֽþ��" name="hp" size="20" value="<%=login.getHp()%>">
								</td>
							</tr>
							<tr>
								<td align="center">
									<textarea name="contents" cols="60" 
									rows="6"><%=bean.getContents()%></textarea>
								</td>
							</tr>
							<tr>
								<td width="500" height="30" colspan="3" align="center">
								<input type="hidden" name="id" value="<%=bean.getId()%>">
								<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
								<input type="submit" value="�ۼ���"> 
								<input type="reset" value="��ġ��"> 
								<input type="checkbox" name="secret" value="1" 
								<%if(bean.getSecret().equals("1")) out.print("checked");%>>��б�
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>