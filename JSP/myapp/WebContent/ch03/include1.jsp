<!-- include1.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%@include file="top.jsp"%>
include �������� body�Դϴ�.<br>
<%
		//String d = "����"; top.jsp���� d��� ������ ����.�ߺ� ����
%>
Date&Time : <%=d.toLocaleString()%>
<%@include file="bottom.jsp"%>