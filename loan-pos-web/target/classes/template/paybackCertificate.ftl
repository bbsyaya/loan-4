<!DOCTYPE html [
<!ENTITY nbsp "&#160;"> 
]>
<html lang="UTF-8">
<head>
<title>流量贷授信协议</title>
<style>
body{font-family: SimSun;line-height:150%}
p {text-indent:2em;}
p.underline {text-decoration:underline;}
span.underLine {border-bottom:1px solid #000;
      padding:0 1px;}
.bold {
       font-weight:bold;
      }
.img {
      text-align:center;
      margin-top: 300px;
      margin-bottom: 150px;}
.img img{width: 50%;}
.title {text-align: center;
      font-size: 40pt;
      margin-bottom: 100px;
      font-weight: bold;}
</style>
</head>

<body>
<div class="img" ><img src="hrbbLogo.png" /></div>
<div class="title">哈尔滨银行贷款还款凭证</div>

<section>
<table border="1">
	<tr><td>借据编号：</td><td>${receiptId}</td><td>验证码：</td><td>${veriCode}</td></tr>
	<tr><td>借款人姓名：</td><td>${custName}</td><td>商户名称：</td><td>${merchantName}</td></tr>
	<tr><td>还款方式：</td><td>${paybackWay}</td><td>实还日期：</td><td>${actualPaybackDate}</td></tr>
	<tr><td>还款总额：</td><td>${actualTotalAmount}</td><td>实还本金：</td><td>${actualCapital}</td></tr>
	<tr><td>实还利息：</td><td>${actualInterest}</td><td>实还罚息：</td><td>${paybackPenalty}</td></tr>
	<tr><td colspan="4" align="right" width = "100%">${endYear}年${endMonth}月${endDay}日<br/></td></tr>
</table>
</section>
</body>
</html>
