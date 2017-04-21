<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>认领外呼任务</title>
</head>
<body>

<div id="claimCallingTaskWindow" class="easyui-window" title="认领外呼任务" closed="true" collapsible="false" minimizable="false" maximizable="true" icon="icon-save"
style="width: 1000px; height: 500px; padding: 5px;background: #fafafa;">
	
	<div id="tb" style="padding:3px">
	
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="claimCallingTask()" iconCls="icon-add" plain="true">认领</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeClaimWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>

			<table>
				<tr>
					<td>客户名称:</td>
					<td><input id="searchCustNameForClaim" name="searchCustNameForClaim" style="line-height:20px;border:1px solid #ccc"/>
					<input type="hidden" id="searchCustNameHiddenForClaim" name="searchCustNameHiddenForClaim"  />
					<td>商户名称:</td>
					<td><input id="searchPosCustNameForClaim" name="searchPosCustNameForClaim" style="line-height:20px;border:1px solid #ccc"/>
					<input type="hidden" id="searchPosCustNameHiddenForClaim" name="searchPosCustNameHiddenForClaim"  />
				</tr>
				<tr>
					<td>任务类型:</td>
					<td><select id="searchCallingTypeForClaim" name="searchCallingTypeForClaim" >
						<option>
						</option>
						<c:forEach items="${callingTypeList}" var="obj">
									<option value="${obj.itemNo}">
									 ${obj.itemName}
									 </option>
						</c:forEach>
					</select>
					<input type="hidden" id="searchCallingTypeHiddenForClaim" name="searchCallingTypeHiddenForClaim"  />
					</td>
					
				</tr>
			</table>
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryCallingTaskForClaim()" iconCls="icon-search" plain="true">查询</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="queryClaimClear()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">清空</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="recoverClaim()" class="easyui-linkbutton" iconCls="icon-mini-edit" plain="true">恢复</a>
	</div>
	<table id="tClaim" style="width:1175px;height:500px"	onClickRow="clickRow" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="taskNo" checkbox="true" ></th>
				<th field="custName" width="190px">客户名称</th>
				<th field="posCustName" width="70px">商户名称</th>
				<th field="generateTime" width="150px">任务生成时间</th>
				<th field="callingTypeName" width="150px">任务类型</th>
				<th field="claimerName" width="150px">认领人</th>
				<th field="claimTime" width="150px">认领时间</th>
			</tr>
		</thead>
	</table>
	
</div>
</body>
</html>