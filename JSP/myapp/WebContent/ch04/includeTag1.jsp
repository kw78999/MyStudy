<!-- includeTag1.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%
		//요청되는 form의 post 방식의 한글 처리
		request.setCharacterEncoding("EUC-KR");
		//요청되는 form의 get 방식의 한글 처리 : server.xml(63라인) 
		//-> URIEncoding="EUC-KR" 
		//get 방식과 a태그 링크 방식 동일한 방식이다.
		String name = request.getParameter("name");
%>
<!-- 요청 할때 name값도 같이 요청이 된다. -->
<jsp:include page="includeTagTop1.jsp" />

