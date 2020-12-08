<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String protocol = request.getProtocol();
		int port = request.getServerPort();
		String remteAddr = request.getRemoteAddr();
		String reqeustURI  = request.getRequestURI();
		StringBuffer reqeustURL = request.getRequestURL();
		String query = request.getQueryString();
		
%>
<%="프로토콜 : " + protocol  %> <br>
<%="포트 : " + port%><br>
<%="아이피 : " + remteAddr%><br>
<%="요청경로(URI) : " + reqeustURI%><br>
<%="요청경로(URL) : " + reqeustURL%><br>
<%="조건 : " + query%><br>