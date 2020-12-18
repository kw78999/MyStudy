<%@page import="ch06.TeamBean"%>
<%@page import="java.util.Vector"%>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>

<jsp:useBean id="mgr" class="ch06.TeamMgr" />
<%
		request.setCharacterEncoding("EUC-KR");
		Vector<TeamBean> vlist = mgr.listTeam();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Team Mgr</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center"><p/>
<h1>Team List</h1>
<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>사는곳</th>
			<th>나이</th>
			<th>팀명</th>
	</tr>
	<%
		for(int i =0 ; i<vlist.size();i++){
			TeamBean bean = vlist.get(i);
	%>
	<tr align="center">
	<td><a href = "teamRead.jsp?num=<%=bean.getNum()%>"><%=bean.getNum()%></a></td>
	<td><%=bean.getName()%></td>
	<td><%=bean.getCity()%></td>
	<td><%=bean.getAge()%></td>
	<td><%=bean.getTeam()%></td>
	</tr>
	
	<%} //---for %>
	
</table><p>
<a href = "teamInsert.html">INSERT</a>
</div>
</body>
</html>