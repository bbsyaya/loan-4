<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<script type="text/javascript" src="${base}/js/common/admin-common.js"></script>
<@pnotify/>
<title>用户列表</title>
</head>
<body>
	<#-- 内容开始 -->
	
	<div class="warp container">
		<form action="${base}/admin/privilege.do">

			<#-- 查询条件 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<span>查询条件</span>
					<ul class="option-group">
						<li><a href="javascript:void(0)" hrbb-show-detail="detail" class="glyphicon glyphicon-chevron-down" title="高级查询"></a></li>
					</ul>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>权限名称</th>
							<td><input type="text" class="form-control" name="privilegeNameLike" value="${(query.privilegeNameLike)!}"></td>
							<td rowspan="10">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span> 查询
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<#-- 结果列表 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<span>用户列表</span>
					<ul class="option-group">
						<li><a data-target="_self" href="${base}/admin/privilege/add.do" class="glyphicon glyphicon-plus" title="添加"></a></li>
						<#-- Privilege does not support batch delete.
						<li><a href="${base}/admin/privilege/delete" hrbb-delete-all="checkboxItem" class="glyphicon glyphicon-trash" title="批量删除"></a></li>
						-->
					</ul>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" hrbb-select-all="checkboxItem"> 序号</th>
							<th>权限名称</th>
							<th>展示名字</th>
							<th>说明</th>
							<th>操作</th>
						</tr>
					</thead>
					<#list page.content as result>
					<tr>
						<td>
							<input type="checkbox" class="checkboxItem" value="${result.privilegeId}">
							<a href="${base}/admin/privilege/${result.privilegeId}.do" data-target="_blank">${result_index+1}</a>
						</td>
						<td>${result.privilegeName}</td>
						<td>${result.displayName}</td>
						<td>${result.remark}</td>
						<td>
							<ul class="option-group">
								<li><a data-backdrop="static" data-target="_blank" href="${base}/admin/privilege/edit/${result.privilegeId}.do" title="编辑"
									class="glyphicon glyphicon-edit"></a></li>
								<li><a href="${base}/admin/privilege/${result.privilegeId}.do" hrbb-delete-one title="删除" class="glyphicon glyphicon-trash"></a>	</li>
							</ul>
						</td>
					</tr>
					</#list>
					<tr>
						<td colspan="100"><@tablePage/></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<#-- 内容结束 --> 
</body>
</html>
