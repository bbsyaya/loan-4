//任务认领
//开启窗口
function openClaimWindow(){
	//检查是否只选择了一条记录
	//if (checkSelected()){
    	createClaimWindow();
    	initClaimWindow();
    	queryCreditApplyForClaim();
		$('#claimWindow').window('open');
	//}
}
//任务认领
function createClaimWindow() {
    $('#claimWindow').window({
        width: 950,
        modal: true,
        shadow: true,
        closed: true,
        height: 500,
        resizable:false
    });
}
function initClaimWindow(){
	$('#searchBizLoanIdForClaim').val('');
	$('#searchPosCustNameForClaim').val('');
	$('#searchCustIdForClaim').val('');
	$('#searchCustNameForClaim').val('');
	$('#searchChannel').combobox('setValue','');
	$('#searchOccurType').combobox('setValue','');
}
//关闭窗口
function closeClaimWindow() {
    $('#claimWindow').window('close');
}
