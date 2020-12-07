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
지금은 오전일까요? 오후일까요 <%= (hour<12	)?"오전":"오후"%><p>
a와 b중에 큰 숫자를 표시하세요 <%= max(a,b)%>