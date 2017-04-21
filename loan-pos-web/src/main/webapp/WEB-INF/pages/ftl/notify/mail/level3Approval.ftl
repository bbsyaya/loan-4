<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>复审3审批通知</title>
</head>

<body>
<p>Dear ${userName}:</p>
<p>一笔业务申请已经提交到了[复审3]的审批队列里，请及时处理。</p>
<p>业务申请概况如下：</p>
<table width="800" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td width="9%">业务渠道</td>
    <td width="10%">客户姓名</td>
    <td width="23%">商户名称</td>
    <td width="14%">申请金额</td>
    <td width="14%">申请时间</td>
    <td width="15%">上一手审批人</td>
    <td width="15%">上一手审批时间</td>
  </tr>
  <tr>
    <td>${channelName}</td>
    <td>${custName}</td>
    <td>${posCustName}</td>
    <td>${applyAmt}</td>
    <td>${beginDate}</td>
    <td>${prvAppover}</td>
    <td>${prvAprvTime}</td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
