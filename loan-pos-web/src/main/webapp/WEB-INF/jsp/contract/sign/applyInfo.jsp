<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <div title="申请信息" style="padding:20px;">
                	<table>
                		<tr>
                		    <td>*申请编号:</td>
                			<td><input type="text" class="insertSignLoanId" readonly= "true " name="insertSignLoanId3"/></td>
                			<td>*申请额度:</td>
                			<td><input type="text" class="insertSignApplyAmount" readonly= "true " name="insertSignApplyAmount2"/></td>
                			
                		</tr>
                		<tr>
                		    <td>*还款方式:</td>
                			<!-- <td><input type="text" class="insertSignPaybackMethod" readonly= "true " name="insertSignPaybackMethod3"/></td> -->
                			<td><select disabled="disabled" class="insertSignPaybackMethod"
							name="insertSignPaybackMethod">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                			<td>*分期还款额:</td>
                			<td><input type="text" class="insertSignAmt" readonly= "true " name="insertSignAmt"/></td>  
                		</tr>
                		<tr>
                		<td>*还款来源说明:</td>
                		<td><input type="text" class="insertSignreturnSourceDesc" readonly= "true " name="insertSignreturnSourceDesc"/></td> 
                		<td>*申请期限:</td>
                		<td><input type="text" class="insertSignApplyTerm" readonly= "true " name="insertSignApplyTerm2"/></td>             			
                		</tr>
                		<tr>
                		<td>*申请日期:</td>
                		<td><input type="text" class="insertSignBeginDate" readonly= "true " name="insertSignBeginDate"/></td>
                		<td>*受理日期:</td>
                		<td><input type="text" class="insertSignAcceptDate" readonly= "true " name="insertSignAcceptDate"/></td>
                		</tr>
                		<tr>
                		<td>*担保方式:</td>
                		<td><input type="text" class="insertSignAssureKind" readonly= "true " name="insertSignBeginDate"/></td>
                		<td>*产品名称:</td>
                		<td><input type="text" class="insertSignProdName" readonly= "true " name="insertSignloanId"/></td>
                		</tr>
                		<tr>
                	    <td>*账单日:</td>
                		<td><input type="text" class="insertSignReckDay" readonly= "true " name="insertvSignReckDay"/></td> 
                		<td>*每期还款日:</td>
                		<td><input type="text" class="insertSignReturnDay" readonly= "true " name="insertSignReturnDay"/></td> 
                		</tr>
                		<tr>
                		<td>*贷款用途:</td>
                		<!-- <td><input type="text" class="insertSignloanUsage" readonly= "true " name="insertSignloanUsage"/></td>  -->
                		<td><select disabled="disabled" class="insertSignloanUsage"
							name="insertSignloanUsage">
								<c:forEach items="${loanPurposeList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td>*贷款用途说明:</td>
                		<td><input type="text" class="insertSignloanUsageDesc" readonly= "true " name="insertSignloanUsageDesc"/></td> 
                		</tr>
                		<tr>
                	    <td><input type="hidden" class="insertSignTermUnit" readonly= "true " name="insertSignTermUnit2"/></td> 
                		</tr>
                	</table>
                </div>