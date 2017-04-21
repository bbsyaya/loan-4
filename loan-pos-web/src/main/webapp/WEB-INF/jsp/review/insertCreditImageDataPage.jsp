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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
<script type="text/javascript">
	    /* 初始化*/
	    $(function() {
	    	
	    });
	  	
	  	var ctrlConcurrent = 0;
	  	var runConcurrent = 0;
	  	function uploadAsSerial(){
	  		if(!verifyBrowser()) return;
	  		
	  		$.messager.progress({
	 	        msg: '影像件上传',
	 	        text: '正在传输，请等待......',
	 	    });
	  		
	  		/*iterate all file obj*/
	  		var arrayTypes = ["0101","0102","0103","0104","0105","0106","0107","0108","0109","0110","0110","0111","0112","0113","0114","0115","0116","0117","0118","0119","0120","0121","0122","0123","0124","0125","0126","0127","0128","0129","0130","0131","0132","0199"];
	  		var form = document.forms["uploadForm"];
	  		for(var i=0;i<arrayTypes.length;i++){
	  			var fileList = form["imageDataFile"+arrayTypes[i]].files;
	  			if (fileList.length > 0) { 
	  				ctrlConcurrent++;
		  			uploadSingleFile(fileList,0,fileList.length,arrayTypes[i]);
			  	}
	  		}
			if(ctrlConcurrent==0){
				$.messager.alert("操作提示","请选择要上传的影像文件.","info");
			}
	  	}
		
		function verifyBrowser(){
			//判断浏览器是否支持FileReader接口  
	  		if(typeof FileReader == 'undefined'){  
	  		    //result.InnerHTML="<p>你的浏览器不支持FileReader接口！</p>";  
	  		    alert("你的浏览器不支持FileReader接口！");
	  		    return false;
	  		} 

			return true;
		}
		
		function parseUrl(file,curr,total,extAttr){
			//alert("3:"+extAttr);
			var url = "uploadApplyImageFile.do?loanId=${loanId}&type="+extAttr+"&sortId="+curr+"&fileName=" + encodeURI(encodeURI(file.name));
			//alert(url);
			return url;
		}
	  	
	  	function uploadSingleFile(fileList,curr,total,extAttr) { 	//extAttr 为扩展属性数组
	  		//alert("2:"+extAttr);
	  		var file = fileList[curr];
  			// try sending 
  			var reader = new FileReader(); 
  			/**/
  			reader.onloadstart = function() {
  				//alert("onloadstart");
		  		// 这个事件在读取开始时触发
	  		} 
	  		reader.onprogress = function(p) { 
	  			//alert("onprogress");
		  		// 这个事件在读取进行中定时触发
		  		//document.getElementById("div"+extAttr).innerHTML=p.loaded+"/"+file.size+"B : "+file.name;
	  		} 
	  		reader.onload = function() { 
	  			//alert("onload");
		  		// 这个事件在读取成功结束后触发
	  		} 
	  		reader.onloadend = function() { 
	  			//alert("onloadend");
		  		// 这个事件在读取结束后，无论成功或者失败都会触发
		  		if (reader.error) { 
		  			alert(reader.error);
		  		} else { 
		  			//构造 XMLHttpRequest 对象，发送文件 Binary 数据
		  			var xhr = new XMLHttpRequest(); 
		  			xhr.upload.extAttr=extAttr;
		  			xhr.upload.curr=curr;
		  			xhr.upload.total=total;
		  			xhr.upload.addEventListener("progress", uploadProgress, false);  
					xhr.addEventListener("load", uploadComplete, false);  
					xhr.addEventListener("error", uploadFailed, false);  
					xhr.addEventListener("abort", uploadCanceled, false); 
		  			xhr.open("POST", parseUrl(file,curr,total,extAttr)); 			//parseUrl 需要个性化定制具体的url指向
		  			xhr.overrideMimeType("application/octet-stream"); 
		  			//xhr.sendAsBinary(reader.result);
		  			xhr.send(reader.result);
		  			xhr.onreadystatechange = function() { 
				  		if (xhr.readyState == 4) { 
					  		 if (xhr.status == 200) { 
					  			//alert("response: " + xhr.responseText);
					  			//还有未下载的文件则继续
					  			++curr;
					  			if(curr<total) {
					  				uploadSingleFile(fileList,curr,total,extAttr);
					  			}else if(curr==total){
					  				//alert(extAttr+" exe finish!");
					  				runConcurrent++;
					  				if(runConcurrent==ctrlConcurrent){	//all done
					  					//alert("all exe finish!");
					  					uploadAndArchive("${loanId}");
					  				}
					  			}
					  		 } 
				  		 } 
			  		 }
		  		}
	  		} 
	  		
	  		reader.readAsArrayBuffer(file);
	  	}
	  
	  	function uploadProgress(evt) {  
	  	  if (evt.lengthComputable) {  
	  	//    var percentComplete = Math.round(evt.loaded * 100 / evt.total);  
	  		var percentComplete = Math.round((++evt.target.curr) * 100 / evt.target.total);
	  		$("#div"+evt.target.extAttr).progressbar('setValue', percentComplete); 
	  	  }  
	  	  else {  
	  	    //document.getElementById('progressNumber').innerHTML = 'unable to compute';  
	  	  }  
	  	}  

	  	function uploadComplete(evt) {  
	  	  /* This event is raised when the server send back a response */  
	  	  //alert(evt.target.responseText);  
	  	}  

	  	function uploadFailed(evt) {  
	  	  alert("上传影像材料失败.");  
	  	}  

	  	function uploadCanceled(evt) {  
	  	  alert("用户已经取消上传,或者浏览器断开连接");  
	  	} 
	  	
	  	function showMore(obj){
	  		var linkTextValue = obj.textContent?obj.textContent:obj.innerText;
	  		var linkTextVal = linkTextValue.trim();
			if(linkTextVal == '更多>>'){
				$('#showMore').linkbutton({text:'收起<<'}); 
				$("#optional").attr("style","display: block");
			}else{
				$('#showMore').linkbutton({text:'更多>>'}); 
				$("#optional").attr("style","display: none");
			}
	  	}
	  	
	  	function uploadAndArchive(loanId){
	  		var reqUrl = "uploadAndArchive.do"
	  		$.post(reqUrl,
	  			{loanId: loanId},
	  			function(data){
	  				$.messager.progress('close');
					var respCode = data.resultCode;
					if(typeof(respCode)!="undefined" && respCode=="000"){
						parent.reloadImage("#edit","贷款申请信息");
					}else{
						var respMsg = data.resultMsg;
						$.messager.alert("操作提示","影像文件上传失败.err="+respMsg,"error");
					}
					
			},'json')
	  	}

