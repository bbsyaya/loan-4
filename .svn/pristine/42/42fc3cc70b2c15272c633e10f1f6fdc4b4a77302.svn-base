<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/common_uiext.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/calendar.js'></script>
	<script type="text/javascript" >

		/* 重置查询条件*/
		function queryBlank(){
			$('#acDate').datebox('setValue','');
			$('#debitSubjId').val("");
			$('#creditSubjId').val("");
			$('#amt').val("");
			$('#listRem').val("");
			$('#listType').val("");
			$('#otherListNo').val("");
			$('#seqOrder').val("");
		}
		
		function doSubmit(){
			if($('#acDate').datebox('getValue')==""){
				alert("记账日期不能为空!");
				return false;
			}
			if($.trim($('#acBankId').val())==""){
				alert("会计机构不能为空!");
				return false;
				$('#acBankId').focus();
			}
			if($.trim($('#debitSubjId').val())==""){
				alert("转出账号不能为空!");
				$('#debitSubjId').focus();
				return false;				
			}
			if($.trim($('#creditSubjId').val())==""){
				alert("转入账号不能为空!");
				$('#creditSubjId').focus();
				return false;				
			}
			if($.trim($('#amt').val())==""){
				alert("金额不能为空!");
				$('#amt').focus();
				return false;				
			}
			if($.trim($('#acStat').val())==""){
				alert("记账状态不能为空!");
				$('#acStat').focus();
				return false;				
			}
			if($.trim($('#seqOrder').val())==""){
				alert("流水号不能为空!");
				$('#seqOrder').focus();
				return false;				
			}
			if($.trim($('#otherListNo').val())==""){
				alert("批次号不能为空!");
				$('#otherListNo').focus();
				return false;				
			}
			if($.trim($('#listType').val())==""){
				alert("业务类型不能为空!");
				$('#listType').focus();
				return false;				
			}
			if($.trim($('#listRem').val())==""){
				alert("摘要不能为空!");
				$('#listRem').focus();
				return false;
			}
			$("#addForm").submit();	
		}
		$(function() {
			var msg = $("#resultMsg").html();
			if(msg !=null && msg.length >0){
				alert(msg);
			}
		});
		
		function doSubmit1(){
			if($.trim($('#workDate').val())==""){
				alert("工作日不能为空!");
				return false;
				$('#workDate').focus();
			}
			if($.trim($('#reqSeqNo').val())==""){
				alert("请求流水号不能为空!");
				return false;
				$('#reqSeqNo').focus();
			}
			
			$("#payOutSuccessForm").submit();	
		}
	</script>
</head>
<body>
	<div id="tb" style="padding:3px;background:#f4f4f4;font-size:12px">
	<fieldset>
	<legend class='dialog-label'>核算冲账</legend>
	<form id="addForm" action="<%=request.getContextPath()%>/acctManager/addAccSubjectOccurHis.do" method="post"">
	<table width="1200" border="0" cellspacing="1" cellpadding="0">
	  <tr>
	    <td width="120">记账日期(acDate):</td>
	    <td width="180"><input  class="easyui-datetimebox"  id="acDate" name="acDate" type="text" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">会计机构(acBankId):</td>
	    <td width="180"><input id="acBankId" name="acBankId" value="6801" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="150">转出账号(debitSubjId):</td>
	    <td width="180"><input id="debitSubjId" name="debitSubjId" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">&nbsp;</td>
	    <td width="180">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="150">转入账号(creditSubjId):</td>
	    <td width="180"><input id="creditSubjId" name="creditSubjId" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">金额(amt):</td>
	    <td width="180"><input id="amt" name="amt" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">记账状态(acStat):</td>	    	    	
	    <td width="180"><select id="acStat" name="acStat" style="line-height:20px;border:1px solid #ccc">
			<option value="0">0-未处理</option>
			<option value="1">1-成功</option>
			<option value="3">3-失败</option>					
		</select></td>			
	    <td width="120">&nbsp;</td>
	    <td width="180">&nbsp;</td>
	  </tr>
	  <tr>
	   	<td width="120">流水号(seqOrder):</td>
	    <td width="180"><input id="seqOrder" name="seqOrder" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">业务类型(listType):</td>	    
	    <td width="180"><input id="listType" name="listType" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">批次号(otherListNo):</td>
	    <td width="180"><input id="otherListNo" name="otherListNo" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">&nbsp;</td>
	    <td width="180">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="120">摘要(listRem):</td>
	    <td width="180"><input id="listRem" name="listRem" style="line-height:20px;border:1px solid #ccc;width:180px"/></td>
	  </tr>
	  <tr>
	    <td colspan="5" align="right">
	    	<input type="button" onclick="doSubmit()" value="增加" />
	    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="queryBlank()">清空</a>&nbsp;&nbsp;
	    </td>
	  </tr>
	</table>
	</form>
	</fieldset>
	</div>
	<div id="resultMsg" style="display:none;">${result}</div>
</div>

<div id="tb1" style="padding:3px;background:#f4f4f4;font-size:12px">
	<fieldset>
	<legend class='dialog-label'>放款成功后处理操作</legend>
	<form id="payOutSuccessForm" action="<%=request.getContextPath()%>/acctManager/payoutSucessHandler.do" method="post"">
	<table width="1200" border="0" cellspacing="1" cellpadding="0">
	  <tr>
	    <td width="120">工作日(workDate):</td>
	    <td width="280"><input id="workDate" name="workDate" style="line-height:20px;border:1px solid #ccc"/>(格式:YYYY-MM-DD)</td>  
	    <td width="120">流水号(reqSeqNo):</td>
	    <td width="180"><input id="reqSeqNo" name="reqSeqNo" style="line-height:20px;border:1px solid #ccc"/></td>
	    <td width="120">&nbsp;</td>
	     <td colspan="5">
	    	<input type="button" onclick="doSubmit1()" value="发起" />
	    </td>
	  </tr>
	</table>
	</form>
	</fieldset>
	</div>
</div>
</body>
</html>
