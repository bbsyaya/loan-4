<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href='<%=request.getContextPath()%>/css/common.css'/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='<%=request.getContextPath()%>/js/validator.js'></script>
    <script type="text/javascript" src='<%=request.getContextPath()%>/js/ajaxfileupload.js'></script>
<style type="text/css">
.align_right {
	width: 185px;
	text-align: right;
}
</style>
<title>短信发送</title>
<fieldSet style="padding: 10px; color: #333; border: #06c dashed 1px; width: 800px;">
  <legend class='dialog-label'>单条短信发送</legend>
  <table width="100%" cellspacing="5" cellpadding="5">
    <tr>
      <td class="align_right"><span><strong>手机号码</strong></span></td>
      <td>
      <input class="easyui-validatebox" invalidMessage="填写的手机号码有误"
        type="text" validtype="mobile" size="30" id="mobile" name="mobile"
        data-options="required:true" />
      </td>
    </tr>
    <tr>
      <td class="align_right"><span><strong>短信内容</strong></span></td>
      <td><textarea id="smsContent" name="smsContent" class="textarea easyui-validatebox" rows="5" style="width: 80%" data-options="required:true"></textarea></td>
    </tr>
    <tr>
      <td class="align_right"><a href="javascript:void(0)"
        class="easyui-linkbutton" onclick="singleSmsSend()"><span class="l-btn-text">&nbsp;发送&nbsp;</span></a></td>
        <td></td>
    </tr>
  </table>
</fieldSet>
<p></p>
<fieldSet style="padding: 10px; color: #333; border: #06c dashed 1px; width: 800px;">
  <legend class='dialog-label'>批量短信发送</legend>
  <table  width="100%" cellspacing="5" cellpadding="5">
    <tr>
      <td class="align_right"><span><strong>导入excel</strong></span></td>
      <td>
      <input type="file" id="batchSmsCotent" name = "smsContent" />
      </td>
      <td><a href="javascript:void(0)"
        class="easyui-linkbutton" onclick="batchSmsSend()"><span class="l-btn-text">&nbsp;发送&nbsp;</span></a></td>
    </tr>
  </table>
</fieldSet>
</head>
<body>
</body>
</html>

<script type="text/javascript">

    //单条短信发送业务逻辑
    function singleSmsSend() {
        var mobile = $("#mobile").val().trim();
        var content = $("#smsContent").val().trim();
        if(typeof(content) == 'undefined' || content == ''){
            alert("短信内容不能为空");
            return;
        }
        $.messager.progress({
            text: '数据发送中，请稍等......',
        }); 
        var url = "<%=request.getContextPath()%>/sms/sendsingle.do";
        var param = {
                mobile: mobile,
                content: content
        };
        $.post(url,param,function(status){
            $.messager.progress('close');
            if(typeof(status) == 'undefined'){
                alert("发送失败，系统错误");
            }else{
                alert("发送成功");
            }
        });
    }
    
    //批量短信内容导入逻辑
    function batchSmsSend(){
        var file = $("#batchSmsCotent").val();
        if(typeof(file) == 'undefined' || file == ''){
            alert("请选择上传文件");
            return;
        }
        var suffix = file.substr(file.lastIndexOf("."));
        if(".xls" == suffix || ".xlsx" == suffix){
            $.messager.progress({
                text: '数据发送中，请稍等......',
            }); 
            var formData = new FormData($('#uploadForm')[0]);
            var param = {
                    file: formData
            };
            var url = "<%=request.getContextPath()%>/sms/batchUpload.do";
            $.ajaxFileUpload({
                url: url,
                dataType: 'text',
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: 'batchSmsCotent', //文件上传域的ID
                success : function(status){
                    console.log("status",status);
                    $.messager.progress('close');
                    if(typeof(status) == 'undefined'){
                        alert("发送失败，系统错误");
                    }else{
                        alert("发送成功");
                    }
                },
                error: function(status){
                    console.log("status",status);
                    $.messager.progress('close');
                    if(typeof(status) == 'undefined'){
                        alert("发送失败，系统错误");
                    }else{
                        alert(status);
                    }
                }
            });
        }else{
            alert("请上传后缀为xls或xlsx的文件");
        }
    }
</script>