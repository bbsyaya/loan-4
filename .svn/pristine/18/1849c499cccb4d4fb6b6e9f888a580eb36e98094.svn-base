<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/themes/icon.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/common_uiext.js"></script>
<script type="text/javascript"
	src='<%=request.getContextPath()%>/js/calendar.js'></script>
</head>
<script type="text/javascript">
function queryLedgerList(){
	var queryUrl="<%=request.getContextPath()%>/acctManager/getAcctLedgerListInfo.do";

		$('#tt').datagrid({
			url : queryUrl,
			queryParams : {
				loanAcNo : $('#txtLoanAcNo').val(),
				beginDate : $('#txtBeginDate').datebox("getValue"),
				endDate : $('#txtEndDate').datebox("getValue")
			}
		});

	}
//日期格式化
function dateFormat(value, row, index){
	var time = timeStamp2String(value);
	if(time == 'NaN-aN-aN'){
		time = null;
	}
	return time;
}
function timestampFormat(value, row, index){
	var time = timeStamp2Time(value);
	if(time == 'NaN-aN-aN'){
		time = null;
	}
	return time;
}

</script>
<body>
	<fieldset>
		<legend class='dialog-label'>查询条件</legend>
		<span>贷款账号:</span> <input id="txtLoanAcNo"
			name="txtLoanAcNo"
			style="line-height: 20px; border: 1px solid #ccc" />
			<input type="hidden" id="txtLoanAcNoHidden"> 
			<span>开始日期:</span>
		<input id="txtBeginDate" name="txtBeginDate" class="easyui-datetimebox"
			style="line-height: 20px; border: 1px solid #ccc" />
			<input type="hidden" id="txtBeginDateHidden">
			<span>結束日期:</span>
		<input id="txtEndDate" name="txtEndDate" class="easyui-datetimebox"
			style="line-height: 20px; border: 1px solid #ccc" />
			<input type="hidden" id="txtEndDateHidden">
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="queryLedgerList()" iconCls="icon-search" plain="true">查询</a>
		</div>
	</fieldset>
	<table id="tt" class="easyui-datagrid"
		style="width: 5000px; height: 600px"
		url="<%=request.getContextPath()%>/creditApply/getAcctLedgerListInfo.do"
		title="账务科目发生额列表" iconCls="icon-search" toolbar="#tb"
		onClickRow="clickRow" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="loanAcNo" width="150px">贷款账号</th>
				<th field="loanId"  width="180px">业务编号</th>
				<th field="contNo" width="180px">合同编号</th>
				<th field="custName" width="100px">客户名称</th>
				<th field="prodId" width="150px">产品编号</th>
				<th field="loanAmount" width="90px">贷款金额</th>
				<th field="loanTerm" width="100px">贷款期限</th>
				<th field="beginDate" formatter="dateFormat" width="100px">开始日期</th>
				<th field="endDate" formatter="dateFormat" width="100px">到期日期</th>
				<th field="interestRate" width="100px">贷款利率</th>
				<th field="installAmt" width="100px">分期还款额</th>
				<th field="sRepayDate" formatter="dateFormat" width="100px">应还款日期</th>
				<th field="rRepaydate" formatter="dateFormat" width="100px">实还款日期</th>
				<th field="bal" width="100px">贷款余额</th>
				<th field="aBal" width="100px">正常本金</th>
				<th field="cInte" width="100px">利息收入</th>
				<th field="rInte" width="100px">累计收回利息</th>
				<th field="acDate" formatter="dateFormat"  width="100px">记账日期</th>
				<th field="lastInteDate" formatter="dateFormat"  width="100px">上次计息日期</th>
				<th field="modifyTime" formatter="timestampFormat" width="150px">修改时间</th>
			</tr>
		</thead>
	</table>
</body>
</html>