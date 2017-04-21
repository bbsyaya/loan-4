<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--申请复议-->
    <div id="reconsiderWindow" class="easyui-window"  title="申请复议" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<div id="reconsiderWindow" class="easyui-layout" fit="true">
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="reconsider()" iconCls="icon-add" plain="true">确定</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeReconsiderWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
			<br/><br/>
			<table>
				<tr>
					<td align="right" valign="top">*申请复议原因:</td>
					<td colspan="3"><textarea id="reconsiderReason" name="reconsiderReason" cols="60" rows="5"></textarea></td>
				</tr>
			</table>
		</div>
	</div>