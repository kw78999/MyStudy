<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="bean" class="guestbook.GuestbookBean" />
<jsp:useBean id="mgr" class="guestbook.GuestBookMgr" />
<jsp:setProperty property="*" name="bean"/>
<%
			if(bean.getSecret()==null)
				bean.setSecret("0");  //��б��� üũ���� ������ �Ӽ��� ��ü�� �Ѿ���� �ʴ´�
				mgr.updateGuestBook(bean);

%>
<!-- ������ ���ÿ� â�� close �ǰ� ������ ���ϱ��� showGuestBook.jsp �� ���ΰ�ħ �Ѵ� -->
<script>
	opener.location.reload();      //�����ʴ� ���ΰ�ħ �ϰ�
	self.close();								//���� ������

</script>