<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = "aaa";
		String pwd = "1234";
		
		//session에 id와 pwd를 저장 
		session.setAttribute("logID", id);
		session.setAttribute("logPWD", pwd);
%>
세션에 id와 pwd를 저장 하였습니다 . <br>
<a href="viewSession.jsp">세션정보 확인</a>