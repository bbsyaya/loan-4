<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
						<td style="width:35%;word-break;">
							<input class="easyui-validatebox" validType="idcard"  data-options="required:true" invalidMessage="请正确输入身份证号码" size="30"
							type="text" id="insertMatePaperId" name="insertMatePaperId" onblur="fullFillCustomerInfo(this,'mate')" /></td>
						<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
						<td style="width:35%;word-break;">
							<select id="insertMatePaperKind"	name="insertMatePaperKind" disabled="disabled">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">配偶姓名:</td><td><input type="text" id="insertFamilyCustName" data-options="required:true" class="easyui-validatebox" size="30"
							name="insertFamilyCustName" /></td>
						<td class="tdtitle">出生日期:</td><td><input  type="text" disabled="disabled"
							id="insertMateBirtDate" name="insertMateBirtDate" /></td>
					</tr>
					<tr>
						<td class="tdtitle">手机号:</td><td><input class="easyui-validatebox"
							validType="mobile"  data-options="required:true" invalidMessage="请输入正确的手机号" type="text" size="30"
							id="insertMateMobilePhone" name="insertMateMobilePhone"></td>
						<td class="tdtitle">性别:</td><td>
							<!-- <input id="insertMateSexSign" name="insertMateSexSign" disabled="disabled"/> -->
							<select id="insertMateSexSign" name="insertMateSexSign" data-options="width:150" disabled="disabled"
								class="easyui-combobox" editable=false>
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select>
							</td>
					</tr>
			