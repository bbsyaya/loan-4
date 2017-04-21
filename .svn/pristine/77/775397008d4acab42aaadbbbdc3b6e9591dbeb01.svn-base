<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 
<div title="协议信息" style="padding:</td><td>20px;"> 
                	<table width="100%">-->
                		<tr>
                			<td class="tdtitle">客户名称:</td><td><input type="text" id="editCustName" readonly="readonly" class="detailCustName" value = "${contract.custName}" size="30"/></td>
                			<td class="tdtitle">合同编号:</td><td><input type="text" id="editContNo" readonly="readonly" class="detailContNo" value="${contract.contNo}" size="30"/></td>
                		</tr>
                		<tr>
                		    <td class="tdtitle">证件类型:</td><td><select disabled="disabled" id="editPaperKind" name="editPaperKind" class="detailPaperKind">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${customer.paperKind eq obj.itemNo}">selected="selected"</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
                			<td class="tdtitle">证件号码:</td><td><input type="text" id="editPaperId" readonly="readonly" class="detailPaperId" value="${customer.paperId}" size="30"/></td> 
                		</tr>
                		<tr>
                		<td class="tdtitle">授信额度:</td><td><input type="text" id="editCreditLine" class="detailCreditLine" readonly="readonly" value="${contract.creditLine}" size="30"/></td> 
                		<td class="tdtitle">授信利率:</td><td><input type="text" id="editCreditInterest" readonly="readonly" readonly="readonly" class="detailCreditInterest" value="${contract.creditInterest}" size="30"/></td> 
                		</tr>
                		<tr>
                        <td class="tdtitle">授信期限:</td><td><input type="text" id="editContTerm"  class="detailContTerm" readonly="readonly" value="${contract.contTerm}" size="30"/></td> 
                		<td class="tdtitle">还款方式:</td><td><select disabled="disabled" id="editReturnKind" name="editReturnKind" class="detailReturnKind">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${contract.paybackMethod eq obj.itemNo}">selected="selected"</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td> 
                		</tr>
                		<tr>
                		<td class="tdtitle">协议生效日期:</td><td><input type="text"  id="editAgreementBiginDate" readonly="readonly" class="detailAgreementBiginDate" value="<fmt:formatDate value='${contract.beginDate}' pattern='yyyy-MM-dd' />" size="30"/></td> 
                		<td class="tdtitle">协议到期日期:</td><td><input type="text"  class="easyui-datebox detailAgreementEndDate" readonly="readonly" id="editAgreementEndDate" value="<fmt:formatDate value='${contract.endDate}' pattern='yyyy-MM-dd'/>" size="30"/></td>
                		</tr>
<!--                	</table>
 
                </div> -->