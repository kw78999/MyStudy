<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String siteName = request.getParameter("siteName");
%>
요청한 사이트 : <%=siteName %><br>
<jsp:include page="includeTagTop2.jsp">
	<jsp:param name="id" value="aaa" />
	<jsp:param name="pwd" value="1234" />
</jsp:include>