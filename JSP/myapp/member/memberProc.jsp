<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bean" class="member.MemberBean" />
<jsp:useBean id="mgr" class="member.MemberMgr" />
<jsp:setProperty property="*" name="bean"/>
          
<%
			boolean result = mgr.insertMember(bean);
			String msg = "���Խ���";
			String url = "member.jsp";
			
			if(result){
			msg = "���Լ���";
			url = "login.jsp";
			//���Լ����� ���ÿ� �α��� ó���� ���� ���
			session.setAttribute("idKey",bean.getId());
			}
%>
<script type="text/javascript">
 	alert("<%=msg%>");
 	location.href = "<%=url%>";
</script>