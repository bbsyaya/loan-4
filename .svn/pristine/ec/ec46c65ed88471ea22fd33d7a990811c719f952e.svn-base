<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle"><input type="hidden" id="detailPosCustId" name="detailPosCustId" value="${applyDetail[3].posCustId}"/>商户名称:</td>
						<td style="width:35%;word-break;"><input type="text" id="detailPosCustName" size="30" readonly
							name="detailPosCustName" class="easyui-validatebox"  value="${applyDetail[3].posCustName}"></td>
						<td style="width:15%;word-break;" class="tdtitle">主营业务:</td>
						<td style="width:35%;word-break;"><input type="text" id="detailPosCustBusiScope" size="30" readonly
							name="detailPosCustBusiScope" class="easyui-validatebox"  value="${applyDetail[3].posCustBusiScope}"></td>
					</tr>
					<tr>
						<td class="tdtitle">实际经营地址:</td>
						<td colspan="3"><table><tr>
							<td>
							<select id="detailPosCustProSelect" name="detailPosCustProSelect" readonly class="easyui-combobox" editable=false>
									<option value="">--请选择(省/市)--</option>
									<c:forEach items="${province}" var="obj">
										<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[3].posCustProv}">selected</c:if>>${obj.itemName}</option>
									</c:forEach>
							</select>
							&nbsp;
							<select id="detailPosCustCitySelect" name="detailPosCustCitySelect" readonly class="easyui-combobox" editable=false>
								<option value="${applyDetail[3].posCustCity}">${applyDetail[3].posCustCityName}</option>
							</select>
							&nbsp;
							<select id="detailBusiDivision" name="detailBusiDivision" readonly class="easyui-combobox" editable=false>
								<option value="${applyDetail[3].operAddrCode}">${applyDetail[3].posCustDivisionName}</option>
							</select>
							&nbsp;(详细)
							<input type="text" id="detailPosCustAddress" readonly name="detailPosCustAddress" class="easyui-validatebox" style="width:200px" value="${applyDetail[3].posCustAddress}">
							</td>
							</tr></table>
						</td>
					</tr>
				<c:if test="${applyDetail[0].applyStatus != '00'}">
					<tr>
						<td class="tdtitle">营业执照注册号:</td>
						<td><input type="text" id="detailRegiCode" size="30" readonly name="detailRegiCode" class="easyui-validatebox" value="${applyDetail[3].regiCode}"></td>
						<td class="tdtitle">所属行业:</td>
						<td><input type="text" id="detailIndustryName" size="30" readonly name="detailIndustryName" class="easyui-validatebox" value="${applyDetail[3].industryTypeName}"></td>
					</tr>
					<tr>
						<td class="tdtitle">注册资本:</td>
						<td><input type="text" id="detailRegCapital" size="30" readonly name="detailRegCapital" class="easyui-validatebox" value="${applyDetail[3].regCapital}"></td>
						<td class="tdtitle">注册日期:</td>
						<td><input type="text" id="detailRegistDate" size="30" readonly name="detailRegistDate" class="easyui-validatebox" value="${applyDetail[3].registDate}"></td>
					</tr>
					<tr>
						<td class="tdtitle">法人代表:</td>
						<td><input type="text" id="detaillegalPersonName" size="30" readonly name="detaillegalPersonName" class="easyui-validatebox" value="${applyDetail[3].legalPersonName}"></td>
						<td class="tdtitle">行内行业分类:</td>
						<td><select id="detailIndustry2" name="detailIndustry2" readonly class="easyui-combobox" editable=false>
								<c:forEach items="${HrrbIndustTypeList}" var="obj">
									<option value="${obj.itemNo}" <c:if test="${obj.itemNo == applyDetail[3].industryTypeId2}">selected</c:if>>${obj.itemName}</option>
								</c:forEach>
							</select></td>
					</tr>
				</c:if>
