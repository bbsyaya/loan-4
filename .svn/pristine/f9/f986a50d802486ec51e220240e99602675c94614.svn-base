<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div title="客户信息">
<table>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
			<td style="width:35%;word-break;">
				<input type="text" id="editPaperId" name="editPaperId" readonly /></td>
			<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
			<td style="width:35%;word-break;">
				<select id="paperKindName2" name="paperKindName2" disabled="disabled">
					<c:forEach items="${paperList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">客户姓名:</td>
			<td style="width:35%;word-break;"><input type="text" id="editCustName2" name="editCustName2" readonly /></td>
			<td class="tdtitle">出生日期:</td><td><input type="text" readonly id="editBirtDate" name="editBirtDate" /></td>
		</tr>
		<tr>
			<td class="tdtitle">民族:</td>
			<td><input type="text" id="editNationality" readonly name="editNationality"></td>
			<td class="tdtitle">户籍地址:</td>
			<td><input type="text" id="editNatiSign1" readonly name="editNatiSign1"></td>
		</tr>
		<tr>
			<td class="tdtitle">从业年限:</td><td><input type="text" id="editBusiYear" name="editBusiYear" /></td>
			<td class="tdtitle">性别:</td><td>
			<select id="editSexSign" name="editSexSign" data-options="width:150" >
					<c:forEach items="${sexList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">婚姻状况:</td><td><select id="editMarrSign" name="editMarrSign" readonly>
					<c:forEach items="${maritalList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
			</select></td>
			<td class="tdtitle">最高学历:</td><td><select id="editEducSign" name="editEducSign" data-options="width:150" >
					<c:forEach items="${eduList}" var="obj">
						<option value="${obj.itemNo}" >>${obj.itemName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="tdtitle">子女人数:</td>
			<td><input id="editChildNum" name="editChildNum" type="text"/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">拥有经营地房产数:</td>
			<td><input type="text" id="editLocalHouseNum" name="editLocalHouseNum"/></td>
			<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
			<td><input type="text" id="editOtherHouseNum" name="editOtherHouseNum"/></td>
		</tr>
		<tr>
			<td class="tdtitle">手机:</td><td><input type="text" id="editMobilePhone" name="editMobilePhone"  readonly /></td>
			<td class="tdtitle">办公电话:</td><td><input type="text" id="editTel" name="editTel" readonly /></td>
		</tr>
		<tr>
			<td class="tdtitle">居住地址:</td>
			<td colspan="3">
				<input type="text" id="editResidentialAddress" name="editResidentialAddress" readonly/>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">微信号:</td><td><input type="text" id="editWeixinNo" readonly name="editWeixinNo" /></td>
			<td class="tdtitle">QQ号:</td><td><input readonly type="text" id="editQQNo" name="editQQNo"  /></td>
		</tr>
		<tr>
			<td class="tdtitle">email:</td><td><input readonly type="text" id="editEmail" name="editEmail" /></td>
			<td class="tdtitle">联系地址:</td>
			<td>
				<input id="editAddrFlag" name="editAddrFlag" type="text" />
			</td>
		</tr>
		</table>
</div>