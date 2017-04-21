<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="detailRelativeId" name="detailRelativeId" value="${applyDetail[2].relativeId}"/>亲属姓名:</td>
						<td style="width:35%;word-break;"><input type="text" id="detailRelaCustName" class="easyui-validatebox" readonly size="30"
							name="detailRelaCustName" value="${applyDetail[2].relaCustName}"/></td>
						<td style="width:15%;word-break;" class="tdtitle">亲属类型:</td>
						<td style="width:35%;word-break;"><select type="text" id="detailRelaKind" name="detailRelaKind" data-options="width:150,panelHeight:80"
							class="easyui-combobox" readonly editable=false>
							<c:forEach items="${relList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[2].relaKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">手机号码:</td><td><input  class="easyui-validatebox" size="30" readonly  type="text" id="detailRelaMobilePhone"
							name="detailRelaMobilePhone" value="${applyDetail[2].relaMobilePhone}"/></td>
						<td class="tdtitle">固定电话:</td><td><input type="text"  class="easyui-validatebox" readonly size="30"
							id="detailRelaTel" name="detailRelaTel" value="${applyDetail[2].relaTel}"/></td>
					</tr>
				