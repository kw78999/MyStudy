<%@page contentType="text/html; charset=EUC-KR"%>
<%String flist[] = {"aaa.jpg", "bbb.jpg","ccc.jpg"};%>
<!doctype html>
<html>
<head>
<script>
	function allChk() {
		f=document.frm;
		if(f.allCh.checked){//allCh üũ ����
			for(i=1;i<f.fch.length;i++){
				f.fch[i].checked = true;
			}
			f.btn.disabled = false;//Ȱ��ȭ
			f.btn.style.color= "blue";
		}else{//allCh üũ �ȵ� ����
			for(i=1;i<f.fch.length;i++){
				f.fch[i].checked = false;
			}
			f.btn.disabled = true;//Ȱ��ȭ
			f.btn.style.color= "gray";
		}
	}
	
	function chk() {
		f=document.frm;
		for (i = 1; i < f.fch.length; i++) {
			if(f.fch[i].checked){
				f.btn.disabled = false;  //Ȱ��ȭ
				f.btn.style.color = "blue";
			}else{
				f.btn.style.color= "gray";
				f.btn.disabled = true;//Ȱ��ȭ
			}
	}}
</script>
</head>
<body>
<div align="center">
<h2>File List</h2>
<form name="frm">
<input type="hidden" name="fch" value="0">
<table border="1" width="300">
	<tr align="center">
		<td><input type="checkbox" name="allCh" onclick="allChk()"></td>
		<td>��ȣ</td>
		<td>���ϸ�</td>
	</tr>
	<%for(int i=0;i<flist.length;i++){%>
	<tr align="center">
		<td>
			<input type="checkbox" value="<%=i%>" name="fch" onclick="chk()">
		</td>
		<td><%=i+1%></td>
		<td>
			<a><%=flist[i]%></a>
		</td>
	</tr>
	<%}//for%>
	<tr>
		<td colspan="4">
			<input type="submit" name="btn" value="DELETE" disabled>
		</td>
	</tr>
</table>
</form><p>
</div>
</body>
</html>










