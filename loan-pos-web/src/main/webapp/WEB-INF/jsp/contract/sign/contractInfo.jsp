<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div title="协议信息" style="padding:20px;">
                    <input type="button" id="signEffect" value="签约生效" onclick="signToEffect()">
                    
                	<table>
                	    <tr>
                		<td>*业务渠道:</td>
                		<!-- <td><input type="text" id="insertSignChannelName" readonly= "true " name="insertSignChannelName" readonly="readonly"/></td> -->
                		<td><select disabled="disabled" id="insertSignChannelName"
							name="insertSignChannelName">
								<c:forEach items="${bizChannel}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		<td>*进件方式:</td>
                		<!-- <td><input type="text" id="insertSignImportWay" readonly= "true " name="insertSignImportWay" readonly="readonly"></td>	 -->
                		<td><select disabled="disabled" id="insertSignImportWay"
							name="insertSignImportWay">
								<c:forEach items="${implTypeList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<tr>
                		<td>*客户名称:</td>
                	    <td><input type="text" id="insertSignCustName" readonly= "true " name="insertSignCustName"/></td>
                		<td>*商户名称:</td>
                		<td><input type="text" id="insertSignPosCustName" readonly= "true " name="insertSignPosCustName"/></td>
                		</tr>
                		<tr>
                		<td>*产品名称:</td>
                	    <td><input type="text" id="insertSignProdName" readonly= "true " name="insertSignProdName"/></td>
                		<td>*还款方式:</td>
                		<!-- <td><input type="text" id="insertSignPaybackMethod" readonly= "true " name="insertSignPaybackMethod1"/></td>  -->
                			<td><select disabled="disabled" id="insertSignPaybackMethod"
							name="insertSignPaybackMethod">
								<c:forEach items="${returnKindList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<tr>
                		<td>*授信金额:</td>
                		<td><input type="text" id="insertSignApproveAmount" readonly= "true " name="insertvApproveAmount"/></td> 
                		<td>*授信币种:</td>
                		<!-- <td><input type="text" id="insertSignApproveMoneyKind" readonly= "true " name="insertSignApproveMoneyKind"/></td> -->
                		<td><select disabled="disabled" id="insertSignApproveMoneyKind"
							name="insertSignApproveMoneyKind">
								<c:forEach items="${currSignList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
                		</tr>
                		<tr>
                		<td>*授信利率:</td>
                		<td><input type="text" id="insertSignApproveInterest" readonly= "true " name="insertSignApproveInterest1"/></td> 
                		<td>*授信期限:</td>
                        <td><input type="text" id="insertSignApproveTerm" readonly= "true " name="insertSignApproveTerm1"/></td> 
                		</tr>
                		<tr>
                		<td>*账户开户行:</td>
                		<td><input type="text" id="insertSignAccountOpenBank" readonly= "true " name="insertSignAccountOpenBank1"/></td>
                		<td>*银行账号:</td>
                		<td><input type="text" id="insertSignAcceptAccount" readonly= "true " name="insertSignAcceptAccount1"/></td>
                		</tr>
                		<tr>
                		<td>*账户分行:</td>
                		<td><input type="text" id="insertSignAccountBranchBank" readonly= "true " name="insertSignAccountBranchBank1"/></td>
                		<td>*账户支行:</td>
                		<td><input type="text" id="insertSignAccountSubBranchBank" readonly= "true " name="insertSignAccountSubBranchBank1"/></td>
                		</tr>
                		<tr>
                		<td>*协议生效日期:</td>
                		<td><input class="easyui-datebox" type="text" id="insertSignContractBeginDate" name="insertSignContractBeginDate"/></td> 
                		<td>*协议到期日期:</td>
                		<td><input type="text"  id="insertSignContractEndDate" name="insertSignContractEndDate"/></td>
                		</tr>
                		<tr>
                		<td>*签订日期:</td>
                		<td><input type="text" id="insertSignDate" readonly= "true " name="insertSignDate"/></td>
                		</tr>
                	</table>
                </div>