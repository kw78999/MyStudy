<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//캐시영역에 저장 안됨. (이페이지는 항상 서버 요청 가능)
		response.setHeader("pragma","no-cache");
		if(request.getProtocol().equals("HTTP/1.1"))
			response.setHeader("Cache-Control", "no-store");
%>
response2.jsp 