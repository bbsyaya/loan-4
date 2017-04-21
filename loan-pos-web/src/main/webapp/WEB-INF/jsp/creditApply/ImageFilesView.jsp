<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>业务影像材料</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/zyImage.css" type="text/css" media="all" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/e-smart-zoom-jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/zyImage.js"></script>
		<script type="text/javascript">
		 $(function() {
			 	var jsonImgFiles = ${listImgFiles};		/*影像文件列表*/
			    var winWidth,winHeight;
		        winWidth = $(window).width(),
		        winHeight= $(window).height();              
		 		var imgList = new Array();
		 		var length = jsonImgFiles.length;
		 		for(var i=0;i< length;i++){
		 			imgList.push({"content":jsonImgFiles[i].title, "src":jsonImgFiles[i].image});			 		
		 		}
		 		if (imgList != '') {
		 			loadImages(winWidth, winHeight,imgList);
		 		}
	 		$(window).resize(function(){
	 			loadImages($(window).width(), $(window).height(),imgList);
 			});
		 });
		 
		 function loadImages(winWidth, winHeight,imgList){
		 		$("#panImage").zyImage({
		 			imgList : imgList,        // 数据列表
//			 		mainBgColor     : "ffffff", // 主图片区域背景颜色*需要6位
//			 		thumBgColor     : "ffffff", // 缩略图片区域背景颜色*需要6位
		 			mainImageWidth  : winWidth-10,    // 主图片区域宽度
		 			mainImageHeight : winHeight-125,    // 主图片区域高度
		 			thumImageWidth  : 100,    // 缩略图片区域宽度
		 			thumImageHeight : 100,    // 缩略图片区域高度
		 			
		 			thumbnails : true,        // 是否显示缩略图
		 			rotate : true,            // 是否旋转
		 			zoom : true,              // 是否放大和缩小
		 			print : false,             // 是否打印
		 			showNum : true,           // 是否显示总数量和索引
		 			del : false,               // 是否可以删除
		 			changeCallback : function(index, image){  // 切换回调事件

		 			},
		 			deleteCallback : function(image){  // 删除回调事件
		 				console.info("删除回调方法：");
		 				console.info(image);
		 			}
		 		});
		 }
		</script>
		
	</head>

<body style="background-color: #000000;">

	<div class="parent_container">
		<div id="panImage" class="pan_image"></div>
	</div>
</body>
</html>
