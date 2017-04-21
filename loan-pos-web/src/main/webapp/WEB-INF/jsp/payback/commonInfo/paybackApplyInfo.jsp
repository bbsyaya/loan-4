<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div title="还款申请" style="padding: 20px;">
	<table>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">贷款总余额:</td>
			<td style="width:35%;word-break;"><input type="text" class="insertSignLoanTotalBalance" readonly name="insertSignLoanTotalBalance" size ="30" value="${paybackApplyInfo.loanBalance}" /></td>
			<td class="tdtitle">到期日:</td>
			<td><input type="text" class="insertSignEndDate" readonly name="insertSignEndDate" size ="30" value="<fmt:formatDate value='${paybackApplyInfo.expectPaybackDate}' pattern='yyyy/MM/dd'/>"/></td>
		</tr>
		<tr>
			<td class="tdtitle">还款方式:</td>
			<td><select disabled="disabled" class="insertSignPaybackWay" name="insertSignPaybackWay">
					<c:forEach items="${returnKindList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == paybackApplyInfo.paybackWay}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
			</select></td>
			<td class="tdtitle">贷款偿还方式:</td>
			<td><select disabled="disabled" class="insertSignLoanPaybackWay" name="insertSignLoanPaybackWay">
					<c:forEach items="${repayMethodList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == paybackApplyInfo.loanPaybackWay}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="tdtitle">期望还款日期:</td>
			<td><input type="text" class="insertSignExpectPaybackDate" readonly name="insertSignExpectPaybackDate" value="<fmt:formatDate value='${paybackApplyInfo.expectPaybackDate}' pattern='yyyy/MM/dd'/>" size ="30"/></td>
			<td class="tdtitle">还款总金额:</td>
			<td><input type="text" class="insertSignPaybackTotalAmount" readonly name="insertSignPaybackTotalAmount" value="${paybackApplyInfo.paybackTotalAmount }" size ="30"/></td>
		</tr>
		<tr>
			<td class="tdtitle">还款本金:</td>
			<td><input type="text" class="insertSignPaybackAmount" readonly name="insertSignPaybackAmount" value="${paybackApplyInfo.paybackAmount }" size ="30"/></td>
			<td class="tdtitle">还款利息:</td>
			<td><input type="text" class="insertSignPaybackInterest" readonly name="insertSignPaybackInterest" value="${paybackApplyInfo.paybackInterest }" size ="30"/></td>
		</tr>
	</table>
</div>