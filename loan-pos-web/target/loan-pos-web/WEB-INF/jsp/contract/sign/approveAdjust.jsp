<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <div title="批复信息" style="padding:20px;">
    <% 
    com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
    boolean adminCtrl = access.hasAnyPrivilege("ROLE_APPROVED_ADMIN");
    String disabledFlg = adminCtrl?"":"disabled=\"disabled\"";
    %>
     <!-- 
            <input type="button" id="confirmchange" value="确认调整" onclick="confirmchange()"> -->
                	<table width="100%">
                	<!-- 
                		<tr>
                		<td>*业务渠道:</td>
                	 	<td>
                	 	<input type="text" id="insertChangeChannelName" readonly="true " name="insertChangeChannelName">
                	 	</td>
                		<td>*进件方式:</td>
                		<td style="width:35%;word-break;">
                		<input type="text" id="insertChangeImportWay" readonly="true " name="insertChangeImportWay">
                		</td>
                		</tr>
                	 -->
                		<tr>
                		<td>*客户名称:</td>
                		<td><input type="text" id="insertChangeCustName" disabled="disabled" name="insertChangeCustName" value="${approval.custName}"></td>	
                		<td>*商户名称:</td>
                		<td><input type="text" id="insertChangePosCustName" disabled="disabled" name="insertChangePosCustName" value="${approval.posCustName}"/></td>
                		</tr>
                	<!-- 
                		<tr>
                		<td>*申请提交日期:</td>
                		<td><input type="text" id="insertChangeApplyCommitDate" readonly="readonly" name="insertChangeApplyCommitDate"/></td>
                		<td>*申请金额:</td>
                		<td><input type="text" id="insertChangeApllyAmount" readonly="readonly" name="insertChangeApllyAmount"/></td>
                		</tr>
                		<tr>
                		<td>*申请币种:</td>
                		<td>
                		<input type="text" id="insertChangeApplyMoneyKind" readonly="readonly" name="insertChangeApplyMoneyKind"/>
                		</td>
                		<td>*申请期限:</td>
                		<td><input type="text" id="insertChangeApplyTerm" readonly="readonly" name="insertChangeApplyTerm1"/></td>
                		</tr>
                	 -->
                		<tr>
                		<td>*批复日期:</td>
                		<td><input type="text" id="insertChangeApproveDate" disabled="disabled" name="insertChangeApproveDate" value="${approval.approveDateStr}"/></td>
                		<td>*批复币种:</td>
                		<td><input type="text" id="insertChangeApproveMoneyKind" disabled="disabled" name="insertChangeApproveMoneyKind" value="${approval.approveMoneyKind}"/></td>
                		</tr>
                		<tr>
                		<td>*批复金额:</td>
                		<td><input type="text" id="insertChangeApproveAmount" <%=disabledFlg %> name="insertChangeApproveAmount" value="${approval.approveAmount}"/></td>
                		<td>*批复利率:</td>
                		<td><input type="text" id="insertChangeApproveInterest" <%=disabledFlg %> name="insertChangeApproveInterest2" value="${approval.approveInterest}"/></td>
                		</tr>
                		<tr>
                		<td>*批复期限:</td>
                		<td><input type="text" id="insertChangeApproveTerm" disabled="disabled" name="insertChangeApproveTerm2" value="${approval.approveTerm}"/></td>
                		<td>*还款方式:</td>
                		<td><input type="text" id="insertChangePaybackMethod" disabled="disabled" name="insertChangePaybackMethod" value="${approval.paybackMethod}"/></td>
                		</tr>
                		<tr>
                		<td>*收款账号:</td>
                		<td><input type="text" id="insertChangeAcceptAccount" name="insertChangeAcceptAccount2" value="${approval.acceptAccount}"/></td>
                		<td>*账户开户行:</td>
                		<td>
                		<select	id="insertChangeAccountOpenBank" name="insertChangeAccountOpenBank" data-options="width:150"class="easyui-combobox" editable=false>
								<c:forEach items="${bankNoList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == approval.accountOpenBank}">selected</c:if>>${obj.itemName}</option>
							</c:forEach>
							</select>
                		</tr>
                		<tr>
                		<td>*账户分行:</td>
                		<td><input type="text" id="insertChangeAccountBranchBank" name="insertChangeBranchBank2" value="${approval.accountBranchBank}"/></td>
                		<td>*账户支行：</td>
                		<td><input type="text" id="insertChangeAccountSubBranchBank" name="insertChangeSubBranchBank2" value="${approval.accountSubBranchBank}"/></td>	
                		</tr>
                		<tr><td>调整原因：</td>
                		<td colspan="3"><textarea id="insertChangeReason" name="insertChangeReason" cols="52" rows="4" style="border: 1px #939393 solid;"></textarea></td>
                		</tr>
                		<tr>
                		<td>
	                		<input type="hidden" id="insertChangeApproveId"  value="${approval.approveId}"/>
	                		<input type="hidden" id="insertChangeLoanId"  value="${approval.loanId}"/>
                		</td>
                		</tr>
                		<tr><td>&nbsp;</td></tr>
                		<tr>
                		<td colspan="4" align="right">
                			<a id="btnCommitModefy" onclick="confirmchange();" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确认修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                	    	<a id="btnClose" onclick="closeModefyWin('#ApprovalChangeWindow');" class="easyui-linkbutton" icon="icon-back" href="javascript:void(0)" >取消</a>&nbsp;&nbsp;&nbsp;&nbsp;
                		</td>
                		</tr>
                	</table>
		</div>
