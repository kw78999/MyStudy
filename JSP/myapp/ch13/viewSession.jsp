<%@page import="java.util.Enumeration"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("logID");
		String pwd = (String)session.getAttribute("logPWD");
		out.println(id + " : "+ pwd+"<br>");
		//������ �����ֱ� 
		out.println("������ �����ֱ�: "+ session.getMaxInactiveInterval()+"<br>");
		
		//���ǿ� ����� ��ü�� ��� ��������
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			Object obj = session.getAttribute(name);
			out.println("session name : "+name+"<br>");
			out.println("session value : "+obj+"<br>");
		}
%>
<a href = "createSession.jsp">���ǻ���</a>
