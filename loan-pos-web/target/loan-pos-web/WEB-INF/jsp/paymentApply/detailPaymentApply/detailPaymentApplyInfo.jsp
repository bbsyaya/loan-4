<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- <div title="用款信息" style="padding:20px;"> -->
<table id="detailform" style="width:800px; ">
		<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">授信协议信息</legend>
				<table style="width:100%;"><jsp:include page="detailContractInfo.jsp"></jsp:include></table>
			</fieldset>
		</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">用款申请信息</legend>
                	<table style="width:100%;">
                		<tr>
                			<td style="width:15%;word-break;" class="tdtitle">业务渠道:</td><td><input type="text" id="channel" readonly="readonly" class="channel" value="${channelName}" size="30"/></td>
                			<td style="width:15%;word-break;" class="tdtitle">用款申请编号:</td><td><input type="text" id="payApplyId" readonly="readonly" class="payApplyId" value="${paymentApply.payApplyId}" size="30"/></td>
                		</tr>
                		<tr>
                		    <td class="tdtitle">客户名称:</td><td><input type="text" id="custName" readonly="readonly" class="custName" value="${contract.custName}" size="30"/></td>
                			<td class="tdtitle">商户名称:</td><td><input type="text" id="posCustName" readonly="readonly" class="posCustName" value="${contract.posCustName}" size="30"/></td> 
                		</tr>
                		<tr>
	                		<td class="tdtitle">用款金额:</td><td><input type="text" id="payApplyAmt" name="payApplyAmt" readonly="readonly" value="<fmt:formatNumber value="${paymentApply.payApplyAmt}" pattern="#,#00.00"/>" size="30"/></td> 
	                		<td class="tdtitle">用款期限:</td><td><input type="text" id="payApplyTerm" name="payApplyTerm" readonly="readonly" value="${paymentApply.payApplyTerm}" size="30"/></td>
                		</tr>
                		<tr>
                        	<td class="tdtitle">期望用款日期:</td>
							<td><input id="expectedDate" name="expectedDate" readonly="readonly" value="<fmt:formatDate value='${paymentApply.expectedDate}' pattern='yyyy-MM-dd'/>" size="30"/></td>
                			<td class="tdtitle">用款到期日:</td>
							<td><input id="expectedEndDate" name="expectedEndDate" readonly="readonly" value="<fmt:formatDate value='${paymentApply.expectedEndDate}' pattern='yyyy-MM-dd' />" size="30"/></td> 
                		</tr>
                		<tr>
                			<td class="tdtitle">还款方式:</td>
							<td><input id="returnType" name="returnType" readonly="readonly" value="${paybackMethodName}" size="30"/></td>
                			<td class="tdtitle">用款利率:</td>
                			<td><input id="payApplyInterest" readonly="readonly" name="payApplyInterest" value="${paymentApply.payApplyInterest}" size="30"/></td>
                		</tr>
                		<tr>
                			<td class="tdtitle">收款账号:</td>
							<td><input id="accNo" name="accNo" readonly="readonly" value="${paymentApply.accNo}" size="30"/></td>
                			<td class="tdtitle">账户开户行:</td>
                			<td><input id="bankInfo" name="bankInfo" value="${openBankName}${contract.accountBranchBank}${contract.accountSubBranchBank}" size="30"/></td>
                		</tr>
                	</table>
			</fieldset>
		</td></tr>
	</table>
<!-- </div> -->