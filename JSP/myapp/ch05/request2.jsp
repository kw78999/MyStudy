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
<%="�������� : " + protocol  %> <br>
<%="��Ʈ : " + port%><br>
<%="������ : " + remteAddr%><br>
<%="��û���(URI) : " + reqeustURI%><br>
<%="��û���(URL) : " + reqeustURL%><br>
<%="���� : " + query%><br>