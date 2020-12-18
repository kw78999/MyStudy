<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String name = "¹Î¼®";
		String bloodType = request.getParameter("bloodType");
%>
<jsp:include page='<%=bloodType+".jsp" %>'>
	<jsp:param value="<%=name %>" name="name"/>
</jsp:include>