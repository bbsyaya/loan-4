<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div title="贷款申请信息" style="padding:20px;">
		<table id="editform" style="width:860px; ">
		<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">发生方式</legend>
					<table style="width:100%;"><jsp:include page="editCreditOccurTypeInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
		<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">业务申请</legend>
               	<table width="100%">
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="editLoanId" name="editLoanId" value="${loanId}"/>业务来源:</td>
						<td style="width:35%;word-break;"><select id="editChannel" name="editChannel" data-options="width:150"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false >
								<c:forEach items="${bizChannel}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].channel}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td class="tdtitle">申请编号:</td><td><input id="editBizLoanId" name="editBizLoanId" class="easyui-validatebox" 
							size="30" maxlength="30" value="${applyDetail[0].bizLoanId}" disabled="disabled"/></td>
					</tr>
					<tr>
						<td class="tdtitle">申请金额:</td><td><input id="editApplyAmt" name="editApplyAmt" maxlength="10"  size="30" style="text-align:right;"
							class="easyui-numberbox" data-options="required:true" precision="2" max="9999999.99" invalidMessage="必须填写金额"
							onblur="validateRepay('#editApplyAmt','#editRepayMethod','#editBankName')" value="${applyDetail[0].applyAmt}"/>（元）</td>
						<td style="width:15%;word-break;" class="tdtitle">进件方式:</td>
						<td style="width:35%;word-break;">
							<select type="text" id="editInChannelKind" name="editInChannelKind"  data-options="width:150,panelHeight:120"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false disabled="disabled">
								<c:forEach items="${implTypeList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].inChannelKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">偿还方式:</td><td><select id="editRepayMethod" name="editRepayMethod" 
							data-options="width:150,panelHeight:100,onChange:function (n,o){validateRepay('#editApplyAmt','#editRepayMethod','#editBankName');}"  
								class="easyui-combobox" validType="selectedRequired" required=true editable=false >
								<c:forEach items="${repayMethodList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].repayMethod}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
						<td class="tdtitle">申请币种:</td><td><select id="editCurrSign" name="editCurrSign" disabled="disabled"
								data-options="width:150" class="easyui-combobox">
								<c:forEach items="${currSignList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[0].currSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
								</select>
							</td>
					</tr>
					<tr>
						<td class="tdtitle">收款账号:</td><td><input id="editBankAccno" name="editBankAccno" class="easyui-validatebox" 
							size="30" maxlength="30" data-options="required:true"
							validType="account[8,20]" invalidMessage="账号填写错误" value="${applyDetail[0].bankAccno}"/></td>
						
						<td class="tdtitle">还款方式:</td><td><select id="editReturnKind" name="editReturnKind" 
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
							<select	id="editBankName" name="editBankName" 
								data-options="width:150,onChange:function (n,o){validateRepay('#editApplyAmt','#editRepayMethod','#editBankName');}"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择开户行--</option>
								<c:forEach items="${bankNoList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[4].bankName}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
							（银行）
							<input type="text" class="easyui-validatebox" data-options="required:true" id="editBankBranName" 
							name="editBankBranName" value="${applyDetail[4].bankBranName}"/>
							（分行）
							<input type="text" class="easyui-validatebox" data-options="required:true" id="editBankSubName" 
							name="editBankSubName" value="${applyDetail[4].bankSubbName}"/>
							（支行）
							</td>
							</tr></table>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">营销/推荐人手机号:</td>
						<td><input type="text" id="editRecContactNo" name="editRecContactNo" size="30" onChange="javascript:loadRecInfo(this,'edit');" value="${applyDetail[0].recContactNo}"
							class="easyui-validatebox" /></td>
						<td class="tdtitle">营销经理/推荐人:</td><td><input type="text" id="editRecPerson"	name="editRecPerson" size="30" value="${applyDetail[0].recPerson}" disabled="disabled"/></td>
					</tr>
					<tr>
						<td class="tdtitle">机构号/推荐机构:</td><td><input type="text" id="editRecOrg" name="editRecOrg" size="30" value="${applyDetail[0].recOrg}" disabled="disabled"/></td>
						<td>&nbsp;</td>
						<td><input type="hidden" id="editRecManager" name="editRecManager" value="${applyDetail[0].recManager}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">备注:</td>
						<td colspan="3"><textarea id="editRemark" name="editRemark" cols="80" rows="2" >${applyDetail[0].remark}</textarea></td>
					</tr>
				</table></fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">申请人信息</legend>
				 	<table style="width:100%;"><jsp:include page="editCreditCustInfo.jsp"></jsp:include></table>
				 	</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">商户信息</legend>
				<table style="width:100%;"><jsp:include page="editCreditPosCustInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">配偶信息</legend>
					<table style="width:100%;"><jsp:include page="editCreditMateInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
				<tr><td><fieldset style="padding:5px; color:#333; border:#06c dashed 1px;"><legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">亲属信息</legend>
					<table style="width:100%;"><jsp:include page="editCreditRelaInfo.jsp"></jsp:include></table>
					</fieldset></td></tr>
			</table>
	</div>
