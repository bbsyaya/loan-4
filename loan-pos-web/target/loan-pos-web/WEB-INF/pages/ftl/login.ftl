<#include "/includes/common.ftl">
<#assign base=request.contextPath />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>哈尔滨银行互联网金融  :: 普惠金融   和谐共富</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<script type="text/javascript" src="${base}/js/md5.js"></script>
<script type="text/javascript">
function check(){
 var pwd=document.getElementById("pwd").value;
 document.getElementById("password").value=hex_md5(pwd);
 return true;
}
</script>

</head>
<body>
   <div class="warp container center">
   <div class="panel">
   <img src="${base}/img/hrbb.png">
   </div>
	   <form action="${base}/j_spring_security_check" method="post" onsubmit="return check();">
		<div class="panel">
		<table>
		<tr>
	   <td><label for="username" class="control-label">用户名:</label></td>
	   <td><Input type="text" class="form-control" name="username" placeholder="用户名"/></td>
	   </tr>
	   <tr>
	   <td><label for="pwd"	class="control-label">密码:</label></td>
	   <td><input id="pwd"  class="form-control" name="pwd" type="password"  placeholder="密码"/></td>
	   	<input id="password" name="password" type="hidden"/>
	   	</tr>
	   	<tr>
	   	<td colspan="2">
		<button type="submit" class="btn btn-default">
			<span class="glyphicon glyphicon-login"></span> 登录
		</button>
	</td></tr>
	</table>
	   	</div>
	   </form>
   </div>
</body>
</html>