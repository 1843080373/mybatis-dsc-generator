<html>
<head>
<meta content="text/html; charset=UTF-8"/>
    <title>欢迎  ${user.username}!</title>
</head>
<body>
    <h1>欢迎 ${user.username}!</h1>
    <h2>年龄: ${user.age}</h2>
    <h2>${user.record.id}：${user.record.name}</h2>
    
    <#assign a="hello"/>
<#assign b="world"/>
<li>连接</li>
${a + b}
<li>截取</li>
${(a + b)?substring(5, 8)}
<li>长度</li>
${(a + b)?length}
<li>大写</li>
${(a + b)?upper_case}
<li>小写</li>
${(a + b)?lower_case}
<li>index</li>
${(a + b)?index_of('o')}
<li>last_index</li>
${(a + b)?last_index_of('o')}
<li>替换</li>
${(a + b)?replace('o', 'xx')}
<br/>
<font color="red">布尔型format</font>
<br/>
布尔变量:${isOk?string('yes', 'no')}
<br/>
${sqldate!}
${utildate?string("yyyy/MM/dd HH:mm:ss")}

${nullVar!'默认输出'}
${missingVar!}
<br/>
<#assign a=100 />
<#assign b=2 />
<li>${a} + ${b} = ${a + b}</li>
<li>${a} - ${b} = ${a - b}</li>
<li>${a} x ${b} = ${a * b}</li>
<li>${a} / ${b} = ${a / b}</li>
<li>${a} % ${b} = ${a % b}</li>
<br/>
<#assign myList=[3, 4, 5, 6, 1, 3, 7, 9, 2] />
mySize大小：${myList?size}<br/>
mySize第三个元素：${myList[3]}<br/>
顺序：<br/>
<#list myList?sort as item>
    <li>${item_index} --> ${item}</li>
</#list>
<br/>
逆序：<br/>
<#list myList?sort?reverse as item>
    <li>${item_index}  --> ${item}</li>
</#list>

<br/>
<#assign str="java" />
<#switch str>
    <#case "python"> 学习python <#break>
    <#case "java"> 学习java <#break>
    <#default> 学习别的。。。
</#switch>

<#assign str="11.1" />
<#switch str>
    <#case "11.1"> 学习python <#break>
    <#case "11.11"> 学习java <#break>
    <#default> 学习别的。。。
</#switch>

<br/>


顺序：
<#list my_sort(numList, true?string('yes', 'no')) as item>
${item_index} : ${item}
</#list>
<br/>
逆序：
<#list my_sort(numList, false?string('yes', 'no')) as item>
${item_index} : ${item}
</#list>

<br/>
<#function doAdd param1 param2>
    <#return param1+param2 />
</#function>
${doAdd(2, 3)}

<br/>
<@role username="admin" password="123456"; result1,result2>
   <#if result1>
     登陆成功，拥有权限：<br>
     <#list result2 as right>
		${right}<br>
	</#list>
	<#else>
	   登陆失败
   </#if>
</@role>
</body>
</html>