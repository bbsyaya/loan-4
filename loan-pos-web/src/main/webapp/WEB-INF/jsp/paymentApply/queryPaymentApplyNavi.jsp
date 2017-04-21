<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/validator.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/calendar.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
	<script type="text/javascript">
	
	/* 根据条件查询 */
	function queryPaymentApply(){
		var queryUrl="<%=request.getContextPath()%>/paymentApply/queryPaymentApply.do?paymentStatus=${paymentStatus}&excuteStatus=${excuteStatus}"
		$('#tt').datagrid(
			{url:queryUrl,
		    queryParams:{
		    	searchContNoLike: $('#searchContNoLike').val(),
				searchPosCustNameLike: $('#searchPosCustNameLike').val(),
				searchCustNameLike: $('#searchCustNameLike').val(),
				searchPaperIdLike: $('#searchPaperIdLike').val(),
			}
		});
	}
	
	function executeQeury(){
		var searchContNoLike = getTextValue("#searchContNoLike");
		var searchPosCustNameLike = getTextValue("#searchPosCustNameLike");
		var searchCustNameLike = getTextValue("#searchCustNameLike");
		var searchPaperIdLike = getTextValue("#searchPaperIdLike");
		
		if(searchContNoLike=="" 
				&& searchPosCustNameLike==""
				&& searchCustNameLike==""
				&& searchPaperIdLike==""){
			$.messager.alert("操作提示","请输入查询条件.","warning");
			return ;
		}
		queryPaymentApply();
	}
	
	/* 重置查询条件	 */
	function queryBlank(){
		$('#searchContNoLike').val("");
		$('#searchPosCustNameLike').val("");
		$('#searchCustNameLike').val("");
		$('#searchPaperIdLike').val("");
		//queryPaymentApply();
	}
	
	//开启窗口
	function openCreatePaymentApply(){
		 $('#createPaymentApply').openWin({
				title:'请选择要用款的授信协议',
				maximized:false,
				href:'openCreatePaymentApply.do?status=00&direct2Path=paymentApply/createPaymentApply/availableCreditAgreement',
				}); 
	}
	
	/* 根据条件查询 */
	function queryAvailableAgreements(){
		$('#agreementTT').datagrid('load',{
			contNoLike: $('#contNoLike').val(),
			posCustNameLike: $('#posCustNameLike').val(),
			custNameLike: $('#custNameLike').val(),
			paperIdLike: $('#paperIdLike').val(),
		});
	}
	/* 条件清空 */
	function queryAvailableAgreementsBlank(){
		 $('#contNoLike').val('');
		 $('#posCustNameLike').val('');
		 $('#custNameLike').val('');
		 $('#paperIdLike').val('');
		 queryAvailableAgreements('');
	}
	//申请详情
	function detailPaymentApply(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var payApplyId = row.payApplyId;
		$('#detailPaymentApply').openWin({
			title:'用款详情-基本信息',
			href:'<%=request.getContextPath()%>/paymentApply/openDetailPaymentApply.do?payApplyId='+payApplyId+'&direct2Path=paymentApply/detailPaymentApply/detailPaymentApplyMain'
		})
		
	}
	//关闭详情窗口
	function colseDetailPaymentApply(){
		$("#detailPaymentApply").window("close");
	}
	//提交审核
	function submitPaymentApply(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var payApplyId = row.payApplyId;
		var reqUrl = "<%=request.getContextPath()%>/paymentApply/submitPaymentApply.do";
		if(confirm("确定要提交该笔用款申请？")){
			$.post(reqUrl,{payApplyId:payApplyId},function(data){
				alert(data);
				$('#tt').datagrid("reload");
			},'text');
		}
	}
	//取消申请
	function cancelPaymentApply(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var payApplyId = row.payApplyId;
		$('#cancelPaymentApply').openWin({
			title:'取消用款',
			href:'openCancelPaymentApply.do?payApplyId='+payApplyId+'&direct2Path=paymentApply/editPaymentApply/cancelPaymentApplyMain'
		})
		
	}
	//确认取消
	function confirmCancelPaymentApply(){
		var reqUrl = "<%=request.getContextPath()%>/paymentApply/cancelPaymentApply.do";
		var cancelPayApplyId = $("#cancelPayApplyId").val();
		if(confirm("确定要取消该笔用款申请？")){
			$.post(reqUrl,{cancelPayApplyId:cancelPayApplyId},function(data){
				alert(data);
				$("#cancelPaymentApply").window('close');
				$('#tt').datagrid('reload');
			},'text');
		}
	}
	// 发送用款指令
	function excutePayment(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid('getSelected');
		var payApplyId = row.payApplyId;
		
		$('#submitPaymentApply').openWin({
			title:'用款详情-基本信息',
			href:'<%=request.getContextPath()%>/paymentApply/openDetailPaymentApply.do?payApplyId='+payApplyId+'&direct2Path=paymentReview/TransferExecView'
		})
		
	}
	
	function colseSubmitPayment(){
		$("#submitPaymentApply").window("close");
	}
	
	function excuteTransfer(){
		var payApplyId = getTextValue("#payApplyId");
		var payChannel = getTextValue("#payChannel");
		
		$.messager.progress({
 	        text: '放款指令执行中，请等待......',
 	    }); 
		var reqUrl = "<%=request.getContextPath()%>/paymentReview/madeLoanExecute.do";
		$.post(reqUrl,
			{payApplyId:payApplyId,payChannel:payChannel},
			function(data){
			$.messager.progress('close');
			alert(data.resMessage);
			if(typeof(data.resCode)!="undefined" && data.resCode=="000"){
				colseSubmitPayment();		//发送成功后关闭窗口
			}
			$('#tt').datagrid('reload');
		},'json');
		
	}
	
	//判断是否选中记录
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
	//
    $(function() {
    	<%
    	com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
    	String paymentStatus = (String)session.getAttribute("paymentStatus");
    	if(!access.hasAnyPrivilege("ROLE_ISSUE_QUERY") || (paymentStatus!=null && !paymentStatus.equals("99"))){	//具有全量查询权限时,初始化不进行查询
    	%>
    		queryPaymentApply();
    	<%}%>
    	
    	$('#tt').datagrid({
    		onClickCell: function (rowIndex, field, value) { 
                if(field != 'id'){
                	$(this).datagrid('unselectAll');
                }
            },
    	});
    });

	//开启新增用款申请窗口
    function insertPaymentApply(){
		if(!checkAgreementSelected()){
			return;
		}
		var row = $('#agreementTT').datagrid('getSelected');
		var contNo = row.contNo;
		$('#insert').openWin({
			title:'新增用款申请',
			maximized:false,
			//width:800,
			href:'openInsertPaymentApply.do?contNo='+contNo,
		});
	}	
	
    function closeAgreementWin(){
    	$('#createPaymentApply').window('close');
	}
    
	//关闭新增用款申请窗口
	function closeInsertPaymentApply(){
		$('#insert').window('close');
	}
	//保存用款申请
	function savePaymentApply(){
		var reqUrl = "<%=request.getContextPath()%>/paymentApply/savePaymentApply.do";
		//合同号
		var contNo = $("#contNo").val();
		var payApplyAmt = $("#payApplyAmt").val();
		var payApplyTerm = $("#payApplyTerm").val();
		var expectedDate = $("#expectedDate").datebox('getValue');
		var expectedEndDate = $("#expectedEndDate").val();
		var payApplyInterest = $("#payApplyInterest").val();
		var returnType = $("#returnType").val();
		var accNo = $("#accNo").val();
		if(payApplyAmt.trim() == "" || payApplyTerm == ""){
			alert('用款金额或者用款期限不能为空');
			return;
		}
		$.post(reqUrl,{contNo:contNo,
			payApplyAmt:payApplyAmt,
			payApplyTerm:payApplyTerm,
			payApplyInterest:payApplyInterest,
			expectedDate:expectedDate,
			expectedEndDate:expectedEndDate,
			returnType:returnType,
			accNo:accNo},
			function(data){
				alert(data);
				closeInsertPaymentApply();
				$('#agreementTT').datagrid('reload');
				$('#createPaymentApply').window('close');
				window.location.reload();
				$('#tt').datagrid('reload');
		},'text');
	}
	//检查是否只选择了记录
    function checkAgreementSelected(){
	   	var rows = $('#agreementTT').datagrid('getSelections');
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
	//计算用款到期日
	function calculateExpectedEndDate(){
		var reqUrl = '<%=request.getContextPath()%>/paymentApply/calculateDate.do';
		//期望用款日
		var expectedDate = $("#expectedDate").datebox('getValue');
		//用款期限
		var payApplyTerm = $("#payApplyTerm").val().trim();
		//还款方式
		var returnType = $("#returnType").val().trim();
		
		if(payApplyTerm>3){
			$.messager.alert("用款期限最长为3个月!","error");
			return;
		}
		$.post(reqUrl,{
			expectedDate: expectedDate,
			payApplyTerm: payApplyTerm,
			paybackMethod: returnType
		},
		function(data){
			setTextValue("#expectedEndDate",data);
		},'text')
	}
	
	function varifyStartDate(date){
		var dateStr = timeStamp2String(date);
		var reqUrl = '<%=request.getContextPath()%>/genericConfig/getWorkingDate.do';
		$.post(reqUrl,{
			sourceDate: dateStr,
		},
		function(data){
			if(typeof(data)!="undefined" && data!=dateStr){
				alert("期望用款日期请选择工作日");
				$("#expectedDate").datebox('setValue',data);
				calculateExpectedEndDate();
			}
		},'text')
	}
	</script>
</head>
<body>
	<table id="tt" title="用款申请管理" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow" rownumbers="true" pagination="true">
		<thead>
			<tr>
			    <th field="id" checkbox="true"></th>
			    <th field="payApplyId" width="150px">用款编号</th>
				<th field="channelName" width="60px">业务渠道</th>
				<th field="custName" width="80px">客户名称</th>
				<th field="paperId" width="140px">证件号码</th>
				<th field="posCustName" width="200px">商户名称</th>
				<th field="payApplyAmt" align="right" formatter="formatMoney" width="80px">用款金额</th>
				<th field="payApplyInterest" width="80px" align="right" formatter="formatRate">用款利率</th>
				<th field="payApplyTerm" width="60px"  align="right"formatter="formatTerm">用款期限</th>
				<c:choose>
				<c:when test="${paymentStatus == '90'}">
					<th field="apprBeginDate" width="80px" align="center" formatter="dateFormat">用款起始日期</th>
					<th field="apprEndDate" width="80px" align="center" formatter="dateFormat">用款到期日期</th>
				</c:when>
				<c:otherwise>
					<th field="expectedDate" width="80px" align="center">期望用款日期</th>
					<th field="expectedEndDate" width="80px" align="center">用款到期日</th>
   				</c:otherwise>
				</c:choose>
				<th field="issueStatusName" width="80px" align="center">申请状态</th>
				 <c:if test="${paymentStatus == '90'}">
				<th field="loanExecuteStatusName" width="110px">用款执行状态</th>
				</c:if>
				<th field="applyDate" width="80px" align="center">申请日期</th>
			</tr>	
		</thead>
	</table>
	<div id="createPaymentApply"></div>	<!-- 提起用款 -->
	<div id="detailPaymentApply"></div>	<!-- 申请详情 -->
	<div id="submitPaymentApply"></div>	<!-- 提交审核 -->
	<div id="cancelPaymentApply"></div>	<!-- 取消用款 -->
	<jsp:include page="searchPayment.jsp"/> <!-- 搜索条件 -->
	<div id="insert"></div>		<!-- 要放在Root-Page,否则在二次进入会js失效 -->
</body>
</html>