<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		//세션에 지정한 값만 삭제
		//session.removeAttribute("idKey");
		 //세션 객체 전체를 제거   (일반적으로 전체 제거함)
		// session.invalidate();
		 response.sendRedirect("login.jsp");
%>