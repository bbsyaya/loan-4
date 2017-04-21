<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--补件-->
    <div id="addInfoWindow" class="easyui-window" title="影像资料补件" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<div id="addInfoWindow" class="easyui-layout" fit="true">
			<br/>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addInfoSubmit()" iconCls="icon-add" plain="true">确定</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeAddInfoWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
			<br/><br/>
			<table>
				<tr>
					<td>补件说明</td>
				</tr>
				<tr>
					<td><textarea id="needReason" name="needReason" cols="50" rows="3"></textarea></td>
				</tr>
				<tr>
					<td>选择需补件的类型</td>
				</tr>
			</table>
            <table id="tAddInfo" style="width:350px;height:280px" iconCls="icon-search" onClickRow="clickRow" rownumbers="true">
				<thead>
					<tr>
						<th field="addInfo_id" checkbox="true"></th>
						<th field="itemNo" width="50px"></th>
						<th field="itemName" width="180px"></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>