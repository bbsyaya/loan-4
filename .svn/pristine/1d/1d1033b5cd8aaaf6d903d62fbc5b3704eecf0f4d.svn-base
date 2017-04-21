<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="editRelativeId" name="editRelativeId" value="${applyDetail[2].relativeId}"/>亲属姓名:</td>
						<td style="width:35%;word-break;"><input type="text" id="editRelaCustName" class="easyui-validatebox" data-options="required:true" size="30"
							name="editRelaCustName" value="${applyDetail[2].relaCustName}"/></td>
						<td style="width:15%;word-break;" class="tdtitle">亲属类型:</td>
						<td style="width:35%;word-break;"><select type="text" id="editRelaKind" name="editRelaKind" data-options="width:150,panelHeight:80"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false>
							<c:forEach items="${relList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[2].relaKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">手机号码:</td><td><input  class="easyui-validatebox" validType="mobile" size="30"
							invalidMessage="请正确输入手机号码" type="text" id="editRelaMobilePhone"
							name="editRelaMobilePhone" data-options="required:true" value="${applyDetail[2].relaMobilePhone}"/></td>
						<td class="tdtitle">固定电话:</td><td><input type="text"  class="easyui-validatebox" validType="tel" invalidMessage="请正确输入电话号码" size="30"
							id="editRelaTel" name="editRelaTel" value="${applyDetail[2].relaTel}"/></td>
					</tr>