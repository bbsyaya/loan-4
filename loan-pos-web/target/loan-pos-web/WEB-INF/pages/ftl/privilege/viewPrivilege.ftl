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
				<td><label for="privilegeName" class="control-label">权限名称</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${privilege.privilegeName}" id="privilegeName" placeholder="权限名称">
				</td>
			</tr>
			<tr>
			<td><label for="displayName" class="control-label">展示名称</label></td>
			<td>
				<input type="text" disabled="disabled" class="form-control" value="${privilege.displayName}" id="displayName" placeholder="展示名称">
			</td>
		</tr>			<tr>
				<td><label for="remark" class="control-label">说明</label></td>
				<td>
					<input type="text" disabled="disabled" class="form-control" value="${privilege.remark}" id="remark" placeholder="说明">
				</td>
			</tr>
			</table>
		</div>
    </div>
    <div class="panel-footer"  align="center">
	<input type="button" class="btn btn-default" value="返回" onclick="javascript:self.location.href='${base}/admin/privilege.do'">
</div>
</div>
	
	<#-- 内容结束 --> 
	</body>
</html>
