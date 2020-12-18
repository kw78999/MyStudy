<h1>빈즈 액션 태그 사용</h1>
<%@ page  contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="bean" class="ch06.SimpleBean"/>
<!-- SimpleBean bean = new SimpleBean();   이것이 jsp:useBean 과 일치한다 -->

<!-- 단 한줄로 모든 속성 셋팅(bean.set~~~~) 가능 -->
<jsp:setProperty property="*" name="bean"/>

msg : <jsp:getProperty property="msg" name="bean"/>
cnt : <jsp:getProperty property="cnt" name="bean"/>