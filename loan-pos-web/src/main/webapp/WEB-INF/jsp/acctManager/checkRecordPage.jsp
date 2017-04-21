<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/common_uiext.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/calendar.js'></script>
	<script type="text/javascript" >	
	function queryCheckRecord(){
		var queryUrl="<%=request.getContextPath()%>/acctManager/queryCheckRecord.do";

			$('#tt').datagrid({
				url : queryUrl,
				queryParams : {
					trandate : $('#trandate').datebox("getValue"),
				}
			});

		}
	
	$(function() {		
		$('#tt').datagrid({
			onClickCell: function (rowIndex, field, value) { 
	            if(field == 'hh'){
	            	$(this).datagrid('unselectAll');
	            }
	            
	        },
		});
	});
	//日期格式化
	function dateFormat(value, row, index){
		return timeStamp2String(value);
	}

</script>
</head>
<body>
	<div id="tb" style="padding:3px;background:#f4f4f4">
	<fieldset>
		<legend class='dialog-label'>查询条件</legend>
		<span>交易日期:</span> 
		<input id="trandate" name="trandate" class="easyui-datetimebox" style="line-height: 20px; border: 1px solid #ccc" />
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="queryCheckRecord()" iconCls="icon-search" plain="true">查询</a>
		</div>
	</fieldset>
	</div>	
	<table id="tt" class="easyui-datagrid" style="width:5000px;height:600px"
			url="<%=request.getContextPath()%>/acctManager/queryCheckRecord.do"
			title="核算对账记录列表" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="listId" width="150px">借据编号</th>
				<th field="prodId" width="60px">商品编号</th>
				<th field="custName" width="90px">客户名称</th>
				<th field="loanAmount" width="60px">发放金额</th>
				<th field="listStat" width="60px">借据状态</th>
				<th field="otherListNo" width="90px">核算流水号</th>
				<th field="batchno" width="90px">CDC流水号</th>
				<th field="trandate" width="90px">交易日期</th>
				<th field="dbrc" width="60px">借方机构</th>
				<th field="dbaccount" width="170px">借方账号</th>
				<th field="cbrc" width="60px">贷方结构</th>
				<th field="craccount" width="170px">贷方账号</th>
				<th field="amt" width="90px">交易金额</th>
				<th field="channelid" width="90px">交易渠道</th>
			</tr>
		</thead>
	</table>	
</body>
</html>