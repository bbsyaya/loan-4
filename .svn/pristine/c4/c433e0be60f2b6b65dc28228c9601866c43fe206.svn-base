<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<div title="贷款申请信息" style="padding:20px;">
		<table id="editform" style="width:800px; "><tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">业务申请</legend>
					<table  width="100%">
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input readonly="readonly" type="hidden" id="detailLoanId" name="detailLoanId" value="${loanId}"/>业务来源:</td>
						<td style="width:35%;word-break;"><select id="detailChannel" name="detailChannel" data-options="width:150"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false readonly>
								<c:forEach items="${bizChannel}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].channel}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td class="tdtitle">申请编号:</td><td><input id="editBizLoanId" name="editBizLoanId" class="easyui-validatebox" 
							size="30" maxlength="30" value="${applyDetail[0].bizLoanId}" readonly/></td>
					</tr>
					<tr>
						<td class="tdtitle">申请金额:</td><td><input id="detailApplyAmt" name="detailApplyAmt" maxlength="10"  size="30" style="text-align:right;"
							class="easyui-numberbox" readonly value="${applyDetail[0].applyAmt}" data-options="groupSeparator:',',precision:2"/>（元）</td>
						<td style="width:15%;word-break;"  class="tdtitle">进件方式:</td>
						<td style="width:35%;word-break;">
							<select type="text" id="detailInChannelKind" name="detailInChannelKind"  data-options="width:150,panelHeight:120"
								class="easyui-combobox" editable=false readonly>
								<c:forEach items="${implTypeList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].inChannelKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">偿还方式:</td><td><select id="editRepayMethod" name="editRepayMethod" readonly
								class="easyui-combobox" validType="selectedRequired" required=true editable=false >
								<c:forEach items="${repayMethodList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].repayMethod}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td class="tdtitle">申请币种:</td><td><select id="detailCurrSign" name="detailCurrSign" readonly
								data-options="width:150" class="easyui-combobox">
								<c:forEach items="${currSignList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].currSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
								</select>
							</td>
					</tr>
					<tr>
						<td class="tdtitle">收款账号:</td><td><input id="detailBankAccno" name="detailBankAccno" class="easyui-validatebox"  readonly
							size="30" value="${applyDetail[0].bankAccno}"/></td>
						<td class="tdtitle">还款方式:</td><td><select readonly id="detailReturnKind" name="detailReturnKind" readonly
								data-options="width:150" class="easyui-combobox">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].returnKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>	
						</td>
					</tr>
					<tr>
						<td class="tdtitle">账户开户行:</td>
						<td colspan="3"><table><tr>
							<td>
							<select	id="detailBankName" name="detailBankName" class="easyui-combobox" editable=false readonly>
								<option value="">--请选择开户行--</option>
								<c:forEach items="${bankNoList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[4].bankName}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
							（银行）
							<input type="text" class="easyui-validatebox" id="detailBankBranName" readonly
							name="detailBankBranName" value="${applyDetail[4].bankBranName}"/>
							（分行）
							<input type="text" class="easyui-validatebox" id="detailBankSubName" readonly
							name="detailBankSubName" value="${applyDetail[4].bankSubbName}"/>
							（支行）
							</td>
							</tr></table>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">机构号/推荐机构:</td><td><input type="text" id="detailRecOrg" name="detailRecOrg" size="30" readonly value="${applyDetail[0].recOrg}"/></td>
						<td class="tdtitle">营销经理/推荐人:</td><td><input type="text" id="detailRecPerson"	name="detailRecPerson" size="30"  readonly value="${applyDetail[0].recPerson}"/></td>
					</tr>
				</table></fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">申请人信息</legend>
				 	<table style="width:100%;"><jsp:include page="detailCreditCustInfo.jsp"></jsp:include></table>
				 	</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">商户信息</legend>
				<table style="width:100%;"><jsp:include page="detailCreditPosCustInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">配偶信息</legend>
					<table style="width:100%;"><jsp:include page="detailCreditMateInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">亲属信息</legend>
					<table style="width:100%;"><jsp:include page="detailCreditRelaInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
			</table>
			</div>