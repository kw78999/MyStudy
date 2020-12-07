<%@page import="ch02.MyUtil"%>
<%@page import="java.util.Random"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%!
   public String randomColor(){
	   Random r = new Random();
	   String rgb = Integer.toHexString(r.nextInt(256));
	rgb += Integer.toHexString(r.nextInt(256));
	rgb += Integer.toHexString(r.nextInt(256));
	return "#"+rgb;
	
}
		
%>
<% for(int i=0;i<10;i++){
	%>
	<p style = "color: <%= randomColor()%>">오늘은 즐거운 월요일</p>
	<%}%>
	<hr>
	<% for(int i=0;i<10;i++){
	%>
	<p style = "color: <%=MyUtil.randomColor()%>">오늘은 즐거운 월요일</p>
	<%}%>