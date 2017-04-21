<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 自动风险探测 -->
<div title="自动风险探测" style="padding:20px;">
    <table id="tRisk" class="easyui-datagrid"
			style="width:800px;height:500px" fitColumns="true" rownumbers="true">
		<thead>
			<tr>
				<th field="checkInfor" width="200px">检查内容</th>
				<th data-options="field:'checkRezult',width:60, formatter: imgFormatter" align="center">检查结果</th>
				<th field="noticeInfor" width="540px">提示信息</th>
			</tr>
		</thead>
	</table>
</div>