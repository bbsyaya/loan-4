<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>当日还款代扣失败用户</title>
</head>

<body>
<p></p>
<p>当日代扣失败用户</p>
<table width="1000" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td width="8%">渠道</td>
    <td width="8%">姓名</td>
    <td>手机</td>
    <td width="12%">还款方式</td>
    <td>账号</td>
    <td width="8%">银行</td>
    <td>期次</td>
    <td>应还日期</td>
    <td>应还本金</td>
    <td>应还利息</td>
    <td>应还总额</td>
  </tr>
  <#list applyList as record> 
	  <tr>
	    <td>${record.recOrg}</td>
	    <td>${record.custName}</td>
	    <td>${record.mobilePhone}</td>
	    <td>${record.returnKind}</td>
	    <td>${record.bankAccno}</td>
	    <td>${record.bankName}</td>
	    <td>${record.period}</td>
	    <td>${record.schedDate}</td>
	    <td>${record.schedPrincipal}</td>
	    <td>${record.schedInterest}</td>
	    <td>${record.schedTotalAmt}</td>
	  </tr>
  </#list>
</table>
<p>&nbsp;</p>
</body>
</html>