</script>
</head>
<body>
	<div style="overflow:auto;width:100%; height:100%">
	<form id="uploadForm" name="uploadForm" action="javascript:uploadAndSubmit();" method="post" enctype="multipart/form-data" ">
		<input type="hidden" id="imageLoanId" name="imageLoanId" value="${loanId}" />
		<input type="hidden" id="marrSign" name="marrSign" value="${currSign}"/>
		<table border="0" cellpadding="5" cellspacing="5" style="width: 860px;">
			<tr>
				<td width="35%" class="tdtitle">申请表:</td>
				<td width="25%"><input id="0101" type="file" name="imageDataFile0101" multiple></td>
				<td width="40%"><div id="div0101" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">申请人身份证正面:</td>
				<td><input id="0102" type="file" name="imageDataFile0102"  multiple></td>
				<td><div id="div0102" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">申请人身份证反面:</td>
				<td><input id="0103" type="file" name="imageDataFile0103"  multiple></td>
				<td><div id="div0103" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">营业执照:</td>
				<td><input id="0107" type="file" name="imageDataFile0107"  multiple></td>
				<td><div id="div0107" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">经营场所门口照片:</td>
				<td><input id="0108" type="file" name="imageDataFile0108"  multiple></td>
				<td><div id="div0108" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">经营场所门内照片:</td>
				<td><input id="0109" type="file" name="imageDataFile0109"  multiple></td>
				<td><div id="div0109" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">配偶身份证正面:</td>
				<td><input id="0104" type="file" name="imageDataFile0104"  multiple></td>
				<td><div id="div0104" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">配偶身份证反面:</td>
				<td><input id="0105" type="file" name="imageDataFile0105"  multiple></td>
				<td><div id="div0105" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">结婚证:</td>
				<td><input id="0106" type="file" name="imageDataFile0106"  multiple></td>
				<td><div id="div0106"  class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">房产证:</td>
				<td><input id="0113" type="file" name="imageDataFile0113"  multiple></td>
				<td><div id="div0113" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">户口本或户籍证明:</td>
				<td><input id="0119" type="file" name="imageDataFile0119"  multiple></td>
				<td><div id="div0119" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td class="tdtitle">银行流水:</td>
				<td><input id="0124" type="file" name="imageDataFile0124"  multiple></td>
				<td><div id="div0124" class="easyui-progressbar" style="width:300px;"></div></td>
			</tr>
			<tr>
				<td>
				<a id="showMore" href="#" class="easyui-linkbutton" data-options="plain:true" onclick="javascript:showMore(this);">更多>></a></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		<div id="optional" style="display:none">
			<table border="0" cellpadding="5" cellspacing="5" style="width: 860px;">
				<tr>
					<td width="35%"  class="tdtitle">经营场所租赁合同或水电煤发票:</td>
					<td width="25%"><input id="0121" type="file" name="imageDataFile0121"  multiple></td>
					<td width="40%"><div id="div0121" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">公司章程:</td>
					<td><input id="0122" type="file" name="imageDataFile0122"  multiple></td>
					<td><div id="div0122" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">欠款结清证明:</td>
					<td><input id="0123" type="file" name="imageDataFile0123"  multiple></td>
					<td><div id="div0123" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">银行流水X季结息:</td>
					<td><input id="0125" type="file" name="imageDataFile0125"  multiple></td>
					<td><div id="div0125" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">银行卡照片:</td>
					<td><input id="0126" type="file" name="imageDataFile0126"  multiple></td>
					<td><div id="div0126" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">贷款卡正面:</td>
					<td><input id="0127" type="file" name="imageDataFile0127"  multiple></td>
					<td><div id="div0127" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">贷款卡反面:</td>
					<td><input id="0128" type="file" name="imageDataFile0128"  multiple></td>
					<td><div id="div0128" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">法院判决书:</td>
					<td><input id="0129" type="file" name="imageDataFile0129"  multiple></td>
					<td><div id="div0129" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">申请人征信授权书:</td>
					<td><input id="0110" type="file" name="imageDataFile0110"  multiple></td>
					<td><div id="div0110" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">申请人配偶征信授权书:</td>
					<td><input id="0111" type="file" name="imageDataFile0111"  multiple></td>
					<td><div id="div0111" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">预签授信协议:</td>
					<td><input id="0130" type="file" name="imageDataFile0130"  multiple></td>
					<td><div id="div0130" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">授信协议骑缝照片:</td>
					<td><input id="0131" type="file" name="imageDataFile0131"  multiple></td>
					<td><div id="div0131" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				
				<tr>
					<td class="tdtitle">协议亲签照片:</td>
					<td><input id="0112" type="file" name="imageDataFile0112"  multiple></td>
					<td><div id="div0112" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">预签放款申请:</td>
					<td><input id="0132" type="file" name="imageDataFile0132"  multiple></td>
					<td><div id="div0132" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">驾驶证:</td>
					<td><input id="0114" type="file" name="imageDataFile0114"  multiple></td>
					<td><div id="div0114" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">离婚证:</td>
					<td><input id="0115" type="file" name="imageDataFile0115"  multiple></td>
					<td><div id="div0115" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">单身证明:</td>
					<td><input id="0116" type="file" name="imageDataFile0116"  multiple></td>
					<td><div id="div0116" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">税务登记证:</td>
					<td><input id="0117" type="file" name="imageDataFile0117"  multiple></td>
					<td><div id="div0117" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">组织机构代码证:</td>
					<td><input id="0118" type="file" name="imageDataFile0118"  multiple></td>
					<td><div id="div0118" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">特许经营许可证:</td>
					<td><input id="0120" type="file" name="imageDataFile0120"  multiple></td>
					<td><div id="div0120" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
				<tr>
					<td class="tdtitle">其他材料:</td>
					<td><input id="0199" type="file" name="imageDataFile0199"  multiple></td>
					<td><div id="div0199" class="easyui-progressbar" style="width:300px;"></div></td>
				</tr>
			</table>
		</div>
		<br/>
		<div style="text-align: center;">
			<input type="button" onclick="uploadAsSerial()" value="确认上传" style="width: 80px;height:30px"/>
		</div>
		<br/>
	</form>
	 </div> 
</body>
</html>
