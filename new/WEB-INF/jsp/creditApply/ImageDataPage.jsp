<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<style type="text/css">
/* reset */
body{font:12px/18px "̎ͥ",arial,sans-serif;color:#585858;}
body,div,p,span,form,iframe,table,td,th,input,textarea,button,label,ul,ol,li,dl,dt,dd,h1,h2,h3,h4,h5,h6{margin:0;padding:0;}
h1,h2,h3,h4,h5,h6{font-size:100%; }
ul,ol,li,dl{list-style-type:none;}
em,i,dfn,cite,strong,small{font-style:normal;} 
img{border:0;}
fieldset,button,input,select,option{vertical-align:middle;font:12px/18px "̎ͥ",arial,sans-serif;}
table{border-collapse:collapse;border-spacing:0}
textarea{resize:none}
/* color */
a:link,a:visited{color:#575757;text-decoration:none;}
a:hover{color:#ef4165;text-decoration:none;}
a:active{color:#1d7400;}
/* clearfix */
.clearfix:after{ visibility:hidden; display:block; font-size:0; content:" "; clear:both; height:0;}
*html .clearfix{ zoom:1;}

.preview{width:400px; height:465px; margin:20px 0px 0px 30px;}
/* smallImg */
.smallImg{position:relative; height:52px; margin-top:1px; background-color:#F1F0F0; padding:6px 5px; width:390px; overflow:hidden;float:left;}
.scrollbutton{width:14px; height:50px; overflow:hidden; position:relative; float:left; cursor:pointer; }
.scrollbutton.smallImgUp , .scrollbutton.smallImgUp.disabled{background:url(images/d_08.png) no-repeat;}
.scrollbutton.smallImgDown , .scrollbutton.smallImgDown.disabled{background:url(images/d_09.png) no-repeat; margin-left:375px; margin-top:-50px;}

#imageMenu {height:50px; width:360px; overflow:hidden; margin-left:0; float:left;}
#imageMenu li {height:50px; width:60px; overflow:hidden; float:left; text-align:center;}
#imageMenu li img{width:50px; height:50px;cursor:pointer;}
#imageMenu li#onlickImg img, #imageMenu li:hover img{ width:44px; height:44px; border:3px solid #959595;}
/* bigImg */
.bigImg{position:relative; float:left; width:400px; height:400px; overflow:hidden;}
.bigImg #midimg{width:400px; height:400px;}
.bigImg #winSelector{width:235px; height:210px;}
#winSelector{position:absolute; cursor:crosshair; filter:alpha(opacity=15); -moz-opacity:0.15; opacity:0.15; background-color:#000; border:1px solid #fff;}
/* bigView */
#bigView{position:absolute;border: 1px solid #959595; overflow: hidden; z-index:999;}
#bigView img{position:absolute;}
</style>
</head>
<body>
<div class="preview">
	<div id="vertical" class="bigImg">
		<img src="" width="400" height="400" alt="" id="midimg" />
		<div style="display:none;" id="winSelector"></div>
	</div><!--bigImg end-->	
	<div class="smallImg">
		<div class="scrollbutton smallImgUp disabled" ><img width="12px" height="50px" alt="<" src="../img/ImgMenu-Left.png"></div>
		<div id="imageMenu">
			<ul>
			<c:forEach items="${loanPosImageData}" var="objImage">
		       <li id="onlickImg"> <img src="${imageUrl}imagedatawork/${loanId}/${objImage.fileName}"  width="68" height="68"></li>
			</c:forEach>
			</ul>
		</div>
		<div class="scrollbutton smallImgDown"><img width="12px" height="50px" alt="<" src="../img/ImgMenu-Right.png"></div>
	</div><!--smallImg end-->	
	<div id="bigView" style="display:none;"><img width="800" height="800" alt="" src="" /></div>
</div>
<!--preview end-->
<script type="text/javascript">
$(document).ready(function(){
	var count = $("#imageMenu li").length; 
	var interval = $("#imageMenu li:first").width();
	var curIndex = 0;
	
	$('.scrollbutton').click(function(){
		if( $(this).hasClass('disabled') ) return false;
		
		if ($(this).hasClass('smallImgUp')) --curIndex;
		else ++curIndex;
		
		$('.scrollbutton').removeClass('disabled');
		if (curIndex == 0) $('.smallImgUp').addClass('disabled');
		if (curIndex == count-1) $('.smallImgDown').addClass('disabled');
		
		$("#imageMenu ul").stop(false, true).animate({"marginLeft" : -curIndex*interval + "px"}, 600);
	});	
	$.fn.decorateIframe = function(options) {
        if ($.browser.msie && $.browser.version < 7) {
            var opts = $.extend({}, $.fn.decorateIframe.defaults, options);
            $(this).each(function() {
                var $myThis = $(this);
                //ԴݨһٶIFRAME
                var divIframe = $("<iframe />");
                divIframe.attr("id", opts.iframeId);
                divIframe.css("position", "absolute");
                divIframe.css("display", "none");
                divIframe.css("display", "block");
                divIframe.css("z-index", opts.iframeZIndex);
                divIframe.css("border");
                divIframe.css("top", "0");
                divIframe.css("left", "0");
                if (opts.width == 0) {
                    divIframe.css("width", $myThis.width() + parseInt($myThis.css("padding")) * 2 + "px");
                }
                if (opts.height == 0) {
                    divIframe.css("height", $myThis.height() + parseInt($myThis.css("padding")) * 2 + "px");
                }
                divIframe.css("filter", "mask(color=#fff)");
                $myThis.append(divIframe);
            });
        }
    }
    $.fn.decorateIframe.defaults = {
        iframeId: "decorateIframe1",
        iframeZIndex: -1,
        width: 0,
        height: 0
    }
    $("#bigView").decorateIframe();
    var midChangeHandler = null;
	
    $("#imageMenu li img").bind("click", function(){
		if ($(this).attr("id") != "onlickImg") {
			midChange($(this).attr("src").replace("small", "mid"));
			$("#imageMenu li").removeAttr("id");
			$(this).parent().attr("id", "onlickImg");
		}
	}).bind("mouseover", function(){
		if ($(this).attr("id") != "onlickImg") {
			window.clearTimeout(midChangeHandler);
			midChange($(this).attr("src").replace("small", "mid"));
			$(this).css({ "border": "3px solid #959595" });
		}
	}).bind("mouseout", function(){
		if($(this).attr("id") != "onlickImg"){
			$(this).removeAttr("style");
			midChangeHandler = window.setTimeout(function(){
				midChange($("#onlickImg img").attr("src").replace("small", "mid"));
			}, 1000);
		}
	});
    function midChange(src) {
        $("#midimg").attr("src", src).load(function() {
            changeViewImg();
        });
    }
    //ճ˓԰ߴͼ
    function mouseover(e) {
        if ($("#winSelector").css("display") == "none") {
            $("#winSelector,#bigView").show();
        }
        $("#winSelector").css(fixedPosition(e));
        e.stopPropagation();
    }
    function mouseOut(e) {
        if ($("#winSelector").css("display") != "none") {
            $("#winSelector,#bigView").hide();
        }
        e.stopPropagation();
    }
    $("#midimg").mouseover(mouseover); //אͼ˂ݾ
    $("#midimg,#winSelector").mousemove(mouseover).mouseout(mouseOut); //ݾ

    var $divWidth = $("#winSelector").width(); //
    var $divHeight = $("#winSelector").height(); //
    var $imgWidth = $("#midimg").width(); //
    var $imgHeight = $("#midimg").height(); //
     var $viewImgWidth = $viewImgHeight = $height = null; //

    function changeViewImg() {
        $("#bigView img").attr("src", $("#midimg").attr("src").replace("mid", "big"));
    }
    changeViewImg();
    $("#bigView").scrollLeft(0).scrollTop(0);
    function fixedPosition(e) {
        if (e == null) {
            return;
        }
        var $imgLeft = $("#midimg").offset().left; //
        var $imgTop = $("#midimg").offset().top; //
        X = e.pageX - $imgLeft - $divWidth / 2; //
        Y = e.pageY - $imgTop - $divHeight / 2; //
        X = X < 0 ? 0 : X;
        Y = Y < 0 ? 0 : Y;
        X = X + $divWidth > $imgWidth ? $imgWidth - $divWidth : X;
        Y = Y + $divHeight > $imgHeight ? $imgHeight - $divHeight : Y;

        if ($viewImgWidth == null) {
            $viewImgWidth = $("#bigView img").outerWidth();
            $viewImgHeight = $("#bigView img").height();
            if ($viewImgWidth < 200 || $viewImgHeight < 200) {
                $viewImgWidth = $viewImgHeight = 800;
            }
            $height = $divHeight * $viewImgHeight / $imgHeight;
            $("#bigView").width($divWidth * $viewImgWidth / $imgWidth);
            $("#bigView").height($height);
        }
        var scrollX = X * $viewImgWidth / $imgWidth;
        var scrollY = Y * $viewImgHeight / $imgHeight;
        $("#bigView img").css({ "left": scrollX * -1, "top": scrollY * -1 });
        $("#bigView").css({ "top": 50, "left": $(".preview").offset().left + $(".preview").width() + 15 });

        return { left: X, top: Y };
    }
});
</script>

</html>