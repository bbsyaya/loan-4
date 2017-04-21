<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html lang="zh-CN"><!-- 指定页面语言 -->
<head>
	<title>展业机构管理</title>
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
	<script type="text/javascript">
	/*打开展业人员列表窗口*/
	function openExecutorListWindow(){
		if(!checkSelected){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var belongOrg = row.orgId;
		if(belongOrg == null || belongOrg==''){
			alert("机构编号为空");
			return;
		}
		var reqUrl = "<%=request.getContextPath()%>/bdManagement/bdExecutorWindow.do?belongOrg="+belongOrg;
		$('#listExecutorsWindow').openWin({
			title:'展业人员管理',
			maximized:false,
			width : 960,
			href:reqUrl
		})
	}
	/**打开新增展业机构窗口*/
	function openAddInstitutionWindow(){
		clearInstitutionWin();
		var reqUrpl = '<%=request.getContextPath()%>/bdManagement/openAddInstitutionWindow.do';
		$('#addInstitutionWindow').openWin({
			title:'新增展业机构',
			maximized:false,
			width:800,
			height:400,
			top:($(window).height()-400)/2,
			href:reqUrpl
		})
	}
	/**新增展业机构*/
	function addInstitutionWindow(){
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/addInstitutionWindow.do';
		var orgName =$('.orgName').val();
		var licenseNo =$('.licenseNo').val();
		var alias = $('.alias').val();
		var nameLR = $('.nameLR').val();
		var phoneNoLR = $('.phoneNoLR').val();
		var certNoLR = $('.certNoLR').val();
		var regAddress = $('.regAddress').val();
		var remark = $('.remark').val();
		var manager = $('.manager').val();
		var active = $('.active').val();
		var email = $('.email').val();
		if(typeof(orgName) == 'undefined' || $.trim(orgName) == ''){
			alert('机构名称不能为空');
			return;
		}
		if(typeof(alias) == 'undefined' || $.trim(alias) == ''){
			alert('机构简称不能为空');
			return;
		}
		$.post(reqUrl,{
			orgName:orgName,
			licenseNo:licenseNo,
			alias:alias,
			nameLR:nameLR,
			phoneNoLR:phoneNoLR,
			certNoLR:certNoLR,
			regAddress:regAddress,
			remark:remark,
			manager:manager,
			active:active,
			email:email
		},function(data){
			alert(data);
			$('#addInstitutionWindow').window('close');
			$('#tt').datagrid('reload');
		},'text')	
	}
	/**打开修改展业机构窗口*/
	function openModifyInstitutionWindow(){
		if(!checkSelected()){
			return;
		}
		clearInstitutionWin();
		var row = $('#tt').datagrid('getSelected');
		var orgId = row.orgId;
		var reqUrpl = '<%=request.getContextPath()%>/bdManagement/openModifyInstitutionWindow.do?orgId='+orgId;
		$('#modifyInstitutionWindow').openWin({
			title:'修改展业机构',
			maximized:false,
			width:800,
			height:400,
			top:($(window).height()-400)/2,
			href:reqUrpl
		})
	}
	/**修改展业机构*/
	function modifyInstitutionWindow(){
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/modifyInstitutionWindow.do';
		var orgId = $('#orgId').val();
		var orgName =$('.orgName').val();
		var licenseNo =$('.licenseNo').val();
		var alias = $('.alias').val();
		var nameLR = $('.nameLR').val();
		var phoneNoLR = $('.phoneNoLR').val();
		var certNoLR = $('.certNoLR').val();
		var regAddress = $('.regAddress').val();
		var remark = $('.remark').val();
		var manager = $('.manager').val();
		var active = $('.active').val();
		var email = $('.email').val();
		$.post(reqUrl,{
			orgId:orgId,
			orgName:orgName,
			licenseNo:licenseNo,
			alias:alias,
			nameLR:nameLR,
			phoneNoLR:phoneNoLR,
			certNoLR:certNoLR,
			regAddress:regAddress,
			remark:remark,
			manager:manager,
			active:active,
			email:email
		},function(data){
			alert(data);
			$('#modifyInstitutionWindow').window('close');
			$('#tt').datagrid('reload');
		},'text')	
	}
	
	function clearInstitutionWin(){
		$('.orgName').val('');
		$('.licenseNo').val('');
		$('.alias').val('');
		$('.nameLR').val('');
		$('.phoneNoLR').val('');
		$('.certNoLR').val('');
		$('.regAddress').val('');
		$('.remark').val('');
		$('.manager').val('');
		$('.active').val('');
	}
	/**逻辑删除,将active状态改成失效(0)*/
	function deleteInstitution(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var orgId = row.orgId;
		var reqUrl = "<%=request.getContextPath()%>/bdManagement/deleteInstitution.do";
		$.post(reqUrl,{orgId:orgId},function(data){
			alert(data);
			$('#tt').datagrid('reload');
		},'text')
	}
	/**激活,将active状态改成激活(1)*/
	function activeInstitution(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var orgId = row.orgId;
		var reqUrl = "<%=request.getContextPath()%>/bdManagement/activeInstitution.do";
		$.post(reqUrl,{orgId:orgId},function(data){
			alert(data);
			$('#tt').datagrid('reload');
		},'text')
	}
	/**打开展业区域管理窗口*/
	function openRegionWindow(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var orgId = row.orgId;
		var reqUrpl = '<%=request.getContextPath()%>/bdManagement/openRegionWindow.do?orgId='+orgId;
		$('#regionWindow').openWin({
			title:'展业区域管理',
			maximized:false,
			width:900,
			height:500,
			top:($(window).height()-500)/2,
			left:($(window).width()-900)/2,
			href:reqUrpl
		})
	}
	/**保存*/
	function saveInstitution(data){
		if(data == '0'){//新增
			addInstitutionWindow();
		}else{//修改
			modifyInstitutionWindow();
		}
	}
	/**返回，关闭窗口*/	
	function cancelInstitution(data){
		if(data == '0'){//新增
			$('#addInstitutionWindow').window('close');
		}else{//修改
			$('#modifyInstitutionWindow').window('close');
		}
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
			url:"<%=request.getContextPath()%>/bdManagement/queryBDInstitution.do",
			onClickCell: function (rowIndex, field, value) { 
                if(field != 'orgId'){
                	$(this).datagrid('unselectAll');
                }
            },
            onDblClickRow:function(rowIndex, rowData) {
            	/*打开指定机构人员列表窗口*/
            	openExecutorListWindow();
            },
            onCheck:function(index,row){
            	var active = row["active"];
            	if(typeof(active)!='undefined' && active!=""){
            		if('Y'==active){
            			$('#deleteBtn').linkbutton('enable');
            			$('#activeBtn').linkbutton('disable');
            		}else{
            			$('#deleteBtn').linkbutton('disable');
            			$('#activeBtn').linkbutton('enable');
            		}	
            	}else{
            		$('#deleteBtn').linkbutton('disable');
        			$('#activeBtn').linkbutton('enable');
            	}
            }
            
		})
	})
	
	/**根据省份获取下级市*/
	function provinceChange(){
		var provinceCode = $('#province').val();
		var url ="<%=request.getContextPath()%>/provinceCity/getCity.do";
		$.getJSON(url,{ itemNo: provinceCode },function(result){
			$("#city").empty();
			var html = "<option value=''>--请选择(市)--</option>"
		    $.each(result, function(i, field){
		    	var option = "<option value='"+ field.itemNo +"'>" + field.itemName + "</option>";
		    	html += option;
		    });
			$("#city").html(html);
		 });
	}
	
	function saveRegion(orgId){
		var url="<%=request.getContextPath()%>/bdManagement/addRegionConfig.do";
		var provinceCode = $('#province').val();
		var cityCode = $('#city').val();
		var sts = $('input[name="include"]:checked').val();
		var regionNo;
		if(provinceCode==''){
			alert("请选择省份！");
			return false;
		}
		if(sts==null){
			alert("请选择包含状态！");
			return false;
		}
		if(provinceCode!='' && cityCode==''){
			if(sts=='0'){
				alert("省份不可选择不包含！");
				return false;
			}
			regionNo = provinceCode;
		}
		
		if(cityCode!=''){
			regionNo = cityCode;
		}
		
		$.post(url,{regionNo: regionNo, include:sts,orgId:orgId},function(data){
			alert(data);
			$('#rt').datagrid('reload');
		},'text');
		
		
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
		var reqUrl = '<%=request.getContextPath()%>/bdManagement/delRegionConfig.do';
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
	
	
	</script>
</head>
<body>
	<div id="tb">
		<!-- 操作按钮 -->
		<div id="buttonDiv" style="padding: 5px; height: auto"> 
			<a href="javascript:void(0)" id="addBtn" width="100px" class="easyui-linkbutton" iconCls="icon-edit" onclick="openAddInstitutionWindow()">新增</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="modifyBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="openModifyInstitutionWindow()">修改</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="deleteBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="deleteInstitution()">失效</a>&nbsp;&nbsp;<!-- 逻辑删除 -->
	    	<a href="javascript:void(0)" id="activeBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="activeInstitution()">激活</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" id="regionBtn" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="openRegionWindow()">展业区域</a>
		</div>
	</div>
	<!-- 机构列表 -->
	<table id="tt" title="Searching"
		iconCls="scon-search" toolbar="#tb" onclickRow="clickRow"
		rownumbers="true" pagination="true" singleSelect="true">
		<thead>
			<tr>
				<th field="orgId" checkbox="true"></th>
				<th field="orgName" width="160px">机构名称</th>
				<th field="alias" width="60">简称</th>
				<th field="licenseNo" width="150px">机构执照编号</th>
				<th field="email" width="150px">联系邮箱</th>
				<!-- <th field="nameLR" width="60px">法人代表</th>
				<th field="phoneNoLR" width="100px">法人联系电话</th>
				<th field="certNoLR" width="150px">法人代表身份证</th> -->
				<th field="regAddress" width="200px">注册地址</th>
				<th field="remark" width="100px">备注</th>
				<th field="manager" width="60px">渠道经理</th>
				<th field="active" width="60px">状态</th>
			</tr> 
		</thead>
	</table>
	<!-- 新增窗口 -->
	<div id="addInstitutionWindow"></div>
	<!-- 修改窗口 -->
	<div id="modifyInstitutionWindow"></div>
	<!-- 删除窗口，逻辑删除 -->
	<div id="deleteInstitutionWindow"></div>
	<!-- 展业人员列表窗口 -->
	<div id="listExecutorsWindow"></div>
	<!-- 展业机构管理窗口 -->
	<div id="regionWindow"></div>
	
</body>
</html>