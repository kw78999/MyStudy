<!-- noteList.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Note List</h3>
<table width="500" border="1">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>내용</th>
		<th>삭제</th>
	</tr>
<c:forEach var="dto" items="${list}">
	<tr>
		<td>${dto.id}</td>
		<td>${dto.writer}</td>
		<td>${dto.content}</td>
		<td><a href="delete?id=${dto.id}">삭제</a></td>
	</tr>
</c:forEach>
<tr>
	<td colspan="4">
		<a href="noteForm">작성</a>
	</td>
</tr>
</table>
</body>
</html>











