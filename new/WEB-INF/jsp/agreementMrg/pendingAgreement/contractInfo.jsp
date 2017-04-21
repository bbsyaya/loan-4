<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<div title="协议信息" style="padding: 20px;">
		<table>
			<tr>
				<td>*业务渠道:</td>
				<td><select disabled="disabled" id="insertSignChannelName"
					name="insertSignChannelName">
						<c:forEach items="${bizChannel}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq approveResult.businessSource}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
				<td>*进件方式:</td>
				<td><select disabled="disabled" id="insertSignImportWay"
					name="insertSignImportWay" >
						<c:forEach items="${implTypeList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq inChannelKind}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>*客户名称:</td>
				<td><input type="text" id="insertSignCustName" readonly
					name="insertSignCustName" value="${approveResult.custName }" /></td>
				<td>*商户名称:</td>
				<td><input type="text" id="insertSignPosCustName" readonly
					name="insertSignPosCustName" value="${approveResult.posCustName}" /></td>
			</tr>
			<tr>
				<td>*产品名称:</td>
				<td><input type="text" id="insertSignProdName" readonly
					name="insertSignProdName" value="" /></td>
				<td>*还款方式:</td>
				<td><select disabled="disabled" id="insertSignPaybackMethod"
					name="insertSignPaybackMethod" >
						<c:forEach items="${returnKindList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq approveResult.paybackMethod}'> selected='selected' </c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>*授信金额:</td>
				<td><input type="text" id="insertSignApproveAmount" readonly 
					name="insertvApproveAmount" value="${approveResult.approveAmount}" /></td>
				<td>*授信币种:</td>
				<td><select disabled="disabled" id="insertSignApproveMoneyKind"
					name="insertSignApproveMoneyKind"
					value="${approveResult.approveMoneyKind}">
						<c:forEach items="${currSignList}" var="obj">
							<option value="${obj.itemNo}" <c:if test='${obj.itemNo eq approveResult.approveMoneyKind}'>selected='selected'</c:if>>${obj.itemName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>*授信利率:</td>
				<td><input type="text" id="insertSignApproveInterest" readonly
					name="insertSignApproveInterest1"
					value="${approveResult.approveInterest}" /></td>
				<td>*授信期限:</td>
				<td><input type="text" id="insertSignApproveTerm" readonly
					name="insertSignApproveTerm1" value="${approveResult.approveTerm}" /></td>
			</tr>
			<tr>
				<td>*账户开户行:</td>
				<td><input type="text" id="insertSignAccountOpenBank" readonly
					name="insertSignAccountOpenBank1"
					value="${accountOpenBank}" /></td>
				<td>*银行账号:</td>
				<td><input type="text" id="insertSignAcceptAccount" readonly
					name="insertSignAcceptAccount1"
					value="${approveResult.acceptAccount}" /></td>
			</tr>
			<tr>
				<td>*账户分行:</td>
				<td><input type="text" id="insertSignAccountBranchBank" readonly
					name="insertSignAccountBranchBank1"
					value="${approveResult.accountBranchBank}" /></td>
				<td>*账户支行:</td>
				<td><input type="text" id="insertSignAccountSubBranchBank"
					readonly name="insertSignAccountSubBranchBank1"
					value="${approveResult.accountSubBranchBank}" /></td>
			</tr>
			<tr>
				<td>*协议生效日期:</td>
				<td><input class="easyui-datebox" type="text"
					id="insertSignContractBeginDate" name="insertSignContractBeginDate"
					value="<fmt:formatDate value='${beginDate}' pattern='yyyy-MM-dd'/>" /></td>
				<td>*协议到期日期:</td>
				<td><input class="easyui-datebox" type="text"
					id="insertSignContractEndDate" name="insertSignContractEndDate"
					value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>"
					readonly /></td>
			</tr>
			<tr>
				<td>*签订日期:</td>
				<td><input class="easyui-datebox" type="text"
					id="insertSignDate" readonly name="insertSignDate"
					value="<fmt:formatDate value='<%=new Date()%>' pattern='yyyy-MM-dd'/>" /></td>
			</tr>
		</table>
	</div>