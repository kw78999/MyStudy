<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String cookieName = "myCookie";
		//��Ű�� ����
		Cookie cookie = new Cookie(cookieName,"Apple");
		cookie.setMaxAge(60);  //1�� 
		//��Ű�� ���� ����
		cookie.setValue("Melone");
		//��Ű�� ������ �������� JSP�� ������ ������ ->Client�� ������.
		response.addCookie(cookie);
%>

��Ű�� ����ϴ�.<br>
��Ű ���� : <a href="tasteCookie.jsp">�����!!~</a>