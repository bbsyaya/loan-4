//黑名单
function openBlackListForReviewWindow(){
	createBlackListForReviewWindow();
	//黑名单理由
	$("#confirmReason").val('');
	queryBlackListForReview();
	$('#blackListForReviewWindow').window('open');
}
//黑名单窗口
function createBlackListForReviewWindow() {
    $('#blackListForReviewWindow').window({
        width: 650,
        modal: true,
        shadow: true,
        closed: true,
        height: 420,
        resizable:false
    });
}
//关闭窗口
function closeBlackListForReviewWindow() {
    $('#blackListForReviewWindow').window('close');
}
//检查
function checkBlackList(){
    var rows = $('#tBlackListForReview').datagrid('getSelections');
	var length = rows.length;
	if (length == 0){
	    alert("请选择一条记录！");
	    return false;
	}
	//添加黑名单理由
	var confirmReason = $("#confirmReason").val();
	if(confirmReason ==''){
		alert("请输入添加理由！");
		return false;	
	}else if (getTotalBytes(confirmReason) > 1000){
		alert("理由不能超过1000个字符！");
		return false;
	}
	return true;
}