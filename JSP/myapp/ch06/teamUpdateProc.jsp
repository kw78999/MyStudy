<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="ch06.TeamMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch06.TeamBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
		boolean result = mgr.updateTeam(bean);
		String msg = "��������";
		String url = "teamList.jsp";
		if(result){
			msg="��������";
			url = "teamRead.jsp?num="+bean.getNum();
		}
	%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
</script>