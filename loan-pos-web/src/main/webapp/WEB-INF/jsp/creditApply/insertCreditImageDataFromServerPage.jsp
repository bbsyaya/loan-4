<!DOCTYPE html>
<%@ page language="java" import="java.io.File,java.io.FileFilter" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <meta content="text/html;charsetset=utf-8"/>
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lrtk.css" />
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.img.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.imgbox.pack.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
   <script type='text/javascript'>
	   function showPage(folderName){
		   var showPageUrl = '<%=request.getContextPath()%>/navigation/showFileUploadPage.do';
		   //var folderName = $("#customerFolder").val();
		   $("#customerFolder").attr("disabled",true);
    	   $.ajax({
		        url:showPageUrl,
		        dataType:'json', //服务器返回的格式,可以是json或xml等
		        data: {'folderName':folderName},
		        success:function(data){//服务器响应成功时的处理函数 
		            if(data.errorCode != "444"){
		            	//alert(data.showFileUpload);
		            	$("#images").empty();
		            	$("#images").append(data.showFileUpload);
		            }else{
		            	alert(data.errorMsg);
	            	} 
	        	},
	        	complete:function(){
	        		$("#customerFolder").attr("disabled",false);
	        		$("a").imgbox({
	    				'speedIn'		: 0,
	    				'speedOut'		: 0,
	    				'alignment'		: 'center',
	    				'overlayShow'	: true,
	    				'allowMultiple'	: false,
	    			});
	                var tdList = $("#allFiles").find("td");
	                var tdSize = tdList.size();
	                
	                for(var i=0; i<tdSize; i++){
		                var fileName = tdList.eq(i).find("div").text();
		                var selectFile = fileName.replace(/[~'!<>@#$%^&*()（）\-+、_=:./0-9a-zA-Z\s*]/g,'');
		                var selectObj = tdList.eq(i).find("select");
		                var options = selectObj.find("option");
		                optionsSize = options.size();
		                if(selectFile != ''){
			                for(var j=0; j<optionsSize; j++){
			                	var obj = options.eq(j);
			                	var optionText = obj.text();
			                	if(optionText.indexOf(selectFile) > -1 || selectFile.indexOf(optionText) > -1 ){
			                		obj.attr("selected",true);
			                		selectPic(selectObj);
			                	}
			                }
		                }
	                }
	        	}
		   });	
	   }
	   function selectPic(thisObj){
		   $(thisObj).prev().find("img").css("border","1px solid #97CBFF");
		   $(thisObj).prev().find("img").css("background-color","#97CBFF");
		   $(thisObj).prev().find("img").css("text-decoration","none");
		   $(thisObj).parent().find("input").remove();
		   var fileID = $(thisObj).find("option:selected").attr("id");
		   if (fileID != '') {
			   var inputID = fileID.substring(4,fileID.length);
			   var inputName = "imageData" + fileID;
			   var inputValue =  $(thisObj).prev().find("img").attr("src");
			   $("<input id='"+inputID+"' name='"+inputName+"'value='"+inputValue+"' style='display:none'/>").appendTo($(thisObj).parent());
		   } else {
			   $(thisObj).prev().find("img").css("border","");
			   $(thisObj).prev().find("img").css("background-color","");
			   $(thisObj).prev().find("img").css("text-decoration","");	
		   }

	   }
	   
		  //影像件上传校验
	    function checkFileName(){
		 var marrSign = $('#marrSign').val();
	   	 //申请表
	   	 var v0101 = getSelected("File0101");
	   	 //申请人身份证正面
	   	 var v0102 = getSelected("File0102");
	   	 //申请人身份证反面
	   	 var v0103 = getSelected("File0103");
	   	 //配偶身份证正面
	   	 var v0104 = getSelected("File0104");
	   	 //配偶身份证反面
	   	 var v0105 = getSelected("File0105");
	   	 //结婚证
	   	 var v0106 = getSelected("File0106");
	   	 //营业执照
	   	 var v0107 = getSelected("File0107");
	   	 //经营场所门口照片
	   	 var v0108 = getSelected("File0108");
	   	 //经营场所门内照片
	   	 var v0109 = getSelected("File0109");

	   	 if(!v0101){
	   		 alert("申请表必须上传");
	   		 return false;
	   	 }
	   	 if(!v0102){
	   		 alert("申请人身份证正面必须上传");
	   		 return false;
	   	 }
	   	 if(!v0103){
	   		 alert("申请人身份证反面必须上传");
	   		 return false;
	   	 }
	   	 if(!v0107){
	   		 alert("营业执照必须上传");
	   		 return false;
	   	 }
	   	 if(!v0108){
	   		 alert("经营场所门口照片必须上传");
	   		 return false;
	   	 }
	   	 if(!v0109){
	   		 alert("经营场所门内照片必须上传");
	   		 return false;
	   	 }
	   	if(marrSign=='20'){
			 if(!v0104){
		   		 alert("配偶身份证正面必须上传");
		   		 return false;
		   	 }
		   	 if(!v0105){
		   		 alert("配偶身份证反面必须上传");
		   		 return false;
		   	 }
		   	 if(!v0106){
		   		 alert("结婚证");
		   		 return false;
		   	 }
		  }
	   	    return true;
	    }
	  
		//检查是不是已经选了某些图像类型
		function getSelected(optionId){
			var options = $("[id="+optionId+"]");
			var optionSize = options.size();
            for(var i=0; i<optionSize;i++){
				if(options.eq(i).attr("selected")==true){
					  return true;
				  }
            }
			return false;
		}
		
		//文件上传
	    function fileUpload(){
	 		selectAllReceipts();//选择所有银行流水
	    	var formData=$("form").serialize();
	 		var uploadUrl = '<%=request.getContextPath()%>/navigation/uploadImageAndChangeFileName.do';
	  		if(checkFileName()){
 		 		$.messager.progress({
		 	        msg: '影像件上传',
		 	        text: '正在传输，请等待......',
		 	    }); 
		 	   $.ajax({
		 		type: 'POST',
		        url:uploadUrl,
		        dataType:'json', //服务器返回的格式,可以是json或xml等
		        data: formData,
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
	  		
	        function reload(){
			   var showPageUrl = '<%=request.getContextPath()%>/navigation/reloadFiles.do';
			   $("#reloadFile").attr("disabled",true);
	    	   $.ajax({
			        url:showPageUrl,
			        dataType:'json', //服务器返回的格式,可以是json或xml等
			        success:function(data){//服务器响应成功时的处理函数 
                        alert(data.success);
		        	},
		        	complete:function(){
		        		location.reload();
		        		$("#reloadFile").attr("disabled",false);
		        	}
			
			     });	
		     }
	        function selectAllReceipts(){
	        	var selects = $('select');
	        	var selectSize = selects.length;
	        	for(var i=0;i<selectSize;i++){
	        		var select = selects.eq(i);
	        		var fileID = select.find("option:selected").attr("id");
	        		if(fileID == ''){
	        			var option =  select.find("#File0124");
	        			var id = option.attr("id");
	        			if (id != ""&& id !=null) {
	        				option.attr("selected",true);
                			selectPic(select);
	        			}
	        		}
	        	}
	        }
  </script>
</head>

<body>
<form action="<%=request.getContextPath()%>/navigation/uploadImageAndChangeFileName.do" method="post" enctype="multipart/form-data" ">
	<input type="hidden" id="imageLoanId" name="imageLoanId" value="${loanId}" />
	<input type="hidden" id="marrSign" name="marrSign" value="${currSign}"/>
	    <div id="content">
	    <span style="padding-right:70px;font-size:28px">影像资料</span>
	    <span style="font-size:14px">请选择需要查看人的文件夹加载图片：</span>
	    <select id="customerFolder"  class="easyui-combobox detailPaperKind" name="customerFolder" data-options="onChange:function(n,o){showPage(n);}">
	        <option value="" ><--请选择需要查看的申请人文件夹--></option>
	        <c:forEach items="${folderNames}" var="obj">
	   	        <option value="${obj}" >${obj}</option>
		    </c:forEach>
	    </select>
	    <span style="padding-right:170px"></span>
	    <input id="reloadFile"value="更新服务器文件" type="button" onclick="reload()" disabled/>    
        <hr/>
		<div id="images">
	   </div>
	</div>
	<div style="text-align: center;">
		<input type="button" onclick="fileUpload()" value="上传" style="width: 80px;height:30px"/>
	</div>
</form>
</body>
</html>