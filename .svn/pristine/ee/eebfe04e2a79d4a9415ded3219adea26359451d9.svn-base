<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!-- 
     <div title="批复信息" style="padding:20px;">
                	<table> -->
     <fieldset style="padding:5px; color:#333; border:#06c dashed 1px;width:860px">
			<legend class='dialog-label' style="color:#06c; font-weight:800; background:#fff;">授信审批结果</legend>
				<table width="860px">
                	    <tr>
                		<td class="tdtitle">*业务渠道:</td>
                		<!-- <td><input type="text" class="insertSignChannelName" readonly="readonly" name="insertSignChannelName" readonly="readonly"/></td> -->
                	 	<td><select disabled="disabled" id="insertSignChannelName"
							name="insertSignChannelName">
								<c:forEach items="${bizChannel}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == approveInfo.channel}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
							 
							
                		<td class="tdtitle">*进件方式:</td>
                		<!-- <td><input type="text" class="insertSignImportWay" readonly="readonly" name="insertSignImportWay" readonly="readonly"></td> -->	
                		<td style="width:35%;word-break;">
                		<select type="text" disabled="disabled" id="insertSignImportWay" name="insertSignImportWay">
								<c:forEach items="${implTypeList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == approveInfo.inChannelKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select></td>
							 
                		</tr>
                		<tr>
                		<td class="tdtitle">*客户名称:</td>
                		<td><input type="text" id="insertSignCustName" readonly="readonly" size="30" name="insertSignCustName" value="${approveInfo.custName}"/></td>	
                		<td class="tdtitle">*商户名称:</td>
                		<td><input type="text" id="insertSignPosCustName" readonly="readonly" size="30" name="insertSignPosCustName" value="${approveInfo.posCustName}"/></td>
                		</tr>
                		<!-- 
                		<tr>
                		<td class="tdtitle">*申请提交日期:</td>
                		<td><input type="text" class="insertSignApplyCommitDate" readonly="readonly" name="insertSignApplyCommitDate" value="${approveInfo.applyCommitDate}"/></td>
                		<td class="tdtitle">*申请金额:</td>
                		<td><input type="text" class="insertSignApllyAmount" readonly="readonly" name="insertSignApllyAmount" value="${approveInfo.approveAmount}"/></td>
                		</tr>
                		<tr>
                		<td class="tdtitle">*申请币种:</td>
                		<td><select disabled="disabled" class="insertSignApplyMoneyKind"
							name="insertSignApplyMoneyKind">
								<c:forEach items="${currSignList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == approveInfo.applyMoneyKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td class="tdtitle">*申请期限:</td>
                		<td><input type="text" class="insertSignApplyTerm" readonly="readonly" name="insertSignApplyTerm1" value="${approveInfo.applyTerm}"/></td>
                		</tr>
                		 -->
                		<tr>
                		<td class="tdtitle">*批复日期:</td>
                		<td><input type="text" id="insertSignApproveDate" readonly="readonly" size="30" name="insertSignApproveDate" value="${approveInfo.approveDateStr}"/></td>
                		<td class="tdtitle">*批复金额:</td>
                		<td><input type="text" id="insertSignApproveAmount" readonly="readonly" size="30" name="insertSignApproveAmount" value="${approveInfo.approveAmount}"/></td>
                		</tr>
                		<tr>
                		<td class="tdtitle">*批复币种:</td>
                		<!-- <td><input type="text" class="insertSignApproveMoneyKind" readonly="readonly" name="insertSignApproveMoneyKind2"/></td> -->
                			<td><select disabled="disabled" id="insertSignApproveMoneyKind"
							name="insertSignApproveMoneyKind">
								<c:forEach items="${currSignList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == approveInfo.approveMoneyKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td class="tdtitle">*批复利率:</td>
                		<td><input type="text" id="insertSignApproveInterest" readonly="readonly" size="30" name="insertSignApproveInterest2" value="${approveInfo.approveInterest}"/></td>
                		</tr>
                		<tr>
                		<td class="tdtitle">*批复期限:</td>
                		<td><input type="text" id="insertSignApproveTerm" readonly="readonly" size="30" name="insertSignApproveTerm2" value="${approveInfo.approveTerm}"/></td>
                		<td class="tdtitle">*还款方式:</td>
                		<!-- <td><input type="text" class="insertSignPaybackMethod" readonly="readonly" name="insertSignPaybackMethod2"/></td>	 -->
                		<td><select disabled="disabled" id="insertSignPaybackMethod"
							name="insertSignPaybackMethod">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == approveInfo.paybackMethod}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<c:if test="${empty cardStatus or cardStatus=='00' or cardStatus=='02' }">
						<tr><td colspan="4">
							<div id="cardWarnning" style="background-color:#FFFF00; border:1px solid red">客户银行卡尚未验真，请注意核实。</div>
						</td></tr>
						</c:if>
                		<tr>
                		<td class="tdtitle">*收款账号:</td>
                		<td><input type="text" id="insertSignAcceptAccount" readonly="readonly" size="30" name="insertSignAcceptAccount2" value="${approveInfo.acceptAccount}"/></td>
                		<td class="tdtitle">*账户开户行:</td>
                		<td><select disabled="disabled" id="insertSignPaybackMethod" name="insertSignPaybackMethod">
								<c:forEach items="${bankNoList}" var="obj">
									<option value="${obj.itemNo}"  <c:if test="${obj.itemNo == approveInfo.accountOpenBank}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<tr>
                		<td class="tdtitle">*账户分行:</td>
                		<td><input type="text" id="insertSignAccountBranchBank" readonly="readonly" size="30" name="insertSignBranchBank2" value="${approveInfo.accountBranchBank}"/></td>
                		<td class="tdtitle">*账户支行:</td>
                		<td><input type="text" id="insertSignAccountSubBranchBank" readonly="readonly" size="30" name="insertSignSubBranchBank2" value="${approveInfo.accountSubBranchBank}"/></td>	
                		<td><input type="hidden" id="insertSignApproveTermUnit" readonly="readonly" name="insertSignApproveTermUnit"/></td>
                		<td><input type="hidden" id="insertSignApproveId" readonly="readonly" name="insertSignApproveId"/></td>
                		<td><input type="hidden" id="insertSignLoanId" readonly="readonly" name="insertSignLoanId"/></td>
                		<td><input type="hidden" id="insertSignCustId" readonly="readonly" name="insertSignCustId"/></td>
                		</tr>
                <!-- 
                	</table> 
                </div>-->
               </table>
              </fieldset>
