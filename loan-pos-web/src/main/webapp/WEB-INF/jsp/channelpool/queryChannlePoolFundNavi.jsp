<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务申请</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href='<%=request.getContextPath()%>/css/common.css'/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/validator.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/review/reviewNote.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/p_validator.js"></script>
	<script type="text/javascript">
	
	//获取银行流水月份
	function queryChannelFund(){
		var acctName = $('#acctName').val();
		var account = $('#account').val();
		var reqUrl = "<%=request.getContextPath()%>/channelFund/queryChannelFund.do";
		$.post(
			reqUrl, {acctName: acctName, account: account}, function(obj){
			alert(obj);
		});
	}
			
	function queryBlank(){
		$('#acctName').val("");
		$('#account').val("");
	}
	</script>
</head>
<body>
	<%-- <table id="tt" class="easyui-datagrid" style="height:600px"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
			    <th field="id" checkbox="true"></th>
				<th field="bizLoanId" width="140px">申请编号</th>
				<th field="prodName" width="60px">产品</th>
				<th field="channelName" width="60px">业务渠道</th>
				<th field="applyAmt" width="80px" align="right" formatter="formatMoney">申请额度</th>
				<th field="beginDate" width="80px" formatter="dateFormat">申请日期</th>
				<th field="custName" width="80px">客户名称</th>
				<th field="posCustName" width="120px">商户名称</th>
				<th field="region" width="80px">地区</th>
				<!-- <th field="tradeArea" width="40px"></th> -->
				<th field="mobilePhone" width="80px">手机号码</th>
			<c:if test="${applyStatus == '90'}">
				<th field="creditLine" width="80px" align="right" formatter="formatMoney">授信额度</th>
				<th field="creditInterest" width="60px">授信利率</th>
				<!-- 
				<th field="creditResult" width="60px">授信结果</th> -->
			</c:if>
				<th field="applyStatusName" width="80px">当前状态</th>
			<c:if test="${(applyStatus != '00' and applyStatus != '10' and applyStatus!=null) or (applyStatus==null and isApplyStatus!='')}">
				<th field="execReviwer" width="60px">当前处理人</th>
				<th field="lastStep" width="60px">上一环节</th>
				<th field="lastStepOperName" width="60px">上一环节处理人</th>
			</c:if>
			<c:if test="${applyStatus == '00' or applyStatus == '10' or applyStatus==null or applyStatus==''}">
				<th field="regDate" width="110px" formatter="timeFormat">录入时间</th>
				<th field="operName" width="60px">录入人</th>
				<c:if test="${applyStatus == '00'}">
				<th field="hh" width="80px"  align="center"  formatter="rowformater">操作</th>
				</c:if>
			</c:if>
				<!-- hidden fields -->
				<th field="loanId" hidden="true">申请流水号</th>
				<th field="prodId" hidden="true">产品代码</th>
				<th field="channel" hidden="true">渠道编码</th>
				<th field="applyStatus" hidden="true">申请状态编码</th>
			</tr>
		</thead>
	</table> --%>

	<jsp:include page="searchChannelFund.jsp"/>
</body>
</html>