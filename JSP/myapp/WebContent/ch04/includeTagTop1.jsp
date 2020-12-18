<%@page contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String name = request.getParameter("name");
%>
incldue 액션태그의 Top입니다.<p>
<b><%=name%></b> 파이팅!!!
<hr align="left" color="red" width="40%">
