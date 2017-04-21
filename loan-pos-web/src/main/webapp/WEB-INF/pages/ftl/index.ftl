<<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<@pnotify/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>哈尔滨银行互联网金融  :: 普惠金融   和谐共富</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="${base}/css/portal.css">
	<style type="text/css">
		.title{
			font-size:16px;
			font-weight:bold;
			padding:20px 10px;
			background:#eee;
			overflow:hidden;
			border-bottom:1px solid #ccc;
		}
		.t-list{
			padding:5px;
		}
	</style>
	<script type="text/javascript" src="${base}/js/jquery.portal.js"></script>
	<script>
		$(function(){
			$('#pp').portal({
				border:false,
				fit:true
			});
			add();
		});
		function add(){
			var p = $('<div></div>').appendTo('body');
			p.panel({
				title: 'My Title',
				height:150,
				closable: true,
				collapsible: true
			});
			 
			// add the panel to portal
			$('#pp').portal('add', {
				panel: p,
				columnIndex: 0
			});

			$('#pp').portal('resize');
		}
		function remove(){
			$('#pp').portal('remove',$('#pgrid'));
			$('#pp').portal('resize');
		}
	</script>
</head>
<body class="easyui-layout">
	<#include "/includes/navbar.ftl"> 
	<#-- 内容开始 -->
<div region="center" border="false">
    <div id="pp" style="position:relative">
        <div style="width:30%;">
        <div id="pgrid0" title="DataGrid" closable="true" style="height:200px;">
		<table class="easyui-datagrid" style="width:650px;height:auto"
				fit="true" border="false"
				singleSelect="true"
				idField="itemid" url="datagrid_data.json">
			<thead>
				<tr>
					<th field="itemid" width="60">Item ID</th>
					<th field="productid" width="60">Product ID</th>
					<th field="listprice" width="80" align="right">List Price</th>
					<th field="unitcost" width="80" align="right">Unit Cost</th>
					<th field="attr1" width="120">Attribute</th>
					<th field="status" width="50" align="center">Status</th>
				</tr>
			</thead>
		</table>
	</div>
        </div>
        <div style="width:40%;">
        <div id="pgrid1" title="DataGrid" closable="true" style="height:200px;">
		<table class="easyui-datagrid" style="width:650px;height:auto"
				fit="true" border="false"
				singleSelect="true"
				idField="itemid" url="datagrid_data.json">
			<thead>
				<tr>
					<th field="itemid" width="60">Item ID</th>
					<th field="productid" width="60">Product ID</th>
					<th field="listprice" width="80" align="right">List Price</th>
					<th field="unitcost" width="80" align="right">Unit Cost</th>
					<th field="attr1" width="120">Attribute</th>
					<th field="status" width="50" align="center">Status</th>
				</tr>
			</thead>
		</table>
	</div>
        </div>
        <div style="width:30%;">
        <div id="pgrid2" title="DataGrid" closable="true" style="height:200px;">
		<table class="easyui-datagrid" style="width:650px;height:auto"
				fit="true" border="false"
				singleSelect="true"
				idField="itemid" url="datagrid_data.json">
			<thead>
				<tr>
					<th field="itemid" width="60">Item ID</th>
					<th field="productid" width="60">Product ID</th>
					<th field="listprice" width="80" align="right">List Price</th>
					<th field="unitcost" width="80" align="right">Unit Cost</th>
					<th field="attr1" width="120">Attribute</th>
					<th field="status" width="50" align="center">Status</th>
				</tr>
			</thead>
		</table>
	</div>
        </div>
    </div>
</div>

	<#-- 内容结束 --> 
	<#include "includes/footer.ftl"> 

</body>
</html>