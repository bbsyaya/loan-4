<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html lang="zh-CN"><!-- 指定页面语言 -->
<head>
	<title>展业人员管理</title>
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
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxfilesupload.js"></script>
	<script type="text/javascript">
	/**初始化*/
	$(function(){
		$("#executorTT").datagrid({
			url:"<%=request.getContextPath()%>/bdManagement/queryBDExecutor.do?belongOrg=${belongOrg}",
			onClickCell: function (rowIndex, field, value) { 
	            if(field != 'menberId'){
	            	$(this).datagrid('unselectAll');
	            }
	        },
	        onCheck:function(index,row){
	        	var active = row["active"];
	        	if(typeof(active)!='undefined' && active!=""){
	        		if('Y'==active){
	        			$('#deleteExecutorBtn').linkbutton('enable');
	        			$('#activeExecutorBtn').linkbutton('disable');
	        		}else{
	        			$('#deleteExecutorBtn').linkbutton('disable');
	        			$('#activeExecutorBtn').linkbutton('enable');
	        		}	
	        	}else{
	        		$('#deleteExecutorBtn').linkbutton('disable');
	    			$('#activeExecutorBtn').linkbutton('disable');
	        	}
	        },
	        singleSelect:true
	        
		})
	})

	
	/**打开新增展业人员窗口*/
	function openAddExecutorWindow(){
		clearExecutorWin();
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/openAddExecutorWindow.do';
		$('#addExecutorWindow').openWin({
			title:'新增展业人员',
			width:800,
			href:reqUrl
		})
	}

	/**打开修改展业人员窗口*/
	function openModifyExecutorWindow(){
		clearExecutorWin();
		if(!checkSelected()){
			return;
		}
		var row = $('#executorTT').datagrid('getSelected');
		var menberId = row.menberId;
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/openModifyExecutorWindow.do?menberId='+menberId;
		$('#modifyExecutorWindow').openWin({
			title:'修改展业人员',
			width:800,
			href:reqUrl
		})
	}
	
	/**保存*/
	function saveExecutor(data){
		if(data == '0'){//新增
			addExecutorWindow();
		}else{//修改
			modifyExecutorWindow();
		}
	}
	/**清空*/
	function clearExecutorWin(){
		$('.menberName').val('');
		$('.certNo').val('');
		$('.birthDate').val('');
		$('.sex').val('');
		$('.contactNo').val('');
		$('.belongOrg').val('');
		$('.email').val('');
		$('.address').val('');
		$('.remark').val('');
		$('.active').val('');
	}
	/**新增展业人员*/
	function addExecutorWindow(){
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/addExecutorWindow.do';
		var menberName = $('.menberName').val();
		var certNo = $('.certNo').val();
		var birthDate = $('.birthDate').val();
		var sex = $('.sex').val();
		var contactNo = $('.contactNo').val();
		var belongOrg = $('.belongOrg').val();
		var email = $('.email').val();
		var address = $('.address').val();
		var remark = $('.remark').val();
		var active = $('.active').val();
		$.post(reqUrl,{
			menberName:menberName,
			certNo:certNo,
			birthDate:birthDate,
			sex:sex,
			contactNo:contactNo,
			belongOrg:belongOrg,
			email:email,
			address:address,
			remark:remark,
			active:active
		},function(data){
			alert(data);
			$('#addExecutorWindow').window('close');
			$('#executorTT').datagrid('reload');
		},'text')
	}
	/**修改展业人员*/
	function modifyExecutorWindow(){
		if(!checkSelected()){
			return;
		}
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/modifyExecutorWindow.do';
		var row = $('#executorTT').datagrid('getSelected');
		var menberId = row.menberId;
		var menberName = $('.menberName').val();
		var certNo = $('.certNo').val();
		var birthDate = $('.birthDate').val();
		var sex = $('.sex').val();
		var contactNo = $('.contactNo').val();
		var belongOrg = $('.belongOrg').val();
		var email = $('.email').val();
		var address = $('.address').val();
		var remark = $('.remark').val();
		var active = $('.active').val();
		$.post(reqUrl,{
			menberId:menberId,
			menberName:menberName,
			certNo:certNo,
			birthDate:birthDate,
			sex:sex,
			contactNo:contactNo,
			belongOrg:belongOrg,
			email:email,
			address:address,
			remark:remark,
			active:active
		},function(data){
			alert(data);
			$('#modifyExecutorWindow').window('close');
			$('#executorTT').datagrid('reload');
		},'text')
	}
	
	/**激活*/
	function activeExecutor(){
		if(!checkSelected()){
			return;
		}
		var row = $('#executorTT').datagrid('getSelected');
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/activeExecutor.do';
		$.post(reqUrl,{menberId:row.menberId},function(data){
			alert(data);
			$('#executorTT').datagrid('reload');
		},'text')
	}
	/**删除*/
	function deleteExecutor(){
		if(!checkSelected()){
			return ;
		}
		var row = $('#executorTT').datagrid('getSelected');
		var reqUrl= '<%=request.getContextPath()%>/bdManagement/deleteExecutor.do';
		$.post(reqUrl,{menberId:row.menberId},function(data){
			alert(data);
			$('#executorTT').datagrid('reload');
		},'text')
	}
	/**检查是否只选择了记录*/
    function checkSelected(){
    	var rows = $('#executorTT').datagrid('getSelections');
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
	/**批量导入*/
	function importExecutorBatch(){
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/excelImportWindow.do';
		$('#execlImportWindow').openWin({
			title:'文件选择',
			width :500,
			height:200,
			href:reqUrl
			})
	}
	
	/**确认导入*/
	function confirm(){
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/confirm.do';
	 	$.messager.progress({
            text: '文件导入中，请稍等......',
        }); 
		$.ajaxFileUpload({
            url: reqUrl,
            secureuri: false, //安全协议
            fileElementId: ['excelImportBatch'], //文件ID
            dataType:'json', //服务器返回的格式,可以是json或xml等
	        success:function(data){//服务器响应成功时的处理函数
	        	$.messager.progress('close'); 
	            if(data.resultCode == "000"){
	                alert(data.resultMsg);
	            }else {
	            	alert(data.resultMsg);
            	} 
	            $('#execlImportWindow').window('close');
        	}}
		)
	}
	/**查询*/
	function executeQeury(){
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/queryBDExecutor.do';
			var menberName = $('#searchMenberName').val();
			var certNo = $('#searchCertNo').val();
			var belongOrg = $('#searchBelongOrg').val();
			$('#executorTT').datagrid({
				url : reqUrl,
				queryParams : {
					menberName : menberName,
					certNo : certNo,
					belongOrg : belongOrg
				}
			})
		}
	
	/*清空查询条件*/
	function queryBlank() {
		$('#searchMenberName').val('');
		$('#searchCertNo').val('');
		$('#searchBelongOrg').val('');
	}
	</script>
</head>
<body>
<div id="executorTB">
	<!-- 查询条件 -->
	<fieldset>
	<legend class='dialog-label'>查询条件</legend>
		<table width="800" border="0" cellspacing="1" cellpadding="0">
		  <tr>
		    <td width="80" align="center">姓名：</td>
		    <td width="180"><input id="searchMenberName" name="searchMenberName" style="line-height:20px;border:1px solid #ccc"/></td>
		    <td width="80" align="center">身份证号：</td>
		    <td width="180"><input id="searchCertNo" name="searchCertNo" style="line-height:20px;border:1px solid #ccc"/></td>
		    <td width="80" align="center">展业机构：</td>
		    <td width="180">
		    	<select id="searchBelongOrg">
		    		<c:forEach items="${institutions}" var="i">
		    			<option value="${i.orgId}">${i.alias}</option>
		    		</c:forEach>
		   	 	</select>
	   	 	</td>
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
			<a href="javascript:void(0)" id="addExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-edit" onclick="openAddExecutorWindow()">新增</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="modifyExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="openModifyExecutorWindow()">修改</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="deleteExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="deleteExecutor()">失效</a>&nbsp;&nbsp;<!-- 逻辑删除 -->
	    	<a href="javascript:void(0)" id="activeExecutorBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="activeExecutor()">激活</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="importExecutorBatch" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="importExecutorBatch()">批量导入</a>
		</div>
</div>
<!-- 机构人员列表 -->
<table id="executorTT"  title="Searching" iconCls="scon-search" toolbar="#executorTB" onclickRow="clickRow"
	rownumbers="true" pagination="true" >
	<thead>
		<tr>
			<th field="menberId" checkbox="true"></th>
			<th field="menberName" width="80px">人员名称</th>
			<th field="certNo" width="150px">身份证号</th>
			<th field="birthDate" width="100" formatter="dateFormat">出生日期</th>
			<th field="contactNo" width="100px">联系电话</th>
			<th field="email" width="160px">邮箱</th>
			<th field="address" width="160px">地址</th>
			<th field="remark" width="160px">备注</th>
			<th field="active" width="50px">状态</th>
			<th field="modifyTime" formatter="dateFormat">修改时间</th>
		</tr>
	</thead>
</table>
	<!-- 新增窗口 -->
	<div id="addExecutorWindow"></div>
	<!-- 修改窗口 -->
	<div id="modifyExecutorWindow"></div>
	<!-- 展业人员批量导入窗口 -->
	<div id="execlImportWindow"></div>
</body>
