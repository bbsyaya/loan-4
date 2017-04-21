//退回补件
function openAddInfoWindow(){
createAddInfoWindow();
	//补件说明
	$("#needReason").val('');
	queryAddInfo();
	$('#addInfoWindow').window('open');
}
//退回补件窗口
function createAddInfoWindow() {
    $('#addInfoWindow').window({
        width: 500,
        modal: true,
        shadow: true,
        closed: true,
        height: 420,
        resizable:false
    });
}




//关闭窗口
function closeAddInfoWindow() {
    $('#addInfoWindow').window('close');
}
//检查
function checkNeed(){
    var rows = $('#tAddInfo').datagrid('getSelections');
	var length = rows.length;
	if (length == 0){
	    alert("请选择一条记录！");
	    return false;
	}
	//补件说明
	var needReason = $("#needReason").val();
	if(needReason == ''){
		alert("请输入补件说明！");
		return false;
	}
	if (getTotalBytes(needReason) > 1000){
		alert("补件说明不能超过1000个字符！");
		return false;
	}
	return true;
}