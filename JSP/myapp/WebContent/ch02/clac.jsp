<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="EUC-KR">

<title></title>
<script type="text/javascript">
var flag = false;
function del(){
    exp.value = "0";
    flag = false;
}
 
function val(num){
    if(!flag)
    {
        exp.value = "";
        exp.value = exp.value + num;

        flag = true;
    }
    else
    {
        exp.value = exp.value + num;
    } 
}
function cal() {
	exp1.value = eval(exp.value);
	document.frm.submit();
}

</script>
<style>
input {
	width: 50px;
	height: 50px;
}

input {
	font-size: 24px
}

.out {
	height: 50px;
	font-size: 24px;
}
</style>

</head>

<body>

	<form name="frm" method="post" action="clacProc.jsp">
	
		<table border="1" bordercolor="black">
			<tr>
				<input name="operation" type="text" value="0" id="exp" style="width:350px"><br>
				<input name="result" type="text" value="0" id="exp1" style="width:350px"><br>
			</tr>

			<tr>
				<td><input type="button"  value="7" onclick="val(7)"></td>
				<td><input type="button" value="8" onclick="val(8)"></td>
				<td><input type="button"  value="9" onclick="val(9)"></td>
				<td><input type="button" value="+" onclick="val('+')"></td>

			</tr>

			<tr>
				<td><input type="button" value="4" onclick="val(4)"></td>
				<td><input type="button" value="5" onclick="val(5)"></td>
				<td><input type="button" value="6" onclick="val(6)"></td>
				<td><input type="button" value="-" onclick="val('-')"></td>
			</tr>

			<tr>
				<td><input type="button" value="1" onclick="val(1)"></td>
				<td><input type="button" value="2" onclick="val(2)"></td>
				<td><input type="button" value="3" onclick="val(3)"></td>
				<td><input type="button" value="*" onclick="val('*')"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="0"
					style="width: 110px; height: 50px;" onclick="val(0)"></td>
				<td><input type="button"  value="=" onclick="cal()"></td>
				<td><input type="button" value="/" onclick="val('/')"></td>
			</tr>
		</table>
	</form>
</body>

</html>