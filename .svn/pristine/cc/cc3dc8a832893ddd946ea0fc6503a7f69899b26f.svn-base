<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>collectionTest</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/themes/icon.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
<script type="text/javascript">
    	function testCollectionButton(){
    		var cardNo = $('#cardNo').val();
    		var cardType = $('#cardType').val();
    		var paperId = $('#paperId').val();
    		var name = $('#name').val();
    		var amt = $('#amt').val();
    		var payChannel = $('input[name="payChannel"]:checked').val();
    		var reqUrl = '<%=request.getContextPath()%>/navigation/collection.do';
    		$.post(reqUrl,
    				{cardNo:cardNo,
    				cardType:cardType,
    				paperId:paperId,
    				name:name,
    				amt:amt,
    				payChannel:payChannel},
    				function(data){
    					var status = data.status;
    					var msg = data.resultMsg;
    					alert('结果状态：' + status + '\n' +'返回信息：' + msg);
    		},
    		'json')
    	}
    </script>
</head>
<form>
	 银行卡号:<input type="text" id="cardNo" name="cardNo" />
	 银行卡类型:<input type="text" id="cardType" name="cardType" />
	 身份证号:<input type="text" id="paperId" name="paperId" />
	 姓名:<input type="text" id="name" name="name" />
	 金额:<input type="text" id="amt" name="amt" />
           支付渠道:<input type="radio" name="payChannel" value="YJRPAY"/> 易极付 <input type="radio" name="payChannel" value="CPNC"/>中金支付
	<button type="button" onclick="testCollectionButton()">提交</button>
</form>
<body>
</body>
</html>
