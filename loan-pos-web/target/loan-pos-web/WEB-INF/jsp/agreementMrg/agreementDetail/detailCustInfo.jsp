<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div title="客户信息">
<table>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
			<td style="width:35%;word-break;">
				<input type="text" id="detailPaperId" name="detailPaperId" readonly data-options="width:200"/></td>
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
			<td style="width:35%;word-break;"><input type="text" id="detailCustName2" name="detailCustName2" readonly data-options="width:200"/></td>
			<td class="tdtitle">出生日期:</td><td><input type="text" readonly id="detailBirtDate" name="detailBirtDate" data-options="width:200"/></td>
		</tr>
		<tr>
			<td class="tdtitle">民族:</td>
			<td><input type="text" id="detailNationality" readonly name="detailNationality" data-options="width:200"></td>
			<td class="tdtitle">户籍地址:</td>
			<td><input type="text" id="detailNatiSign1" readonly name="detailNatiSign1" data-options="width:200"></td>
		</tr>
		<tr>
			<td class="tdtitle">从业年限:</td><td><input type="text" id="detailBusiYear" name="detailBusiYear"  data-options="width:200"/></td>
			<td class="tdtitle">性别:</td><td>
			<select id="detailSexSign" name="detailSexSign" data-options="width:150"
				class="easyui-combobox" editable=false>
					<c:forEach items="${sexList}" var="obj">
						<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">婚姻状况:</td><td><select id="detailMarrSign" name="detailMarrSign" readonly>
					<c:forEach items="${maritalList}" var="obj">
						<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
			</select></td>
			<td class="tdtitle">最高学历:</td><td><select id="detailEducSign" name="detailEducSign" data-options="width:150" >
					<c:forEach items="${eduList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="tdtitle">子女人数:</td>
			<td><input id="detailChildNum" name="detailChildNum" type="text" data-options="width:200"/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle" >拥有经营地房产数:</td>
			<td><input type="text" id="detailLocalHouseNum" name="detailLocalHouseNum" data-options="width:200"/></td>
			<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
			<td><input type="text" id="detailOtherHouseNum" name="detailOtherHouseNum" data-options="width:200"/></td>
		</tr>
		<tr>
			<td class="tdtitle">手机:</td><td><input type="text" id="detailMobilePhone" name="detailMobilePhone"  readonly data-options="width:200"/></td>
			<td class="tdtitle">办公电话:</td><td><input type="text" id="detailTel" name="detailTel" readonly data-options="width:200"/></td>
		</tr>
		<tr>
			<td class="tdtitle">居住地址:</td>
			<td colspan="3">
				<input type="text" id="detailResidentialAddress" name="detailResidentialAddress" readonly data-options="width:200"/>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">微信号:</td><td><input type="text" id="detailWeixinNo" data-options="width:200"
				readonly name="detailWeixinNo" /></td>
			<td class="tdtitle">QQ号:</td><td><input readonly id="detailQQNo" name="detailQQNo" data-options="width:200" /></td>
		</tr>
		<tr>
			<td class="tdtitle">email:</td><td><input readonly type="text" id="detailEmail" name="detailEmail" data-options="width:200" /></td>
			<td class="tdtitle">联系地址:</td>
			<td>
				<input id="detailAddrFlag" name="detailAddrFlag" type="text" data-options="width:200"/>
			</td>
		</tr>
		</table>
</div>