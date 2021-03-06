<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="editCustId" name="editCustId" value="${applyDetail[1].custId}"/>证件号码:</td>
						<td style="width:35%;word-break;">
							<input type="text" id="editPaperId" name="editPaperId" size="30" class="easyui-validatebox" 
								disabled="disabled" value="${applyDetail[1].paperId}"/></td>
							
						<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
						<td style="width:35%;word-break;">
							<select id="editPaperKind" name="editPaperKind" disabled="disabled">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].paperKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">客户姓名:</td>
						<td style="width:35%;word-break;"><input type="text" id="editCustName" size="30"
							name="editCustName" class="easyui-validatebox" data-options="required:true" value="${applyDetail[1].custName}"/></td>
						<td class="tdtitle">出生日期:</td><td><input type="text" disabled="disabled" id="editBirtDate" name="editBirtDate" value="${applyDetail[1].birtDate}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">从业年限:</td><td><input class="easyui-numberbox" type="text"  size="30"
							id="editBusiYear" name="editBusiYear" validType="number" data-options="required:true" value="${applyDetail[1].busiYear}"/></td>
						<td class="tdtitle">性别:</td><td>
						<select id="editSexSign" name="editSexSign" data-options="width:150" disabled="disabled"
							class="easyui-combobox" editable=false>
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].sexSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">婚姻状况:</td><td><select id="editMarrSign" name="editMarrSign" data-options="width:150,panelHeight:120,onChange:function (n,o){switchRequired(n,'Edit');}"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false disabled="disabled">
								<c:forEach items="${maritalList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].marrSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select></td>
						<td class="tdtitle">最高学历:</td><td><select id="editEducSign" name="editEducSign" data-options="width:150,panelHeight:140"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<c:forEach items="${eduList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].educSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="tdtitle">子女人数:</td>
						<td><input id="editChildNum" name="editChildNum" type="text" maxlength="1"  size="30"
							class="easyui-numberbox" validType="number" invalidMessage="必须填写数字" data-options="required:true" value="${applyDetail[1].childNum}"/></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">拥有经营地房产数:</td>
						<td><input class="easyui-numberbox" validType="number" data-options="required:true" invalidMessage="必须填写数字" type="text" 
							id="editLocalHouseNum" name="editLocalHouseNum"  maxlength="2"  size="30" value="${applyDetail[1].localHouseNum}"/></td>
						<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
						<td><input class="easyui-numberbox" validType="number" invalidMessage="必须填写数字" type="text" id="editOtherHouseNum" 
							data-options="required:true" name="editOtherHouseNum" maxlength="2"  size="30" value="${applyDetail[1].otherHouseNum}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">手机:</td><td><input class="easyui-validatebox" invalidMessage="填写的手机号码有误" type="text" validtype="mobile" size="30"
							id="editMobilePhone" name="editMobilePhone"  data-options="required:true" value="${applyDetail[1].mobilePhone}"/></td>
						<td class="tdtitle">办公电话:</td><td><input class="easyui-validatebox" validType="tel" invalidMessage="电话号码填写错误,格式xxx-xxx" size="30"
							type="text" id="editTel" name="editTel" value="${applyDetail[1].tel}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">居住地址:</td>
						<td colspan="3"><table><tr>
							<td>
							<select  id="editResidentProv" name="editResidentProv" 
								data-options="onChange:function (n,o){selectDivision(n,$('#editResidentCity'),$('#editResidentDivision'));}"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择(省/市)--</option>
								<c:forEach items="${province}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].residentProv}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
							&nbsp;
							<select id="editResidentCity"	name="editResidentCity"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="${applyDetail[1].residentCity}">${applyDetail[1].residentCityName}</option>
							</select>
							&nbsp;
							<select id="editResidentDivision" name="editResidentDivision"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="${applyDetail[1].residentDivision}">${applyDetail[1].residentDivisionName}</option>
							</select>
							&nbsp;(详细)
							<input type="text" id="editResidentDetail"
								name="editResidentDetail" class="easyui-validatebox" data-options="required:true" style="width:200px" value="${applyDetail[1].residentDetail}"/>
							</td>
							</tr></table>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">微信号:</td><td><input type="text" id="editWeixinNo" class="easyui-validatebox" size="30"
						data-options="required:false" invalidMessage="请正确输入微信号" name="editWeixinNo" value="${applyDetail[1].weixinNo}"/></td>
						<td class="tdtitle">QQ号:</td><td><input class="easyui-validatebox" data-options="required:false" validType="number" size="30"
							type="text" id="editQQNo" name="editQQNo"  invalidMessage="请正确输入QQ号" value="${applyDetail[1].qqNo}" /></td>
					</tr>
					<tr>
						<td class="tdtitle">email:</td><td><input class="easyui-validatebox" data-options="required:false" size="30"
							type="text" validtype="email" invalidMessage="请正确填写邮箱" id="editEmail" name="editEmail" value="${applyDetail[1].email}"/></td>
						<td class="tdtitle">联系地址:</td>
						<td>
							<c:forEach items="${contactFlags}" var="obj">
								<input id="${obj.itemNo}" name="editAddrFlag" type="radio" class="easyui-validatebox" value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].contactAddrFlag}">checked</c:if>>${obj.itemName}
							</c:forEach>
						</td>
					</tr>