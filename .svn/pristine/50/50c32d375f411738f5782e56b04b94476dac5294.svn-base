<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add search functionality in DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/common_uiext.js"></script>
	
	<script type="text/javascript">
		function queryContractManagement(){
			var queryUrl="<%=request.getContextPath()%>/contractManagement/queryContractManagement.do?searchApproveStatus=${approveStatus}";
			$('#tt').datagrid(
				{url:queryUrl,
			    queryParams:{
			    	loanIdLike: $('#bizLoanId').val(),
					custNameLike: $('#custName').val(),
					custIdNoLike: $('#custIdNo').val(),
					//searchApproveStatus:$('#approveStatus').val(),
				}
			});
			
		}
		
		function executeQeury(){
			var bizLoanId = getTextValue("#bizLoanId");
			var custName = getTextValue("#custName");
			var custIdNo = getTextValue("#custIdNo");
			//var approveStatus = getTextValue("#approveStatus");
			if(bizLoanId=="" 
					&& custName==""
					&& custIdNo==""){
				$.messager.alert("操作提示","请输入查询条件.","warning");
				return ;
			}
			queryContractManagement();
		}
		
		function formatInterest(val,row){
			
			return val+"%";
		}
		
		function formatApproveTerm(val,row){
			return val+"月";
		}
		function clearSearch(){
		       $('#bizLoanId').val(""),
			   $('#custName').val(""),
			   $('#merchantName').val(""),
			   //$('#custId').val(""),
			   $('#custIdNo').val("")
		}
		
		
		function deleteContractManagement(){
			var reqUrl = "<%=request.getContextPath()%>/contractManagement/deleteContractManagement.do";
			var row = $('#tt').datagrid('getSelected');
			$.get(reqUrl, {deleteItem: row.approveId}, function(data){
				alert(data);
				queryContractManagement();
			});
		} 
		
	
		function openConfirmationSign(){
            var rows = $('#tt').datagrid('getSelections');
			var length = rows.length;
			if (length == 0){
			    alert("请选择一条记录！");
			    return;
			}else if(length > 1){ 
			    alert("请只选择一条记录！");
			    return;
			} 
 //       	$('#confirmationSignWindow').window('open'); 
        	var row = $('#tt').datagrid('getSelected');
        	var loanId = row.loanId;
        	 
        	$('#confirmationSignWindow').openWin({
				title:'确认审批结果',
				//maximized:true,
				width:860,
				height:640,
				href:'openAcceptResult.do?loanId='+loanId+'&direct2Path=contract/sign/signcontract',
			});
		    return;
        
        }
        
        
        
        //打开调整批复窗口
         function openChangeApprove(){
        	/*
            var rows = $('#tt').datagrid('getSelections');
			var length = rows.length;
			if (length == 0){
			    alert("请选择一条记录！");
			    return;
			}else if(length > 1){ 
			    alert("请只选择一条记录！");
			    return;
			} 
	        $('#signEffect').show();
	        $('#confirmchange').show();
        	$('#ApprovementChangeWindow').window('open'); 
        	var row = $('#tt').datagrid('getSelected');
	        initDetailTabApprove2(row.loanId);
		     $('#preChangeAmount').val(row.approveAmount);
		     $('#preChangeTerm').val(row.approveTerm);
		     $('#preChangeInterest').val(row.approveInterest);
		    */
		    if(!checkSelected()){
		    	return;
		    }
		    var row = $('#tt').datagrid('getSelected');
		    var loanId = row.loanId;
		    var approveId = row.approveId;
		    
		    $('#ApprovalChangeWindow').openWin({
				title:'审批结果调整',
				//maximized:true,
				width:640,
				height:480,
				href:'openApprovalWin.do?approveId='+approveId+'&direct2Path=contract/sign/approveAdjust',
			});
       }
		
        
       function closeModefyWin(win){
       		$(win).window('close');
       }
        
       //检查是否只选择了记录
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
       
       function confirmchange(){
			$.messager.confirm('Confirm', '确定要调整批复吗?', function(data){
				if (data){ 
					// exit action; 
					var approveId = $('#ApprovalChangeWindow #insertChangeApproveId').val();
		 			var approveAmt = $('#ApprovalChangeWindow #insertChangeApproveAmount').val();
					var approveInt = $('#ApprovalChangeWindow #insertChangeApproveInterest').val();
					var accountNo = $('#ApprovalChangeWindow #insertChangeAcceptAccount').val();
					var bankId = getComboValue('#ApprovalChangeWindow #insertChangeAccountOpenBank');
					var branchId = $('#ApprovalChangeWindow #insertChangeAccountBranchBank').val();
					var subBranchId = $('#ApprovalChangeWindow #insertChangeAccountSubBranchBank').val();
		 			var changeReason = $('#ApprovalChangeWindow #insertChangeReason').val();
					
					var reqUrl = "<%=request.getContextPath()%>/contractManagement/updateContractManagement3.do";
					$.post(reqUrl, 
						{approveId: approveId,
							approveAmount:approveAmt,
							approveInterest:approveInt,
							accountNo:accountNo,
							bankId:bankId,
							branchId:branchId,
							subBranchId:subBranchId,
							changeReason:changeReason}, 
						function(data){
		 					alert(data);
		 					closeModefyWin('#ApprovalChangeWindow');
		 					queryContractManagement();
		 				});
				} 
			});
       }
       
        function initDateInfo(){
            var reqUrl = "<%=request.getContextPath()%>/contractManagement/queryContractManagement3.do";
			var unit = $('.insertSignApproveTermUnit').val();
 			var approveTerm = $('.insertSignApproveTerm').val();
 			var a = $("#insertSignContractBeginDate").datebox('getValue');
			$.post(reqUrl, {apprTermUnit: unit,apprTerm:approveTerm,beginDate:a}, function(data){
				$('#insertSignDate').val(data.sd);
				$('#insertSignContractEndDate').val(data.ed);
			}, 'json');
        
        }
      
	    
         //签约生效按钮触发函数
         function signToEffect(){
             initDateInfo();
        	 $('#win').window('open'); 
         }
         
         function changeStatus1(){ 
        	 changeApprovementStatus1();
        	 $('#signEffect').hide();
        	 $('#win').window('close');	
        	 $('#confirmationSignWindow').window('close');	
        	 queryContractManagement();
         }
         
         
             function removeElement(){
                 $('#insertRejectReasonDetail').val("");
                 $('#1').attr("checked",false);
                 $('#2').attr("checked",false);
                 $('#3').attr("checked",false);
                 $('#4').attr("checked",false);
                     
		         $('#1').attr("disabled",true);
		         $('#2').attr("disabled",true);
		         $('#3').attr("disabled",true);
		         $('#4').attr("disabled",true);
		         $('#insertRejectReasonDetail').attr("disabled",true);
		         }
         
	         function clearInfo(){
	             $('#1').attr("disabled",false);
		         $('#2').attr("disabled",false);
		         $('#3').attr("disabled",false);
		         $('#4').attr("disabled",false);
		         $('#insertRejectReasonDetail').attr("disabled",false);
	         
	         
	         }
         
         function commit(){
         var a=$('input:radio[name="apprResult"]:checked').val();
         var b=$('input:radio[name="reason"]:checked').val();
         var reasondetail = $('#insertRejectReasonDetail').val();
         if(a=="10"){
          $('#win').window('open'); 
         }else if(b==undefined){
                    alert("请选择拒绝原因");
		            return false;
         
         }else if(b=="其他"&&reasondetail==""){
         alert("请输入原因详情");
				          return false;
         }else{
					          $('#winReject').window('open');	
					          }
         
         
         }
         function rejectConfrimWindow(){
	          var rej=$('input:radio[name="reason"]:checked').val();
	          var reasondetail = $('#insertRejectReasonDetail').val();
		          if(rej==undefined)
		          {
		            alert("请选择拒绝原因");
		            return false;
				   }else if(rej=="其他"&&reasondetail==""){
				          alert("请输入原因详情");
				          return false;
				          }else{
					          $('#winReject').window('open');	
					          }
         }
         
          function changeStatus2(){ 
        	 changeApprovementStatus2();
        	 $('#winReject').window('close');
        	 $('#btnYes').show();
        	 $('#btnReject').hide();
        	 queryContractManagement();
         }
      

         
         function  changeApprovementStatus1(){
        	var reqUrl = "<%=request.getContextPath()%>/contractManagement/updateContractManagement1.do";
 			var row = $('#tt').datagrid('getSelected');
 			$.post(reqUrl, {approveId: row.approveId}, function(data){
 				alert(data);
 			});
         }
         
         
             function  changeApprovementStatus2(){
		        	var reqUrl = "<%=request.getContextPath()%>/contractManagement/updateContractManagement2.do";
		 			var row = $('#tt').datagrid('getSelected');
		 			var approveId = row.approveId;
		 			var rejectreason  = $('input[name="reason"]:checked').val();
		 			var rejectdetail = $('#insertRejectReasonDetail').val();
		 			$.post(reqUrl, {approveId: approveId,rejectreason:rejectreason,rejectdetail:rejectdetail}, function(data){
		 				alert(data);
		 			});
		 			 
		 			 $('#RejectApproveWindow').window('close');
		 			$('#confirmationSignWindow').window('close'); 
        	         queryContractManagement();	
            }
		
      	function closeConfirmWindow(){
  			$('#confirmationSignWindow').window('close');
  		}
		
		
    //打开拒绝批复窗口
      function openRejectApprove(){
            $('#btnYes').hide();
            var rows = $('#tt').datagrid('getSelections');
			var length = rows.length;
			if (length == 0){
			    alert("请选择一条记录！");
			    return;
			}else if(length > 1){ 
			    alert("请只选择一条记录！");
			    return;
			} 
        	 $('#RejectApproveWindow').window('open'); 
        	 var row = $('#tt').datagrid('getSelected');
				$('#insertRejectCustName').val(row.custName);
				$('#insertRejectApproveAmount').val(row.approveAmount);
				$('#insertRejectApproveMoneyKind').val(row.approveMoneyKind);
				$('#insertRejectApproveInterest').val(row.approveInterest);
				$('#insertRejectApproveTerm').val(row.approveTerm);
        	 initDetailTabApprove1();
			 initDetailTabCustomer(row.custId);
      }
   
     
     
       $(function() {
        	//$('#04').hide();
       	<%
    	com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
    	String approveStatus = (String)session.getAttribute("approveStatus");
    	if(!access.hasAnyPrivilege("ROLE_APPROVED_QUERY") || (approveStatus!=null && !approveStatus.trim().equals("99"))){	//具有全量查询权限时,初始化不进行查询
    	%>
    		queryContractManagement();
    	<%}%>
        	$('#tt').datagrid({
    		onClickCell: function (rowIndex, field, value) { 
                if(field != 'id'){
                	$(this).datagrid('unselectAll');
                }
                
            },
            onDblClickRow:function(rowIndex, rowData) {
            	openConfirmationSign();
            },
            singleSelect: true
    	});
        	     	
        }); 
	</script>
