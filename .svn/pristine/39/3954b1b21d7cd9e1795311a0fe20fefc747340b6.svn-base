<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!--任务回池-->
<form id="taskBackPoolform">
	<input id="payApplyId" type="hidden" name="payApplyId" value="${payApplyId}" />
	<table style="width: 100%; margin-top: 20px">
		<tr>
			<td>回池原因:</td>
			<td colspan="3"><textarea id="reason" style="width: 95%" name="backReason"></textarea></td>
		</tr>
		<tr>
			<td>当前审核人：</td>
			<td><input id="userName" name="userName" value="${userName}" /></td>
			<td>当前审核时间：</td>
			<td><input id="currDate" name="currDate" value="${currDate}" /></td>
		</tr>
	</table>
	<table style="width: 100%; margin-top: 30px">
		<tr>
			<td align="center"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTaskBackPoolButton()" iconCls="icon-save">提交</a>&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="javascript:void(0)" onclick="colseTaskBackPoolWindow()" class="easyui-linkbutton" iconCls="icon-cancel">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</form>
