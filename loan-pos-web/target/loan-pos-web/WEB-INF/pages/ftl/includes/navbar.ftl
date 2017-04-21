<!--导航条开始 -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand top-margin-10" href="#"><img src="${base}/img/hrbb_small.png" class="logo">融兴通达</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${base}/index">工作台</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">客户管理<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">客户查询</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">申请管理<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">申请查询</a></li>
						<li><a href="#">新建申请</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">审核管理<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">审核查询</a></li>
						<li class="divider"></li>
						<li><a href="#">Excel模板</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">合同管理<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">合同查询</a></li>
						<li><a href="#">新建合同</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">用款申请查询<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">用款申请查询</a></li>
					</ul>
				</li>
			</ul>
			<#if Session["assignedPrivileges"]?exists>
	            <#assign assignedPrivileges = Session["assignedPrivileges"]>			
				<#if assignedPrivileges?contains("ROLE_ADMIN") >
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">用户管理<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${base}/admin/user">用户管理</a></li>
								<li><a href="${base}/admin/role">用户组管理</a></li>
								<li><a href="${base}/admin/privilege">权限管理</a></li>
							</ul>
						</li>
					</ul>
				</#if>
			</#if>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">用户中心<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${base}/j_spring_security_logout">注销</a></li>
						<li><a href="#">修改密码</a></li>
						<li><a href="#">用户信息</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
<!-- 导航条结束 -->