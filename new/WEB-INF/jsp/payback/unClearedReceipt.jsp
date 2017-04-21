<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>未结清业务</title>
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
			var queryUrl="<%=request.getContextPath()%>/payback/queryPaybackInfo.do?clearStatus=${clearStatus}";
			$('#tt').datagrid(
				{url:queryUrl,
			    queryParams:{
			    	ReceiptIdLike: $('#ReceiptId').val(),
					custNameLike: $('#custName').val(),
					merchantNameLike: $('#merchantName').val(),
					custIdNoLike: $('#custIdNo').val(),
				},
				singleSelect:true
			});
		}
    	
    	function executeQeury(){
    		var receiptId = getTextValue("#ReceiptId");
    		var custName = getTextValue("#custName");
    		var merchantName = getTextValue("#merchantName");
    		var custIdNo = getTextValue("#custIdNo");
    		if(receiptId=="" 
    				&& custName==""
    				&& merchantName==""
    				&& custIdNo==""){
    			$.messager.alert("操作提示","请输入查询条件.","warning");
    			return ;
    		}
    		queryContractManagement();
    	}
		
    	function openReceiptDetail(){
            var rows = $('#tt').datagrid('getSelections');
			var length = rows.length;
			if (length == 0){
			    alert("请选择一条记录！");
			    return;
			}else if(length > 1){ 
			    alert("请只选择一条记录！");
			    return;
			} 
        	$('#ReceiptRelatedInfoWindow').window('open'); 
        	var row = $('#tt').datagrid('getSelected');
        	initDetailTabReceipt(row.receiptId);
	        initDetailTabContract(row.contNo);
			initDetailTabCustomer(row.contNo);
    }
        function initDetailTabReceipt(receiptId){
            /*  var row = $('#tt').datagrid('getSelected');
        	 $('.insertSignReceiptId').val(row.receiptId); 
             $('.insertSignCustName').val(row.custName);
             $('.insertSignPosCustName').val(row.posCustName);
             $('.insertSignLoanAmount').val(row.payApplyAmt);
             $('.insertSignLoanInterest').val(row.loanInterest);
             $('.insertSignBeginDate').val(row.beginDateStr);
             $('.insertSignEndDate').val(row.endDateStr);
             $('.insertSignPaybackWay').val(row.paybackWay);
             $('.insertSignLoanUsage').val(row.paybackWay); */
             
             
             var reqUrl = "<%=request.getContextPath()%>/payback/getReceiptInfo.do";
				$.post(reqUrl, {receiptId: receiptId}, function(obj){
					var obj = eval('(' +obj+')');
					 $('.insertSignReceiptId').val(obj.receiptId); 
					 $('.insertSignBusinessChannel').val(obj.channel);
		             $('.insertSignCustName').val(obj.custName);
		             $('.insertSignPosCustName').val(obj.posCustName);
		             $('.insertSignLoanAmount').val(obj.payApplyAmt);
		             $('.insertSignLoanInterest').val(obj.loanInterest);
		             $('.insertSignBeginDate').val(obj.beginDate);
		             $('.insertSignEndDate').val(obj.endDate);
		             $('.insertSignPaybackWay').val(obj.paybackMethod);
		             $('.insertSignLoanUsage').val(obj.loanUsage);
		             
		             $('.insertSignPaybackAccount').val(obj.payAccount);
		             $('.insertSignAccountOpenBank').val(obj.accountOpenBank);
		             $('.insertSignAccountBranchBank').val(obj.accountBranckBank);
		             $('.insertSignAccountSubBranchBank').val(obj.accountSubBranchBank);
		             $('.insertSignLoanTotalBalance').val(obj.loanTotalBalance);
		             $('.insertSignNormalBalance').val(obj.normalBalance);
		             $('.insertSignOverdueBalance').val(obj.overdueBalance);
		             $('.insertSignInnerOwnedInterest').val(obj.innerOwnedInterest);
		             $('.insertSignOutterOwnedInterest').val(obj.outterOwnedInterest);
		          
			
				});  	
				
				
             
        }
         
        function initDetailTabContract(contNo){
        var reqUrl = "<%=request.getContextPath()%>/payback/getContractInfo.do";
			$.post(reqUrl, {contNo: contNo}, function(data){
				var obj = eval('(' +data+')');
				$('.insertSignChannelName').val(obj.channel);
				$('.insertSignImportWay').val(obj.inChannelKind);
				$('.insertSignCustName').val(obj.custName);
				$('.insertSignPosCustName').val(obj.posCustName);
				$('.insertSignProdName').val(obj.prodName);
				$('.insertSignPaybackMethod').val(obj.paybackMethod);
				$('.insertSignApproveAmount').val(obj.apprTotalAmt);
				$('.insertSignApproveMoneyKind').val(obj.approveMoneyKind);
				$('.insertSignApproveInterest').val(obj.approveInterest);
				$('.insertSignApproveTerm').val(obj.contTerm);
			    $('.insertSignAccountOpenBank').val(obj.accountOpenBank);
			    $('.insertSignAcceptAccount').val(obj.acceptAccount);
			    $('.insertSignAccountBranchBank').val(obj.accountBranchBank);
			    $('.insertSignAccountSubBranchBank').val(obj.accountSubBranchBank);
			    $('.insertSignContractBeginDate').val(obj.beginDateStr);
			    $('.insertSignContractEndDate').val(obj.endDateStr);
			    $('.insertSignDate').val(obj.signDateStr);
			});  	
    
        } 
      
  
	     
	      function initDetailTabCustomer(contNo){	
			var reqUrl = "<%=request.getContextPath()%>/payback/getCustomerInfo.do";
			$.post(reqUrl, {contNo: contNo}, function(data){
				var obj = eval('(' +data+')');
				$('.insertSignCustId').val(obj.custId);
				$('.insertSignCustName').val(obj.custName);
				$('.insertSignCredentialtype').val(obj.paperKind);
				$('.insertSignCredentialNo').val(obj.paperId);
				$('.insertSignCredentialtype').val(obj.paperKind);
				$('.insertSignBirthDate').val(obj.birtDateStr);
				$('.insertSignGender').val(obj.sexSign);
				$('.insertSignMarriageStatus').val(obj.marrSign);
				$('.insertSignHighestDegree').val(obj.educSign);
				$('.insertSignPermanentAddress').val(obj.regiSeat);
			 	$('.insertSignNation').val(obj.natiSign1);
				$('.insertSignProvince').val(obj.residentProv); 
				$('.insertSignCity').val(obj.residentCity); 
				$('.insertSignDivision').val(obj.residentDivision); 
				$('.insertSignDetailedAddress').val(obj.residentDetail);
				$('.insertSignCellphoneNo').val(obj.mobilePhone);
				$('.insertSignOfficeTel').val(obj.tel);
				$('.insertSignWechatNo').val(obj.weixinNo);
				$('.insertSignChildrenNo').val(obj.childNum);
				$('.insertSignQQNo').val(obj.qqNo);
				$('.insertSignEmailAddress').val(obj.email);
			});  	
	    }
    
    
    	function openPayback(){
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
			if(row.loanPaybackWay=="01"){
			$('#PaybackConfirm').hide();
			}
			$('#PaybackInfoWindow').window('open'); 
			
			$("#insertPaybackAmount").blur(function(){
			if( $('#insertPaybackAmount').val()==null|| $('#insertPaybackAmount').val()==""){
			 alert("请输入还款金额");
			 return;
			}
	         paybackCalculate();
	           });
						
        	initPaybackApply();
        	initDetailTabReceipt();
			initDetailTabCustomer(row.contNo);
    	}
    
    
       	function paybackAdvance(){
           var row = $('#tt').datagrid('getSelected');
           $('#insertPaybackAmount').focus();
           $('#insertPaybackAmount').val(row.loanTotalBalance); 
           $('#insertPaybackPrincipal').val(row.loanTotalBalance); 
           }
           
           function totalBalance(){
           $('#insertPaybackAmount').val(); 
           $('#insertPaybackPrincipal').val(); 
       	  }
           
           function defineCapital(){
        	   $('#insertPaybackAmount').val(); 
               $('#insertPaybackPrincipal').val(); 
        	   
           }
           
           function paybackConfirm(){
        	   $('#winConfirm').window('open'); 
       	}
           
           function confirm(){
        	   var reqUrl = "<%=request.getContextPath()%>/paybackApply/savePaybackApply.do";
        	   var row = $('#tt').datagrid('getSelected');
        	   var receiptId = row.receiptId;
        	   var insertLoanBalance = $('#insertLoanBalance').val();
        	   var insertPaybackWay = $('#insertPaybackWay').val();
        	   var insertExpectPaybackDate = $('#insertExpectPaybackDate').val();
        	   var insertLoanPaybackWay = $('#insertLoanPaybackWay').val();
        	   var kind = $('input[name="kind"]:checked').val();
        	   var insertPaybackAmount = $('#insertPaybackAmount').val();
        	   var insertPaybackPrincipal = $('#insertPaybackPrincipal').val();
        	   var insertPaybackInterest = $('#insertPaybackInterest').val();
        	   var insertPaybackTotalAmount = $('#insertPaybackTotalAmount').val();
        	   $.post(reqUrl,
       			   {receiptId: receiptId,
        		   insertLoanBalance: insertLoanBalance,
        		   insertPaybackWay: insertPaybackWay,
        		   insertExpectPaybackDate: insertExpectPaybackDate,
        		   insertLoanPaybackWay: insertLoanPaybackWay,
        		   kind: kind,
        		   insertPaybackAmount: insertPaybackAmount,
        		   insertPaybackPrincipal: insertPaybackPrincipal,
        		   insertPaybackInterest:insertPaybackInterest,
        		   insertPaybackTotalAmount:insertPaybackTotalAmount },
       			   function(data){
       				   alert("还款申请成功");
       				 $('#winConfirm').window('close'); 
       				closePayback();
       			   });
           }
           
           function cancel(){
        	   $('#winConfirm').window('close'); 
           }
		    function initPaybackApply(){
		    var row = $('#tt').datagrid('getSelected');
		    $('#insertLoanBalance').val(row.loanTotalBalance); 
		    $('#insertPaybackWay').val(row.paybackWay);
		    $('#insertLoanPaybackWay').val(row.loanPaybackWay);
		    
		    }
    
		    function closePayback(){
		    $('#PaybackInfoWindow').window('close'); 
		    }
    
    
		    function paybackCalculate(){
		    var reqUrl = "<%=request.getContextPath()%>/payback/paybackCalculate.do";
			var row = $('#tt').datagrid('getSelected');
			var totalamount = row.loanTotalBalance;
			var amount =$('#insertPaybackAmount').val();
			var paybackDate =$('#insertExpectPaybackDate').val();
			var paybackCapitalType=$('input:radio[name="kind"]:checked').val();
			$.post(reqUrl, {amount: amount,
				paybackCapitalType:paybackCapitalType,
				loanAcNo:row.loanAcNo,
				loanTotalBalance:totalamount,
				custId:row.custId,
				custName:row.custName,
				receiptId:row.receiptId,
				paybackDate:paybackDate}, 
					function(data){
				var obj = data;
				if(paybackCapitalType=="1"){
					$('#insertPaybackPrincipal').val(obj.capital);
					$('#insertPaybackInterest').val(obj.interest);
					$('#insertPaybackTotalAmount').val(obj.totalAmount);
				}else if(paybackCapitalType=="2"){
					$('#insertPaybackInterest').val(obj.interest);
					$('#insertPaybackTotalAmount').val(obj.totalAmount);
					
				}else{
					$('#insertPaybackPrincipal').val(obj.capital);
					$('#insertPaybackInterest').val(obj.interest);
					$('#insertPaybackTotalAmount').val(obj.totalAmount);
					
				}
			},'json');
		    
		    
		    }
    	//修改批复详情窗口
		function modifyReceiptDetailWindow(){
			$('#ReceiptRelatedInfoWindow').window({
                title: '借据详情',
                width: 1000,
                left:($(window).width()-1000)*0.5,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                top:($(window).height()-500)*0.5,
                resizable:false
            });
		}
		
		
		//修改批复详情窗口
		function modifyPaybackInfoWindow(){
			$('#PaybackInfoWindow').window({
                title: '还款详情',
                width: 1000,
                left:($(window).width()-1000)*0.5,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                top:($(window).height()-500)*0.5,
                resizable:false
            });
		}
		
		function closeDetailWindow(){
			$('#ReceiptRelatedInfoWindow').window('close'); 
		}
		
		$(function() {
			<%
	    	com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
	    	String clearStatus = (String)session.getAttribute("clearStatus");
	    	if(!access.hasAnyPrivilege("ROLE_POSTED_QUERY") || (clearStatus!=null && !clearStatus.equals("99"))){	//具有全量查询权限时,初始化不进行查询
	    	%>
	    	queryContractManagement();
	    	<%}%>
	    	
		    modifyReceiptDetailWindow();
		    modifyPaybackInfoWindow();
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
    <a href="javascript:void(0)" id="01" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="openReceiptDetail()">借据详情</a> 
    <a href="javascript:void(0)" id="02" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="openPayback()">发起还款</a> 
  </div>  
	
	
	
	
	<div id="tb" style="padding:3px">
		<span>业务编号:</span>
		<input id="receiptId" name="ReceiptId" style="line-height:20px;border:1px solid #ccc"/>
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
		<div id="search" style="padding:3px">
			<span>业务编号:</span>
			<input id="ReceiptId" name="ReceiptId" style="line-height:20px;border:1px solid #ccc"/>
			<span>客户名称:</span>
			<input id="custName" name="custName" style="line-height:20px;border:1px solid #ccc"/>
			<span>商户名称:</span>
			<input id="merchantName" name="merchantName" style="line-height:20px;border:1px solid #ccc"/>
			<span>证件号码:</span>
			<input id="custIdNo" name="custIdNo" style="line-height:20px;border:1px solid #ccc"/>
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="executeQeury()">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="clearInfo()">清空</a>
		</div>
		<div id="func">   
	    	<a href="javascript:void(0)" id="01" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openReceiptDetail()">借据详情</a>
	    <c:if test="${clearStatus!='99' and clearStatus!='01'}">
	    	<a href="javascript:void(0)" id="02" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openPayback()">发起还款</a>
	    </c:if>
  		</div>  
	</div>  
    <table id="tt" class="easyui-datagrid" style="width:1500px;height:800px"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
			   
			    <th field="id" checkbox="true"></th>
			    <th field="receiptId" width="120">借据编号</th> 
			    <th field="contNo" width="120" hidden="true">合同编号</th> 
			    <th field="paybackWay" width="120" hidden="true">还款方式</th> 
			    <th field="loanPaybackWay" width="120" hidden="true">贷款偿还方式</th> 
			    <th field="contNo" width="120" hidden="true">合同编号</th> 
			    <th field="custName" width="120">客户名称</th>
				<th field="posCustName" width="120">商户名称</th>
				<th field="payApplyAmt" width="120" formatter="formatMoney" align="right">借据金额</th>
			    <th field="loanInterest" width="120" formatter="formatRate" align="right">贷款利率</th>
			    <th field="beginDateStr" width="120">起贷日</th>
			    <th field="endDateStr" width="120">到期日</th>
			    <th field="loanTotalBalance" width="120" formatter="formatMoney" align="right">贷款余额</th>
			    <th field="payApplyId" width="120" hidden="true">用款申请号</th>
			    <th field="loanAcNo" width="120" hidden="true">核心借据号</th>
			    <th field="custId" width="120" hidden="true">客户编号</th>
			<!-- 	<th field="hh" width="150"  align="center" formatter="rowformater">操作</th> -->
			</tr>
		</thead>
	</table> 
    
     <div id="winConfirm" class="easyui-window" title="信息提示" closed="true" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                                   确认发起还款申请?
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp1" onclick="confirm()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a><a id="btnEp2" onclick="cancel()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    取消</a>  
            </div>
        </div>
    </div> 
    
    <jsp:include page="ReceiptDetail.jsp"></jsp:include> 
    <jsp:include page="revokePayback.jsp"></jsp:include> 
  </body>
</html>
