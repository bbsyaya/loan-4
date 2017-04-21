<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="com.hrbb.loan.web.security.entity.User"%>
<div title="取消用款" style="padding:</td><td>20px;">
					<input type="hidden" name="cancelPayApplyId" id="cancelPayApplyId" value="${paymentApply.payApplyId}"/>
                	<table>
                		<tr>
                		    <td>客户名称:</td><td><input type="text" id="custName" readonly="readonly" class="custName" value="${contract.custName}" /></td>
                			<td>商户名称:</td><td><input type="text" id="posCustName" readonly="readonly" class="posCustName" value="${contract.posCustName}"/></td> 
                		</tr>
                		<tr>
                		<td>用款金额</td><td><input type="text" id="payApplyAmt" name="payApplyAmt" value="${paymentApply.payApplyAmt}" readonly="readonly"/></td> 
                		<td>用款期限</td><td><input type="text" id="payApplyTerm" name="payApplyTerm" value="${paymentApply.payApplyTerm}" readonly="readonly"/></td>
                		</tr>
                		<tr>
                        <td>期望用款日期</td>
								<td><input id="expectedDate" name="expectedDate" value="<fmt:formatDate value='${paymentApply.expectedDate}' pattern='yyyy-MM-dd'/>" readonly="readonly"/></td>
                		<td>用款到期日</td>
								<td><input id="expectedEndDate" name="expectedEndDate" value="<fmt:formatDate value='${paymentApply.expectedEndDate}' pattern='yyyy-MM-dd'/>"/></td> 
                		</tr>
                		<tr>
                		<td>还款方式</td>
								<td><input id="returnType" name="returnType" value="${paybackMethodName}" readonly="readonly"/></td>
                		<td>用款利率</td><td><input id="" name="" value="${paymentApply.payApplyInterest}" readonly="readonly"/></td>
                		</tr>
                		<tr>
                		<td>取消原因</td>
						<td colspan="3"><input id="cancelReason" name="cancelReason"/></td>
                		</tr>
                		<tr>
                		<td>取消日期</td>
								<td><input id="cancelDate" name="cancelDate" value="<fmt:formatDate value='<%=new Date() %>' pattern='yyyy-MM-dd'/>" readonly="readonly"/></td>
                		<td>经办人</td><td><input id="" name="" value="<%=((User)request.getSession().getAttribute("USER")).getUserName()%>" readonly="readonly"/></td>
                		</tr>
                	</table>
                </div>