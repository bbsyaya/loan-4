<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div title="申请信息" style="padding:20px;">
	<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
		<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">业务申请</legend>
		<table  width="100%">
		<tr>
			<td style="width:15%;word-break;" class="tdtitle"><input readonly="readonly" type="hidden" id="editLoanId" name="editLoanId"/>业务来源:</td>
			<td style="width:35%;word-break;"><select id="editChannel" name="editChannel" data-options="width:150"
				class="easyui-combobox" validType="selectedRequired" required=true editable=false readonly>
					<c:forEach items="${bizChannel}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
				</select></td>
			<td class="tdtitle">申请编号:</td><td><input id="editBizLoanId" name="editBizLoanId" class="easyui-validatebox" 
				size="30" maxlength="30" readonly/></td>
		</tr>
		<tr>
			<td class="tdtitle">申请金额:</td><td><input id="editApplyAmt" name="editApplyAmt" style="text-align:right;" readonly"/>（元）</td>
			<td style="width:15%;word-break;"  class="tdtitle">进件方式:</td>
			<td style="width:35%;word-break;">
				<select type="text" id="editInChannelKind" name="editInChannelKind"  data-options="width:150" readonly>
					<c:forEach items="${implTypeList}" var="obj">
						<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
				</select></td>
		</tr>
		<tr>
			<td class="tdtitle">偿还方式:</td><td><select id="editRepayMethod" name="editRepayMethod" readonly >
					<c:forEach items="${repayMethodList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
				</select></td>
			<td class="tdtitle">申请币种:</td><td><select id="editCurrSign" name="editCurrSign" readonly data-options="width:150" >
					<c:forEach items="${currSignList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
					</select>
				</td>
		</tr>
		<tr>
			<td class="tdtitle">收款账号:</td><td><input id="editBankAccno" name="editBankAccno" readonly /></td>
			<td class="tdtitle">还款方式:</td><td><select readonly id="editReturnKind" name="editReturnKind" readonly data-options="width:150" >
					<c:forEach items="${returnKindList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
				</select>	
			</td>
		</tr>
		<tr>
			<td class="tdtitle">账户开户行:</td>
			<td colspan="3"><table><tr>
				<td>
				<input type="text" class="easyui-validatebox" id="editBankName" readonly name="editBankName"/>
				</td>
				</tr></table>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">机构号/推荐机构:</td><td><input type="text" id="editRecOrg" name="editRecOrg" readonly /></td>
			<td class="tdtitle">营销经理/推荐人:</td><td><input type="text" id="editRecPerson" name="editRecPerson" readonly /></td>
		</tr>
</table>
</fieldset>
<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">客户信息</legend>
			<jsp:include page="editCustInfo.jsp"></jsp:include>
			</fieldset>
</div>
