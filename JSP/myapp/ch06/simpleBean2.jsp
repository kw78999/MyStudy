<h1>���� �׼� �±� ���</h1>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="bean" class="ch06.SimpleBean"/>
<!-- SimpleBean bean = new SimpleBean();   �̰��� jsp:useBean �� ��ġ�Ѵ� -->

<!-- �� ���ٷ� ��� �Ӽ� ����(bean.set~~~~) ���� -->
<jsp:setProperty property="*" name="bean"/>

msg : <jsp:getProperty property="msg" name="bean"/>
cnt : <jsp:getProperty property="cnt" name="bean"/>