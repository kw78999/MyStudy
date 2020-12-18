<!-- scopeBean.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="pBean" scope="page" class="ch06.ScopeBean"/>
<!-- scope가 session은 id가 동일한 객체가 있는지 없는지 검색 -> 없으면 
       새롭게 만들지만 있으면 재사용을 한다. 그러나 세션이 종료가 되면 안에 있는 객체도 같이
       제거가 된다.
 -->
<jsp:useBean id="sBean" scope="session" class="ch06.ScopeBean"/>

<jsp:setProperty property="num" name="pBean" 
value="<%=pBean.getNum()+10%>"/>
<jsp:setProperty property="num" name="sBean" 
value="<%=sBean.getNum()+10%>"/>

<h1>Scope Bean</h1>
pBean num값 : <jsp:getProperty property="num" name="pBean"/><br>
sBean num값 : <jsp:getProperty property="num" name="sBean"/><br>
<a href="scopeBean2.jsp">세션종료</a>
세션 id : <%= session.getId()%>

