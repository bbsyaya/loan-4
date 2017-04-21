<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  -->
					<tr>
						<td style="width:15%;word-break;" class="tdtitle">商户名称:</td>
						<td style="width:35%;word-break;"><input type="text" id="insertPosCustName" size="30"
							name="insertPosCustName" class="easyui-validatebox" data-options="required:true"></td>
						<td style="width:15%;word-break;" class="tdtitle">主营业务:</td>
						<td style="width:35%;word-break;"><input type="text" id="insertPosCustBusiScope" size="30"
							name="insertPosCustBusiScope" class="easyui-validatebox" data-options="required:true"></td>
					</tr>
					<tr>
						<td class="tdtitle">实际经营地址:</td>
						<td colspan="3"><table><tr>
							<td>
							<select id="insertPosCustProSelect" name="insertPosCustProSelect" 
								data-options="onChange:function (newVal,oldVal){selectDivision(newVal,$('#insertPosCustCitySelect'),$('#insertBusiDivision'));}"
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
									<option value="">--请选择(省/市)--</option>
									<c:forEach items="${province}" var="obj">
										<option value="${obj.itemNo}">${obj.itemName}</option>
									</c:forEach>
							</select>
							&nbsp;
							<select id="insertPosCustCitySelect" name="insertPosCustCitySelect" 
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择(市/区)--</option>
							</select>
							&nbsp;
							<select id="insertBusiDivision" name="insertBusiDivision" 
								class="easyui-combobox" validType="selectedRequired" required=true editable=false>
								<option value="">--请选择(区/县)--</option>
							</select>
							&nbsp;(详细)
							<input type="text" id="insertPosCustAddress"
							name="insertPosCustAddress" class="easyui-validatebox" data-options="required:true" style="width:200px">
							</td>
							</tr></table>
						</td>
					</tr>


<script type="text/javascript">
$(function() {
	//alert("2.1");

	//alert("2.2");
});

</script>

