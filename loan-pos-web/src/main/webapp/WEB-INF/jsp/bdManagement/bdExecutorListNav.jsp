<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 机构人员列表 -->
<table id="executorTT" class="easyui-datagrid" title="Searching"
	iconCls="scon-search" toolbar="#executorTB" onclickRow="clickRow"
	rownumbers="true" pagination="true" 
	url="<%=request.getContextPath()%>/bdManagement/queryBDExecutor.do?belongOrg=${belongOrg}" singleSelect="true">
	<thead>
		<tr>
			<th field="menberId" checkbox="true"></th>
			<th field="menberName" width="80px">人员名称</th>
			<th field="certNo" width="150px">身份证号</th>
			<th field="birthDate" width="100" formatter="dateFormat">出生日期</th>
			<th field="contactNo" width="100px">联系电话</th>
			<th field="email" width="160px">邮箱</th>
			<th field="address" width="160px">地址</th>
			<th field="remark" width="160px">备注</th>
			<th field="active" width="50px">状态</th>
			<th field="modifyTime" formatter="dateFormat">修改时间</th>
		</tr>
	</thead>
</table>
