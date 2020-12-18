<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="ch02.CalcMgr" />
<jsp:useBean id="bean" class="ch02.CalcBean" />
<jsp:setProperty property="*" name="bean"/>
<%
		mgr.insertTeam(bean);
%>