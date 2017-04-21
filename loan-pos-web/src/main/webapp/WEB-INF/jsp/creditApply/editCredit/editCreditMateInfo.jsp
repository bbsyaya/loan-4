<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
						<td style="width:35%;word-break;">
							<input class="easyui-validatebox" validType="idcard"  data-options="required:true" invalidMessage="请正确输入身份证号码" size="30"
							type="text" id="editMatePaperId" name="editMatePaperId" onblur="fullFillCustomerInfo(this,'mate')" 
							value="${applyDetail[1].matePaperId}" <c:if test="${'20' == applyDetail[1].marrSign}">disabled</c:if> /></td>
						<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
						<td style="width:35%;word-break;">
							<select id="editMatePaperKind"	name="editMatePaperKind" disabled="disabled">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].matePaperKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">配偶姓名:</td><td><input type="text" id="editFamilyCustName" data-options="required:true" class="easyui-validatebox" size="30"
							name="editFamilyCustName" value="${applyDetail[1].familyCustName}"/></td>
						<td class="tdtitle">出生日期:</td><td><input  type="text" disabled="disabled"
							id="editMateBirtDate" name="editMateBirtDate" value="${applyDetail[1].mateBirtDate}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">手机号:</td><td><input class="easyui-validatebox"
							validType="mobile"  data-options="required:true" invalidMessage="请输入正确的手机号" type="text" size="30"
							id="editMateMobilePhone" name="editMateMobilePhone" value="${applyDetail[1].mateMobilephone}"/></td>
						<td class="tdtitle">性别:</td><td>
							<select id="editMateSexSign" name="editMateSexSign" data-options="width:150" disabled="disabled"
								class="easyui-combobox" editable=false>
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].mateSexSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>