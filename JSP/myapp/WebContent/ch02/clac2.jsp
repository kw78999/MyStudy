<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		
%>
<!DOCTYPE html>
<html>
<head>
    <title>계산기 만들기</title>
<style>
input
{
    width: 60px;
    height: 20px;
}
</style>
<script>
var flag = false;
function calculate() 
{
    exp.value = eval(exp.value);
}
function del()
{
    exp.value = "0";
    flag = false;
}
 
function val(num)
{
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
function back()
{
    //var exp = document.getElementById("exp");
 
    exp.value = exp.value.substring(0, exp.value.length-1);
 
}
</script>
</head>
<body>
<h3>계산기 만들기</h3>
<hr>
<input type="text" value="0" id="exp" style="width:350px"><br>
&emsp;<input type="button" value="BACK" onclick="back()">&emsp;
<input type="button" value="CE" onclick="del()">&emsp;
<input type="button" value="C" onclick="del()">&emsp;
<input type="button" value="=" onclick="calculate()"><br>
&emsp;<input type="button" value="7" onclick="val('7')">&emsp;
<input type="button" value="8" onclick="val('8')">&emsp;
<input type="button" value="9" onclick="val('9')">&emsp;
<input type="button" value="/" onclick="val('/')"><br>
&emsp;<input type="button" value="4" onclick="val('4')">&emsp;
<input type="button" value="5" onclick="val('5')">&emsp;
<input type="button" value="6" onclick="val('6')">&emsp;
<input type="button" value="*" onclick="val('*')"><br>
&emsp;<input type="button" value="1" onclick="val('1')">&emsp;
<input type="button" value="2" onclick="val('2')">&emsp;
<input type="button" value="3" onclick="val('3')">&emsp;
<input type="button" value="-" onclick="val('-')"><br>
&emsp;<input type="button" value="0" onclick="val('0')">&emsp;
<input type="button" value="+" onclick="val('+')">&emsp;
<input type="button" value="NONE">&emsp;
<input type="button" value="NONE"> 
</body>
</html>