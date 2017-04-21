<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
						<td style="width:35%;word-break;">
							<input class="easyui-validatebox" size="30" type="text" id="detailMatePaperId" name="detailMatePaperId" 
							value="${applyDetail[1].matePaperId}" readonly /></td>
						<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
						<td style="width:35%;word-break;">
							<select id="detailMatePaperKind" name="detailMatePaperKind" disabled="disabled">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].matePaperKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
					<tr>
						<td class="tdtitle">配偶姓名:</td><td><input type="text" id="detailFamilyCustName" readonly class="easyui-validatebox" size="30"
							name="detailFamilyCustName" value="${applyDetail[1].familyCustName}"  /></td>
						<td class="tdtitle">出生日期:</td><td><input  type="text" readonly
							id="detailMateBirtDate" name="detailMateBirtDate" value="${applyDetail[1].mateBirtDate}"/></td>
					</tr>
				<c:if test="${applyDetail[0].applyStatus != '00'}">
					<tr>
						<td class="tdtitle">民族:</td>
						<td><input type="text" id="detailMateNationSign" size="30" readonly name="detailMateNationSign" class="easyui-validatebox" value="${applyDetail[1].mateNationSign}"></td>
						<td class="tdtitle">户籍地址:</td>
						<td><input type="text" id="detailMateRegiAddr" size="30" readonly name="detailMateRegiAddr" class="easyui-validatebox" value="${applyDetail[1].mateRegiAddr}"></td>
					</tr>
				</c:if>
					<tr>
						<td class="tdtitle">手机号:</td><td><input class="easyui-validatebox"  type="text" size="30" readonly
							id="detailMateMobilePhone" name="detailMateMobilePhone" value="${applyDetail[1].mateMobilephone}"/></td>
						<td class="tdtitle">性别:</td><td>
							<select id="detailMateSexSign" name="detailMateSexSign" data-options="width:150" readonly
								class="easyui-combobox" editable=false>
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].mateSexSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
