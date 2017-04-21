<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/p_validator.js"></script>
    <script type="text/javascript" src='<%=request.getContextPath()%>/js/validator.js'></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
	<script type="text/javascript">
	$(function() {
        	//查询
        	queryCallingTask();
        });
     //查询
		function queryCallingTask(){
			var queryUrl = '<%=request.getContextPath()%>/callingTaskForReview/queryCallingTaskForReview.do';
			$('#t').datagrid({url:queryUrl,
			    queryParams:{
				custName: $('#searchCustName').val(),
				posCustName: $('#searchPosCustName').val(),
				callingType: $('#searchCallingType').val(),
				opflag: $('#opflag').val()
				}
			});
		}
		function queryCallingTaskForClaim(){
			var queryUrl = '<%=request.getContextPath()%>/callingTaskForReview/queryCallingTaskForReview.do';
			$('#tClaim').datagrid({url:queryUrl,
			    queryParams:{
				custName: $('#searchCustNameForClaim').val(),
				posCustName: $('#searchPosCustNameForClaim').val(),
				callingType: $('#searchCallingTypeForClaim').val(),
				opflag: 3
				}
			});
		}
		function queryClear(){
			$("#searchCustNameHidden").val($('#searchCustName').val());
			$('#searchCustName').val("");
			$("#searchPosCustNameHidden").val($('#searchPosCustName').val());
			$('#searchPosCustName').val("");
			$("#searchCallingTypeHidden").val($('#searchCallingType').val());
			$('#searchCallingType').val("");
		}
		function queryClaimClear(){
			$("#searchCustNameHiddenForClaim").val($('#searchCustNameForClaim').val());
			$('#searchCustNameForClaim').val("");
			$("#searchPosCustNameHiddenForClaim").val($('#searchPosCustNameForClaim').val());
			$('#searchPosCustNameForClaim').val("");
			$("#searchCallingTypeHiddenForClaim").val($('#searchCallingTypeForClaim').val());
			$('#searchCallingTypeForClaim').val("");
		}
		function recoverClaim(){
			
			$('#searchCustNameForClaim').val($('#searchCustNameHiddenForClaim').val());
			$('#searchPosCustNameForClaim').val($('#searchPosCustNameHiddenForClaim').val());
			$('#searchCallingTypeForClaim').val($('#searchCallingTypeHiddenForClaim').val());
		}
		
		function recover(){
			
			$("#searchCustName").val($('#searchCustNameHidden').val());
		
			$("#searchPosCustName").val($('#searchPosCustNameHidden').val());
			
			$("#searchCallingType").val($('#searchCallingTypeHidden').val());
		}
		 //检查是否只选择了记录
        function checkSelected(){
        	var rows = $('#t').datagrid('getSelections');
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
		
      //打开任务认领窗口
        function openCallingTaskClaimWindow(){
        		createCallingTaskClaimWindow();
        		initCallingTaskClaimWindow();
        }
      //初始化任务认领窗口信息
        function initCallingTaskClaimWindow(){
        	
        	
        	$('#searchCustNameForClaim').val("");
			$('#searchPosCustNameForClaim').val("");
			$('#searchCallingTypeForClaim').val("");
			queryCallingTaskForClaim();
			$('#claimCallingTaskWindow').window('open');
      }
      //创建认领窗口
      function createCallingTaskClaimWindow(){
    	  $('#claimCallingTaskWindow').window({
              width: 1000,
              modal: true,
              shadow: true,
              closed: true,
              height: 500,
              resizable:false
          });
      }
      
        //关闭任务认领窗口
        function closeClaimWindow(){
        	$('#claimCallingTaskWindow').window('close');
        }
        
      	//认领任务
      	function claimCallingTask(){
      		
      		var rows = $('#tClaim').datagrid('getSelections');
			var length = rows.length;
			if (length == 0){
			    alert("请选择要认领的任务！");
			    return;
			}
     		 var reqUpdateClaimerUrl = "<%=request.getContextPath()%>/callingTaskForReview/updateCallingTaskClimer.do";
     		 var taskNoes = "";
     		 for(var i =0; i<length;i++){
     			 taskNoes += rows[i].taskNo + "|";
     		 }
     		 $.post(reqUpdateClaimerUrl, {taskNoes : taskNoes}, function(obj){
     			 if(obj == true){
     				 alert("认领 成功");
     			 }else{
     				 alert("认领失败,请刷新页面");
     			 }
     			queryCallingTaskForClaim();
     			queryCallingTask();
			},'json');
     		
      	}
        //任务详情窗口
        function callingTaskDetail(){
        	if(checkSelected()){
        		//createCallingTaskDetailWindow();
        		//initCallingTaskDetailWindow();
        		var row = $('#t').datagrid("getSelected");
        		var taskNo = row.taskNo;
        		var relaBizPhase = row.relaBizPhase;
        		$("#generateTime").val(row.generateTime);
        		$('#callingTaskDetailWindow').openWin({
        			title:'外呼任务',
        			maximized:true,
        			href:'<%=request.getContextPath()%>/callingTaskForReview/queryCallingTaskByTaskNo.do?taskNo='+taskNo+'&relaBizPhase='+relaBizPhase+'&direct2Path=outBound/detail',
        		});
        	}
        	
        }
    <%--     function initCallingTaskDetailWindow(){
        	 $('#callingTaskDetailWindow').window('open');
			var reqUrl = "<%=request.getContextPath()%>/callingTaskForReview/queryCallingTaskByTaskNo.do";
			var row = $('#t').datagrid("getSelected");
			$("#generateTime").val(row.generateTime);
			var taskNo = row.taskNo;
			var isClaimed = true;
			$.post(reqUrl, {taskNo : taskNo}, function(obj){
				$("#callingType").val(obj.callingType);
				$("#relaBizPhase").val(obj.relaBizPhase);
				$("#relaBizNo").val(obj.relaBizNo);
				$("#claimerName").val(obj.claimerName);
			},'json');		

    		var loanId = "11";
    		var direct2Path = "outBound/detail.jsp";
    		//$.post(reqUrl, {loanId : loanId,direct2Path:direct2Path}, function(obj){}, 'json');
    		document.location.href= "<%=request.getContextPath()%>/navigation/openCreditMain.do?loanId="+loanId+"&direct2Path="+direct2Path;
        } --%>
      //创建任务详情窗口
        function createCallingTaskDetailWindow() {
            $('#callingTaskDetailWindow').window({
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                resizable:false
            });
        }
        function confirmDiag(){
        	//意见详情）
    		var dealInfo = document.getElementById("dealInfo").value;
    		if(dealInfo == ''){
    			alert("请输入意见详情！");
    			return false;
    		}else if (getTotalBytes(dealInfo) > 1000){
    			alert("意见详情不能超过1000个字符！");
    			return false;
    		} 
        	      	
        	if(confirm("确定完成？")){
            	return true;
          	}
        	return false;
        }
      	//操作完成
      	function completeCallingTaskClimer(){
      		if(confirmDiag()){
      			$('#callingTaskDetailWindow').window('close');
         		 var reqUpdateClaimerUrl = "<%=request.getContextPath()%>/callingTaskForReview/completeCallingTaskClimer.do";
         		 var row = $('#t').datagrid("getSelected");
   			 	var taskNo = row.taskNo;
   			 	var dealInfo = $("#dealInfo").val();
         		 $.post(reqUpdateClaimerUrl, {taskNo : taskNo,dealInfo:dealInfo}, function(obj){
    				 queryCallingTask();
    			},'json');
      		}
      		
      	}
        //关闭窗口
        function closeCallingTaskDetailWindow() {
        	
            $('#callingTaskDetailWindow').window('close');
            
        }
       
 
      
        
</script>
</head>
<body>
    <input type="hidden" id="windowflag" name="windowflag" />
	<% String opflag = request.getParameter("opflag"); %>
	<input type="hidden" id="opflag" name="opflag" value="<%=opflag%>" />
	<div id="tb" style="padding:5px;height:auto">
		
		<div id="tb">
			<% if("1".equals(opflag)) {%>
			 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openCallingTaskClaimWindow()">任务认领</a>&nbsp;&nbsp;&nbsp;&nbsp;
			 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="callingTaskDetail()">任务详情</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<%} %>
		</div>
	
		 <fieldset><legend class='dialog-label'>查询条件</legend>
			 <div id="tb" style="padding:3px">
				<table>
				
					<tr>
						<td>客户名称:</td>
						<td><input id="searchCustName" name="searchCustName" style="line-height:20px;border:1px solid #ccc"/>
						<input type="hidden" id="searchCustNameHidden" name="searchCustNameHidden"  /></td>
						<td>商户名称:</td>
						<td><input id="searchPosCustName" name="searchPosCustName" style="line-height:20px;border:1px solid #ccc"/>
						<input type="hidden" id="searchPosCustNameHidden" name="searchPosCustNameHidden"  /></td>
					</tr>
					<tr>
						<td>任务类型:</td>
						<td><select id="searchCallingType" name="searchCallingType" >
							<option>
							</option>
							<c:forEach items="${callingTypeList}" var="obj">
										<option value="${obj.itemNo}">
										 ${obj.itemName}
										 </option>
							</c:forEach>
						</select>
						<input type="hidden" id="searchCallingTypeHidden" name="searchCallingTypeHidden"  />
						</td>
						
					</tr>
			
				</table>
				
				<br/>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryCallingTask()" iconCls="icon-search" plain="true">查询</a>
				&nbsp;&nbsp;<a href="javascript:void(0)" onclick="queryClear()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">清空</a>
				&nbsp;&nbsp;<a href="javascript:void(0)" onclick="recover()" class="easyui-linkbutton" iconCls="icon-mini-edit" plain="true">恢复</a>
				</div>
		 </fieldset>
	</div>
	<table id="t" width=100% style="height:500px"	toolbar="#tb" onClickRow="clickRow" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="taskNo" checkbox="true" ></th>
				<th field="custName" width="190px">客户名称</th>
				<th field="posCustName" width="70px">商户名称</th>
				<th field="generateTime" width="150px">任务生成时间</th>
				<th field="callingTypeName" width="150px">任务类型</th>
				<th field="claimerName" width="150px">认领人</th>
				<th field="claimTime" width="150px">认领时间</th>
				<th field="relaBizPhase" hidden="true">关联业务类型</th>
			</tr>
		</thead>
	</table>
	<jsp:include page="claimCallingTask.jsp"></jsp:include>
	<div id="callingTaskDetailWindow"></div>	<!-- 查看申请 -->
	<%-- <jsp:include page="detail.jsp"></jsp:include> --%>
</body>
</html>