<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/p_validator.js"></script>
<div id="adjustApproval" class="easyui-layout" fit="true">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="adjustApproval()" iconCls="icon-ok" plain="true">调件</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeAdjustApprovalWindow()" iconCls="icon-cancel" plain="true">关闭</a>
	<input type="hidden" id="adjustLoanId" name="adjustLoanId" value="${applyInfo.loanId }"/>
	<table>
		<tr>
			<td width="100" class="tdtitle">复审阶段：</td>
			<td>
				<select id="approvalLevel" class="easyui-combobox" editable=false data-options="width:150,panelHeight:150,onChange:function (n,o){selectApprovalPerson(n,$('#approvalPerson'));}">
					<option value="">--请选择--</option>
					<option value="31" <c:if test="${'31' == applyInfo.applyStatus }">selected</c:if>>风险复审1</option>
					<option value="33" <c:if test="${'33' == applyInfo.applyStatus }">selected</c:if>>风险复审2</option>
					<option value="34" <c:if test="${'34' == applyInfo.applyStatus }">selected</c:if>>风险复审3</option>
					<option value="35" <c:if test="${'35' == applyInfo.applyStatus }">selected</c:if>>风险复审4</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">复审人：</td>
			<td>
				<select id="approvalPerson" class="easyui-combobox" editable="false"  data-options="width:150,panelHeight:150">
					<option value="">--请选择--</option>
					<c:forEach items="${userList }" var="obj">
						<option value="${obj.userName }" <c:if test="${applyInfo.creditRecheckPerson==obj.userName}">selected</c:if>>${obj.loginName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">

</script>