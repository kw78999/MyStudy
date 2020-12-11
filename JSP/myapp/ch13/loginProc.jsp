<!-- loginProc.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//DB에 갔다 왔다 가정하고.
		boolean result = true;
		String msg ="로그인 실패 하였습니다.";
		String url = "login.jsp";
		if(true){
			msg="로그인 되었습니다.";
			url= "loginOK.jsp";
			session.setAttribute("idKey",id);
			
		}
		
		%>
<script type="text/javascript">
alert("<%=msg%>");
location.href = "<%=url%>";
</script>