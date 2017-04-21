<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div title="申请信息" style="padding:20px;">
	<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
		<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">业务申请</legend>
		<table  width="100%">
		<tr>
			<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="detailLoanId" name="detailLoanId" readonly/>业务来源:</td>
			<td style="width:35%;word-break;"><select id="detailChannel" name="detailChannel" data-options="width:150" readonly>
					<c:forEach items="${bizChannel}" var="obj">
						<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
				</select></td>
			<td class="tdtitle">申请编号:</td><td><input id="detailBizLoanId" name="detailBizLoanId" data-options="width:200" readonly/></td>
		</tr>
		<tr>
			<td class="tdtitle">申请金额:</td><td><input id="detailApplyAmt" name="detailApplyAmt" data-options="width:200" readonly value="${applyDetail[0].applyAmt}"/>（元）</td>
			<td style="width:15%;word-break;"  class="tdtitle">进件方式:</td>
			<td style="width:35%;word-break;">
				<select id="detailInChannelKind" name="detailInChannelKind"  data-options="width:150,panelHeight:120" readonly>
					<c:forEach items="${implTypeList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
				</select></td>
		</tr>
		<tr>
			<td class="tdtitle">偿还方式:</td><td><select id="detailRepayMethod" name="detailRepayMethod" data-options="width:150" readonly>
					<c:forEach items="${repayMethodList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
				</select></td>
			<td class="tdtitle">申请币种:</td><td><select id="detailCurrSign" name="detailCurrSign" data-options="width:150" readonly >
					<c:forEach items="${currSignList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
					</select>
				</td>
		</tr>
		<tr>
			<td class="tdtitle">收款账号:</td><td><input id="detailBankAccno" name="detailBankAccno" readonly data-options="width:200"/></td>
			<td class="tdtitle">还款方式:</td><td><select readonly id="detailReturnKind" name="detailReturnKind" data-options="width:150">
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
					<input type="text" id="detailBankName" readonly name="detailBankName" />
				</td>
				</tr></table>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">机构号/推荐机构:</td><td><input type="text" id="detailRecOrg" name="detailRecOrg" readonly data-options="width:200"/></td>
			<td class="tdtitle">营销经理/推荐人:</td><td><input type="text" id="detailRecPerson"	name="detailRecPerson" readonly data-options="width:200"/></td>
		</tr>
</table>
</fieldset>
<br/>
<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">客户信息</legend>
			<jsp:include page="detailCustInfo.jsp"></jsp:include>
			</fieldset>
</div>