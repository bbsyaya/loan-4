<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div title="协议信息" style="padding:20px;"> 
     	<table width="100%">
     		<tr>
     			<td style="width:15%;word-break;" class="tdtitle">客户名称:</td>
     			<td><input type="text" id="editCustName" readonly="readonly" class="detailCustName" value = "${contract.custName}" size="30"/></td>
     			<td style="width:15%;word-break;" class="tdtitle">合同编号:</td>
     			<td><input type="text" id="editContNo" readonly="readonly" class="detailContNo" value="${contract.contNo}" size="30"/></td>
     		</tr>
     		<tr>
     		    <td class="tdtitle">证件类型:</td>
     		    <td>
	     		    <select disabled="disabled" id="editPaperKind" name="editPaperKind" class="detailPaperKind">
					<c:forEach items="${paperList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${customer.paperKind eq obj.itemNo}">selected="selected"</c:if>>${obj.itemName}</option>
					</c:forEach>
					</select>
				</td>
       			<td class="tdtitle">证件号码:</td>
       			<td><input type="text" id="editPaperId" readonly="readonly" class="detailPaperId" value="${customer.paperId}" size="30"/></td> 
     		</tr>
     		<tr>
	     		<td class="tdtitle">授信额度:</td>
	     		<td><input type="text" id="editCreditLine" class="detailCreditLine" readonly="readonly" value="<fmt:formatNumber value="${contract.creditLine}" pattern="#,#00.00"/>" size="30" style="text-align:right"/></td> 
	     		<td class="tdtitle">授信利率:</td>
	     		<td><input type="text" id="editCreditInterest" readonly="readonly" readonly="readonly" class="detailCreditInterest" value="${contract.creditInterest}" size="30" style="text-align:right"/></td> 
     		</tr>
     		<tr>
             	<td class="tdtitle">授信期限:</td>
             	<td><input type="text" id="editContTerm"  class="detailContTerm" readonly="readonly" value="${contract.contTerm}" size="30"/></td> 
     			<td class="tdtitle">可用额度:</td>
     			<td><input type="text"  id="editAvailableCreditLine " readonly="readonly" value="<fmt:formatNumber value="${availableBalance}" pattern="#,#00.00"/>" size="30" style="text-align:right"/></td> 
     		</tr>
     		<tr>
	     		<td class="tdtitle">还款方式:</td>
	     		<td>
		     		<select disabled="disabled" id="editReturnKind" name="editReturnKind" class="detailReturnKind">
					<c:forEach items="${returnKindList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${contract.paybackMethod eq obj.itemNo}">selected="selected"</c:if>>${obj.itemName}</option>
					</c:forEach>
					</select>
				</td> 
	       		<td class="tdtitle">协议生效日期:</td>
	       		<td><input type="text"  id="editAgreementBiginDate" readonly="readonly" value="<fmt:formatDate value='${contract.beginDate}' pattern='yyyy-MM-dd' />" size="30"/></td> 
     		</tr>
     		<!-- add by cjq 2015-08-25 -->
     		<tr>
     			<td class="tdtitle">协议到期日期:</td>
     			<td><input type="text"  class="easyui-datebox" readonly="readonly" id="editAgreementEndDate" value="<fmt:formatDate value='${contract.endDate}' pattern='yyyy-MM-dd'/>" size="30"/></td>
     		</tr>
     		<!-- end by cjq -->
   	</table>
 
</div>