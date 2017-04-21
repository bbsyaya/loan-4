<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add search functionality in DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript">
		function queryContractManagement(){
			$('#tt').datagrid('load',{	
				loanIdLike: $('#loanId').val(),
				custNameLike: $('#custName').val(),
				merchantNameLike: $('#merchantName').val(),
				custIdLike: $('#custId').val(),
				custIdNoLike: $('#custIdNo').val(),
				searchApproveStatus:$('#approveStatus').val(),
			});
		}
		
        function formatInterest(val,row){
			
			return val+"%";
		}
		
		function formatApproveTerm(val,row){
			return val+"月";
		}
			
		function clearInfo(){
		       $('#loanId').val(""),
			   $('#custName').val(""),
			   $('#merchantName').val(""),
			   $('#custId').val(""),
			   $('#custIdNo').val("")
		}
		

		 	
	  
		 
		   function modifyApprovementChangeWindow(){
			$('#ApprovementChangeWindow').window({
                title: '调整批复',
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                maximized:true,
                resizable:false
            });
			
		}
		 
		

       /*  
	     function initDetailTabApprove1(){
		    var row = $('#tt').datagrid('getSelected');
	     	$('.insertSignApproveId').val(row.approveId);
		    $('.insertSignLoanId').val(row.loanId);
		    $('.insertSignProductId').val(row.productId);
		    $('.insertSignCustId').val(row.custId);
		    $('.insertSignPosCustName').val(row.posCustName);
		    $('.insertSignApproveMoneyKind').val(row.approveMoneyKind);
		    $('.insertSignPaybackMethod').val(row.paybackMethod);
		    $('.insertSignAccountBranchBank').val(row.accountBranchBank);
		    $('.insertSignAccountSubBranchBank').val(row.accountSubBranchBank);
		    $('.insertSignChannelName').val(row.businessSource);
		    $('.insertSignApllyAmount').val(row.applyAmt);
		    $('.insertSignApplyMoneyKind').val(row.applyMoneyKind);
		    $('.insertSignApplyTerm').val(row.applyTerm);
		    $('.insertSignTermUnit').val(row.termUnit);
		    $('.insertSignApplyCommitDate').val(row.applyCommitDateStr);
		    $('.insertSignApproveAmount').val(row.approveAmount);
		    $('.insertSignApproveInterest').val(row.approveInterest);
		    $('.insertSignApproveTerm').val(row.approveTerm);
		    $('.insertSignApproveTermUnit').val(row.approveTermUnit);
		    $('.insertSignApproveDate').val(row.approveDateStr);
		    $('.insertSignAcceptAccount').val(row.acceptAccount);
		    $('.insertSignAccountOpenBank').val(row.accountOpenBank);
		    $('.insertSignApproveStatus').val(row.approveStatus);
		} */
		
		
		       function initDetailTabApprove2(loanId){
		    	   var reqUrl = "<%=request.getContextPath()%>/contractManagement/openChangeApprove.do";
					$.post(reqUrl, {loanId: loanId}, function(obj){
						var obj = eval('(' +obj+')');
						$('#insertChangeChannelName').val(obj.channel);
						$('#insertChangeImportWay').val(obj.inChannelKind);
						$('#insertChangeCustName').val(obj.custName);
						$('#insertChangePosCustName').val(obj.posCustName);
						$('#insertChangeApplyCommitDate').val(obj.applyCommitDate);
						$('#insertChangeApllyAmount').val(obj.applyAmt);
						$('#insertChangeApplyMoneyKind').val(obj.applyMoneyKind);
						$('#insertChangeApplyTerm').val(obj.applyTerm);
						$('#insertChangeApproveDate').val(obj.approveDate);
						$('#insertChangeApproveAmount').val(obj.approveAmount);
						$('#insertChangeApproveMoneyKind').val(obj.approveMoneyKind);
						$('#insertChangeApproveInterest').val(obj.approveInterest);
						$('#insertChangeApproveTerm').val(obj.approveTerm);
					 	$('#insertChangePaybackMethod').val(obj.paybackMethod);
						$('#insertChangeAcceptAccount').val(obj.acceptAccount); 
						$('#insertChangeAccountOpenBank').val(obj.accountOpenBank); 
						$('#insertChangeAccountBranchBank').val(obj.accountBranchBank); 
						$('#insertChangeAccountSubBranchBank').val(obj.accountSubBranchBank);
						$('#check1').val(obj.approveAmount);
						$('#check2').val(obj.approveInterest);
						$('#check3').val(obj.approveTerm);
					});  	
					
					
		    }
		
		  
		
	   <%--  function initDetailTabCustomer(custId){	
			var reqUrl = "<%=request.getContextPath()%>/contractManagement/queryContractManagement1.do";
			$.post(reqUrl, {custId: custId}, function(data){
				var obj = eval('(' +data+')');
				$('.insertSignCustId').val(custId);
				$('.insertSignCustName').val(obj.custName);
				$('#insertChangeCustName').val(obj.custName);
				$('.insertSignCredentialtype').val(obj.paperKind);
				$('.insertSignCredentialNo').val(obj.paperId);
				$('#insertSignIdType').val(obj.paperKind);
				$('#insertSignIdNo').val(obj.paperId);
				$('#insertRejectIdNo').val(obj.paperId);
				$('.insertSignBirthDate').val(obj.birtDate);
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
      
	    
        function initDetailTabApply(loanId){    
			var reqUrl = "<%=request.getContextPath()%>/contractManagement/queryContractManagement2.do";
			$.post(reqUrl, {loanId: loanId}, function(data){
				var obj = eval('(' +data+')');
				$('.insertSignLoanId').val(loanId);
				$('.insertSignApplyAmount').val(obj.applyAmt);
				$('.insertSignProdName').val(obj.prodName);
				$('.insertSignPaybackMethod').val(obj.returnKind);			
				$('.insertSignTermUnit').val(obj.termUnit);
				$('.insertSignApplyTerm').val(obj.applyTerm);		
				$('.insertSignBeginDate').val(obj.beginDate);
				$('.insertSignAcceptDate').val(obj.acptDate);		
				$('.insertSignAssureKind').val(obj.assuKind);
				$('.insertSignAmt').val(obj.amt);	
				$('.insertSignReckDay').val(obj.reckDay);
				$('.insertSignReturnDay').val(obj.returnDay);	
				$('.insertSignloanUsage').val(obj.loanUsage);
				$('.insertSignloanUsageDesc').val(obj.loanUsageDesc);	
				$('.insertSignreturnSourceDesc').val(obj.returnSourceDesc);
			});   	
	    } 
        
       function initDateInfo(){
          var reqUrl = "<%=request.getContextPath()%>/contractManagement/queryContractManagement3.do";
			var apprTermUnit = $('.insertSignApproveTermUnit').val();
 			var approveTerm = $('.insertSignApproveTerm').val();
			$.get(reqUrl, {apprTermUnit: apprTermUnit,apprTerm:approveTerm,}, function(obj){
				$('#insertSignContractBeginDate').val(obj.bd);
				$('#insertSignInputDate').val(obj.bd);
				$('#insertSignContractEndDate').val(obj.ed);
				$('#insertSignContractId').val(obj.contNo);
				$('#insertSignInputPerson').val(obj.username);
			}, 'json');
        
        }--%>
        
        
       function openChangeApprove(){
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
		    
		    
       }
       
       function bbb(){
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
            var reqUrl = "<%=request.getContextPath()%>/contractManagement/queryDate1.do";
            var approveId = row.approveId;
            var expiryDate = row.expiryDate;
			$.post(reqUrl, {approveId:approveId,expiryDate:expiryDate}, function(data){
				if(data==2){
					alert("当前批复记录不允许被激活，拒绝日期超过一个月");
					return;
				}else if(data==3){
					alert("该批复已经进行过激活，不能再次激活");
				}else{
						$('#ApprovementActivateWindow').window('open'); 
			            $('#approveAmount').val(row.approveAmount);
			            $('#approveMoneyKind').val(row.approveMoneyKind);
					    $('#approveTerm').val(row.approveTerm);
					    $('#approveInterest').val(row.approveInterest);
				   }
			});
			
			
			
			
			
       
       }
       
       function ccc(){
            var reqUrl = "<%=request.getContextPath()%>/contractManagement/updateContractManagement4.do";
 			var row = $('#tt').datagrid('getSelected');
 			$.post(reqUrl, {approveId: row.approveId}, function(data){
 				alert(data);
 			});
       $('#ApprovementActivateWindow').window('close'); 
       queryContractManagement(); 
       }
       
         
         
            function confirmchange(){
                         var a = $('#check1').val();
						 var b = $('#check2').val();
						 var c = $('#check3').val();
						 var d = $('#insertChangeApproveAmount').val();
						 var e = $('#insertChangeApproveInterest').val();
						 var f = $('#insertChangeApproveTerm').val();
						if(a==d&&b==e&&c==f){
						alert("请输入要调整的业务要素（批复金额，批复利率，批复期限）");
						return;
						}else{
								if((d-a)>=0){
								alert("调整后的批复金额必须小于调整前的批复金额");
								return;
								}else{
									$('#apprChange').window('open');
									$('#postChangeAmount').val(d);
									$('#postChangeInterest').val(e);
							        $('#postChangeTerm').val(f);
							        
									}
						}
            }
       
       
          function  aaa(){
		        	
		        	var reqUrl = "<%=request.getContextPath()%>/contractManagement/updateContractManagement3.do";
		 			var row = $('#tt').datagrid('getSelected');
		 			var approveId = row.approveId;
		 			var d = $('#insertChangeApproveAmount').val();
					var e = $('#insertChangeApproveInterest').val();
					var f = $('#insertChangeApproveTerm').val();
		 			var changereason = $('#insertChangeReason').val();
		 			$.post(reqUrl, {approveId: approveId,approveAmount:d,approveInterest:e,approveTerm:f,changereason:changereason}, function(data){
		 				alert(data);
		 			});
        	       $('#apprChange').window('close');
        	       $('#ApprovementChangeWindow').window('close');
        	       $('#confirmchange').hide();
         }

      
        
        function reactivate(){
         var reqUrl = "<%=request.getContextPath()%>/contractManagement/updateContractManagement3.do";
 			var row = $('#tt').datagrid('getSelected');
 			$.post(reqUrl, {approveId: row.approveId}, function(data){
 				alert(data);
 			});
        
        }
        
       
	  
	
       $(function() {
        	//$('#01').hide();
        	//$('#02').hide();
        	//$('#03').hide();
        	//$('#06').hide();
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
	<input type="hidden" id="approveStatus" value="<%=request.getAttribute("approveStatus")%>">
	<table id="tt" class="easyui-datagrid" style="width:1500px;height:800px"
			url="<%=request.getContextPath()%>/contractManagement/queryContractManagement.do?searchApproveStatus=<%=request.getAttribute("approveStatus")%>"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
			   
			    <th field="id" checkbox="true"></th>
			    <th field="approveId" width="120">批复编号</th> 
			    <th field="custName" width="120">客户名称</th>
				<th field="businessSource" width="120">业务来源</th>
				<th field="applyAmt" width="120" hidden="true">申请额度</th>
			    <th field="applyMoneyKind" width="120" hidden="true">申请币种</th>
			    <th field="termUnit" width="120" hidden="true">期限单位</th>
			    <th field="applyTerm" width="120" hidden="true">申请期限</th>
			    <th field="applyCommitDateStr" width="120" hidden="true">申请提交日期</th>  
			    <th field="acceptAccount" width="120">收款账号</th>
			    <th field="accountOpenBank" width="120">账户开户行</th>
				<th field="loanId" width="120" hidden="true">申请编号</th>
				<th field="custId" width="120">客户编号</th>
				<th field="approveAmount" width="120">批复额度</th>
				<th field="approveMoneyKind" width="120">批复币种</th>
				<th field="approveInterest" width="120" align="right" formatter="formatInterest">批复利率</th>
				<th field="approveTerm" width="120" align="right" formatter="formatApproveTerm">批复期限</th>
				<th field="approveDateStr" width="120">批复日期</th>
				<th field="approveStatus" width="120">批复状态</th>
				<th field="paybackMethod" width="120">还款方式</th>  
			</tr>
		</thead>
	</table>
	
	  <div id="apprChange" class="easyui-window" title="信息提示" closed="true" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 500px; height: 300px; padding: 5px;
        background: #fafafa;">
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
	
	
	  <div id="ApprovementActivateWindow" class="easyui-window" title="信息提示" closed="true" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 500px; height: 300px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                     确认重新激活该笔授信批复吗？
                     <table>    
                     
                     <tr>
                     <td>批复额度</td>
                     <td><input type="text" id="approveAmount" readonly= "true " name="approveAmount"/></td>
                     <td>批复币种</td>
                     <td><input type="text" id="approveMoneyKind" readonly= "true " name="approveMoneyKind"/></td>
                     </tr>
                     <tr>
                     <td>批复期限</td>
                     <td><input type="text" id="approveTerm" readonly= "true " name="approveTerm"/></td>
                     <td>批复利率</td>
                     <td><input type="text" id="approveInterest" readonly= "true " name="approveInterest"/></td>
                     </tr>
                     </table>
            </div>
            <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="ccc()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> 
            </div>
        </div>
    </div> 
	
	
	
	    <jsp:include page="sign/changeapprove.jsp"></jsp:include>
	 	<jsp:include page="head.jsp"></jsp:include>
	 	
</body>
</html>