<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="member.MemberMgr" />
<%
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		boolean result = mgr.checkId(id);
%>
<!doctype html>
<html>
<head>
<title>ID �ߺ�üũ</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
<div align="center">
<br/><b><%=id%></b>
<%
		if(result){
			out.println("�� �̹� �����ϴ� ID�Դϴ�.<p/>");
		}else{
			out.println("�� ��� �����մϴ�.<p/>");
		}
%>
<a1 href="#" onclick="self.close()">�ݱ�</a>
</div>
</body>
</html>