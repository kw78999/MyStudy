<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<jsp:useBean id="cbean" class="guestbook.CommentBean" />
<jsp:setProperty property="*" name="cbean"/>
<% 
	//������ �Է��� �� ó���ϴ� jsp.
	String flag = request.getParameter("flag");
	if(flag.equals("insert")){
		mgr.insertComment(cbean);
	}else if(flag.equals("delete")){
		mgr.deleteComment(cbean.getCnum());
	}
	response.sendRedirect("showGuestBook.jsp");
%>