</head>
<body>
<input type="hidden" id="approveStatus" value="<%=request.getAttribute("approveStatus")%>">
 	<table id="tt" class="easyui-datagrid" style="width:1248px;height:600px"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true" style="width:100%;height:600;overflow:scroll;">
		<thead>
			<tr>
			   
			    <th field="id" checkbox="true"></th>
			    <th field="approveId" width="120">批复编号</th> 
			    <th field="custName" width="120">客户名称</th>
				<th field="businessSource" width="80">业务来源</th>
				<th field="applyAmt" width="120" hidden="true">申请额度</th>
			    <th field="applyMoneyKind" width="120" hidden="true">申请币种</th>
			    <th field="termUnit" width="120" hidden="true">申请期限单位</th>
			    <th field="applyTerm" width="120" hidden="true">申请期限</th>
			    <th field="approveAmount" width="120" align="right" formatter="formatMoney">批复额度</th>
				<th field="approveInterest" width="80" align="right" formatter="formatInterest">批复利率</th>
				<th field="approveTerm" width="120" align="right" formatter="formatApproveTerm">批复期限</th>
			    <th field="applyCommitDateStr" width="120" hidden="true">申请提交日期</th>  
			    <th field="acceptAccount" width="120">收款账号</th>
			    <th field="accountOpenBank" width="120">账户开户行</th>
				<th field="loanId" width="120" hidden="true">申请编号</th>
				<th field="custId" width="120" hidden="true">客户编号</th>
				<th field="approveDateStr" width="100">批复日期</th>
				<th field="paybackMethod" width="100">还款方式</th>
			</tr>
		</thead>
	</table> 

