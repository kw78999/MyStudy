<!-- scopeBean.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="pBean" scope="page" class="ch06.ScopeBean"/>
<!-- scope�� session�� id�� ������ ��ü�� �ִ��� ������ �˻� -> ������ 
       ���Ӱ� �������� ������ ������ �Ѵ�. �׷��� ������ ���ᰡ �Ǹ� �ȿ� �ִ� ��ü�� ����
       ���Ű� �ȴ�.
 -->
<jsp:useBean id="sBean" scope="session" class="ch06.ScopeBean"/>

<jsp:setProperty property="num" name="pBean" 
value="<%=pBean.getNum()+10%>"/>
<jsp:setProperty property="num" name="sBean" 
value="<%=sBean.getNum()+10%>"/>

<h1>Scope Bean</h1>
pBean num�� : <jsp:getProperty property="num" name="pBean"/><br>
sBean num�� : <jsp:getProperty property="num" name="sBean"/><br>
<a href="scopeBean2.jsp">��������</a>
���� id : <%= session.getId()%>

