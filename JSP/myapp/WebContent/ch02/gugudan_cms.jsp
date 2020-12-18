<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");

int i = 2;
int j = 1;
%>
<title>备备窜</title>
<style type="text/css">
#table1:hover{color:white;}
#test{border-radius: 15px;border:3px yellow;box-shadow:2px 2px 2px 2px orange;}
</style>  
<body style="background-color:aliceblue">
<h1 align="center">备备窜</h1>
<table  align="center">
	<tr align="center" bgcolor="skyblue" id="table1">
		<%
			for (i = 2; i < 10; i++) {
		%>
		<th id="test" height="40px" width="80px" width="90%"  bgcolor='#<%="f010"+i*10 %>'><%=i%> 窜</th>
		<%
			}
		%>
	</tr>
	<%
		for (j = 1; j < 10; j++) {
	%><tr align="center" id="table1"> 
		<%
			for (i = 2; i < 10; i++) {
		%>

		<td  id="test" radius="3"  height="40px" width="80px" width="90%" bgcolor='#<%= "f0"+j*10+i*10%>'><%=i + "x" + j + " = " + i * j%></td>

		<%
			}
		%>
	</tr>
	<%
		}
	%>


</table>
</body>