<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
    <body>
        <table border='1' width="99%">
            <tr>
                <td colspan="5" align="center"><font color="red" size="6">user用户列表</font></td>
            </tr>
            <#list userList as user>
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.passWord}</td>
                    <td>${user.realName}</td>
                    <td>${user.age}</td>
                    <td>${user.addr}</td>
                </tr>
            </#list>
        </table>
     </body>
</html>