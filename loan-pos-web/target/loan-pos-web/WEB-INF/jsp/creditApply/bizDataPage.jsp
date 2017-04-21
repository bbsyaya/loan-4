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
	<style type="text/css">
	.tdtitle {
	    background-color: #E0ECFF;
	    height: 20px
	}
</style>
</head>
<body>
	<form id="exportForm" action="<%=request.getContextPath()%>/navigation/exportBizData.do" method="post" ">
		<table>
			<tr>			
			   <td>		
                	申请开始时间：<input  class="easyui-datetimebox"  id="beginDate" name="beginDate" type="text" style="line-height:20px;border:1px solid #ccc"/>
			   </td>                		
               <td>		
                	申请截止时间：<input  class="easyui-datetimebox"  id="endDate" name="endDate" type="text"  style="line-height:20px;border:1px solid #ccc"/>
			   </td> 				
			</tr>
			<tr>
				<td>		
                	渠道：
					<select id="channel" name="channel">
						<option value="58">58金融</option>
						<option value="UM">银商</option>
						<option value="CY">四川烟草</option>
						<option value="HK">汇卡</option>
						<option value="KQ">快钱</option>
						<option value="SQ">商圈</option>
						<option value="UP">银联</option>
						<option value="YB">易宝</option>
						<option value="YF">云之富</option>
						<option value="YS">银盛</option>
						<option value="ZY">展业</option>
						<option value="ZZ">自助</option>						
					</select>
			   </td>
			   <td>					   
			                             产品名称：
					<select id="prodId" name="prodId">
						<option value="1001020306">pos贷</option>
						<option value="1001020305">流量贷</option>					
					</select>
			   </td> 
			   <td>
					<input type="button" onclick="doSubmit()" value="导出" />
				</td> 
			
		</table>
	</form>
	
	
	<table id="tt" class="easyui-datagrid" style="width:5000px;height:600px"
			url="<%=request.getContextPath()%>/creditApply/queryImageDataList.do"
			title="影像下载列表" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="id" checkbox="true"></th>
				<th field="bizLoanId" width="200px">业务编号</th>
				<th field="loanId" width="240px">申请流水号</th>
				<th field="custName" width="140px">客户名称</th>
				<th field="hh" width="100px"  align="center" formatter="rowformater">操作</th>
			</tr>
		</thead>
	</table>
 
	<div id="tb" style="padding:5px;height:auto">
	
		<div id="tb" style="padding:3px">
			<span>业务编号:</span>
			<input id="searchBizLoanId" name="searchBizLoanId" style="line-height:20px;border:1px solid #ccc;width:160px"/>
			<span>客户名:</span>
			<input id="searchCustName" name="searchCustName" style="line-height:20px;border:1px solid #ccc"/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryImageDataList()" iconCls="icon-search" plain="true">查询</a>
		</div>
	</div>  
</body>
</html>

<script type="text/javascript">

	$(function() {		
		$('#tt').datagrid({
			onClickCell: function (rowIndex, field, value) { 
	            if(field == 'hh'){
	            	$(this).datagrid('unselectAll');
	            }
	            
	        },
		});
	});
	
	function doSubmit(){
		$.messager.progress({
 	        msg: '导出',
 	        text: '正在导出，请等待......',
 	    });
		$("#exportForm").submit();		
		setTimeout("$.messager.progress('close')",3000);
	}
	
	function rowformater(value, row, index) {

        return "<a href='javascript:downLoadimgData();'>导出</a>";
    }
	
	function downLoadimgData(){
		var row = $('#tt').datagrid('getSelected');
		var loanId = row.loanId;
		var custName = row.custName;
		
		document.location.href="<%=request.getContextPath()%>/creditApply/downLoadimgData.do?loanId="+loanId+"&custName="+custName;
	}
	
	function viewProtocol(){
		var row = $('#tt').datagrid('getSelected');
		var loanId = row.loanId;
		var custName = row.custName;		
		document.location.href="<%=request.getContextPath()%>/creditApply/viewProtocol.do?loanId="+loanId;
	}
	
	
	function queryImageDataList(){
		$('#tt').datagrid('load',{
			bizLoanId: $('#searchBizLoanId').val(),
			custName: $('#searchCustName').val(),
		});
	}
</script>