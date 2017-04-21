<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--复审照会-->
    <div id="reviewNoteListWindow" class="easyui-window"  title="复审照会记录" collapsible="false" minimizable="false" closed="true"
        maximizable="true" icon="icon-save"  style="width: 1000px; height: 500px; padding: 5px; background: #fafafa;">
		<div id="reviewNoteListWindow" class="easyui-layout" fit="true">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="reviewNote()" iconCls="icon-add" plain="true">新增</a>
			&nbsp;&nbsp;<a href="javascript:void(0)" onclick="delReviewNote()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">删除</a>
			<br/><br/>
			<table id="tReviewNote" style="width:800px;height:350px" iconCls="icon-search" onClickRow="clickRow" rownumbers="true">
				<thead>
					<tr>
						<th field="rn_id" checkbox="true"></th>
						<th field="reviewid" hidden="true">照会编号</th>
						<th field="teltype" width="100px">照会电话类型</th>
						<th field="tel" width="150px">照会电话号码</th>
						<th field="relationtype" width="70px">照会对象</th>
						<th field="result" width="70px">核实结果</th>
						<th field="reviewdayStr" width="70px">照会日期</th>
						<th field="registrarname" width="70px">复审人</th>
						<th field="note" width="200px">备注</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<jsp:include page="reviewNote.jsp"/>