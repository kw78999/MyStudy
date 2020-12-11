<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bean" class="member.MemberBean" />
<jsp:useBean id="mgr" class="member.MemberMgr" />
<jsp:setProperty property="*" name="bean"/>
            <script type="text/javascript">
				alert("회원가입 성공");
             </script>
<%
		if(mgr.insertMember(bean)){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("member.jsp");
		}
		
%>