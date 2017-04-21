<!DOCTYPE html>
<html lang="UTF-8">
<head>
<#include "/includes/common.ftl">
<script type="text/javascript" src="${base}/js/p_validator.js"></script>
<@pnotify/>
<title>权限信息</title>
</head>
<body>
	<#-- 内容开始 -->
	<div class="warp container">
	    <div class="row">
		<div class="col-xs-8">    	
		    <div class="panel-heading">
					<span>权限信息</span>
			</div>
			<div class="panel-body">
			<form class="form-horizontal" role="form" method="post" action="${base}/admin/privilege.do">
				<div class="form-group">
					<label for="privilegeName" class="col-md-2 control-label">权限名称</label>
					<div class="col-md-5">
						<input type="text" name="privilegeName" class="form-control" value="" id="privilegeName" placeholder="权限名称">
					</div>
				</div>
				<div class="form-group">
				<label for="displayName" class="col-md-2 control-label">展示名称</label>
				<div class="col-md-5">
					<input type="text" name="displayName" class="form-control" value="" id="displayName" placeholder="展示名称">
				</div>
			</div>
				<div class="form-group">
					<label for="remark" class="col-md-2 control-label">说明</label>
					<div class="col-md-5">
						<input type="text" name="remark" class="form-control" value="" id="remark" placeholder="说明">
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
	<div class="panel-footer" align="center">
	<button type="button" id="saveBtn" class="btn btn-primary">保存</button>
	<input type="button" class="btn btn-default" value="返回" onclick="javascript:self.location.href='${base}/admin/privilege.do'">
</div>

</div>
</div>

<#-- 内容结束 --> 
</body>
<script type="text/javascript">
	var errorMsg = "";    
	function validate(){
    	errorMsg="";
    	var privilegename = document.getElementById('privilegeName').value;
    	if (!isFirstMatch(privilegename,'ROLE_')){
    		errorMsg = "权限名称必须以'ROLE_'开始";
    		return false;
    	}
    	if (!isFineLens(privilegename,7,24)){
    		errorMsg = "权限名称长度在7-24之间";
    		return false;
    	}
    	var displayname = document.getElementById('displayName').value;
    	if (!isFineLens(displayname,3,20)){
    		errorMsg = "展示名称不能为空，且长度在3-20之间";
    		return false;
    	}
    	return true;
	};
	$(function() {
		$("#saveBtn").click(function() {
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
