<%@page import="guestbook.JoinBean"%>
<%@page pageEncoding="EUC-KR"%>
<jsp:useBean id="login" scope="session" class="guestbook.JoinBean"/>
<%
		//JoinBean login = (JoinBean)session.getAttribute("login");
%>
<html>
<head>
<title>GuestBook</title>
<script type="text/javascript">
	function checkInputs() {
		frm = document.postFrm;
		if(frm.contents.value==""){
			alert("������ �Է��� �ּ���.");
			frm.contents.focus();
			return;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<table cellspacing="0" cellpadding="3">
			<tr>
				<td bgcolor="#F5F5F5"><font size="4"><b>�ۿø���</b></font></td>
			</tr>
		</table>
		<form name="postFrm" method="post" action="postGuestBookProc.jsp">
			<table border="1" bordercolor="#000000" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table>
							<tr>
								<td height="40" align="center">
								<img src="img/face.bmp" border="0" alt="����"> 
								<input title="�̸��� �����ּ���" name="name" size="9" 
								maxlength="20" value="<%=login.getName()%>" readonly>
								<img src="img/email.bmp" border="0" alt="����">
								<input title="���ڸ��� �ּҸ� ���� ���̱���" name="email" size="20"
									maxlength="80" value="<%=login.getEmail()%>"> 
								<img src="img/hp.bmp" border="0" alt="Ȩ������"> 
								<input title="Ȩ�������� ������ �˷��ּ���." name="hp" size="20"
									maxlength="80" value="<%=login.getHp()%>">
									</td>
							</tr>
							<tr>
								<td align="center">
									<textarea title="���� �� �����ּ���"
										name="contents" cols="60" rows="6">����~~~</textarea>
								</td>
							</tr>
							<tr>
								<td width="500" height="30" colspan="3" align="center">
									<!-- table start -->
									<input type="hidden" name="id" value="<%=login.getId()%>">
									<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
									<input type="button" value="�ۿø���" onclick="javascript:checkInputs()"> 
									<input type="reset" value="��ġ��">
									<input type="checkbox" name="secret" value="1">��б�
									<!--table end  -->
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
