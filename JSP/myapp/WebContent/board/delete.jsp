<!-- delete.jsp -->
<%@page import="board2.BoardBean"%>
<%@page import="board2.UtilMgr"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="board2.BoardMgr"/>
<jsp:useBean id="cmgr" class="board2.BCommentMgr"/>
<html>
<head>
<%
		request.setCharacterEncoding("EUC-KR");
		String nowPage = request.getParameter("nowPage");
		int num = UtilMgr.parseInt(request, "num");
		//����� �Է��� �޾Ƽ� ������ ó���ϴ� ���
		if(request.getParameter("pass")!=null){
			BoardBean bean = (BoardBean)session.getAttribute("bean");
			//delete.jsp���� ����ڰ� �Է��� ���
			String inPass = request.getParameter("pass");
			//db�� ����� ���
			String dbPass = bean.getPass();
			if(inPass.equals(dbPass)){//==�� ��ü�� �ּҰ� ��.
				mgr.deleteBoard(num, bean.getFilename());
				//�� �Խù��� �����Ǹ� ������ ��� ��� ����
				cmgr.deleteAllBComment(num);
				String url = "list.jsp?nowPage="+nowPage;
				response.sendRedirect(url);
			}else{%>
			<script type="text/javascript">
				alert("�Է��Ͻ� ��й�ȣ�� �ƴմϴ�.");
				history.back();
			</script>
			<%}
		}else{//����� �Է� �ޱ� ���� ��(form) ���
%>
<title>JSP Board</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function check() {
		if (document.delFrm.pass.value == "") {
			alert("�н����带 �Է��ϼ���.");
			document.delFrm.pass.focus();
			return;
		}
		document.delFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
<div align="center"><br/><br/>
	<table width="50%" cellspacing="0" cellpadding="3">
		<tr>
			<td bgcolor=#dddddd height="21" align="center">
				������� ��й�ȣ�� �Է����ּ���.
			</td>
		</tr>
	</table>
	<form name="delFrm" method="post">
		<table width="70%" cellspacing="0" cellpadding="2">
			<tr>
				<td align="center">
					<table width=80%>
						<tr>
							<td align="center">
								<input type="password" name="pass" size="17" maxlength="15">
							</td>
						</tr>
						<tr>
							<td><hr size="1" color="#eeeeee"/></td>
						</tr>
						<tr>
							<td align="center">
								<input type="button" value="�����Ϸ�" onClick="check()"> 
								<input type="reset" value="�ٽþ���">
								<input type="button" value="�ڷ�" onClick="history.go(-1)">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="hidden" name="nowPage" value="<%=nowPage%>"> 
		<input type="hidden" name="num" value="<%=num%>">
	</form>
</div>
<%}%>
</body>
</html>