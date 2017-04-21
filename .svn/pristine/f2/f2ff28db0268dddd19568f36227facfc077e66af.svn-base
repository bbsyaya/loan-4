<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    	function queryPaybackImport(){
			var queryUrl="<%=request.getContextPath()%>/paybackImport/notMatchedPaybackImport.do?viewStatus=${viewStatus}";
			$('#tt').datagrid(
				{url:queryUrl,
			    queryParams:{
			    	paybackPersonName: $('#paybackPersonName').val(),
					paybackPersonAccount: $('#paybackPersonAccount').val(),
				}
			});
		}
    	
    	function executeQeury(){
    		var paybackPersonName = getTextValue("#paybackPersonName");
    		var paybackPersonAccount = getTextValue("#paybackPersonAccount");
    		if(paybackPersonName=="" 
    				&& paybackPersonAccount==""){
    			$.messager.alert("操作提示","请输入查询条件.","warning");
    			return ;
    		}
    		queryPaybackImport();
    	}
    	
    	/* 重置查询条件*/
    	function clearInfo(){
    		$('#paybackPersonName').val("");
    		$('#paybackPersonAccount').val("");
    	}
		
   		function openImportDetail(){
            var rows = $('#tt').datagrid('getSelections');
			var length = rows.length;
			if (length == 0){
			    alert("请选择一条记录！");
			    return;
			}else if(length > 1){ 
			    alert("请只选择一条记录！");
			    return;
			} 
        	$('#ImportDetailWindow').window('open'); 
        	initDetailTabImport();
    	}
   		
        function initDetailTabImport(){
             var row = $('#tt').datagrid('getSelected');
        	 $('.insertSignReceiptId').val(row.receiptId); 
             $('.insertSignCustName').val(row.custName);
             $('.insertSignPosCustName').val(row.posCustName);
             $('.insertSignLoanAmount').val(row.payApplyAmt);
             $('.insertSignLoanInterest').val(row.loanInterest);
             $('.insertSignBeginDate').val(row.beginDateStr);
             $('.insertSignEndDate').val(row.endDateStr);
             $('.insertSignPaybackWay').val(row.paybackWay);
             $('.insertSignLoanUsage').val(row.paybackWay);
        }
         
	       function openRelateReceipt(){
	    	    var rows = $('#tt').datagrid('getSelections');
				var length = rows.length;
				if (length == 0){
				    alert("请选择一条记录！");
				    return;
				}else if(length > 1){ 
				    alert("请只选择一条记录！");
				    return;
				} 
				var row = $('#tt').datagrid('getSelected');
				var custId = row.matchedCustId;
				var a = row.importRunningId;
				window.location.href="<%=request.getContextPath()%>/paybackImport/relateReceipt.do?custId="+custId+"&importRunningId="+a;
	    	   
	       }
		 
		$(function() {
			<%
	    	com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
	    	String viewStatus = (String)session.getAttribute("viewStatus");
	    	if(!access.hasAnyPrivilege("ROLE_REPAY_QUERY") || (viewStatus!=null && !viewStatus.equals("99"))){	//具有全量查询权限时,初始化不进行查询
	    	%>
	    	queryPaybackImport();
	    	<%}%>
	    	
		    modifyPaybackDetailWindow();
        	$('#tt').datagrid({
    		onClickCell: function (rowIndex, field, value) { 
                if(field != 'id'){
                	$(this).datagrid('unselectAll');
                }
            },
    	});
        }); 
    
    </script>
  </head>
  
  <body>


	
	<div id="tb" style="padding:5px;height:auto">  
		<div id="tb">
		
		  <a href="javascript:void(0)" id="01" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="openImportDetail()">进项详情</a> 
		  <c:if test="${viewStatus == '01'}">
		  <a href="javascript:void(0)" id="02" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="openRelateReceipt()">关联借据</a>
		  </c:if>
		</div>  
		<div id="tb" style="padding:3px">
			<span>付款人名称:</span>
			<input id="paybackPersonName" name="paybackPersonName" style="line-height:20px;border:1px solid #ccc"/>
			<span>付款人账号:</span>
			<input id="paybackPersonAccount" name="paybackPersonAccount" style="line-height:20px;border:1px solid #ccc"/>
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="clearInfo()">清空</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="executeQeury()">查询</a>
		</div>
	</div>  
    <table id="tt" class="easyui-datagrid" style="width:1500px;height:800px"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
			   
			    <th field="id" checkbox="true"></th>
			    <th field="importRunningDate" width="120" formatter="dateFormat">进项日期</th> 
			    <th field="paybackPersonName" width="120">付款人名称</th> 
			    <th field="importAmount" width="120" align="right" formatter="formatMoney">进项金额</th> 
			    <th field="moneyKind" width="120">币种</th> 
			    <th field="paybackPersonAcount" width="120">付款人账号</th> 
			    <th field="delegateTime" width="120" hidden="true">委托时间</th> 
			    <th field="notAllocateAmount" width="120" align="right" formatter="formatMoney">未分配金额</th>
			    <th field="matchedCustId" width="120">关联客户编号</th> 
			    <th field="importRunningId" width="120" hidden="true">进项流水编号</th> 
			</tr>
		</thead>
	</table> 
      <jsp:include page="paybackImportInfo.jsp"></jsp:include> 
  </body>
</html>
