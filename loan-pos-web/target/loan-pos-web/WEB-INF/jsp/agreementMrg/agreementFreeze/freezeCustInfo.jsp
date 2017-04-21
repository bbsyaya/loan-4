<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div title="客户信息">
<table>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
			<td style="width:35%;word-break;">
				<input type="text" id="freezePaperId2" name="freezePaperId2" readonly /></td>
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
			<td style="width:35%;word-break;"><input type="text" id="freezeCustName2" name="freezeCustName2" readonly /></td>
			<td class="tdtitle">出生日期:</td><td><input type="text" readonly id="freezeBirtDate" name="freezeBirtDate" /></td>
		</tr>
		<tr>
			<td class="tdtitle">民族:</td>
			<td><input type="text" id="freezeNationality" readonly name="freezeNationality"></td>
			<td class="tdtitle">户籍地址:</td>
			<td><input type="text" id="freezeNatiSign1" readonly name="freezeNatiSign1"></td>
		</tr>
		<tr>
			<td class="tdtitle">从业年限:</td><td><input type="text" id="freezeBusiYear" name="freezeBusiYear" /></td>
			<td class="tdtitle">性别:</td><td>
			<select id="freezeSexSign" name="freezeSexSign" data-options="width:150" >
					<c:forEach items="${sexList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">婚姻状况:</td><td><select id="freezeMarrSign" name="freezeMarrSign" readonly>
					<c:forEach items="${maritalList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
			</select></td>
			<td class="tdtitle">最高学历:</td><td><select id="freezeEducSign" name="freezeEducSign" data-options="width:150" >
					<c:forEach items="${eduList}" var="obj">
						<option value="${obj.itemNo}" >${obj.itemName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="tdtitle">子女人数:</td>
			<td><input id="freezeChildNum" name="freezeChildNum" type="text"/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td style="width:15%;word-break;" class="tdtitle">拥有经营地房产数:</td>
			<td><input type="text" id="freezeLocalHouseNum" name="freezeLocalHouseNum"/></td>
			<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
			<td><input type="text" id="freezeOtherHouseNum" name="freezeOtherHouseNum"/></td>
		</tr>
		<tr>
			<td class="tdtitle">手机:</td><td><input type="text" id="freezeMobilePhone" name="freezeMobilePhone"  readonly /></td>
			<td class="tdtitle">办公电话:</td><td><input type="text" id="freezeTel" name="freezeTel" readonly /></td>
		</tr>
		<tr>
			<td class="tdtitle">居住地址:</td>
			<td colspan="3">
				<input type="text" id="freezeResidentialAddress" name="freezeResidentialAddress" readonly/>
			</td>
		</tr>
		<tr>
			<td class="tdtitle">微信号:</td><td><input type="text" id="freezeWeixinNo" readonly name="freezeWeixinNo" /></td>
			<td class="tdtitle">QQ号:</td><td><input class="easyui-validatebox" readonly type="text" id="freezeQQNo" name="freezeQQNo"  /></td>
		</tr>
		<tr>
			<td class="tdtitle">email:</td><td><input class="easyui-validatebox" readonly type="text" id="freezeEmail" name="freezeEmail" /></td>
			<td class="tdtitle">联系地址:</td>
			<td>
				<c:forEach items="${contactFlags}" var="obj">
					<input id="${obj.itemNo}" name="editAddrFlag" type="radio" value="${obj.itemNo}" disabled >${obj.itemName}
				</c:forEach>
			</td>
		</tr>
		</table>
</div>