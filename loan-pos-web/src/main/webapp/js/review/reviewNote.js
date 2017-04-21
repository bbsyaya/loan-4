//取得当前日期（yyyy-MM-dd）
function getToday(){
	var curr_time = new Date();
	var strDate = curr_time.getFullYear()+"-";
	var strMonth = curr_time.getMonth()+1;
	if(strMonth < 10){
		strDate += "0"+strMonth+"-";
	}else{
		strDate += strMonth+"-";
	}
	strDate += curr_time.getDate();
	return strDate;
}
//复审照会
function reviewNoteList(){
	//检查是否只选择了记录
	if (checkSelected()){
		if(!checkApplyStatusForReviewNote()){
			return;
		}
		createReviewNoteListWindow();
		queryReviewNote();
		openReviewNoteListWindow();
	}
}
function checkApplyStatusForReviewNote(){
	var row = $('#t').datagrid('getSelected');
	var applyStatus = row.applyStatus;
	if (applyStatus == '10'){
		alert("受理状态的申请不能查看复审照会记录！");
		return false;
	}
	return true;
}
//新增窗口
function createReviewNoteListWindow() {
	$('#reviewNoteListWindow').window({
		width: 850,
		modal: true,
		shadow: true,
		closed: true,
		height: 510,
		resizable:false
	});
}
//开启窗口
function openReviewNoteListWindow(){
	$('#reviewNoteListWindow').window('open');
}
//关闭窗口
function closeReviewNoteListWindow() {
	$('#reviewNoteListWindow').window('close');
}
//复审登录
function reviewNote(){
	createReviewNoteWindow();
	clearReviewNoteWindow();
	initTelType();
	initRelationtype();
	openReviewNoteWindow();
}
//新增窗口
function createReviewNoteWindow() {
    $('#reviewNoteWindow').window({
        width: 650,
        modal: true,
        shadow: true,
        closed: true,
        height: 300,
        resizable:false
    });
}
//开启窗口
function openReviewNoteWindow(){
	$('#reviewNoteWindow').window('open');
}
//关闭窗口
function closeReviewNoteWindow() {
    $('#reviewNoteWindow').window('close');
}
function clearReviewNoteWindow(){
	$('#rn_teltype').combobox('setValue','');
	$('#rn_tel').val('');
	$('#rn_relationtype').combobox('setValue','');
	$('input[name=rn_result]').get(0).checked = true;
	$("#rn_reviewday").datebox("setValue", getToday());
	$('#note').val('');
}
function checkAddReviewNote(){
	if ($('#rn_tel').val()==''){
		alert("请输入照会电话号码！");
		return false;
	}
	if ($('#rn_relationtype').combobox('getValue')==''){
		alert("请选择照会对象！");
		return false;
	}
	var rn_reviewday = $('#rn_reviewday').datebox("getValue");
	if (rn_reviewday == ''){
		alert("请输入照会日期！");
		return false;
	}else if (rn_reviewday.length != 10){
		alert("照会日期输入有误！");
		return false;
	}else if (!isDate(rn_reviewday,"yyyy-MM-dd")){
		alert("照会日期输入有误！");
		return false;
	}
	var note = $("#note").val();
	if (getTotalBytes(note) > 1000){
		alert("备注不能超过1000个字符！");
		return false;
	}
	return true;
}