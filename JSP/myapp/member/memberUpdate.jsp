<!-- memberUpdate.jsp -->
<%@page import="member.MemberBean"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="member.MemberMgr"/>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("idKey");
		if(id==null){
			response.sendRedirect("login.jsp");
			return;
		}
		MemberBean bean = mgr.getMember(id);
%>
<html>
<head>
<title>ȸ������</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript">
	function zipCheck() {
		url = "zipSearch.jsp?search=n";
		window.open(url, "ZipCodeSearch","width=500,height=300,scrollbars=yes");
	}
</script>
</head>
<body bgcolor="#FFFFCC" onLoad="regFrm.id.focus()">
	<div align="center">
		<br /> <br />
		<form name="regFrm" method="post" action="memberUpdateProc.jsp">
			<table align="center" cellpadding="5" >
				<tr>
					<td align="center" valign="middle" bgcolor="#FFFFCC">
						<table border="1" cellpadding="2" align="center" width="600">
							<tr align="center" bgcolor="#996600">
								<td colspan="3"><font color="#FFFFFF"><b>ȸ�� ����</b></font></td>
							</tr>
							<tr>
								<td width="20%">���̵�</td>
								<td width="80%"><input name="id" size="15"
									value="<%=bean.getId() %>" readonly></td>
							</tr>
							<tr>
								<td>�н�����</td>
								<td><input type="password" name="pwd" size="15"
									value="<%=bean.getPwd()%>"></td>
							</tr>
							<tr>
								<td>�̸�</td>
								<td><input name="name" size="15"
									value="<%=bean.getName()%>"></td>
							</tr>
							<tr>
								<td>����</td>
								<%-- <td>
									��<input type="radio" name="gender" value="1" 
									<%=bean.getGender().equals("1")?"checked":""%>> 
								     ��<input type="radio" name="gender" value="2" 
								     <%=bean.getGender().equals("2")?"checked":""%>>
								</td> --%>
								<td>
									��<input type="radio" name="gender" value="1" 
									   <%if(bean.getGender().equals("1")) 
										   			out.println("checked");%>>
									��<input type="radio" name="gender" value="2" 
										<%if(bean.getGender().equals("2")) 
										   			out.println("checked");%>>
								</td>
							</tr>
							<tr>
								<td>�������</td>
								<td><input name="birthday" size="6"
									value="<%=bean.getBirthday()%>"> ex)830815</td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input name="email" size="30"
									value="<%=bean.getEmail()%>"></td>
							</tr>
							<tr>
								<td>�����ȣ</td>
								<td><input name="zipcode" size="5"
									value="<%=bean.getZipcode()%>" readonly> <input
									type="button" value="�����ȣã��" onClick="zipCheck()"></td>
							</tr>
							<tr>
								<td>�ּ�</td>
								<td><input name="address" size="45" value="<%=bean.getAddress()%>"></td>
							</tr>
							<tr>
								<td>���</td>
								<td>
								<%
										String list[] = {"���ͳ�", "����", "����", "��ȭ", "�"};
										String hb[] = bean.getHobby();//{"1","0","1,"0,"1"}
										
										for(int i=0;i<hb.length;i++){
								%>
								<%=list[i] %>
								<input type="checkbox" name="hobby"  value="<%=list[i]%>" 
								
								<%=hb[i].equals("1")?"checked":""%>>
								<%}//---for%>	
								</td>
							</tr>
							<tr>
								<td>����</td>
								<td><select name="job">
										<option value="0">�����ϼ���.
										<option value="ȸ���">ȸ���
										<option value="����������">����������
										<option value="�����л�">�����л�
										<option value="�Ϲ��ڿ���">�Ϲ��ڿ���
										<option value="������">������
										<option value="�Ƿ���">�Ƿ���
										<option value="������">������
										<option value="����,���,������">����.���/������
										<option value="��,��,����,������">��/��/����/������
										<option value="�ֺ�">�ֺ�
										<option value="����">����
										<option value="��Ÿ">��Ÿ
								</select>
								<script>
									document.regFrm.job.value="<%=bean.getJob()%>";
								</script>
								</td>
							</tr>
							<tr>
								<td colspan="3" align="center">
								<input type="submit" value="�����Ϸ�"> &nbsp; &nbsp; 
								<input type="reset" value="�ٽþ���"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>


