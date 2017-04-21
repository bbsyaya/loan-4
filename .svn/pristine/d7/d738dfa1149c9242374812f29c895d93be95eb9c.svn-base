<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div title="任务详情">
	<table >
		<thead>
			<tr>
				<td>外呼任务信息</td>
			</tr>
			<tr>
				<td>外呼任务类型</td>
				<td><input id="callingType" name="callingType" value="${taskObj.callingType}" style="line-height:20px;border:1px solid #ccc" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>任务生成时间</td>
				<td><input id="generateTime" name="generateTime" value="${taskObj.generateTime}" style="line-height:20px;border:1px solid #ccc" disabled="disabled"/></td>
				<td>认领人名称</td>
				<td><input id="claimerName" name="claimerName" value="${taskObj.claimerName}" style="line-height:20px;border:1px solid #ccc" disabled="disabled"/></td>
	
			</tr>
			<tr>
				<td>业务所处阶段</td>
				<td><input id="relaBizPhaseName" name="relaBizPhaseName" value="${taskObj.relaBizPhaseName}" style="line-height:20px;border:1px solid #ccc" disabled="disabled"/></td>
				<td>业务编号</td>
				<td><input id="relaBizNo" name="relaBizNo" value="${taskObj.relaBizNo}" style="line-height:20px;border:1px solid #ccc" disabled="disabled"/></td>
	
			</tr>
			<tr>
    			<td class="tdtitle"><br/>意见详情：</td>
    			<td colspan="3"><textarea id="dealInfo" name="dealInfo" cols="50" rows="3">${taskObj.dealInfo}</textarea></td>
    		</tr>
		</thead>					
	</table>
	 <div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
    	
		<a id="btnEpinsert" onclick="completeCallingTaskClimer()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">处理完成</a>

		<a id="btnCancel" onclick="closeCallingTaskDetailWindow()" class="easyui-linkbutton" icon="icon-cancel"	href="javascript:void(0)">放弃处理</a>
 	</div>
</div>
