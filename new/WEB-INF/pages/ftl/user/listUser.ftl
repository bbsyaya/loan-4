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
	<#assign custSrcEnum =  {"0":"我司","1":"PC端","2":"APP端"} >
	<#assign lockedEnum =  {"0":"正常","1":"锁定"} >
	
	<div class="warp container">
		<form action="${base}/admin/user.do">

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
							<th>名称</th>
							<td><input type="text" class="form-control" name="userNameLike" value="${(query.userNameLike)!}"></td>
							<th>手机</th>
							<td><input type="text" class="form-control" name="cellphoneLike" value="${(query.cellphoneLike)!}"></td>
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
						<li><a data-target="_self" href="${base}/admin/user/add.do" class="glyphicon glyphicon-plus" title="添加"></a></li>
						<li><a href="${base}/admin/user/delete.do" hrbb-delete-all="checkboxItem" class="glyphicon glyphicon-trash" title="批量删除"></a></li>
						<li><a href="${base}/admin/user/lock.do" hrbb-lock-all="checkboxItem" class="glyphicon glyphicon-lock" title="批量锁定"></a></li>
						<li><a href="${base}/admin/user/unlock.do" hrbb-unlock-all="checkboxItem" class="glyphicon glyphicon-ok" title="批量解锁"></a></li>
					</ul>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" hrbb-select-all="checkboxItem"> 序号</th>
							<th>用户名</th>
							<th>姓名</th>
							<th>手机</th>
							<th>电邮</th>
							<th>电话</th>
							<th>注册类型</th>
							<th>账户状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<#list page.content as result>
					<tr>
						<td>
							<input type="checkbox" class="checkboxItem" value="${result.userId}">
							<a href="${base}/admin/user/${result.userId}.do" data-target="_blank">${result_index+1}</a>
						</td>
						<td>${result.userName}</td>
						<td>${result.loginName}</td>
						<td>${result.cellphone}</td>
						<td>${result.email}</td>
						<td>${result.tel}</td>
						<td>${custSrcEnum["${result.loginType}"]}</td>
						<td>${lockedEnum["${result.locked}"]}</td>
						<td>
							<ul class="option-group">
								<li><a data-backdrop="static" data-target="_blank" href="${base}/admin/user/edit/${result.userId}.do" title="编辑"
									class="glyphicon glyphicon-edit"></a></li>
								<li><a href="${base}/admin/user/${result.userId}.do" hrbb-delete-one title="删除" class="glyphicon glyphicon-trash"></a>	</li>
								<li><a href="${base}/admin/user/lock/${result.userId}.do" hrbb-lock-one class="glyphicon glyphicon-lock" title="锁定"></a></li>
								<li><a href="${base}/admin/user/unlock/${result.userId}.do" hrbb-unlock-one class="glyphicon glyphicon-ok" title="解锁"></a></li>
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
