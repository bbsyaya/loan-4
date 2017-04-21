<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!--任务认领-->
<!-- 
<div id="paymentClaimWindow" class="easyui-window"  region="center" title="任务认领" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;"> -->
	<table width="480px">
		<tr>
		<td width="15%">客户名称:</td><td width="35%"><input id="searchCustNameForPaymentClaim" name="searchCustNameForPaymentClaim" style="line-height:20px;border:1px solid #ccc"/></td>
		<td width="15%">商户名称:</td><td width="35%"><input id="searchPosCustNameForPaymentClaim" name="searchPosCustNameForPaymentClaim" style="line-height:20px;border:1px solid #ccc"/></td>
		</tr>
		<tr align="center"><td colspan="4">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryPaymentReview()" iconCls="icon-search" plain="true">查询</a>&nbsp;&nbsp;
		<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>&nbsp;&nbsp;
		</td></tr>
	</table>
	<table id="tc" class="easyui-datagrid" title="待审核用款申请" iconCls="icon-search" width="100%" style="height:360px" 
			 url="<%=request.getContextPath()%>/paymentApply/queryAvailableClaimPaymentApply.do?paymentStatus=10" 
			onClickRow="clickRow" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="id" checkbox="true"></th>
				<th field="payApplyId" hidden="true">
				<th field="custName" width="100px">客户名称</th>
				<th field="posCustName" width="180px">商户名称</th>
				<th field="payApplyAmt" width="110px">用款金额(元)</th>
				<th field="payApplyInterest" width="80px">用款利率(%)</th>
				<th field="payApplyTerm" width="80px">用款期限(月)</th>
				<th field="expectedDate" width="80px">期望用款日</th>
				<th field="expectedEndDate" width="80px">用款到期日</th>
				<th field="statusName" width="110px">申请状态</th>
			</tr>
		</thead>
	</table>
	<table width="100%"><tr><td align="center">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="claimPaymentApplyApprovals()" iconCls="icon-add">认领</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:void(0)"  onclick="closeClaimWindow()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</td></tr></table>
<!-- 
</div> -->