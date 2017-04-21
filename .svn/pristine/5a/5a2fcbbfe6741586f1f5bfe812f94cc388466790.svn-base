<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<div title="贷款申请信息" style="height:750;padding:10px;">
			<table id="applyform" style="width:800px; "><tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
				<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">业务申请</legend>
				<table width="100%">
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">
							<input type="hidden" id="insertLoanId"	name="insertLoanId" value="${loanId}"/>业务来源:</td>
						<td style="width:35%;word-break;"><select id="insertChannel" name="insertChannel" data-options="width:150"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<c:forEach items="${bizChannel}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == 'ZY'}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td style="width:15%;word-break;" class="tdtitle">进件方式:</td>
						<td style="width:35%;word-break;">
							<select type="text" id="insertInChannelKind" name="insertInChannelKind" data-options="width:150,panelHeight:120"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false disabled="disabled">
								<c:forEach items="${implTypeList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == '04'}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>						
					</tr>
					<tr>
						<td class="tdtitle">
							<input type="hidden" id="insertApplyTerm"	name="insertApplyTerm" value="12"/>申请金额:</td>
						<td><input id="insertApplyAmt" name="insertApplyAmt" maxlength="10"  size="30" style="text-align:right;"
							class="easyui-numberbox" data-options="required:true,precision:2,max:2000000.00,groupSeparator:',' "
							onblur="validateRepay('#insertApplyAmt','#insertRepayMethod','#insertBankName')" />（元）</td>
						<td class="tdtitle">币种:</td>
						<td><select id="insertCurrSign" name="insertCurrSign" disabled="disabled"
								data-options="width:150" class="easyui-combobox">
								<c:forEach items="${currSignList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
								</select>
							</td>
					</tr>
					<tr>
						<td class="tdtitle">偿还方式:</td>
						<td><select id="insertRepayMethod" name="insertRepayMethod" 
							data-options="width:150,panelHeight:100,onChange:function (n,o){validateRepay('#insertApplyAmt','#insertRepayMethod','#insertBankName');}"  
								class="easyui-combobox" validType="selectedRequired" required=true editable=false >
								<c:forEach items="${repayMethodList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td class="tdtitle">还款方式:</td>
						<td><select disabled="disabled" id="insertReturnKind" name="insertReturnKind" 
								data-options="width:150" class="easyui-combobox">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == '90'}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>	
						</td>
					</tr>
					<tr>
						<td class="tdtitle">银行账号:</td>
						<td><input id="insertBankAccno" name="insertBankAccno" class="easyui-validatebox" 
							size="30" maxlength="30" data-options="required:true" onChange="javascript:valiateBankCard(this);"
							validType="number[8,20]" invalidMessage="账号填写错误"/></td>
						
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td class="tdtitle">账户开户行:</td>
						<td colspan="3"><table><tr>
							<td>
							<select	id="insertBankName" name="insertBankName" 
								data-options="width:150,onChange:function (n,o){validateRepay('#insertApplyAmt','#insertRepayMethod','#insertBankName');}"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择开户行--</option>
								<c:forEach items="${bankNoList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select>
							（银行）
							<input type="text" class="easyui-validatebox" data-options="required:true" id="insertBankBranName" 
							name="insertBankBranName" />
							（分行）
							<input type="text" class="easyui-validatebox" data-options="required:true" id="insertBankSubName" 
							name="insertBankSubName" />
							（支行）
							</td>
							</tr></table>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">营销/推荐人手机号:</td>
						<td><input type="text" id="insertRecContactNo" name="insertRecContactNo" size="30" onChange="javascript:loadRecInfo(this,'insert');"
							class="easyui-validatebox" validType="mobile" invalidMessage="手机号填写错误"/></td>
						<td class="tdtitle">营销经理/推荐人:</td>
						<td><input type="text" id="insertRecPerson"	name="insertRecPerson" size="30" disabled="disabled"/></td>
					</tr>
					<tr>
						<td class="tdtitle">机构号/推荐机构:</td>
						<td><input type="text" id="insertRecOrg" name="insertRecOrg" size="30" disabled="disabled"/></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></fieldset></td></tr>

				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">商户信息</legend>
				 	<table style="width:100%;"><jsp:include page="insertCreditPosCustInfo.jsp"></jsp:include></table>
				 	</fieldset></td></tr>				 
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">申请人信息</legend>
					<table style="width:100%;"><jsp:include page="insertCreditCustoInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">配偶信息</legend>
					<table style="width:100%;"><jsp:include page="insertCreditMateInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">亲属信息</legend>
					<table style="width:100%;"><jsp:include page="insertCreditRelaInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
			</table>
		</div>
