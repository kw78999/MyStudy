<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<jsp:useBean id="bean" class="guestbook.GuestbookBean" />
<jsp:setProperty property="*" name="bean"/>
<%
			if(bean.getSecret()==null){
				//��б��� üũ ���Ѱ��
				bean.setSecret("0");
			}
			mgr.insertGuestBook(bean);
			response.sendRedirect("showGuestBook.jsp");
%>