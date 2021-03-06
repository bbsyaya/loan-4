<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>业务影像材料</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/supersized/supersized.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/js/supersized/theme/supersized.shutter.css" type="text/css" media="screen" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/supersized/jquery.easing.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/supersized/supersized.3.2.7.min.hrbb.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/supersized/theme/supersized.shutter.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/supersized/jquery.rotate.min.js"></script>
		<script type="text/javascript">
		 $(function() {
			 	var jsonImgFiles = ${listImgFiles};		/*影像文件列表*/
				$.supersized({
					slideshow:1,autoplay:0,start_slide:1,stop_loop:0,random:0,slide_interval:3000,transition:6,
					transition_speed:1000,new_window:1,pause_hover:0,keyboard_nav:1,performance:1,image_protect:1,
					min_width:0,min_height:0,vertical_center:1,horizontal_center:1,fit_always:0,fit_portrait:1,
					fit_landscape:0,slide_links:'blank',thumb_links:1,thumbnail_navigation:0,progress_bar:0,mouse_scrub:0,
					slides:jsonImgFiles
				});
				
		    });
		 
		 var angle = 0;
		 var rotaeImg = "";
		 function imgRotation(img){
			 if(rotaeImg!=img){
				 rotaeImg = img;
				 angle = 90;
			 }else{
				 angle += 90;
			 }
			 $(img).rotate({animateTo:angle});
		 }
		</script>
		
	</head>
	
	<style type="text/css">
		ul#demo-block{ margin:0 15px 15px 15px; }
		ul#demo-block li{ margin:0 0 10px 0; padding:10px; display:inline; float:left; clear:both; color:#aaa; background:url('../img/supersized/bg-black.png'); font:11px Helvetica, Arial, sans-serif; }
		ul#demo-block li a{ color:#eee; font-weight:bold; }
	</style>

<body>

	<!--Thumbnail Navigation-->
	<div id="prevthumb"></div>
	<div id="nextthumb"></div>
	
	<!--Arrow Navigation-->
	<a id="prevslide" class="load-item"></a>
	<a id="nextslide" class="load-item"></a>
	
	<div id="thumb-tray" class="load-item">
		<div id="thumb-back"></div>
		<div id="thumb-forward"></div>
	</div>
	
	<!--Time Bar
	<div id="progress-back" class="load-item">
		<div id="progress-bar"></div>
	</div>
	-->
	<!--Control Bar-->
	<div id="controls-wrapper" class="load-item">
		<div id="controls">
			<!--
			<a id="play-button"><img id="pauseplay" src="img/supersized/pause.png"/></a>
			-->
			<!--Slide counter-->
			<div id="slidecounter">
				<span class="slidenumber"></span> / <span class="totalslides"></span>
			</div>
			
			<!--Slide captions displayed here-->
			<div id="slidecaption"></div>
			
			<!--Thumb Tray button-->
			<a id="tray-button"><img id="tray-arrow" src="../img/supersized/button-tray-up.png"/></a>
			
			<!--Navigation-->
			<ul id="slide-list"></ul>
			
		</div>
	</div>

</body>
</html>
