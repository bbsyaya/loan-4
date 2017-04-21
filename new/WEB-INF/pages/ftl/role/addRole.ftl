<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<script type="text/javascript" src="${base}/js/p_validator.js"></script>
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
			<div class="panel-body">
			<form class="form-horizontal" role="form" method="post" action="${base}/admin/role.do">
				<div class="form-group">
					<label for="roleName" class="col-md-2 control-label">组名称</label>
					<div class="col-md-5">
						<input type="text" name="roleName" class="form-control" value="" id="roleName" placeholder="组名称">
					</div>
				</div>
				<div class="form-group">
					<label for="remark" class="col-md-2 control-label">说明</label>
					<div class="col-md-5">
						<input type="text" name="remark" class="form-control" value="" id="remark" placeholder="说明">
					</div>
				</div>
				<input id="assignedPrivilegeList" type="hidden" name="assignedPrivilegeList" value="">
			</form>
			</div>
		</div>
	
    <div class="col-xs-4">
        <div class="panel-heading">
				<span>权限列表</span>
		</div>
		<table class="table table-condensed">
         <#list allPrivileges as privilege>
         <#if (privilege_index%2=0)> <tr> </#if>
  				<td>
						<input type="checkbox" class="checkboxRoles" value="${privilege.privilegeId}">${privilege_index+1}
			    </td>
			    <td>${privilege.displayName}</td>
		 <#if (privilege_index%2=1)> </tr> </#if>
         </#list>
         </table>
	</div>
	
</div>
<div class="panel-footer" align="center">
		<button type="button" id="saveBtn" class="btn btn-primary">保存</button>
		<input type="button" class="btn btn-default" value="返回" onclick="javascript:self.location.href='${base}/admin/role.do'">
	</div>

</div>



<#-- 内容结束 --> 
</body>
<script type="text/javascript">
	var errorMsg = "";    
	function validate(){
    	errorMsg="";
    	var rolename = document.getElementById('roleName').value;
    	if (!isFineLens(rolename,3,20)){
    		errorMsg = "组名称不能为空，且长度在3-20之间";
    		return false;
    	}
    	var remark = document.getElementById('remark').value;
    	if (!isFineLens(remark,3,15)){
    		errorMsg = "说明不能为空，且长度在3-20之间";
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
				document.getElementById('assignedPrivilegeList').value = ids.join(",");
			}
			if(!validate()){
				$.pnotify({title: '新增失败！',text:errorMsg,type: 'error'});
			} else {
				$.post($('form').attr('action'), $('form').serialize(), function(data) {
					if (data.status == "OK"){
						$.pnotify({title: '添加成功！',type: 'success'});
					}else{
						$.pnotify({title: '添加失败！',text:data.message,type: 'error'});
					}
				}, 'json');
			}
		});
	});
</script>
</html>
