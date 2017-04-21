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
	function batchKeepAccounts(){
		if(confirm("确定要发起吗？")){
			document.location.href="<%=request.getContextPath()%>/acctManager/batchKeepAccounts.do";
		}		
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
	<legend class='dialog-label'>核算批量记账</legend>
	<table width="800" border="0" cellspacing="1" cellpadding="0">
	  <tr>
	    <td width="180">发起批量记账接口:</td>
	    <td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="batchKeepAccounts()">发起调用</a>&nbsp;&nbsp;</td>
	    <c:if test="${not empty result}">
			<td colspan="3"style="color: red;padding-left:5px">提示:&nbsp;${result}</td>
		</c:if>
	  </tr>
	</table>	
	</fieldset>
	</div>	
	<table id="tt" class="easyui-datagrid" style="width:5000px;height:600px"
			url="<%=request.getContextPath()%>/acctManager/getAccSubjectOccurHis.do"
			title="账务科目发生额列表" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="id" checkbox="true"></th>
				<th field="acDate" formatter="dateFormat" width="100px">发生日期</th>
				<th field="acBankId" width="100px">会计机构</th>
				<th field="debitSubjId" width="150px">转出账号</th>
				<th field="creditSubjId" width="150px">转入账号</th>
				<th field="amt" width="90px">发生额</th>
				<th field="acStat" width="100px">记账状态</th>
				<th field="listType" width="100px">业务类型</th>
				<th field="listRem" width="100px">摘要</th>
			</tr>
		</thead>
	</table>	
</body>
</html>