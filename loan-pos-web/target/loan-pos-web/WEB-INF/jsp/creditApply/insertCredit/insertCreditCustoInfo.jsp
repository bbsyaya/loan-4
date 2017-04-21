<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">证件号码:</td>
						<td style="width:35%;word-break;">
							<input type="text" id="insertPaperId" name="insertPaperId" size="30" class="easyui-validatebox" validType="idcard" 
							data-options="required:true" invalidMessage="身份证号输入有误" onblur="fullFillCustomerInfo(this,'self')" /></td>
						<td class="tdtitle">证件类型:</td><td>
							<select id="insertPaperKind" name="insertPaperKind" disabled="disabled">
								<c:forEach items="${paperList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">客户姓名:</td>
						<td style="width:35%;word-break;"><input type="text" id="insertCustName" size="30"
							name="insertCustName" class="easyui-validatebox" data-options="required:true"/></td>
						<td class="tdtitle">出生日期:</td><td><input type="text" disabled="disabled"
							id="insertBirtDate" name="insertBirtDate" /></td>
					</tr>
					<tr>
						<td class="tdtitle">从业年限:</td><td><input class="easyui-numberbox" type="text"  size="30"
							id="insertBusiYear" name="insertBusiYear" validType="number" data-options="required:true"/></td>
						<td class="tdtitle">性别:</td><td>
						<!--
						<input type="text" id="insertSexSign" name="insertSexSign" disabled="disabled"/>-->
						<select id="insertSexSign" name="insertSexSign" data-options="width:150" disabled="disabled"
							class="easyui-combobox" editable=false>
								<c:forEach items="${sexList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">婚姻状况:</td>
						<td><select id="insertMarrSign" name="insertMarrSign" data-options="width:150,panelHeight:120,onChange:function (n,o){switchRequired(n,'New');}"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择--</option>
								<c:forEach items="${maritalList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
						</select></td>
						<td class="tdtitle">最高学历:</td>
						<td><select id="insertEducSign" name="insertEducSign" data-options="width:150,panelHeight:140"
							class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<c:forEach items="${eduList}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="tdtitle">子女人数:</td>
						<td><input id="insertChildNum" name="insertChildNum" type="text" maxlength="1"  size="30"
							class="easyui-numberbox" validType="number" invalidMessage="必须填写数字" data-options="required:true" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">拥有经营地房产数:</td>
						<td><input class="easyui-numberbox" validType="number" data-options="required:true"
							invalidMessage="必须填写数字" type="text" id="insertLocalHouseNum" name="insertLocalHouseNum"  maxlength="2"  size="30"/></td>
						<td style="width:15%;word-break;" class="tdtitle">拥有非经营地房产数:</td>
						<td><input class="easyui-numberbox" validType="number" invalidMessage="必须填写数字" 
							type="text" id="insertOtherHouseNum" data-options="required:true" name="insertOtherHouseNum" maxlength="2"  size="30"/></td>
					</tr>
					<tr>
						<td class="tdtitle">手机:</td>
						<td><input class="easyui-validatebox" invalidMessage="填写的手机号码有误" type="text" validtype="mobile" size="30"
							id="insertMobilePhone" name="insertMobilePhone"  data-options="required:true"/></td>
						<td class="tdtitle">办公电话:</td>
						<td><input class="easyui-validatebox" validType="tel" invalidMessage="电话号码填写错误,格式xxx-xxx" size="30"
							type="text" id="insertTel" name="insertTel" /></td>
					</tr>
					<tr>
						<td class="tdtitle">居住地址:</td>
						<td colspan="3"><table><tr>
							<td>
							<select  id="insertResidentProv" name="insertResidentProv" 
								data-options="onChange:function (n,o){selectDivision(n,$('#insertResidentCity'),$('#insertResidentDivision'));}"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择(省/市)--</option>
								<c:forEach items="${province}" var="obj">
									<option value="${obj.itemNo}">${obj.itemName}</option>
								</c:forEach>
							</select>
							&nbsp;
							<select id="insertResidentCity"	name="insertResidentCity"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择(市/区)--</option>
							</select>
							&nbsp;
							<select id="insertResidentDivision" name="insertResidentDivision"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择(区/县)--</option>
							</select>
							&nbsp;(详细)
							<input type="text" id="insertResidentDetail"
							name="insertResidentDetail" class="easyui-validatebox" data-options="required:true" style="width:200px"/>
							</td>
							</tr></table>
						</td>
					</tr>
					<tr>
						<td class="tdtitle">微信号:</td>
						<td><input type="text" id="insertWeixinNo" class="easyui-validatebox" size="30"
						data-options="required:false" invalidMessage="请正确输入微信号" name="insertWeixinNo" /></td>
						<td class="tdtitle">QQ号:</td>
						<td><input class="easyui-validatebox" data-options="required:false" validType="number" size="30"
							type="text" id="insertQQNo" name="insertQQNo"  invalidMessage="请正确输入QQ号"/></td>
					</tr>
					<tr>
						<td class="tdtitle">email:</td>
						<td><input class="easyui-validatebox" data-options="required:false" size="30"
							type="text" validtype="email" invalidMessage="请正确填写邮箱" id="insertEmail" name="insertEmail" /></td>
						<td class="tdtitle">联系地址:</td>
						<td>
							<c:forEach items="${contactFlags}" var="obj">
								<input id="${obj.itemNo}" name="insertAddrFlag" type="radio" class="easyui-validatebox" value="${obj.itemNo}" <c:if test="${obj.itemNo == '01'}">checked</c:if>>${obj.itemName}
							</c:forEach>
						</td>
					</tr>
