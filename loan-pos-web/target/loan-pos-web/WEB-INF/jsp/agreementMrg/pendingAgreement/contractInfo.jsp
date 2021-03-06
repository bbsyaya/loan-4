<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 
	<div title="协议信息" style="padding: 20px;"> -->
	<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
		<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">协议信息</legend>
		<table width="100%">
			<tr>
				<td width="15%" class="tdtitle">业务渠道:</td>
				<td width="35%"><select disabled="disabled" id="insertSignChannelName" name="insertSignChannelName" class="easyui-combobox" data-options="width:150">
						<c:forEach items="${bizChannel}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq approveResult.businessSource}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
				<td width="15%" class="tdtitle">进件方式:</td>
				<td width="35%"><select disabled="disabled" id="insertSignImportWay" name="insertSignImportWay" class="easyui-combobox" data-options="width:150">
						<c:forEach items="${implTypeList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq inChannelKind}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="tdtitle">客户名称:</td>
				<td><input type="text" id="insertSignCustName" readonly name="insertSignCustName" value="${approveResult.custName }" size="30"/></td>
				<td class="tdtitle">证件号码:</td>
				<td><input type="text" id="certNo" readonly name="certNo" value="${customer.paperId}" size="30"/></td>
			</tr>
			<tr>
				<td class="tdtitle">商户名称:</td>
				<td><input type="text" id="insertSignPosCustName" readonly name="insertSignPosCustName" value="${approveResult.posCustName}" size="30"/></td>
				<td class="tdtitle">证件类型:</td>
				<td><select disabled="disabled" id="certType" name="certType" >
						<c:forEach items="${paperList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq customer.paperKind}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="tdtitle">产品名称:</td>
				<td><input type="text" id="insertSignProdName" readonly name="insertSignProdName" value="${apply.prodName}" size="30"/></td>
				<td class="tdtitle">还款方式:</td>
				<td><select disabled="disabled" id="insertSignPaybackMethod"
					name="insertSignPaybackMethod" >
						<c:forEach items="${returnKindList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq approveResult.paybackMethod}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="tdtitle">授信金额:</td>
				<td><input type="text" id="insertSignApproveAmount" readonly name="insertvApproveAmount" value="${approveResult.approveAmount}" size="30"/></td>
				<td class="tdtitle">授信币种:</td>
				<td><select disabled="disabled" id="insertSignApproveMoneyKind"
					name="insertSignApproveMoneyKind"
					value="${approveResult.approveMoneyKind}">
						<c:forEach items="${currSignList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq approveResult.approveMoneyKind}'>selected='selected'</c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="tdtitle">授信利率:</td>
				<td><input type="text" id="insertSignApproveInterest" readonly name="insertSignApproveInterest1" value="${approveResult.approveInterest}" size="30"/></td>
				<td class="tdtitle">授信期限:</td>
				<td><input type="text" id="insertSignApproveTerm" readonly name="insertSignApproveTerm1" value="${approveResult.approveTerm}" size="30"/></td>
			</tr>
			<tr>
				<td class="tdtitle">账户开户行:</td>
				<td><input type="text" id="insertSignAccountOpenBank" readonly name="insertSignAccountOpenBank1" value="${accountOpenBank}" size="30"/></td>
				<td class="tdtitle">银行账号:</td>
				<td><input type="text" id="insertSignAcceptAccount" readonly name="insertSignAcceptAccount1" value="${approveResult.acceptAccount}" size="30"/></td>
			</tr>
			<tr>
				<td class="tdtitle">账户分行:</td>
				<td><input type="text" id="insertSignAccountBranchBank" readonly name="insertSignAccountBranchBank1" value="${approveResult.accountBranchBank}" size="30"/></td>
				<td class="tdtitle">账户支行:</td>
				<td><input type="text" id="insertSignAccountSubBranchBank" readonly name="insertSignAccountSubBranchBank1" value="${approveResult.accountSubBranchBank}" size="30"/></td>
			</tr>
			<tr>
				<td class="tdtitle">协议生效日期:</td>
				<td><input class="easyui-datebox" type="text" id="insertSignContractBeginDate" name="insertSignContractBeginDate" size="30"
					value="<fmt:formatDate value='${beginDate}' pattern='yyyy-MM-dd'/>" /></td>
				<td class="tdtitle">协议到期日期:</td>
				<td><input class="easyui-datebox" type="text" id="insertSignContractEndDate" name="insertSignContractEndDate" size="30"
					value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>" readonly /></td>
			</tr>
			<tr>
				<td class="tdtitle">签订日期:</td>
				<td><input class="easyui-datebox" type="text" id="insertSignDate" readonly name="insertSignDate" size="30"
					value="<fmt:formatDate value='<%=new Date()%>' pattern='yyyy-MM-dd'/>" /></td>
			</tr>
		</table>
	</fieldset>
	<br/>
	<c:if test="${apply.repayMethod eq '01'}">
	<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
		<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">还款账号信息</legend>
		<table width="100%">
			<tr>
				<td width="15%" class="tdtitle">还款账号:</td>
				<td width="35%"><input type="text" id="repayAccountNo" readonly name="repayAccountNo" value="${repayAccount.accountIssue}" size="30"/></td>
				<td width="15%" class="tdtitle">账户名称:</td>
				<td width="35%"><input type="text" id="repayAccountName" readonly name="repayAccountName" value="${repayAccount.acctIssueName}" size="30"/></td>
			</tr>
		</table>
	</fieldset>
	</c:if>
<!-- 
	</div>-->