<%@ page  contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<%
		request.setCharacterEncoding("EUC-KR");
		int num=0;
		if(request.getParameter("num")!=null){
	    num = Integer.parseInt(request.getParameter("num"));
	    mgr.deleteGuestBook(num);
		}
		response.sendRedirect("showGuestBook.jsp");
%>
