<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--任务回池-->
    <%  Object obj = session.getAttribute("USER");
        if(obj!=null && obj instanceof com.hrbb.loan.web.security.entity.User){
        com.hrbb.loan.web.security.entity.User user = (com.hrbb.loan.web.security.entity.User)obj;
    %>
    <div id="doNotClaimWindow" class="easyui-window"  title="任务回池" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<div id="doNotClaimWindow" class="easyui-layout" fit="true">
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="doNotClaim()" iconCls="icon-add" plain="true">确定</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeDoNotClaimWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
			<br/><br/>
			<table>
				<tr>
					<td align="right" valign="top">*回池原因:</td>
					<td colspan="3"><textarea id="backReason" name="backReason" cols="60" rows="5"></textarea></td>
				</tr>
				<tr>
					<td>当前审核人员:</td>
					<td><input type="text" id="username" name="rn_reviewday" value="<%= user.getLoginName() %>" readonly="readonly"/></td>
					<td>审核时间:</td>
					<td><input type="text" id="timenow" name="timenow" readonly="readonly"/></td>
				</tr>
			</table>
		</div>
		<% } %>
	</div>