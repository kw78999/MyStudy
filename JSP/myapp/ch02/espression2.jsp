<%@page import="java.util.Date"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%!
			public int max(int a,int b){
			return a>b? a:b;
}
%>
<%
		Date d = new Date();
			int hour = d.getHours();
			int a = 10, b = 20;
%>
������ �����ϱ��? �����ϱ�� <%= (hour<12	)?"����":"����"%><p>
a�� b�߿� ū ���ڸ� ǥ���ϼ��� <%= max(a,b)%>