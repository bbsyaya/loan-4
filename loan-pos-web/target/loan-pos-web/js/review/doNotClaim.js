//任务回池
function openDoNotClaimWindow(){
	//检查是否只选择了一条记录
	if (checkSelected()){
		var row = $('#t').datagrid('getSelected');
		if (row.applyStatus == '32' || row.applyStatus == '21'){
		    alert("该申请正在补件中，不能回池！");
		    return;
		}
    	createDoNotClaimWindow();
    	initDoNotClaimWindow();
    	$('#doNotClaimWindow').window('open');
	}
}
//任务回池窗口
function createDoNotClaimWindow() {
    $('#doNotClaimWindow').window({
        width: 650,
        modal: true,
        shadow: true,
        closed: true,
        height: 300,
        resizable:false
    });
}
function initDoNotClaimWindow(){
	var myDate = new Date();
	$('#timenow').val(myDate.toLocaleDateString());
	$('#backReason').val('');
}
//关闭窗口
function closeDoNotClaimWindow() {
    $('#doNotClaimWindow').window('close');
}
