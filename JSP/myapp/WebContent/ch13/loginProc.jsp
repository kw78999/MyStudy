<!-- loginProc.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//DB�� ���� �Դ� �����ϰ�.
		boolean result = true;
		String msg ="�α��� ���� �Ͽ����ϴ�.";
		String url = "login.jsp";
		if(true){
			msg="�α��� �Ǿ����ϴ�.";
			url= "loginOK.jsp";
			session.setAttribute("idKey",id);
			
		}
		
		%>
<script type="text/javascript">
alert("<%=msg%>");
location.href = "<%=url%>";
</script>