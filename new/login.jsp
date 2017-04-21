<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${base}/js/md5.js"></script>
<script type="text/javascript">
function check(){
 var pwd=document.form.pwd.value;
 document.form.password.value=hex_md5(pwd);
 return true;
}
</script>

</head>
<body>
   <form action="/loan-web/j_spring_security_check" method="post" onsubmit="return check();">
   	账户：<Input name="username"/><br/>
   	密码：<input id="pwd" name="pwd" type="password"/><br/>
   	<input id="password" name="password" type="hidden"/>
   	<input value="submit" type="submit"/>
   </form>
</body>
</html>