<!-- 
 <div id="apprChange" class="easyui-window" title="信息提示" closed="true" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 500px; height: 300px; padding: 5px;background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                     确认完成如下授信批复调整？
                     <table>    
                     <tr>
                     <th>调整要素</th>
                     <th>调整前</th>  
                     <th>调整后</th>
                     </tr>
                     <tr>
                     <td>批复额度</td>
                     <td><input type="text" id="preChangeAmount" readonly= "true " name="preChangeAmount"/></td>
                     <td><input type="text" id="postChangeAmount" readonly= "true " name="postChangeAmount"/></td>           
                     </tr>
                     <tr>
                     <td>批复期限</td>
                     <td><input type="text" id="preChangeTerm" readonly= "true " name="preChangeTerm"/></td>
                     <td><input type="text" id="postChangeTerm" readonly= "true " name="postChangeTerm"/></td>           
                     </tr>
                     <tr>
                     <td>批复利率</td>
                     <td><input type="text" id="preChangeInterest" readonly= "true " name="preChangeInterest"/></td>
                     <td><input type="text" id="postChangeInterest" readonly= "true " name="postChangeInterest"/></td>           
                     </tr>
                     <tr>
                     <td>*调整原因:</td>
                	 <td><textarea id="insertChangeReason" name="insertChangeReason" cols="20" rows="2" style="border: 1px #939393 solid;"></textarea></td>
                	 </tr>
                     </table>
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="aaa()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> 
            </div>
        </div>
    </div> 
 -->
	<!-- 确认签约窗口中的签约生效窗口里的确定按钮 -->
    <div id="win" class="easyui-window" title="确认签约" closed="true" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                                   协议签约确认完成并生效？
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="changeStatus1()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> 
            </div>
        </div>
    </div> 
    
    <div id="winReject" class="easyui-window" title="拒绝批复" closed="true" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                                   确定要拒绝批复吗?
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="changeStatus2()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> 
            </div>
        </div>
    </div> 
         

	 
	
	<jsp:include page="sign/changeapprove.jsp"></jsp:include>

	<jsp:include page="head.jsp"></jsp:include>
	<div id="confirmationSignWindow"></div>
	<div id="ApprovalChangeWindow"></div>
</body>
</html>