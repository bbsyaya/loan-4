<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div title="协议详情" style="padding:</td><td>20px;">
                	<table width="100%">
                		<tr>
                			<td style="width:15%;word-break;" class="tdtitle">客户名称:</td><td style="width:35%;word-break;"><input type="text" id="freezeCustName" readonly="readonly" class="detailCustName"/></td>
                			<td class="tdtitle">合同编号:</td><td><input type="text" id="freezeContNo" readonly="readonly" class="detailContNo"/></td>
                		</tr>
                		<tr>
                		    <td class="tdtitle">证件类型:</td><td><select disabled="disabled" id="freezePaperKind"
							name="freezePaperKind" class="detailPaperKind">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                			<td class="tdtitle">证件号码:</td><td><input type="text" id="freezePaperId1" readonly="readonly" class="detailPaperId"/></td> 
                		</tr>
                		<tr>
                		<td class="tdtitle">授信额度:</td><td><input type="text" id="freezeCreditLine" readonly="readonly" class="detailCreditLine"/></td> 
                		<td class="tdtitle">授信利率:</td><td><input type="text" id="freezeCreditInterest" readonly="readonly" class="detailCreditInterest"/></td> 
                		</tr>
                		<tr>
                        <td class="tdtitle">授信期限:</td><td><input type="text" id="freezeContTerm" readonly="readonly" class="detailContTerm"/></td> 
                		<td class="tdtitle">还款方式:</td><td><select disabled="disabled"
							id="freezeReturnKind" name="freezeReturnKind" class="detailReturnKind">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td> 
                		</tr>
                		<tr>
                		<td class="tdtitle" class="tdtitle">协议生效日期:</td><td><input type="text"  id="freezeAgreementBiginDate" readonly="readonly" class="detailAgreementBiginDate"/></td> 
                		<td class="tdtitle" class="tdtitle">协议到期日期:</td><td><input type="text"  id="freezeAgreementEndDate" readonly="readonly" class="detailAgreementEndDate"/></td>
                		</tr>
                		<tr>
                			<td class="tdtitle">冻结原因:</td><td colspan="3"><input type="text" id="freezeReason" name="freezeReason" class="detailFreezeReason"></td>
                		</tr>
                	</table>
                </div>