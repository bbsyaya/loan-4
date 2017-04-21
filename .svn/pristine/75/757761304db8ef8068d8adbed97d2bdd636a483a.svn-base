<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<script type="text/javascript" src="${base}/js/p_validator.js"></script>
<script type="text/javascript" src="${base}/js/md5.js"></script>
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
			<div class="panel-body">
			<form class="form-horizontal" id="addForm" role="form" method="post" action="${base}/admin/user.do">
				<div class="form-group">
					<label for="userName" class="col-md-2 control-label">登录名</label>
					<div class="col-md-5">
						<input type="text" name="userName" class="form-control" value="" id="userName" placeholder="登录名" >
					</div>
				</div>
				<div class="form-group">
					<label for="loginName" class="col-md-2 control-label">姓名</label>
					<div class="col-md-5">
						<input type="text" name="loginName" class="form-control" value="" id="loginName" placeholder="姓名">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-2 control-label">密码</label>
					<div class="col-md-5">
						<input type="password" name="password" class="form-control" value="" id="password" placeholder="密码">
					</div>
				</div>
				<div class="form-group">
					<label for="cellphone" class="col-md-2 control-label">手机</label>
					<div class="col-md-5">
						<input type="text" name="cellphone" class="form-control" value="" id="cellphone" placeholder="手机">
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-md-2 control-label">电邮</label>
					<div class="col-md-5">
						<input type="text" name="email" class="form-control" value="" id="email" placeholder="电邮">
					</div>
				</div>
				<div class="form-group">
					<label for="tel" class="col-md-2 control-label">电话</label>
					<div class="col-md-5">
						<input type="text" name="tel" class="form-control" value="" id="tel" placeholder="电话">
					</div>
				</div>
				<div class="form-group">
				<label for="loginType" class="col-md-2 control-label">注册来源</label>
				<div class="col-md-5">
					<select name="loginType" class="form-control" value="" id="loginType" placeholder="电话">
					<#list custSrcEnum?keys as custSrc>
					    <option value="${custSrc}"> ${custSrcEnum[custSrc]} </option>						    
					</#list>
					</select>
				</div>
				<input id="assignedRoleList" type="hidden" name="assignedRoleList" value="">
			</form>
			</div>
		</div>
	</div>
    <div class="col-xs-4">
        <div class="panel-heading">
				<span>用户组列表</span>
		</div>
		<table class="table table-condensed">
         <#list allRoles as role>
         <#if (role_index%2=0)> <tr> </#if>
  				<td>
						<input type="checkbox" class="checkboxRoles" value="${role.roleId}">${role_index+1}
			    </td>
			    <td>${role.roleName}</td>
         <#if (role_index%2=1)> </tr> </#if>
         </#list>
         </table>
	</div>
	
</div>
<div class="panel-footer" align="center">
		<button type="button" id="saveBtn" class="btn btn-primary">保存</button>
		<input type="button" class="btn btn-default" value="返回" onclick="javascript:self.location.href='${base}/admin/user.do'">
	</div>

</div>


<#-- 内容结束 --> 
</body>
<script type="text/javascript">
	var errorMsg = "";    
	function validate(){
		errorMsg="";
		var username = document.getElementById('userName').value;
		if(!isNumberOr_Letter(username)){
			errorMsg = "用户名只能使用英文字母、数字和下划线";
			return false;

		}
		if (!isFineLens(username,3,15)){
			errorMsg = "用户名不能为空，且长度在3-15之间";
			return false;
		}
		var loginname = document.getElementById('loginName').value;
		if (!isFineLens(loginname,2,15)){
			errorMsg = "姓名不能为空，且长度在2-15之间";
			return false;
		}
		var password = document.getElementById('password').value;
		if (!isFineLens(password,4,150)){
			errorMsg = "密码不能为空，且长度在4位以上";
			return false;
		}
		var cellphone = document.getElementById('cellphone').value;
		if (!checkMobile(cellphone)){
			errorMsg = "请输入有效手机号！";
			return false;
		}
		var tel = document.getElementById('tel').value;
		if (!checkPhone(tel)){
			errorMsg = "请输入有效电话号码！";
			return false;
		}
		var email = document.getElementById('email').value;
		if (!checkEmail(email)){
			errorMsg = "请输入有效电子邮箱！";
			return false;
		}
		return true;
	};
	$(function() {
		$("#saveBtn").click(function() {
			var $item = $(".checkboxRoles:checked");
			if($item.length > 0){
				var ids =new Array();
				$item.each(function(){
					ids.push($(this).val());
				});
				document.getElementById('assignedRoleList').value = ids.join(",");
			}
			if(!validate()){
				$.pnotify({title: '新增失败！',text:errorMsg,type: 'error'});
			} else {
				var pwd = document.getElementById('password').value;
				if(pwd.length!=32){
					document.getElementById('password').value=hex_md5(pwd);					
				}
				$.post($('form').attr('action'), $('form').serialize(), function(data) {
					if (data.status == "OK"){
						$.pnotify({title: '添加成功！',type: 'success'});
						localtion.href="${base}/admin/user.do";
					}else{
						$.pnotify({title: '添加失败！',text:data.message,type: 'error'});
					}
				}, 'json');
			}
		});
	});
</script>
</html>
