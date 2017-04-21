<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div title="协议详情" style="padding:</td><td>20px;">
                	<table width="100%">
                		<tr>
                			<td style="width:15%;word-break;"  class="tdtitle">客户名称:</td><td style="width:35%;word-break;"><input type="text" id="unfreezeCustName1" readonly="readonly" class="detailCustName1"/></td>
                			<td class="tdtitle">合同编号:</td><td><input type="text" id="unfreezeContNo" readonly="readonly" class="detailContNo"/></td>
                		</tr>
                		<tr>
                		    <td class="tdtitle">证件类型:</td><td><select disabled="disabled" id="unfreezePaperKind1" name="unfreezePaperKind1" class="detailPaperKind1">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                			<td class="tdtitle">证件号码:</td><td><input type="text" id="unfreezePaperId1" readonly="readonly" class="detailPaperId1"/></td> 
                		</tr>
                		<tr>
                		<td class="tdtitle">授信额度:</td><td><input type="text" id="unfreezeCreditLine" readonly="readonly" class="detailCreditLine"/></td> 
                		<td class="tdtitle">授信利率:</td><td><input type="text" id="unfreezeCreditInterest" readonly="readonly" class="detailCreditInterest"/></td> 
                		</tr>
                		<tr>
                        <td class="tdtitle">授信期限:</td><td><input type="text" id="unfreezeContTerm" readonly="readonly" class="detailContTerm"/></td> 
                		<td class="tdtitle">还款方式:</td><td><select disabled="disabled" id="freezeReturnKind" name="unfreezeReturnKind" class="detailReturnKind">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == '90'}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td> 
                		</tr>
                		<tr>
                		<td class="tdtitle">协议生效日期:</td><td><input type="text" id="unfreezeAgreementBiginDate" readonly="readonly"/></td> 
                		<td class="tdtitle">协议到期日期:</td><td><input type="text" id="unfreezeAgreementEndDate" readonly="readonly"/></td>
                		</tr>
                		<tr>
                			<td class="tdtitle">冻结原因:</td><td colspan="3"><input type="text" id="freezeReason2" name="freezeReason2" readonly="readonly" ></td>
                		</tr>
                		<tr>
                			<td class="tdtitle">冻结日期:</td><td><input type="text" id="freezeDate2" name="freezeDate2" class="freezeDate2" readonly="readonly" /></td>
                			<td class="tdtitle">冻结操作人:</td><td><input type="text" id="freezePerson2" name="freezePerson2" readonly="readonly" class="detailFreezePerson"/></td>
                		</tr>
                		<tr>
                			<td class="tdtitle">解冻原因:</td><td colspan="3"><input type="text" id="unFreezeReason" name="unFreezeReason"/></td>
                		</tr>
                	</table>
                </div>