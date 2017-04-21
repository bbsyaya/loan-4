<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--任务认领-->
    <div id="claimWindow" class="easyui-window"  title="任务认领" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<div>
			<table>
				<tr>
					<td>申请编号:</td>
					<td><input id="searchBizLoanIdForClaim" name="searchBizLoanIdForClaim" style="line-height:20px;border:1px solid #ccc"/></td>
					<td>商户名称:</td>
					<td><input id="searchPosCustNameForClaim" name="searchPosCustNameForClaim" style="line-height:20px;border:1px solid #ccc"/></td>
				</tr>
				<tr>
					<td>客户编号:</td>
					<td><input id="searchCustIdForClaim" name="searchCustIdForClaim" style="line-height:20px;border:1px solid #ccc"/></td>
					<td>客户名称:</td>
					<td><input id="searchCustNameForClaim" name="searchCustNameForClaim" style="line-height:20px;border:1px solid #ccc"/></td>
				</tr>
			</table>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryCreditApplyForClaim()" iconCls="icon-search" plain="true">查询</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="initClaimWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
			<br/><br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="claim()" iconCls="icon-add" plain="true">认领</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeClaimWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
			<table id="tClaim" style="width:920px;height:320px" iconCls="icon-search" onClickRow="clickRow" rownumbers="true" pagination="true">
				<thead>
					<tr>
						<th field="id" checkbox="true"></th>
						<th field="bizLoanId" width="190px">申请编号</th>
						<th field="loanId" hidden="true">申请流水号</th>
						<th field="channelName" width="70px">业务渠道</th>
						<th field="inChannelKindName" width="70px">进件方式</th>
						<th field="custName" width="150px">客户名称</th>
						<!-- <th field="posCustName" width="150px">商户名称</th> -->
						<th field="prodName" hidden="true">产品</th>
						<th field="beginDateStr" width="80px">申请日期</th>
						<!-- <th field="applyAmt" width="100px" align="right" formatter="formatMoney">申请额度</th> -->
						<th field="applyTerm" hidden="true">申请期限</th>
						<th field="region" hidden="true">地区</th>
						<th field="applyStatusName" width="80px">当前状态</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>