//签署意见
function sign(){
	//检查是否只选择了记录
	if (!checkSelected()){
		return;
	}
	if (!checkApplyStatusForSign()){
		return;
	}
	createSignSubmitWindow();
	var row = $('#t').datagrid('getSelected');
	//初始化签署意见画面
	initSignSubmitWindow();
	//资料审核或资料审核补件状态时，隐藏回退前手和尽职调查按钮和下一阶段按钮
	if (row.applyStatus == '20' || row.applyStatus == '21' ){
		$("input[id='apprResult03']").hide();
		$('#apprResult03L').hide();
		$('#backToInfos + .combo').hide();
		$("input[id='apprResult05']").hide();
		$('#apprResult05L').hide();
		$("input[id='apprResult06']").hide();
		$('#apprResult06L').hide();
		$('#modeCheckRezult').hide();
		//尽调审核状态时，隐藏退回补件按钮和尽调按钮
	} else if (row.applyStatus == '41'){
		$("input[id='apprResult04']").hide();
		$('#apprResult04L').hide();
		$("input[id='apprResult05']").hide();
		$('#apprResult05L').hide();
		$("input[id='apprResult06']").hide();
		$('#apprResult06L').hide();
		//复审第2阶段状态时，只留通过和拒绝按钮
	} else if(row.applyStatus == '34'){
		$("input[id='apprResult03']").hide();
		$('#apprResult03L').hide();
		$('#backToInfos + .combo').hide();
		$("input[id='apprResult04']").hide();
		$('#apprResult04L').hide();
		$("input[id='apprResult05']").hide();
		$('#apprResult05L').hide();
		$("input[id='apprResult06']").hide();
		$('#apprResult06L').hide();
	}
	//风险复审和尽调岗
	var row = $('#t').datagrid('getSelected');
	if (row.applyStatus == '31' || row.applyStatus == '32' || row.applyStatus == '33' || row.applyStatus == '34' || row.applyStatus == '41' ){
		//币种和还款方式查询
		$('#currSignName').val(row.currSignName);
		$('#returnKindName').val(row.returnKindName);
		//初审模型结果查询
		queryModeCheckResult(row.loanId);
		//自动风险探测结果查询
		queryRiskCheckResult(row.loanId);
		//尽调报告查询
		queryDueDiligence(row.loanId);
	}
	//签署意见查询
	querySignInfo(row.loanId,row.applyStatus);
	//风险复审1,2,复审补件
	if (row.applyStatus == '31' || row.applyStatus == '32' || row.applyStatus == '33'){
		//查询操作者的审批额度
		queryUserApprQuota();
	}
	openSignSubmitWindow(row.custName);
}
//操作人审批额度小于申请额度时，通过选项不可见
function checkApprquota(userApprQuota){
	var row = $('#t').datagrid('getSelected');
	if (userApprQuota < row.applyAmt){
		$("input[id='apprResult01']").hide();
		$('#apprResult01L').hide();
	}
}
function checkApplyStatusForSign(){
	var row = $('#t').datagrid('getSelected');
	var applyStatus = row.applyStatus;
	if (applyStatus == '10'){
		alert("受理状态的申请不能签署意见！");
		return false;
	}
	return true;
}
//新增窗口
function createSignSubmitWindow() {
    $('#signSubmitWindow').window({
        width: 1000,
        modal: true,
        shadow: true,
        closed: true,
        height: 510,
        resizable:false
    });
}
//初始化签署意见画面
function initSignSubmitWindow(){
	$('#modeCheckRezult').show();
	$('#apprAmount').val('');
	$('#apprInte').val('');
	$("input[id='apprResult01']").show();
	$('#apprResult01L').show();
	$('input[name=apprResult]').get(0).checked = true;
	$('#apprResult02L').html("拒绝");
	$("input[id='apprResult03']").show();
	$('#apprResult03L').show();
	$('#backToInfos + .combo').show();
	$("input[id='apprResult04']").show();
	$('#apprResult04L').show();
	$("input[id='apprResult05']").show();
	$('#apprResult05L').show();
	$("input[id='apprResult06']").show();
	$('#apprResult06L').show();
	$('#apprInfo').val('');
	$('#apprInfoExt').val('');
}
//开启窗口
function openSignSubmitWindow(custName){
	$('#signSubmitWindow').window('open');
    $("#signSubmitWindow").panel({title:'签署意见—'+custName});
}
//关闭登录窗口
function closeSignSubmitWindow() {
    $('#signSubmitWindow').window('close');
}
//检查审批信息
function checkSignInfo(){
	//审批意见
	var apprResult = $("input[name='apprResult']:checked").val();
	//风险复审和尽调岗
	var row = $('#t').datagrid('getSelected');
//	if (row.applyStatus == '31' || row.applyStatus == '32' || row.applyStatus == '33' || row.applyStatus == '34' || row.applyStatus == '41' ){
	if (row.applyStatus == '31' || row.applyStatus == '33' || row.applyStatus == '34' || row.applyStatus == '41'){
		//审批通过时
		if (apprResult == '10'){
			//批准金额
			var apprAmount = $("#apprAmount").val();
			if (!isMoneyInt14Dec2(apprAmount)){
				alert("批准金额最大为14位整数，2位小数！");
				return false;
			}else{
				var row = $('#t').datagrid('getSelected');
				var applyAmt = row.applyAmt;
				if (apprAmount > applyAmt){
					alert("批准金额不能大于申请金额！");
					return false;
				}
			}
			//批准利率
			var apprInte = $("#apprInte").val();
			if (!isRateInt3Dec6(apprInte)){
				alert("批准利率最大为3位整数，6位小数！");
				return false;
			}
		}
		//回退前手时
		if (apprResult == '30'){
			//回退前手人
			var backToInfos = $('#backToInfos').combobox('getValue');
			//没有选择回退人时
			if (backToInfos == ''){
				alert("请选择回退前手人!");
				return false;
			}
		}
	}
	//审批意见
	if (typeof(apprResult) == "undefined"){
		alert("请选择审批意见！");
		return false;
	}
	//意见详情（内部）
	var apprInfo = $("#apprInfo").val();
	if(apprInfo == ''){
		alert("请输入意见详情（内部）！");
		return false;
	}else if (getTotalBytes(apprInfo) > 1000){
		alert("意见详情（内部）不能超过1000个字符！");
		return false;
	}
	//意见详情（外部）
	var apprInfoExt = $("#apprInfoExt").val();
	if (getTotalBytes(apprInfoExt) > 1000){
		alert("意见详情（外部）不能超过1000个字符！");
		return false;
	}
	return true;
}