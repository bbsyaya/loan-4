<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="editAgreementMassageWindow" minimizable="false" maximizable="true" style="background: #fafafa;"   title="信息提示" >
	<font size="5">确认完成如下授信批复调整？</font>
	<br/>
	<table style="width:100%;height:300px;text-align: center;"  border="1">
		<tr style="width:100%;margin-left:12px;background-color: gray;">
			<td width="30%" >调整要素</td>
			<td width="30%" >调整前</td>
			<td width="30%" >调整后</td>
		</tr>
		<tr>
			<td>授信额度</td>
			<td><input id="beforeAgreementCreditLine"/></td>
			<td><input id="afterAgreementCreditLine"/></td>
		</tr>
		<tr>
			<td>授信期限</td>
			<td><input id="beforeAgreementContTerm"/></td>
			<td><input id="afterAgreementContTerm"/></td>
		</tr>
		<tr>
			<td>还款方式</td>
			<td>
			<select id="beforeAgreementReturnKind" name="beforeAgreementReturnKind" class="beforeAgreementReturnKind">
					<c:forEach items="${returnKindList}" var="obj">
							<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
			</select>
			</td>
			<td>
				<select id="afterAgreementReturnKind" name="afterAgreementReturnKind" class="afterAgreementReturnKind">
					<c:forEach items="${returnKindList}" var="obj">
							<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		
		<tr>
			<td>银行账号</td>
			<td><input id="beforeAgreementBankAccount"/></td>
			<td><input id="afterAgreementBankAccount"/></td>
		</tr>
		<tr>
			<td>开户行</td>
			<td><input id="beforeAgreementAccountOpenBank"/></td>
			<td><input id="afterAgreementAccountOpenBank"/></td>
		</tr>
		<tr>
			<td>账户分行</td>
			<td><input id="beforeAgreementAccountBranchBank"/></td>
			<td><input id="afterAgreementAccountBranchBank"/></td>
		</tr>
		<tr>
			<td>账户支行</td>
			<td><input id="beforeAgreementAccountSubBranchBank"/></td>
			<td><input id="afterAgreementAccountSubBranchBank"/></td>
		</tr>
		
		<tr>
			<td>协议到期日期</td>
			<td><input type="text"  class="easyui-datebox beforeAgreementEndDate" id="beforeAgreementEndDate"/></td>
			<td><input type="text"  class="easyui-datebox afterAgreementEndDate" id="afterAgreementEndDate"/></td>
		</tr>
	</table>
	<div style="text-align: center">
		<a id="btnEp" class="easyui-linkbutton" icon="icon-ok" onclick="modifyAgreement(5)" >确定</a>
	    <a id="btnEp"  class="easyui-linkbutton" icon="icon-cancel" >取消</a>	
    </div>
</div>