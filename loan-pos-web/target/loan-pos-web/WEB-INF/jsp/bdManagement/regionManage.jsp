<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 展业区域配置 -->
<div  title="展业区域配置" style="padding:20px; margin:auto;width: 90%">
	<fieldset>
	<legend class='dialog-label'>操作</legend>
	<div style="text-align: left">
		<table >
			<tr>
				<td>区域：</td>
				<td>
					
					<select  id="province"  class="" onchange='provinceChange();'>
					<option value="">--请选择(省)--</option>
					<c:forEach items="${province}" var="obj">
						<option value="${obj.itemNo}">${obj.itemName}</option>
					</c:forEach>
					</select>
					<select id='city'>
						<option value="">--请选择(市)--</option>
					</select>
					
			   		<input type="radio" name='include' value='1'></input>包含
			   		<input type="radio" name='include' value='0'></input>不包含
	   		    </td>
	   		</tr>
	   		<tr>
	   			<td>操作：</td>
	   			<td>	   	
		   			<a href="javascript:void(0)" id="save" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRegion(${orgId})">保存</a>&nbsp;&nbsp;
	   				<a href="javascript:void(0)" id="delete" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="delRegion(${orgId})">删除</a>&nbsp;&nbsp;
	   			</td>
	   		</tr>
   		</table>

   	</div>
   	</fieldset>
   	</br>
	<!-- 机构列表 -->
	<table id="rt" title="区域列表"  class="easyui-datagrid"
		url="<%=request.getContextPath()%>/bdManagement/queryRegionConfig.do?orgId=${orgId}"
		iconCls="scon-search"  onclickRow="clickRow"
		rownumbers="true" pagination="true" singleSelect="true">
		<thead>
			<tr>
				<th field="region" checkbox="true"></th>
				<th field="regionName" width="320px">区域名称</th>
				<th field="include" width="160px">状态</th>				
			</tr> 
		</thead>
	</table>
</div>