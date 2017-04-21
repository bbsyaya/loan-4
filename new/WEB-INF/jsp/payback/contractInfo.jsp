<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div title="协议信息" style="padding:20px;">
                	<table>
                	    <tr>
                		<td>*业务渠道:</td>
                		<td><input type="text" class="insertSignChannelName" readonly= "true " name="insertSignChannelName"/></td>
                		<td>*进件方式:</td>
                		<td><input type="text" class="insertSignImportWay" readonly= "true " name="insertSignImportWay"/></td>
                		</tr>
                		<tr>
                		<td>*客户名称:</td>
                	    <td><input type="text" class="insertSignCustName" readonly= "true " name="insertSignCustName"/></td>
                		<td>*商户名称:</td>
                		<td><input type="text" class="insertSignPosCustName" readonly= "true " name="insertSignPosCustName"/></td>
                		</tr>
                		<tr>
                		<td>*产品名称:</td>
                	    <td><input type="text" class="insertSignProdName" readonly= "true " name="insertSignProdName"/></td>
                		<td>*还款方式:</td>
                			<td><input type="text" class="insertSignPaybackMethod" readonly= "true " name="insertSignPaybackMethod"/></td>
                		</tr>
                		<tr>
                		<td>*授信金额:</td>
                		<td><input type="text" class="insertSignApproveAmount" readonly= "true " name="insertvApproveAmount"/></td> 
                		<td>*授信币种:</td>
                		<td><input type="text" class="insertSignApproveMoneyKind" readonly= "true " name="insertSignApproveMoneyKind"/></td>
                		</tr>
                		<tr>
                		<td>*授信利率:</td>
                		<td><input type="text" class="insertSignApproveInterest" readonly= "true " name="insertSignApproveInterest1"/></td> 
                		<td>*授信期限:</td>
                        <td><input type="text" class="insertSignApproveTerm" readonly= "true " name="insertSignApproveTerm1"/></td> 
                		</tr>
                		<tr>
                		<td>*账户开户行:</td>
                		<td><input type="text" class="insertSignAccountOpenBank" readonly= "true " name="insertSignAccountOpenBank1"/></td>
                		<td>*银行账号:</td>
                		<td><input type="text" class="insertSignAcceptAccount" readonly= "true " name="insertSignAcceptAccount1"/></td>
                		</tr>
                		<tr>
                		<td>*账户分行:</td>
                		<td><input type="text" class="insertSignAccountBranchBank" readonly= "true " name="insertSignAccountBranchBank1"/></td>
                		<td>*账户支行:</td>
                		<td><input type="text" class="insertSignAccountSubBranchBank" readonly= "true " name="insertSignAccountSubBranchBank1"/></td>
                		</tr>
                		<tr>
                		<td>*协议生效日期:</td>
                		<td><input type="text"  class="insertSignContractBeginDate"  name="insertSignContractBeginDate"/></td> 
                		<td>*协议到期日期:</td>
                		<td><input type="text"  class="insertSignContractEndDate" name="insertSignContractEndDate"/></td>
                		</tr>
                		<tr>
                		<td>*签订日期:</td>
                		<td><input type="text" class="insertSignDate" readonly= "true " name="insertSignDate"/></td>
                		</tr>
                	</table>
                </div>