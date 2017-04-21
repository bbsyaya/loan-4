<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page import="com.hrbb.loan.web.security.entity.User"%>
<!--新增窗口-->
<form method="post" id="insertPaymentApplyForm">
<input type="hidden" name="contNo" id="contNo" value="${contNo}"/>
	<table width="100%">
	<!-- 协议信息 -->
	<tr>
		<td>
			<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;" >
				<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">协议信息</legend>
				<table  width="100%">
					<tr>
						<td class="tdtitle" width="15%">客户名称</td>
						<td width="35%"><input name="custName" id="custName" value="${contract.custName}" readonly="readonly" width="100%" size="30"/></td>
						<td class="tdtitle" width="15%">商户名称</td>
						<td width="35%"><input name="posCustName" id="posCustName" value="${contract.posCustName}" readonly="readonly" size="30"/></td>
					</tr>
					<tr>
						<td class="tdtitle">授信金额（元）</td>
						<td><input id="creditLine" name="creditLine" value="${contract.creditLine}" readonly="readonly" size="30"/></td>
						<td class="tdtitle" >授信利率（%）</td>
						<td><input id="creditInterest" name="creditInterest" value="${contract.creditInterest}" readonly="readonly" size="30"/></td>
					</tr>
					<tr>
						<td class="tdtitle">授信期限（月）</td>
						<td><input id="contTerm" name="contTerm" value="${contract.contTerm}" readonly="readonly" size="30"/></td>
						<td class="tdtitle">可用额度（元）</td>
						<td><input id="availableBalance" name="availableBalance" value="${availableBalance}" size="30" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="tdtitle">协议生效日期</td>
						<td><input id="beginDate" name="beginDate" value="<fmt:formatDate value='${contract.beginDate}' pattern='yyyy-MM-dd'/>" readonly="readonly" size="30"/></td>
						<td class="tdtitle">协议到期日期</td>
						<td><input id="endDate" name="endDate" value="<fmt:formatDate value='${contract.endDate}' pattern='yyyy-MM-dd'/>" readonly="readonly" size="30"/></td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	</br>
	<!-- 用款信息 -->
	<tr>
		<td>
			<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;" >
				<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">用款信息</legend>
				<table width="100%">
					<tr>
						<td class="tdtitle" width="15%">用款金额（元）</td>
						<td width="35%"><input id="payApplyAmt" name="payApplyAmt" size="30"
							class="easyui-numberbox" data-options="required:true,precision:2,max:${availableBalance} "/></td>
						<td class="tdtitle" width="15%">用款期限（月）</td>
						<td width="35%"><input id="payApplyTerm" name="payApplyTerm" onblur="calculateExpectedEndDate()" size="30" maxlength="1"
							class="easyui-numberbox" data-options="required:true,max:3,min:1,precision:0 "/></td>
					</tr>
					<tr>
						<td class="tdtitle">期望用款日期</td>
						<td><input id="expectedDate" name="expectedDate" class="easyui-datebox" value="<fmt:formatDate value='<%=new Date()%>' pattern='yyyy-MM-dd'/>" size="30"
							data-options="onSelect:function(date){varifyStartDate(date);calculateExpectedEndDate();}"/></td>
						<td class="tdtitle">用款到期日</td>
						<td><input id="expectedEndDate" name="expectedEndDate" disabled="disabled" size="30"/></td>
					</tr>
					<tr>
						<td class="tdtitle">还款方式</td>
						<td><select id="returnType" name="returnType" data-options="width:150,panelHeight:100" class="easyui-combobox" readonly="readonly">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == contract.paybackMethod}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td class="tdtitle">用款利率（%）</td>
						<td><input id="payApplyInterest" name="payApplyInterest" value="<fmt:formatNumber value='${contract.approveInterest}' pattern='0.00'/>" size="30" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="tdtitle">银行账号</td>
						<td colspan="3"><input id="accNo" name="accNo" value="${contract.acceptAccount}" size="30" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="tdtitle">开户行信息</td>
						<td colspan="3"><input id="" name="" value="${contract.accountOpenBank}${contract.accountBranchBank}${contract.accountSubBranchBank}" size="30"/></td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	</br>
	<!-- 登记信息 -->
	<tr>
		<td>
			<fieldset style="padding:5px; color:#333; border:#06c dashed 1px;" >
				<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">登记信息</legend>
				<table width="100%">
					<tr>
						<td class="tdtitle" width="15%">经办人</td>
						<td width="35%"><input name="" value='<%=((User)request.getSession().getAttribute("USER")).getUserName()%>' size="30" readonly="readonly" /></td>
						<td class="tdtitle" width="15%">经办日期</td>
						<td width="35%"><input name="" value="<fmt:formatDate value='<%=new Date()%>' pattern='yyyy-MM-dd'/>" size="30" readonly="readonly" /></td>
					</tr>
				</table>
			</fieldset>
		</td>
	</tr>
</table>
</form>
<br/>
<div border="false" style="text-align: center; height: 30px; line-height: 30px;">
	<a id="btnEpinsert2" onclick="savePaymentApply()" class="easyui-linkbutton" icon="icon-save" plain="true" href="javascript:void(0)">保存</a>
	<a id="btnIPCancel" onclick="closeInsertPaymentApply()" class="easyui-linkbutton" icon="icon-back" plain="true" href="javascript:void(0)">返回</a>
</div>