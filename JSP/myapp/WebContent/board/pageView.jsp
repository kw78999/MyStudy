<!-- pageView.jsp -->
<%@page import="board2.UtilMgr"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		int totalRecord = UtilMgr.parseInt(request, "totalRecord");//�ѰԽù���
		int numPerPage = 10;//�������� ���ڵ� ����
		int pagePerBlock = 15;//���� ������ ����
		int totalPage = 0;//�� ������ ����
		int totalBlock =0;//�� �� ����
		int nowPage = 1;//���� ������
		int nowBlock = 1;//���� ��
		
		if(request.getParameter("nowPage")!=null){
			nowPage = UtilMgr.parseInt(request, "nowPage");
		}
		
		int start = (nowPage*numPerPage)-numPerPage;
	
		totalPage = (int)Math.ceil((double)totalRecord/numPerPage);
		totalBlock = (int)Math.ceil((double)totalPage/pagePerBlock);
		nowBlock = (int)Math.ceil((double)nowPage/pagePerBlock);
		
%>
<!DOCTYPE html>
<html>
<head>
	<title>����¡ & �� ó�� �׽�Ʈ</title>
</head>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function pageing(page) {
		document.readFrm.nowPage.value=page;
		document.readFrm.submit();
	}

	function block(block) {
		document.readFrm.nowPage.value=<%=pagePerBlock%>*(block-1)+1;
		document.readFrm.submit();
	}
</script>
<body bgcolor="#FFFFCC">
<div align="center"><br/>
<h2>����¡ & �� ó�� �׽�Ʈ</h2>
<table>
	<tr>
		<td  width="700" align="center">
		Total : <%=totalRecord%>Articles(
		<font color="red"><%=nowPage+"/"+totalPage%>Pages</font>
		)
		</td>
	</tr>
</table>
<!-- �Խù� ��ȣ Start -->
<table>
	<tr> 
		<td> �Խù� ��ȣ : &nbsp; </td>
		<%
				int listSize = totalRecord - start;
				for(int i=0;i<numPerPage/*10*/;i++){
					if(i==listSize) break;
		%>
		<td align="center"><%=totalRecord-start-i%>&nbsp;</td>
		<%}//---for%>
	</tr>
</table>	
<!-- �Խù� ��ȣ End -->
<!-- ����¡ �� �� Start -->
<table>
	<tr> 
		<td> 
		<!-- ������ -->
		<%if(nowBlock>1){%>
		<a href="javascript:block('<%=nowBlock-1 %>')">prev...</a>
			<%} %>
		<!-- ����¡ -->
		<%
				int pageStart = (nowBlock-1)*pagePerBlock+1;
				int pageEnd = (pageStart+pagePerBlock/*15*/)<totalPage?
						pageStart+pagePerBlock:totalPage+1;
				for(;pageStart<pageEnd;pageStart++){
		%>
		<a href="javascript:pageing('<%=pageStart%>')">
			<%if(nowPage==pageStart){%><font color="blue"><%}%>
				[<%=pageStart%>]
			<%if(nowPage==pageStart){%></font><%}%>
		</a>
		<%}//--for%>
		<!-- ������ -->
			<%if(totalBlock>nowBlock){%>
			<a href="javascript:block('<%=nowBlock+1 %>')">...next</a>
			<%} %>
		</td>
	</tr>
</table>
<!-- ����¡ �� �� End -->
<form name="readFrm">
	<input type="hidden" name="totalRecord" value="<%=totalRecord%>">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
</form>
<hr width="60%"/>
<b>
totalRecord : <%=totalRecord%>&nbsp;
numPerPage : <%=numPerPage%>&nbsp;
pagePerBlock : <%=pagePerBlock%>&nbsp;
totalPage : <%=totalPage%>&nbsp;<br/>
totalBlock : <%=totalBlock%>&nbsp;
nowPage : <%=nowPage%>&nbsp;
nowBlock : <%=nowBlock%>&nbsp;
</b>
<p/>
<input type="button" value="TotalRecord �Է���"
 onClick="javascript:location.href='pageView.html'">
</div>
</html>
