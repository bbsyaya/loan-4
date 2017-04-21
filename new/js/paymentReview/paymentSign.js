//开启窗口
function openSignWindow(){
	//检查是否只选择了一条记录
	var rows = $('#tt').datagrid('getSelections');
	var length = rows.length;
	if (length == 0){
	    alert("请选择要签署的任务！");
	    return;
	}
	createSignWindow();
	//查询该条用款审批详情
	var reqUrl = 'sign.do';
	var payApplyId = rows[0].payApplyId;
	$.post(reqUrl, 
    {payApplyId: payApplyId},
    function(data){
		$('#custName').val(data.custName);
		$('#posCustName').val(data.posCustName);
		$('#payApplyAmt').val(data.payApplyAmt);
		$('#payApplyTerm').val(data.payApplyTerm);
		$('#payApplyInterest').val(data.payApplyInterest);
		$('#returnType').val(data.returnType);
		$('#expectedDate').val(data.expectedDate);
		$('#expectedEndDate').val(data.expectedEndDate);
		$('#payApplyIdSign').val(data.payApplyId);
		var bankDetailInfo = renameBankInfo(data.accountOpenBank,data.accountBranchBank,data.accountSubBranchBank)
		$('#ptcptnm').val(bankDetailInfo);
		$('#approvalContent').val('');
		$('#paymentSignWindow').window('open');
    },'json'
)
}
//任务认领
function createSignWindow() {
    $('#paymentSignWindow').window({
        width: 700,
        left:($(window).width()-700)*0.5,
        modal: true,
        shadow: true,
        closed: true,
        height: 350,
        top:($(window).height()-350)*0.5,
        resizable:false
    });
}

/* 银行开户信息格式化*/
function renameBankInfo(accountOpenBank,accountBranchBank,accountSubBranchBank){
	
	var accountBankDetail = '';
	if(typeof(accountOpenBank) == 'undefined'){
		accountOpenBank = '';
	}
	// 支行
	if(typeof(accountBranchBank) != 'undefined' && accountBranchBank.length > 0){
		if(accountBranchBank.indexOf('分行') == -1){
			accountBranchBank = accountBranchBank + '分行';
		}
	}else{
		accountBranchBank = '';
	}
    // 分行
	if(typeof(accountSubBranchBank) != 'undefined' && accountSubBranchBank.length > 0 ){
		if(accountSubBranchBank.indexOf('支行') == -1){
			accountSubBranchBank = accountSubBranchBank + '支行';
		}
	}else{
		accountSubBranchBank = '';
		
	}
	accountBankDetail = accountOpenBank+accountBranchBank+accountSubBranchBank;
	return accountBankDetail;
}