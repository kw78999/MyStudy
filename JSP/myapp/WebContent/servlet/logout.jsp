<%@ page contentType="text/html; charset=EUC-KR"%>
<%
		//������ ������� ���� ��ü�� ���� -> ���ο� ���ǰ�ü�� ����
		session.invalidate();
		//���� �������� login.jsp ȣ��
		response.sendRedirect("login(1).jsp");
%>