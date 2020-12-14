<!-- memberUpdateProc.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="member.MemberMgr"/>
<jsp:useBean id="bean" class="member.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<%
		boolean result = mgr.updateMember(bean);
		if(result){
%>
		<script>
			alert("회원정보를 수정 하였습니다.");
			location.href = "login.jsp";
		</script>
<%}else{%>
		<script>
			alert("회원정보 수정에 실패 하였습니다.");
			history.back();
		</script>
<%}%>






