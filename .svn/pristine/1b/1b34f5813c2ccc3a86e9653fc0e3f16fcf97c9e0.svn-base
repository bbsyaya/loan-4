//任务认领
//开启窗口
function openClaimWindow(){
    	createClaimWindow();
    	initClaimWindow();
		$('#paymentClaimWindow').window('open');
		
	//}
}
//任务认领
function createClaimWindow() {
    $('#paymentClaimWindow').window({
        width: 900,
        left:($(window).width()-900)*0.5,
        modal: true,
        shadow: true,
        closed: true,
        height: 500,
        top:($(window).height()-500)*0.5,
        resizable:false
    });
}
function initClaimWindow(){
	$('#searchLoanIdForPaymentClaim').val('');
	$('#searchPosCustNameForPaymentClaim').val('');
	$('#searchCustNameForPaymentClaim').val('');
	$('#searchPaperIdForPaymentClaim').val('');
}
