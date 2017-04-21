<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--添加为黑名单-->
    <div id="blackListForReviewWindow" class="easyui-window"  title="添加为黑名单" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 600px; height: 300px; padding: 5px; background: #fafafa;">
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveBlackListForReview()" iconCls="icon-add" plain="true">确定</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="closeBlackListForReviewWindow()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">取消</a>
			<br/><br/>
			<table>
				<tr>
					<td>添加理由</td>
				</tr>
				<tr>
					<td><textarea id="confirmReason" name="confirmReason" cols="50" rows="3"></textarea></td>
				</tr>
				<tr>
					<td>选择认定维度</td>
				</tr>
			</table>
			<table id="tBlackListForReview" style="width:600px;height:230px" iconCls="icon-search" onClickRow="clickRow" rownumbers="true">
				<thead>
					<tr>
						<th field="id" checkbox="true"></th>
						<th field="infoDimension" width="150px">认定维度</th>
						<th field="infoType" hidden="true">认定类型</th>
						<th field="infoTypeName" width="50px">认定类型</th>
						<th field="infoDetail" width="200px">认定维度结果</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>