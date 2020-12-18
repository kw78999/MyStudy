<!-- include1.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<%@include file="top.jsp"%>
include 지시자의 body입니다.<br>
<%
		//String d = "하하"; top.jsp에서 d라는 변수를 선언.중복 선언
%>
Date&Time : <%=d.toLocaleString()%>
<%@include file="bottom.jsp"%>