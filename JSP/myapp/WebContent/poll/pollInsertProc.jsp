<!-- pollInsertProc.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="poll.PollMgr"/>
<jsp:useBean id="plBean" class="poll.PollListBean"/>
<jsp:setProperty property="*" name="plBean"/>
<jsp:useBean id="piBean" class="poll.PollItemBean"/>
<jsp:setProperty property="*" name="piBean"/>
<%
		boolean result = mgr.insertPoll(plBean, piBean);
		String msg = "���� �߰��� ���� �Ͽ����ϴ�.";
		String url = "pollInsert.jsp";
		if(result){
			msg = "���� �߰��� ���� �Ͽ����ϴ�.";
			url = "pollList.jsp";
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
</script>



