<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	input[type="button"]{
		color: #3232CD;
		text-align:center;
	}
</style>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxfilesupload.js"></script>
<script type="text/javascript">
	  //影像件上传校验
	    function checkFileName(){
	   	return true;
	    }
	  
	  	//ajax文件批量上传
	    function ajaxFileUpload(){
	    	var imageLoanId = $("#imageLoanId").val();
	 		var uploadUrl = '<%=request.getContextPath()%>/navigation/uploadImageData.do';
	  		if(checkFileName()){
		 		$.messager.progress({
		 	        msg: '影像件上传',
		 	        text: '正在传输，请等待......',
		 	    }); 
		        $.ajaxFileUpload({
		        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
		        url:uploadUrl,
		        secureuri:false, //是否启用安全提交,默认为false
		        fileElementId:['0101','0102','0103','0104','0105','0106','0107','0108','0109','0110','1010','1011','1012','1013','1014','1015','1016','1017','1018','1019','1020','1021','1022','1023','1024','1025','1026','1027','1028','1029','1030','1031','1032','1099'],           //文件选择框的id属性4
		        dataType:'json', //服务器返回的格式,可以是json或xml等
		        data: {imageLoanId:imageLoanId},
		        success:function(data){//服务器响应成功时的处理函数
		        	$.messager.progress('close');
		            if(data.resultCode == "000"){
		                alert(data.resultMsg);
		            }else if ( data.resultCode == "999"){
		            	alert(data.resultMsg);
		            }else {
		            	alert(data.resultMsg);
	            	} 
	        	}
		    	});	
	  	    }
	   }
	  
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/navigation/uploadImageData.do" method="post" enctype="multipart/form-data" ">
		<input type="hidden" id="imageLoanId" name="imageLoanId" value="${loanId}" />
		<table style="border-collapse: collapse; border: none; width: 100%;">
			<tr>
				<td style="border: solid #000 1px;" width="35%">申请表:</td>
				<td style="border: solid #000 1px;" width="5%"><input id="0101" type="file" name="imageDataFile0101" multiple></td>
				<td style="border: solid #000 1px;" width="35%">申请人身份证正面:</td>
				<td style="border: solid #000 1px;" width="5%"><input id="0102" type="file" name="imageDataFile0102"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">申请人身份证反面:</td>
				<td style="border: solid #000 1px;"><input id="0103" type="file" name="imageDataFile0103"  multiple></td>
				<td style="border: solid #000 1px;">营业执照:</td>
				<td style="border: solid #000 1px;"><input id="0107" type="file" name="imageDataFile0107"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">经营场所门口照片:</td>
				<td style="border: solid #000 1px;"><input id="0108" type="file" name="imageDataFile0108"  multiple></td>
				<td style="border: solid #000 1px;">经营场所门内照片:</td>
				<td style="border: solid #000 1px;"><input id="0109" type="file" name="imageDataFile0109"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">配偶身份证反面:</td>
				<td style="border: solid #000 1px;"><input id="0105" type="file" name="imageDataFile0105"  multiple></td>
				<td style="border: solid #000 1px;">结婚证:</td>
				<td style="border: solid #000 1px;"><input id="0106" type="file" name="imageDataFile0106"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">配偶身份证正面:</td>
				<td style="border: solid #000 1px;"><input id="0104" type="file" name="imageDataFile0104"  multiple></td>
				<td style="border: solid #000 1px;">申请人征信授权书:</td>
				<td style="border: solid #000 1px;"><input id="0110" type="file" name="imageDataFile0110"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">申请人配偶征信授权书:</td>
				<td style="border: solid #000 1px;"><input id="0111" type="file" name="imageDataFile0111"  multiple></td>
				<td style="border: solid #000 1px;">协议亲签照片:</td>
				<td style="border: solid #000 1px;"><input id="0112" type="file" name="imageDataFile0112"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">房产证:</td>
				<td style="border: solid #000 1px;"><input id="0113" type="file" name="imageDataFile01013"  multiple></td>
				<td style="border: solid #000 1px;">驾驶证:</td>
				<td style="border: solid #000 1px;"><input id="0114" type="file" name="imageDataFile0114"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">离婚证:</td>
				<td style="border: solid #000 1px;"><input id="0115" type="file" name="imageDataFile0115"  multiple></td>
				<td style="border: solid #000 1px;">单身证明:</td>
				<td style="border: solid #000 1px;"><input id="0116" type="file" name="imageDataFile0116"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">税务登记证:</td>
				<td style="border: solid #000 1px;"><input id="0117" type="file" name="imageDataFile0117"  multiple></td>
				<td style="border: solid #000 1px;">组织机构代码证:</td>
				<td style="border: solid #000 1px;"><input id="0118" type="file" name="imageDataFile0118"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">户口本或户籍证明:</td>
				<td style="border: solid #000 1px;"><input id="0119" type="file" name="imageDataFile0119"  multiple></td>
				<td style="border: solid #000 1px;">特许经营许可证:</td>
				<td style="border: solid #000 1px;"><input id="0120" type="file" name="imageDataFile0120"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">经营场所租赁合同或水电煤发票:</td>
				<td style="border: solid #000 1px;"><input id="0121" type="file" name="imageDataFile0121"  multiple></td>
				<td style="border: solid #000 1px;">公司章程:</td>
				<td style="border: solid #000 1px;"><input id="0122" type="file" name="imageDataFile0122"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">欠款结清证明:</td>
				<td style="border: solid #000 1px;"><input id="0123" type="file" name="imageDataFile0123"  multiple></td>
				<td style="border: solid #000 1px;">银行流水:</td>
				<td style="border: solid #000 1px;"><input id="0124" type="file" name="imageDataFile0124"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">银行流水X季结息:</td>
				<td style="border: solid #000 1px;"><input id="0125" type="file" name="imageDataFile0125"  multiple></td>
				<td style="border: solid #000 1px;">银行卡照片:</td>
				<td style="border: solid #000 1px;"><input id="0126" type="file" name="imageDataFile0126"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">贷款卡正面:</td>
				<td style="border: solid #000 1px;"><input id="0127" type="file" name="imageDataFile0127"  multiple></td>
				<td style="border: solid #000 1px;">贷款卡反面:</td>
				<td style="border: solid #000 1px;"><input id="0128" type="file" name="imageDataFile0128"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">法院判决书:</td>
				<td style="border: solid #000 1px;"><input id="0129" type="file" name="imageDataFile0129"  multiple></td>
				<td style="border: solid #000 1px;">预签授信协议:</td>
				<td style="border: solid #000 1px;"><input id="0130" type="file" name="imageDataFile0130"  multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">授信协议骑缝照片:</td>
				<td style="border: solid #000 1px;"><input id="0131" type="file" name="imageDataFile0131"  multiple></td>
				<td style="border: solid #000 1px;">预签放款申请:</td>
				<td style="border: solid #000 1px;"><input id="0132" type="file" name="imageDataFile0132" multiple></td>
			</tr>
			<tr>
				<td style="border: solid #000 1px;">其他材料:</td>
				<td style="border: solid #000 1px;"><input id="0199" type="file" name="imageDataFile0199"  multiple></td>
			</tr>
		</table>
		<br/>
		<div style="text-align: center;">
			<input type="button" onclick="ajaxFileUpload()" value="上传" style="width: 80px;height:30px"/>
		</div>
	</form> 
</body>
</html>
