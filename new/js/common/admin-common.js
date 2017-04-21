$(function(){
	$('[hrbb-lock-one]').on('click',lockOne);
	$('[hrbb-unlock-one]').on('click',unlockOne);
	$('[hrbb-lock-all]').on('click',lockAll);
	$('[hrbb-unlock-all]').on('click',unlockAll);
	$('[hrbb-update-one]').on('click',updateOne);
	
});

/**
 * 显示详细信息事件。操作hrbb-show-detail 属性指定的class类
 * hrbb-show-detail ： 要显示的类名称，隐藏class使用".hidden"
 */
function showDetail(e){
	if (e) e.preventDefault();
	var detail = $(this).attr("hrbb-show-detail");
	if(!detail){
		detail = "detail";
	}
	$(this).toggleClass("glyphicon-chevron-down").toggleClass("glyphicon-chevron-up");
	$("."+detail).toggleClass("hidden");
}

/**
 * 确认对话框
 * @param title 标题
 * @param text 内容
 * @param callback 回调函数
 * @param buttons 按钮数组
 */
function confirm_dialog(title, text, callback, buttons) {
    if (typeof buttons !== "object") {
        buttons = {
            "确定": true,
            "取消": false
        };
    }
    var notice;
    text = $('<div>' + text + '<br style="clear: both;" /><div class="button-container" style="margin-top: 10px; text-align: right;"></div></div>');
    $.each(buttons, function(b, val) {
        text.find("div.button-container").append($('<button style="margin-left: 5px;" class="btn btn-default btn-small">' + b + '</button>').click(function() {
            notice.pnotify_remove();
            callback.call(notice, val);
        }));
    });
    notice = $.pnotify({
        title: title,
        text: text,
        insert_brs: false,
        hide: false,
        icon: 'glyphicon glyphicon-question-sign'
    });
}

/**
 * 锁定一个对象
 * hrbb-lock-one
 */
function lockOne(e) {
	if (e) e.preventDefault();
	var path =	getUpdateUrl($(this));
	if(!path) return ;
	var $tr = $(this).parents("tr");
	confirm_dialog('询问', '您确定?', function(answer) {
		if(!answer) return false;
		ajaxUpdate(path,{"_method":"post"},$tr);
	});
}

/**
 * 锁定一个对象
 * hrbb-lock-all
 */
function lockAll(e) {
	if (e) e.preventDefault();
	var path =	getUpdateUrl($(this));
	if(!path) return ;
	var $item = $("."+$(this).attr("hrbb-lock-all")+":checked");
	if($item.length == 0){
		$.pnotify({title: '请选择要锁定的客户！',type: 'info'});
		return;
	}
	var ids =new Array();
	$item.each(function(){
		ids.push($(this).val());
	});
	confirm_dialog('询问', '您确定锁定选定客户?', function(answer) {
		if(!answer) return false;
		ajaxUpdate(path,{"_method":"post","ids":ids.join(",")},$item.parents("tr"));
	});}

/**
 * 锁定一个对象
 * hrbb-unlock-all
 */
function unlockAll(e) {
	if (e) e.preventDefault();
	var path =	getUpdateUrl($(this));
	if(!path) return ;
	var $item = $("."+$(this).attr("hrbb-unlock-all")+":checked");
	if($item.length == 0){
		$.pnotify({title: '请选择要解锁的客户！',type: 'info'});
		return;
	}
	var ids =new Array();
	$item.each(function(){
		ids.push($(this).val());
	});
	confirm_dialog('询问', '您确定解锁所选客户?', function(answer) {
		if(!answer) return false;
		ajaxUpdate(path,{"_method":"post","ids":ids.join(",")},$item.parents("tr"));
	});}

/**
 * 锁定一个对象
 * hrbb-unslock-one
 */
function unlockOne(e) {
	if (e) e.preventDefault();
	var path =	getUpdateUrl($(this));
	if(!path) return ;
	var $tr = $(this).parents("tr");
	confirm_dialog('询问', '您确定解锁该客户?', function(answer) {
		if(!answer) return false;
		ajaxUpdate(path,{"_method":"post"},$tr);
	});
}

/**
 * update一个对象
 * hrbb-update-one
 */
function updateOne(e) {
	if (e) e.preventDefault();
	var path =	getUpdateUrl($(this));
	if(!path) return ;
	var $tr = $(this).parents("tr");
	confirm_dialog('询问', '您确定修改信息?', function(answer) {
		if(!answer) return false;
		ajaxUpdate(path,{"_method":"post"},$tr);
	});
	history.goback(-1);
}

/**
 * 获取要删除的URL路径
 * @param $this 删除事件对象
 * @returns 路径信息，没有路径返回false
 */
function getUpdateUrl($this){
	var path = $this.attr("href");
	path = (!path) ? $this.attr("hrbb-update-url") : path;
	if(!path){
		$.pnotify({title: '更新路径不正确！',type: 'info'});
		return false;
	}
	return path;
}
/**
 * Ajax异步更新元素
 * @param path 路径
 * @param params 参数
 * @param trSelect tr选择器(可选)
 */
function ajaxUpdate(path,params,$tr){
	$.ajax({
		type:"post",
		url:path, 
		data:params,
		dataType:"json",
		success:function(data) {
				if (data.status == "OK"){
					$.pnotify({title: '更新成功！',type: 'success'});
				}else{
					$.pnotify({title: '更新失败！',text:data.message,type: 'error'});
				}
			},
		error:function(request, textStatus, e){
			$.pnotify({title: '更新失败！',type: 'error'});
		}
	});
}

