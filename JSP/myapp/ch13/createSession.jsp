<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = "aaa";
		String pwd = "1234";
		
		//session�� id�� pwd�� ���� 
		session.setAttribute("logID", id);
		session.setAttribute("logPWD", pwd);
%>
���ǿ� id�� pwd�� ���� �Ͽ����ϴ� . <br>
<a href="viewSession.jsp">�������� Ȯ��</a>