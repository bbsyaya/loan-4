<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html lang="zh-CN"><!-- 指定页面语言 -->
<head>
	<title>利率上限</title>
	<meta http-equiv="pragma" content="no-cache"><!-- 禁止本地缓冲 -->
	<meta http-equiv="cache-control" content="no-cache"><!-- 清除缓冲 -->
	<meta http-equiv="expires" content="0"><!-- 过期时间 -->
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"><!-- 关键字，给搜索引擎用 -->
	<meta http-equiv="description" content="This is my page"><!-- 页面描述 -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
    <script type="text/javascript" src='<%=request.getContextPath()%>/js/validator.js'></script>
	<script type="text/javascript">
	/*打开展业人员列表窗口*/
	function openApprovingRateUplimitConfigListWindow(){
		if(!checkSelected){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		if(id == null || id==''){
			alert("请选择一条记录");
			return;
		}
		var reqUrl = "<%=request.getContextPath()%>/approvingRateUplimitConfig/approvingRateUplimitConfigDetail.do?id="+id;
		$('#listExecutorsWindow').openWin({
			title:'风险区域配置',
			maximized:false,
			width : 960,
			href:reqUrl
		})
	}
	/**打开新增风险区域配置窗口*/
	function openApprovingRateUplimitConfigWindow(){
		var reqUrpl = '<%=request.getContextPath()%>/approvingRateUplimitConfig/openAddApprovingRateUplimitConfig.do';
		$('#addApprovingRateUplimitConfigWindow').openWin({
			title:'新增风险区域配置',
			maximized:false,
			width:800,
			height:400,
			top:($(window).height()-400)/2,
			href:reqUrpl
		})
	}
	/**新增批复利率配置*/
	function addApprovingRateUplimitConfigWindow(){
		var flag = validateForm("apprvRateUplimitDiv");
		if (!flag){
			$.messager.alert("操作提示","还有未填写的必输项或输入不符合要求","error");
			return;
		}
		var reqUrl = '<%=request.getContextPath()%>/approvingRateUplimitConfig/addApprovingRateUplimitConfig.do';
		var amt_uplimit =$('.amt_uplimit').val();
		var rate_uplimit =$('.rate_uplimit').val();
        var deleted_flag = $('#rate_deleted_flag').combobox('getValue');
		var valid_date = $('.valid_date').datebox("getValue");
		var invalid_date = $('.invalid_date').datebox("getValue");
		$.post(reqUrl,{
			amt_uplimit:amt_uplimit,
			rate_uplimit:rate_uplimit,
			deleted_flag:deleted_flag,
			valid_date:valid_date,
			invalid_date:invalid_date
		},function(data){
			alert(data);
			$('#addApprovingRateUplimitConfigWindow').window('close');
			clearForm("#apprvRateUplimitDiv");
			$('#tt').datagrid('reload');
		},'text')	
	}
	/**打开修改皮肤利率配置窗口*/
	function openModifyApprovingRateUplimitConfigWindow(){
		if(!checkSelected()){
			return;
		}
//		clearInstitutionWin();
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		var reqUrpl = '<%=request.getContextPath()%>/approvingRateUplimitConfig/openModifyApprovingRateUplimitConfigWindow.do?id='+id;
		$('#modifyApprovingRateUplimitConfigWindow').openWin({
			title:'修改批复利率配置信息',
			maximized:false,
			width:800,
			height:400,
			top:($(window).height()-400)/2,
			href:reqUrpl
		})
	}
	/**修改展业机构*/
	function modifyApprovingRateUplimitConfigWindow(){
		var flag = validateForm("apprvRateUplimitDiv");
		if (!flag){
			$.messager.alert("操作提示","还有未填写的必输项或输入不符合要求","error");
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		var reqUrl = '<%=request.getContextPath()%>/approvingRateUplimitConfig/modifyApprovingRateUplimitConfigWindow.do';
		var amt_uplimit =$('.amt_uplimit').val();
		var rate_uplimit =$('.rate_uplimit').val();
        var deleted_flag = $('#rate_deleted_flag').combobox('getValue');
		var valid_date = $('.valid_date').datebox("getValue");
		var invalid_date = $('.invalid_date').datebox("getValue");
		$.post(reqUrl,{
			id:id,
			amt_uplimit:amt_uplimit,
			rate_uplimit:rate_uplimit,
			deleted_flag:deleted_flag,
			valid_date:valid_date,
			invalid_date:invalid_date
		},function(data){
			alert(data);
			$('#modifyApprovingRateUplimitConfigWindow').window('close');
			clearForm("#apprvRateUplimitDiv");
			$('#tt').datagrid('reload');
		},'text')	
	}
	
	function clearApprovingRateUplimitConfigWin(){
		$('.orgName').val('');
		$('.licenseNo').val('');
		
	}
	/**逻辑删除,将active状态改成失效(0)*/
	function deleteApprovingRateUplimitConfig(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		var reqUrl = "<%=request.getContextPath()%>/approvingRateUplimitConfig/deleteApprovingRateUplimitConfig.do";
		$.post(reqUrl,{id:id},function(data){
			alert(data);
			$('#tt').datagrid('reload');
		},'text')
	}


	/**保存*/
	function saveApprovingRateUplimitConfig(data){
		if(data == '0'){//新增
			addApprovingRateUplimitConfigWindow();
		}else{//修改
			modifyApprovingRateUplimitConfigWindow();
		}
	}
	/**返回，关闭窗口*/	
	function cancelApprovingRateUplimitConfig(data){
		if(data == '0'){//新增
			$('#addApprovingRateUplimitConfigWindow').window('close');
		}else{//修改
			$('#modifyApprovingRateUplimitConfigWindow').window('close');
		}
		clearForm("#apprvRateUplimitDiv");
		$('#tt').datagrid('reload');
	}
	/**检查是否只选择了记录*/
    function checkSelected(){
    	var rows = $('#tt').datagrid('getSelections');
    	var length = rows.length;
		if (length == 0){
		    alert("请选择一条记录！");
		    return false;
		}else if(length > 1){ 
		    alert("请只选择一条记录！");
		    return false;
		}else{
		    return true;
		}
    }
	/**初始化*/
	$(function(){
		$("#tt").datagrid({
			url:"<%=request.getContextPath()%>/approvingRateUplimitConfig/queryApprovingRateUplimitConfig.do",
			onClickCell: function (rowIndex, field, value) { 
                if(field != 'orgId'){
                	$(this).datagrid('unselectAll');
                }
            },
            onDblClickRow:function(rowIndex, rowData) {
            	/*打开指定机构人员列表窗口*/
            	openApprovingRateUplimitConfigListWindow();
            }
		})
	})
	
	
	/**查询*/
	function executeQeury(){
		var reqUrl = '<%=request.getContextPath()%>/approvingRateUplimitConfig/queryApprovingRateUplimitConfig.do';
			var amt_uplimit = $('#amt_uplimit').val();
			var rate_uplimit = $('#rate_uplimit').val();
			$('#tt').datagrid({
				url : reqUrl,
				queryParams : {
					amt_uplimit : amt_uplimit,
					rate_uplimit : rate_uplimit,
				}
			})
		}
	
	function delRegion(orgId){
		if(!checkRegionSelected()){
			return;
		}
		if(!confirm("确定要删除数据吗？")){
			return false;
		}
		var row = $('#rt').datagrid('getSelected');
		var region = row.region;
		var reqUrl = '<%=request.getContextPath()%>/approvingRateUplimitConfig/queryApprovingRateUplimitConfig.do';
		$.post(reqUrl,{region: region, orgId:orgId},function(data){
			alert(data);
			$('#rt').datagrid('reload');
		},'text');
	}
	
	
	function checkRegionSelected(){
    	var rows = $('#rt').datagrid('getSelections');
    	var length = rows.length;
		if (length == 0){
		    alert("请选择一条记录！");
		    return false;
		}else if(length > 1){ 
		    alert("请只选择一条记录！");
		    return false;
		}else{
		    return true;
		}
    }
	
	function queryBlank(){
		$("#amt_uplimit").val("");
		$("#rate_uplimit").val("");
	}
	</script>
</head>
<body>
<div id="tb">
<fieldset>
	<legend class='dialog-label'>查询条件</legend>
		<table width="800" border="0" cellspacing="1" cellpadding="0">
		  <tr>
		    <td width="80" align="center">额度上限：</td>
		    <td width="180"><input id="amt_uplimit" name="regioncode" style="line-height:20px;border:1px solid #ccc"/></td>
		    <td width="80" align="center">利率上限：</td>
		    <td width="180"><input id="rate_uplimit" name="risktype" style="line-height:20px;border:1px solid #ccc"/></td>
		  </tr>
		  <tr><td colspan="6">&nbsp;</td></tr>
		  <tr>
		    <td colspan="6" align="center">
		    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="executeQeury()">查询</a>&nbsp;&nbsp;
		    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="queryBlank()">清空</a>&nbsp;&nbsp;
		    </td>
		  </tr>
		</table>
	</fieldset>
	<!-- 操作按钮 -->
		<div  style="padding: 5px; height: auto"> 
			<a href="javascript:void(0)" id="addExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-edit" onclick="openApprovingRateUplimitConfigWindow()">新增</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="modifyExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="openModifyApprovingRateUplimitConfigWindow()">修改</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="deleteExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="deleteApprovingRateUplimitConfig()">删除</a>&nbsp;&nbsp;<!-- 逻辑删除 -->
		</div>
</div>
	<!-- 机构列表 -->
	<table id="tt" title="Searching"
		iconCls="scon-search" toolbar="#tb" onclickRow="clickRow"
		rownumbers="true" pagination="true" singleSelect="true">
		<thead>
			<tr>
			<th field="id" checkbox="true"></th>
			<th field="amt_uplimit" width="80px">额度上限</th>
			<th field="rate_uplimit" width="150px">利率上限</th>
			<th field="deleted_flag" width="100px">是否生效</th>
			<th field="valid_date" width="100" formatter="dateFormat">生效时间</th>
			<th field="invalid_date" width="100" formatter="dateFormat">失效时间</th>
		</tr>
		</thead>
	</table>
	<!-- 新增窗口 -->
	<div id="addApprovingRateUplimitConfigWindow"></div>
	<!-- 修改窗口 -->
	<div id="modifyApprovingRateUplimitConfigWindow"></div>
	<!-- 删除窗口，逻辑删除 -->
	<div id="deleteApprovingRateUplimitConfigWindow"></div>
	<!-- 展业人员列表窗口 -->
	<div id="listExecutorsWindow"></div>
	<!-- 展业机构管理窗口 -->
	<div id="regionWindow"></div>
	
</body>
</html>