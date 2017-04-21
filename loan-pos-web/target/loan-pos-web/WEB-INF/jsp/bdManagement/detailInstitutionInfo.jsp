<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 展业机构信息 -->
<div title="机构信息" style="padding:20px; margin:auto;width: 90%">
   	<table style = "width:100%">
   		<tr>
	   		<td style="width:15%;word-break;" class="tdtitle">机构名称:</td>
	   		<td style="width:35%;word-break;"><input type="text" class="orgName" name="orgName" value="${institution.orgName}" size="30"></td>
	   		<td class="tdtitle">营业执照编号:</td>
	   		<td><input type="text" class="licenseNo" name="licenseNo" value="${institution.licenseNo}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">机构简称:</td>
	   		<td><input type="text" class="alias" name="alias" value="${institution.alias}" size="30"></td>
	   		<td class="tdtitle">法人代表:</td>
	   		<td><input type="text" class="nameLR" name="nameLR" value="${institution.nameLR}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">法人联系电话:</td>
	   		<td><input type="text" class="phoneNoLR" name="phoneNoLR"  value="${institution.phoneNoLR}"/></td>
	   		<td class="tdtitle">法人代表身份证号码:</td>
	   		<td><input type="text" class="certNoLR" name="certNoLR" value="${institution.certNoLR}" size="30"></td>
   		</tr>
   		<tr>
	   		<td class="tdtitle">注册地址:</td>
	   		<td><input type="text" class="regAddress" name="regAddress" value="${institution.regAddress}" size="30"></td>
	   		<td class="tdtitle">备注:</td>
	   		<td><input type="text" class="remark" name="remark" value="${institution.remark}" size="30"></td>
    	</tr>
   		<tr>
	   		<td class="tdtitle">联系邮箱:</td>
	   		<td><input type="text" class="email" name="email" value="${institution.email}" size="30"></td>
	   		<td class="tdtitle">管理员:</td>
			<td><input type="text" class="manager" name="manager" value="${institution.manager}" size="30"></td>
    	</tr>
    	<tr>
	   		<td class="tdtitle">激活状态:</td>
	   		<td>
	   		<c:if test="${oprFlag eq 0}"><!-- 新增 -->
	   		<input type="text" class="active" name="active" value="Y" size="30" readonly>
	   		</c:if>
	   		<c:if test="${oprFlag eq 1}"><!-- 修改 -->
	   		<input type="text" class="active" name="active" value="${institution.active}" size="30" readonly>
	   		</c:if>
	   		</td>
   	</table>
   	<br/><br/>
   	<div style="text-align: center">
   		<input type="hidden" id="orgId" value="${institution.orgId}"/>
	   	<a href="javascript:void(0)" id="save" width="100px" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveInstitution(${oprFlag})">保存</a>&nbsp;&nbsp;
	   	<a href="javascript:void(0)" id="cancel" width="100px" class="easyui-linkbutton" iconCls="icon-no" onclick="cancelInstitution(${oprFlag})">返回</a>
   	</div>
</div>