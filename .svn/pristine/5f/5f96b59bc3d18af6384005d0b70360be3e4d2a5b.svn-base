<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div title="申请人信息" style="padding:20px;">
				<table width="100%">
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="detailCustId" name="detailCustId" value="${customer.custId}"/>证件号码:</td>
						<td style="width:35%;word-break;">
							<input type="text" id="detailPaperId" name="detailPaperId" readonly value="${customer.paperId}"/></td>
						<td style="width:15%;word-break;" class="tdtitle">证件类型:</td>
						<td style="width:35%;word-break;">
							<select id="paperKindName2" name="paperKindName2" disabled="disabled">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == customer.paperKind}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">客户姓名:</td>
						<td style="width:35%;word-break;"><input type="text" id="detailCustName2"  name="detailCustName2" readonly value="${customer.custName}"/></td>
						<td class="tdtitle">出生日期:</td><td><input type="text" readonly id="detailBirtDate" name="detailBirtDate" value="<fmt:formatDate value='${customer.birtDate}' pattern='yyyy-MM-dd' />"/></td>
					</tr>
				<c:if test="${creditApplyMap[0].applyStatus != '00'}">
					<tr>
						<td class="tdtitle">民族:</td>
						<td><input type="text" id="detailNationality" name="detailNationality" readonly value="${customer.nationality}"></td>
						<td class="tdtitle">户籍地址:</td>
						<td><input type="text" id="detailNatiSign1" name="detailNatiSign1" readonly value="${customer.natiSign1}"></td>
					</tr>
				</c:if>
					<tr>
						<td class="tdtitle">从业年限:</td><td><input type="text" id="detailBusiYear" name="detailBusiYear" value="${customer.busiYear}"/></td>
						<td class="tdtitle">性别:</td><td>
						<select id="detailSexSign" name="detailSexSign" data-options="width:150" disabled="disabled">
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == customer.sexSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">婚姻状况:</td><td><select id="detailMarrSign" name="detailMarrSign" disabled="disabled">
								<c:forEach items="${maritalList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == customer.marrSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select></td>
						<td class="tdtitle">最高学历:</td><td><select id="detailEducSign" name="detailEducSign" disabled="disabled">
								<c:forEach items="${eduList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == customer.educSign}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="tdtitle">子女人数:</td>
						<td><input id="detailChildNum" name="detailChildNum" type="text" value="${customer.childNum}"/></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">拥有经营地房产数:</td>
						<td><input class="easyui-numberbox"  type="text" 
							id="detailLocalHouseNum" name="detailLocalHouseNum" value="${customer.localHouseNum}"/></td>
						<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
						<td><input class="easyui-numberbox" type="text" id="detailOtherHouseNum" 
							name="detailOtherHouseNum" value="${customer.otherHouseNum}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">手机:</td><td><input type="text" id="detailMobilePhone" name="detailMobilePhone"  readonly value="${customer.mobilePhone}"/></td>
						<td class="tdtitle">办公电话:</td><td><input type="text" id="detailTel" name="detailTel" readonly value="${customer.tel}"/></td>
					</tr>
					<tr>
						<td class="tdtitle">居住地址:</td>
						<td colspan="3"><input type="text" id="detailResidentDetail" name="detailResidentDetail" readonly value="${residentDetail}" size="40"/>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">微信号:</td><td><input type="text" id="detailWeixinNo" readonly name="detailWeixinNo" value="${customer.weixinNo}"/></td>
						<td class="tdtitle">QQ号:</td><td><input readonly type="text" id="detailQQNo" name="detailQQNo" value="${customer.qqNo}" /></td>
					</tr>
					<tr>
						<td class="tdtitle">email:</td><td><input readonly type="text" id="detailEmail" name="detailEmail" value="${customer.email}"/></td>
						<td class="tdtitle">联系地址:</td>
						<td>
							<c:forEach items="${contactFlags}" var="obj">
								<input id="${obj.itemNo}" name="editAddrFlag" type="radio" value="${obj.itemNo}" disabled <c:if test="${obj.itemNo == customer.contactAddrFlag}">checked</c:if>>${obj.itemName}
							</c:forEach>
						</td>
					</tr>
				</table>
</div>