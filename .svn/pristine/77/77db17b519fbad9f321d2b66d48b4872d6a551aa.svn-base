<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!--任务认领-->
<div id="paymentClaimWindow" class="easyui-window"  region="center" title="任务认领" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="claimPaymentApplyApprovals()" iconCls="icon-add" plain="true">认领</a>
		&nbsp;&nbsp;<a href="javascript:void(0)"  onclick="closeClaimWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
		<br/><br/>
		<div id="searchTC">
		<span>申请流水号:</span>
		<input id="searchPayApplyIdForPaymentClaim" name="searchPayApplyIdForPaymentClaim" style="line-height:20px;border:1px solid #ccc"/>
		<span>商户名称:</span>
		<input id="searchPosCustNameForPaymentClaim" name="searchPosCustNameForPaymentClaim" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<span>客户名称:</span>
		<input id="searchCustNameForPaymentClaim" name="searchCustNameForPaymentClaim" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户证件号:</span>
		<input id="searchPaperIdForPaymentClaim" name="searchPaperIdForPaymentClaim" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryPaymentApply()" iconCls="icon-search" plain="true">查询</a>
		&nbsp;&nbsp;
		<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
		</div>
	<table id="tc" class="easyui-datagrid" title="searing..." iconCls="icon-search" toolbar="searchTC" width="100%" height="1000px" 
			 url="<%=request.getContextPath()%>/paymentApply/queryAvailableClaimPaymentApply.do?paymentStatus=10" 
			onClickRow="clickRow" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="id" checkbox="true"></th>
				<th field="payApplyId" >
				<th field="custName" width="110px">客户名称</th>
				<th field="posCustName" width="110px">商户名称</th>
				<th field="payApplyAmt" width="110px">用款金额(元)</th>
				<th field="payApplyInterest" width="110px">用款利率(%)</th>
				<th field="payApplyTerm" width="110px">用款期限(月)</th>
				<th field="expectedDate" width="110px">期望用款日</th>
				<th field="expectedEndDate" width="110px">用款到期日</th>
				<th field="statusName" width="110px">申请状态</th>
			</tr>
		</thead>
	</table>
</div>