<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="bean" class="guestbook.GuestbookBean" />
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<jsp:setProperty property="*" name="bean"/>
<%
			if(bean.getSecret()==null)
				bean.setSecret("0");  //비밀글을 체크하지 않으면 속성값 자체가 넘어오지 않는다
				mgr.updateGuestBook(bean);

%>
<!-- 수정과 동시에 창은 close 되고 수정된 방명록글을 showGuestBook.jsp 를 새로고침 한다 -->
<script>
	opener.location.reload();      //오프너는 새로고침 하고
	self.close();								//나는 닫을게

</script>