<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8"></meta>
<style>
.order{
color:green
	}	
</style>
</head>
<body>
<span class='order'>订单id</span>： ${order_id}<br/>
<font color='red'>借款编号</font>： ${loanId}<br/>
借款人： ${realName!}<br/>
放款银行卡号： ${cardNo!}<br/>
实际借款人： ${name!}<br/>
借款金额： ${loanAmount!}（${loanAmountCharacter!}）<br/>
借款期限： ${timeLimit!}月<br/>
利率： ${interest!} %<br/>
放款银行： ${bankName!}<br/>
到款银行卡号： ${bankNo!}<br/>
</body>
</html>
