<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//���ǿ� ������ ���� ����
		//session.removeAttribute("idKey");
		 //���� ��ü ��ü�� ����   (�Ϲ������� ��ü ������)
		// session.invalidate();
		 response.sendRedirect("login.jsp");
%>