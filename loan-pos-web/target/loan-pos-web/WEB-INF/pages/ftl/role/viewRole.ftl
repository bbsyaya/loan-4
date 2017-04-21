<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<@pnotify/>
<title>用户列表</title>
</head>
<body>
	<#-- 内容开始 -->

<div class="warp container">
    <div class="row">
		<div class="col-xs-8">    	
		    <div class="panel-heading">
					<span>用户组信息</span>
			</div>
			    
		    <table class="table">
			<tr>
				<td><label for="roleName" class="control-label">组名称</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${role.roleName}" id="roleName" placeholder="组名称">
				</td>
			</tr>
			<tr>
				<td><label for="remark" class="control-label">说明</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${role.remark}" id="remark" placeholder="说明">
				</td>
			</tr>
			</table>
		</div>
        <div class="col-xs-4">
            <div class="panel-heading">
					<span>权限列表</span>
			</div>
			<table class="table table-condensed">
            <#list allPrivileges as privilege>
            <#if (privilege_index%2=0)> <tr> </#if>
      				<td>
							<input type="checkbox" disabled="disabled" <#if privilegesByRole?seq_contains(privilege) >checked</#if> class="checkboxItem" value="${privilege.privilegeId}">${privilege_index+1}
				    </td>
				    <td>${privilege.displayName}</td>
			<#if (privilege_index%2=1)> </tr> </#if>
            </#list>
            </table>
		</div>
    </div>
    <div class="panel-footer">
		<input type="button" class="btn btn-default" value="返回" onclick="javascript:self.location.href='${base}/admin/role.do'">
	</div>
</div>
	
	<#-- 内容结束 --> 
	</body>
</html>
