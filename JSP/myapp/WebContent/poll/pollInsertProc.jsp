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
		String msg = "설문 추가에 실패 하였습니다.";
		String url = "pollInsert.jsp";
		if(result){
			msg = "설문 추가에 성공 하였습니다.";
			url = "pollList.jsp";
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
</script>



