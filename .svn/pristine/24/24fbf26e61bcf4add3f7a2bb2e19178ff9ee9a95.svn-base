<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
<div title="客户信息">
<table> -->
		<tr>
			<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="detailCustId" name="detailCustId" value="${applyDetail[1].custId}"/>证件号码:</td>
			<td style="width:35%;word-break;">
				<input type="text" id="detailPaperId" name="detailPaperId" size="30" class="easyui-validatebox" 
					readonly value="${applyDetail[1].paperId}"/></td>
				
			<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
			<td style="width:35%;word-break;">
				<select id="paperKindName2" name="paperKindName2" disabled="disabled">
					<c:forEach items="${paperList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].paperKind}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">客户姓名:</td>
			<td style="width:35%;word-break;"><input type="text" id="detailCustName2" size="30"
				name="detailCustName2" class="easyui-validatebox" readonly value="${applyDetail[1].custName}"/></td>
			<td class="tdtitle">出生日期:</td><td><input type="text" readonly id="detailBirtDate" name="detailBirtDate" value="${applyDetail[1].birtDate}"/></td>
		</tr>
	<c:if test="${applyDetail[0].applyStatus != '00'}">
		<tr>
			<td class="tdtitle">民族:</td>
			<td><input type="text" id="detailNationality" size="30" readonly name="detailNationality" class="easyui-validatebox" value="${applyDetail[1].nationality}"></td>
			<td class="tdtitle">户籍地址:</td>
			<td><input type="text" id="detailNatiSign1" size="30" readonly name="detailNatiSign1" class="easyui-validatebox" value="${applyDetail[1].natiSign1}"></td>
		</tr>
	</c:if>
		<tr>
			<td class="tdtitle">从业年限:</td><td><input class="easyui-numberbox" type="text"  size="30"
				id="detailBusiYear" name="detailBusiYear" value="${applyDetail[1].busiYear}"/></td>
			<td class="tdtitle">性别:</td><td>
			<select id="detailSexSign" name="detailSexSign" data-options="width:150" readonly
				class="easyui-combobox" editable=false>
					<c:forEach items="${sexList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].sexSign}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">婚姻状况:</td><td><select id="detailMarrSign" name="detailMarrSign" 
				class="easyui-combobox" editable=false readonly>
					<c:forEach items="${maritalList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].marrSign}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
			</select></td>
			<td class="tdtitle">最高学历:</td><td><select id="detailEducSign" name="detailEducSign" data-options="width:150,panelHeight:140"
				class="easyui-combobox" readonly editable=false>
					<c:forEach items="${eduList}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].educSign}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="tdtitle">子女人数:</td>
			<td><input id="detailChildNum" name="detailChildNum" type="text" maxlength="1"  size="30" class="easyui-numberbox" value="${applyDetail[1].childNum}"/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">拥有经营地房产数:</td>
			<td><input class="easyui-numberbox"  type="text" 
				id="detailLocalHouseNum" name="detailLocalHouseNum"  maxlength="2"  size="30" value="${applyDetail[1].localHouseNum}"/></td>
			<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
			<td><input class="easyui-numberbox" type="text" id="detailOtherHouseNum" 
				name="detailOtherHouseNum" maxlength="2"  size="30" value="${applyDetail[1].otherHouseNum}"/></td>
		</tr>
		<tr>
			<td class="tdtitle">手机:</td><td><input class="easyui-validatebox" type="text" size="30"
				id="detailMobilePhone" name="detailMobilePhone"  readonly value="${applyDetail[1].mobilePhone}"/></td>
			<td class="tdtitle">办公电话:</td><td><input class="easyui-validatebox" size="30"
				type="text" id="detailTel" name="detailTel" readonly value="${applyDetail[1].tel}"/></td>
		</tr>
		<tr>
			<td class="tdtitle">居住地址:</td>
			<td colspan="3"><table><tr>
				<td>
				<select  id="detailResidentProv" name="detailResidentProv" class="easyui-combobox" editable=false readonly>
					<option value="">--请选择(省/市)--</option>
					<c:forEach items="${province}" var="obj">
						<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[1].residentProv}">selected</c:if>>${obj.itemName}</option>
					</c:forEach>
				</select>
				&nbsp;
				<select id="detailResidentCity"	name="detailResidentCity" class="easyui-combobox" editable=false readonly>
					<option value="${applyDetail[1].residentCity}">${applyDetail[1].residentCityName}</option>
				</select>
				&nbsp;
				<select id="detailResidentDivision" name="detailResidentDivision" class="easyui-combobox" editable=false readonly>
					<option value="${applyDetail[1].residentDivision}">${applyDetail[1].residentDivisionName}</option>
				</select>
				&nbsp;(详细)
				<input type="text" id="detailResidentDetail"
					name="detailResidentDetail" class="easyui-validatebox" readonly style="width:200px" value="${applyDetail[1].residentDetail}"/>
				</td>
				</tr></table>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">微信号:</td><td><input type="text" id="detailWeixinNo" class="easyui-validatebox" size="30"
				readonly name="detailWeixinNo" value="${applyDetail[1].weixinNo}"/></td>
			<td class="tdtitle">QQ号:</td><td><input class="easyui-validatebox" readonly size="30" type="text" id="detailQQNo" name="detailQQNo" value="${applyDetail[1].qqNo}" /></td>
		</tr>
		<tr>
			<td class="tdtitle">email:</td><td><input class="easyui-validatebox" readonly size="30"	type="text" id="detailEmail" name="detailEmail" value="${applyDetail[1].email}"/></td>
			<td class="tdtitle">联系地址:</td>
			<td>
				<c:forEach items="${contactFlags}" var="obj">
					<input id="${obj.itemNo}" name="editAddrFlag" type="radio" class="easyui-validatebox" value="${obj.itemNo}" disabled <c:if test="${obj.itemNo == applyDetail[1].contactAddrFlag}">checked</c:if>>${obj.itemName}
				</c:forEach>
			</td>
		</tr>
<!-- 
		</table>
</div> -->