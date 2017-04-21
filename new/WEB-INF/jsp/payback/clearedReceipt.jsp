<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'unClearedReceipt.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
    <script type="text/javascript">
    	function queryContractManagement(){
			$('#tt').datagrid('load',{	
				ReceiptIdLike: $('#ReceiptId').val(),
				custNameLike: $('#custName').val(),
				merchantNameLike: $('#merchantName').val(),
				custIdNoLike: $('#custIdNo').val(),
			});
		}
    
    
    
    </script>
  </head>
  
  <body>
  

	
	<div id="tb" style="padding:5px;height:auto">  
	<div id="tb">   
    <a href="javascript:void(0)" id="01" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="openReceiptDetail()">业务详情</a> 
  </div>  
	
	
	
	
	<div id="tb" style="padding:3px">
		<span>业务编号:</span>
		<input id="ReceiptId" name="ReceiptId" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户名称:</span>
		<input id="custName" name="custName" style="line-height:20px;border:1px solid #ccc"/>
		<span>商户名称:</span>
		<input id="merchantName" name="merchantName" style="line-height:20px;border:1px solid #ccc"/>
		<span>证件号码:</span>
		<input id="custIdNo" name="custIdNo" style="line-height:20px;border:1px solid #ccc"/>
		<br/>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="clearInfo()">清空</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="queryContractManagement()">查询</a>
	</div>
	</div>  
    <table id="tt" class="easyui-datagrid" style="width:1500px;height:800px"
			url="<%=request.getContextPath()%>/payback/queryPaybackInfo.do?clearStatus=<%=request.getAttribute("clearStatus")%>"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
			   
			    <th field="id" checkbox="true"></th>
			    <th field="receiptId" width="120">借据编号</th> 
			    <!-- <th field="custName" width="120">业务渠道</th> -->
			    <th field="custName" width="120">客户名称</th>
				<th field="posCustName" width="120">商户名称</th>
				<th field="payApplyAmt" width="120">贷款金额</th>
			    <th field="loanInterest" width="120">贷款利率</th>
			    <th field="beginDate" width="120">起贷日</th>
			    <th field="endDate" width="120">到期日</th>
			    <th field="paybackWay" width="120">贷款偿还方式</th>  
			    <th field="loanTotalBalance" width="120">贷款余额</th>
			 
			<!-- 	<th field="hh" width="150"  align="center" formatter="rowformater">操作</th> -->
			</tr>
		</thead>
	</table> 
    
  </body>
</html>
