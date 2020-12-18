<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		String subject[]  = {"Java","JSP","Android","Kotlin"};
		
%>
<table border="1">
		<tr>
		<th>번호</th>
		<th>과목</th>
	</tr>
	<%
			for(int i =0;i<subject.length;i++){
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=subject[i] %></td>
		</tr>
		<% 		
			}
		%>
</table>