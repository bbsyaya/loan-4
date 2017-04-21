<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<@pnotify/>
<title>用户列表</title>
</head>
<body>
	<#-- 内容开始 -->
	<#assign custSrcEnum =  {"0":"我司","1":"PC端","2":"APP端"} >
<div class="warp container">
    <div class="row">
		<div class="col-xs-8">    	
		    <div class="panel-heading">
					<span>用户信息</span>
			</div>
			    
		    <table class="table">
			<tr>
				<td><label for="userName" class="control-label">名称</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${user.userName}" id="userName" placeholder="名称">
				</td>
			</tr>
			<tr>
				<td><label for="loginName" class="control-label">登录名</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${user.loginName}" id="loginName" placeholder="登录名">
				</td>
			</tr>
			<tr>
				<td><label for="cellphone" class="control-label">手机</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${user.cellphone}" id="cellphone" placeholder="手机">
				</div>
			</div>
			<tr>
				<td><label for="email" class="control-label">电邮</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${user.email}" id="email" placeholder="电邮">
				</td>
			</tr>
			<tr>
				<td><label for="tel" class="control-label">电话</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${user.tel}" id="tel" placeholder="电话">
				</td>
			</tr>
			<tr>
				<td><label for="loginType" class="control-label">注册来源</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${custSrcEnum[user.loginType]}" id="loginType" placeholder="注册来源">
				</td>
			</tr>
			</table>
		</div>
        <div class="col-xs-4">
            <div class="panel-heading">
					<span>用户组列表</span>
			</div>
			<table class="table table-condensed">
             <#list allRoles as role>
             <#if (role_index%2=0)> <tr> </#if>
      				<td>
							<input type="checkbox" disabled="disabled" <#if assignedRoles?seq_contains(role) >checked</#if> class="checkboxItem" value="${role.roleId}">${role_index+1}
				    </td>
				    <td>${role.roleName}</td>
			 <#if (role_index%2=1)> </tr> </#if>
             </#list>
             </table>
		</div>
    </div>
    <div class="panel-footer"  align="center">
		<input type="button" class="btn btn-default" value="返回" onclick="javascript:self.location.href='${base}/admin/user.do'">
	</div>

</div>
	
	<#-- 内容结束 --> 
	</body>
</html>
