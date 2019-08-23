<html>
<head>
<meta content="text/html; charset=UTF-8"/>
<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
	align:center;
	width:800px;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
	text-align:center;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
	text-align:center;
}
</style>

</head>

<body>
<img src="${imgPath!}" style="width: 500px;height: 100px"/>
<table class="gridtable">
<tr>
    <td colspan="5" align="center"><font color="red" size="6">${title!}</font></td>
</tr>
<tr>
	<th>姓名</th>
	<th>密码</th>
	<th>真实姓名</th>
	<th>年龄</th>
	<th>住址</th>
</tr>
 <#list userList as user>
	<tr>
		<td>${user.userName!}</td>
		<td>${user.passWord!}</td>
		<td>${user.realName!}</td>
		<td>${user.age!}</td>
		<td>${user.addr!}</td>
	</tr>
 </#list>
 </table>
</body>
</html>
