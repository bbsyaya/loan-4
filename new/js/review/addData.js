//录入流水信息
/**/
function openAddDataWindow(){
	if(checkSelected()){
		//createAddDataWindow();
		//initAddDataWindow();
		//$('#addDataWindow').window('open');
		openDetailApply();
	}
}
/*
//流水信息窗口
function createAddDataWindow() {
    $('#addDataWindow').window({
        width: 1000,
        modal: true,
        shadow: true,
        closed: true,
        height: 500,
        resizable:false
    });
}
*/
//关闭窗口
function closeAddDataWindow() {
    $('#addDataWindow').window('close');
}

function bankMonthClear(){
	for(var i=0; i<=11; i++){
		$('#currMonth'+i).val('');
		$('#bankName'+i).val('');
		$('#bankAccno'+i).val('');
		$('#currMonthIn'+i).val('');
		$('#currMonthOut'+i).val('');
		$('#currSeaInterestAmt'+i).val('');
		$('#'+i).hide();
	}
}
