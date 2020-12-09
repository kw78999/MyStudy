<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="ch06.TeamMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch06.TeamBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
		mgr.insertTeam(bean);
		response.sendRedirect("teamList.jsp");
	%>

