<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务申请</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href='<%=request.getContextPath()%>/css/common.css'/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/validator.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/review/reviewNote.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/p_validator.js"></script>
	<script type="text/javascript">
	
	//获取银行流水月份
	function getOverMonths(){
		var startMonth = $('#startMonth').val();
		var endMonth = $('#endMonth').val();
		var reqUrl = "<%=request.getContextPath()%>/creditApply/getSerialMonth.do";
		$.post(
			reqUrl, {startMonth :startMonth, endMonth :endMonth}, function(obj){
			$('input.easyui-validatebox').validatebox('disableValidation');
			for(var i=0; i<=11; i++){
				$('#currMonth'+i).val('');
				$('#'+i).hide();
			}			
			for(var i=0; i<obj.length; i++){
				$('#currMonth'+i).val(obj[i].month);
				$('#'+i).show();
			}
		}, 'json');
	}
	/* 提交审核*/
	function submitCreditApply(){
		var reqUrl = "<%=request.getContextPath()%>/creditApply/updateApplyStatus.do";
		var reqStr = "";
		var applyStatus = '20';
		var rows = $('#tt').datagrid('getSelections');
		if(rows.length == 0){
			alert('请选择一条记录');
			return;
		}else if(rows.length > 1){
			alert('只允许选择一条记录');
			return;
		}
		for(var i=0; i<rows.length; i++){
			reqStr=reqStr+rows[i].loanId+"|";
		}
		$.get(reqUrl, {applyStatus: applyStatus,loanStr: reqStr}, function(data){
			alert(data);
			queryCreditApply();
		}, 'text');
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
	
	//根据婚姻状况切换必输区域：20已婚配偶必输
	function switchRequired(newVal,type){
		var obj;
		if(type=="New"){
			obj = {"matePaperId":"#insertMatePaperId",
					"familyCustName":"#insertFamilyCustName",
					"mateMobilePhone":"#insertMateMobilePhone",
					"relaCustName":"#insertRelaCustName",
					"relaMobilePhone":"#insertRelaMobilePhone"};
		}else if(type=="Edit"){
			obj = {"matePaperId":"#editMatePaperId",
					"familyCustName":"#editFamilyCustName",
					"mateMobilePhone":"#editMateMobilePhone",
					"relaCustName":"#editRelaCustName",
					"relaMobilePhone":"#editRelaMobilePhone"};
		}
		
		if(typeof(newVal)!="undefined" && newVal=="20"){
			//----已婚时配偶必输	
			$(obj.matePaperId).validatebox('reduce');
			$(obj.familyCustName).validatebox('reduce');
			$(obj.mateMobilePhone).validatebox('reduce');
			
			$(obj.relaCustName).validatebox('remove');
			$(obj.relaMobilePhone).validatebox('remove');
		}else{
			//----非已婚家属笔数
			$(obj.matePaperId).validatebox('remove');
			$(obj.familyCustName).validatebox('remove');
			$(obj.mateMobilePhone).validatebox('remove');
			
			$(obj.relaCustName).validatebox('reduce');
			$(obj.relaMobilePhone).validatebox('reduce');
		}
	}
	
	function selectDivision(provId,oCity,oCountry){
		var city = oCity.combobox({  
            disabled:false,  
            url:'<%=request.getContextPath()%>/provinceCity/getCity.do?itemNo='+provId,  
            valueField:'itemNo',  
            textField:'itemName',  
            onLoadSuccess:function(data){ //第2选中  
                var combobox = oCity.combobox('getData'); 
                oCity.combobox('setText',combobox[0].itemName).combobox('setValue',combobox[0].itemNo);  
            },  
            onChange:function(newValue, oldValue){
                if(newValue != ""){  
                    //刷新数据，重新读取省份下的城市，并清空当前输入的值  
                   oCountry.combobox({  
                        disabled:false,  
                        url:'<%=request.getContextPath()%>/provinceCity/getDistrict.do?itemNo='+newValue,  
                        valueField:'itemNo',  
                        textField:'itemName',  
                        onLoadSuccess:function(){ //第2选中  
                            var combobox = oCountry.combobox('getData');  
                            oCountry.combobox('setText',combobox[0].itemName).combobox('setValue',combobox[0].itemNo);  
                        }  
                    });//.combobox('clear');  
                }  
            }  
        });//.combobox('clear');
	}
	
	function executeQeury(){
		var searchBizLoanId = getTextValue("#searchBizLoanId");
		var searchPosCustName = getTextValue("#searchPosCustName");
		var searchCustName = getTextValue("#searchCustName");
		var searchPaperId = getTextValue("#searchPaperId");
		var searchRecOrg = getTextValue("#searchRecOrg");
		var searchRecPerson = getTextValue("#searchRecPerson");
		var searchChannel = getTextValue("#searchChannel");
		var searchRegion = getTextValue("#searchRegion");
		
		if(searchBizLoanId=="" 
				&& searchPosCustName==""
				&& searchCustName==""
				&& searchPaperId==""
				&& searchRecOrg==""
				&& searchRecPerson==""
				&& searchChannel==""
				&& searchRegion==""){
			$.messager.alert("操作提示","请输入查询条件.","warning");
			return ;
		}
		queryCreditApply();
	}
	
	/* 根据条件查询 */
	function queryCreditApply(){
		var queryUrl="<%=request.getContextPath()%>/creditApply/queryCreditApply.do?applyStatus=${applyStatus}&isApplyStatus=${isApplyStatus}";

		$('#tt').datagrid(
			{url:queryUrl,
		    queryParams:{
				bizLoanIdLike: $('#searchBizLoanId').val(),
				posCustNameLike: $('#searchPosCustName').val(),
				custIdLike: $('#searchCustId').val(),
				custNameLike: $('#searchCustName').val(),
				paperIdLike: $('#searchPaperId').val(),
				recOrgLike: $('#searchRecOrg').val(),
				recPersonLike: $('#searchRecPerson').val(),
				applyStatus: $('#searchApplyStatus').val(),
				channel:$('#searchChannel').val(),
				region:$('#searchRegion').val()
			}
		});
	}
	
	
	/* 重置查询条件	 */
	function queryBlank(){
		$('#searchBizLoanId').val("");
		$('#searchPosCustName').val("");
		$('#searchCustId').val("");
		$('#searchCustName').val("");
		$('#searchPaperId').val("");
		$('#searchRecOrg').val("");
		$('#searchRecPerson').val("");
		$('#searchApplyStatus').val("0");
		queryCreditApply();
	}
	
	
	/* 删除记录 */
	function deleteCreditApply(){
	    if(confirm('确定要取消该笔申请吗？')){
			var reqUrl = "<%=request.getContextPath()%>/creditApply/deleteCreditApply.do";
			var reqStr = "";
			var rows = $('#tt').datagrid('getSelections');
			if(rows.length == 0){
				alert('请选择一条记录');
				return;
			}
			for(var i=0; i<rows.length; i++){
				reqStr=reqStr+rows[i].loanId+"|";
			}
			$.post(reqUrl, {deleteItem: reqStr}, function(data){
				alert(data);
				queryCreditApply();
			}, 'text');
	    }else{
	    	return;
	    }
	}
	
	function valiateBankCard(card){
		var cardno = $(card).val();
		if(typeof(cardno)!="undefined" && cardno.length >= 6){
		/*银行卡号luhm校验*/
		var flag = luhmCheck(cardno);
		if(!flag){
			$.messager.alert("操作提示",cardno + "不是合法的银行卡号","error");
			return;
		}
			//var bin = cardno.substring(0,6);
			var reqUrl="<%=request.getContextPath()%>/genericConfig/getIssuerInfo.do";
			$.post(reqUrl, {cardno: cardno}, function(data){
				var issueBankName = data.issueBankName;
				if(typeof(issueBankName)!="undefined" && issueBankName.length > 0){
					var bankAttr = data.bankAttr;
					if(typeof(bankAttr)!="undefined" && bankAttr==''){
						var cardName = data.cardName;
						//var cardType = data.cardType;
						$.messager.alert("操作提示",cardName+" ["+issueBankName+"] 不能作为有效的收款银行账号!","error");
						return;
					}
					setInputValue("#insertBankName", bankAttr, "combo");
				}else{
					setInputValue("#insertBankName", "", "combo");
				}
			}, 'json');
		}
	}
	
	function loadRecInfo(contact, type){
		var contactNo = $(contact).val();
		
		if(typeof(contactNo)!="undefined" && contactNo.length > 0){
			var reqUrl="<%=request.getContextPath()%>/genericConfig/getRecInfo.do";
			$.post(reqUrl, 
				{contactNo: contactNo}, 
				function(data){
					var recPerson = data.recPerson;
					var recOrg = data.recOrg;
					var recManager = data.recManager;
//					alert(recPerson+" / "+recOrg+" / "+recManager);
					if(typeof(recPerson)!="undefined" && recPerson.length > 0
							&& typeof(recOrg)!="undefined" && recOrg.length > 0){
						setInputValue("#"+type+"RecPerson", recPerson);
						setInputValue("#"+type+"RecOrg", recOrg);
						setInputValue("#"+type+"RecManager", recManager);
					}else{
						setInputValue("#"+type+"RecPerson", "");		//查不到清空
						setInputValue("#"+type+"RecOrg", "");
						setInputValue("#"+type+"RecManager", "");
					}
			
			}, 'json');
		}else{
			setInputValue("#"+type+"RecPerson", "");		//号码为空时清空
			setInputValue("#"+type+"RecOrg", "");
		}
	}
	
	/* 根据银行名称查看最高代扣限额 */
	function validateRepay(applyAmt,repayMethod,bankName){
		//金额
		var amount = getNumberValue(applyAmt);
		//偿还方式
		var insertRepayMethod = getValue(repayMethod,"combo");
		//银行Id
		var bankId = getValue(bankName,"combo");
		
		if(amount=="" || insertRepayMethod=="" || bankName==""){
			//do nothing but ignore;	
			return ;
		}
		
		var reqUrl="<%=request.getContextPath()%>/custBank/queryBankLimit.do";
		//代扣还款规则
		if(insertRepayMethod=='02'){
			$.post(reqUrl,{bankId:bankId},function(data){
				var propValue=data.propValue;
				if(propValue==0){
					$.messager.alert("操作提示", "<b>"+data.bankName+"</b> 只支持主动还款方式，请使用主动还款或更换其他银行卡.","warning");
					$(repayMethod).combobox('setValue',"01");
				}else if(amount-propValue>0){
					$.messager.alert("操作提示", "申请金额超 <b>"+data.bankName+"</b> 扣款限额，请使用主动还款或更换其他银行卡。","warning");
					$(repayMethod).combobox('setValue',"01");
				}
			},'json')
		}
	}
	
	function fullFillCustomerInfo(obj, type){
		if(typeof(type)=="undefined" || type==""){
			return;
		}
		var certId = $(obj).val();
		var being;
		if(type=="self"){
			being = [{"id":"custName","ref":"#insertCustName","type":"text","disabled":"true"},
			         {"id":"birtDate","ref":"#insertBirtDate","type":"text","func":"timeStamp2String"},
					{"id":"busiYear","ref":"#insertBusiYear","type":"text"},
					{"id":"sexSign","ref":"#insertSexSign","type":"combo"},
					{"id":"educSign","ref":"#insertEducSign","type":"combo"},
					{"id":"marrSign","ref":"#insertMarrSign","type":"combo"},
		            {"id":"childNum","ref":"#insertChildNum","type":"text"},
		            {"id":"localHouseNum","ref":"#insertLocalHouseNum","type":"text"},
		            {"id":"otherHouseNum","ref":"#insertOtherHouseNum","type":"text"},
		            {"id":"mobilePhone","ref":"#insertMobilePhone","type":"text"},
		            {"id":"tel","ref":"#insertTel","type":"text"},
		            {"id":"residentProv","ref":"#insertResidentProv","type":"combo"},
		            {"id":"residentCity","ref":"#insertResidentCity","type":"combo"},
		            {"id":"residentDivision","ref":"#insertResidentDivision","type":"combo"},
		            {"id":"residentDetail","ref":"#insertResidentDetail","type":"text"},
		            {"id":"weixinNo","ref":"#insertWeixinNo","type":"text"},
		            {"id":"QQNo","ref":"#insertQQNo","type":"text"},
		            {"id":"contactAddrFlag","ref":"insertAddrFlag","type":"radio"}
			];
		}else if(type="mate"){
			being =[{"id":"custName","ref":"#insertFamilyCustName","type":"text","disabled":"true"},
				    {"id":"birtDate","ref":"#insertMateBirtDate","type":"text","func":"timeStamp2String"},
				    {"id":"sexSign","ref":"#insertMateSexSign","type":"combo"},
				    {"id":"mobilePhone","ref":"#insertMateMobilePhone","type":"text"}
			];
		}
		return executeFullfill(certId,being);
	}///timeStamp2String
	
	function executeFullfill(paperId, being){
		if(paperId==""){
			//身份证为空清掉所有
			for(var i=0; i<being.length; i++){
				setInputValue(being[i].ref, "", being[i].type);
			}
			return;
		}
		
		//身份证非空
		var reqUrl = "<%=request.getContextPath()%>/creditApply/queryExistCustomer.do";
		//ajax查询是否为存量客户
		$.post(reqUrl, {paperId: paperId}, function(data){
			if(data.length>0){
				//查询到多个客户时只处理第一个
				for(var i=0; i<being.length; i++){
					if(null != data[0][being[i].id] && '' != data[0][being[i].id]){
						//需要先运行的function
						if(typeof(being[i].func)!="undefined" && being[i].func!=""){
							//alert(data[0][being[i].id]);
							data[0][being[i].id]=eval(being[i].func+"("+data[0][being[i].id]+")");
							//alert(data[0][being[i].id]);
						}
						//赋值
						setInputValue(being[i].ref, data[0][being[i].id], being[i].type);
						//需要进行的disabled操作
						if(typeof(being[i].disabled)!="undefined" && being[i].disabled=="true"){
							$(being[i].ref).attr("disabled","disabled");
						}
					}
				}
			}else{
				//查不到清空当前并赋值性别和生日
				for(var i=0; i<being.length; i++){
					//需要进行还原的disabled操作
					if(typeof(being[i].disabled)!="undefined" && being[i].disabled=="true"){
						$(being[i].ref).attr("disabled",false);
					}
					//赋值
					if(being[i].id=="sexSign"){
						//填充生日和性别
						var sex = paperId.substring(16, 17);
						
						if (sex % 2 == 0) {
							setInputValue(being[i].ref, "2", being[i].type);
						} else {
							setInputValue(being[i].ref, "1", being[i].type);
						}
					}else if(being[i].id=="birtDate"){
						var birth = paperId.substring(6, 14);
						var birthYear = birth.substring(0, 4);
						var birthMonth = birth.substring(4, 6);
						var birthDay = birth.substring(6, 8);
						var birthDate = birthYear + "-" + birthMonth + "-" + birthDay;
						
						setInputValue(being[i].ref, birthDate, being[i].type);
						
					}else{
						setInputValue(being[i].ref, "", being[i].type);
					}
				}
				
			}
		},'json');
		
	}
	
	/*新增申请记录*/
	function creditApplyReg(flag) {
		var flag = validateForm("applyform");
		if (!flag){
			$.messager.alert("操作提示","还有未填写的必输项.","error");
			return;
		}
		var reqUrl = "<%=request.getContextPath()%>/creditApply/insertCreditApply.do";
		var loanId = $('#insertLoanId').val();
		var channel = getComboValue('#insertChannel');
		var paperKind = $('#insertPaperKind').val();
		//var applyAmt = $('#insertApplyAmt').val();
		var applyAmt = getNumberValue('#insertApplyAmt');
		var currSign = $('#insertCurrSign').val();
		var applyTerm = $('#insertApplyTerm').val();
		var returnKind = getComboValue('#insertReturnKind');
		var bankAccno = $('#insertBankAccno').val();
		var bankName = getComboValue('#insertBankName');
		var bankBranName = $('#insertBankBranName').val();
		var	bankSubName = $('#insertBankSubName').val();
		var recOrg = $('#insertRecOrg').val();
		var recPerson = $('#insertRecPerson').val();
		var remark = $('#insertRemark').val();
        if (getTotalBytes(remark) > 1000){
			alert('备注不能超过1000个字符！');
			return;
		}
		var recContactNo = $('#insertRecContactNo').val();
		var posCustName = $('#insertPosCustName').val();
		var posCustBusiScope = $('#insertPosCustBusiScope').val();
		var busiDivision = getComboValue('#insertBusiDivision');
		var posCustAddress = $('#insertPosCustAddress').val();
		var custName =$('#insertCustName').val();
		var paperId =$('#insertPaperId').val();
		//长度校验
		if((paperId.length-18)!=0){
			alert('身份证长度不正确');
			return;
		}
		//年龄校验
		var age = getAgeFromUUserCard(paperId);
		if(age<18 || age>60){
			alert('年龄不符合,必须在18-60之间');	
			return;
		}
		var inChannelKind = getComboValue('#insertInChannelKind');
		var repayMethod = getComboValue('#insertRepayMethod');
		var birtDate =$('#insertBirtDate').val();
		var sexSign = getComboValue('#insertSexSign');
		var busiYear =$('#insertBusiYear').val();
		var marrSign = getComboValue('#insertMarrSign');
		var educSign = getComboValue('#insertEducSign');
		var childNum =$('#insertChildNum').val();
		var localHouseNum =$('#insertLocalHouseNum').val();
		var otherHouseNum =$('#insertOtherHouseNum').val();
		var mobilePhone =$('#insertMobilePhone').val();
		var tel =$('#insertTel').val();
		var residentProv = getComboValue('#insertResidentProv');
		var residentCity = getComboValue('#insertResidentCity');
		var matePaperKind =$('#insertMatePaperKind').val();
		var matePaperId =$('#insertMatePaperId').val();
		var residentDivision = getComboValue('#insertResidentDivision');
		var residentDetail =$('#insertResidentDetail').val();
		var weixinNo =$('#insertWeixinNo').val();
		var qqNo =$('#insertQQNo').val();
		var email =$('#insertEmail').val();
		var familyCustName =$('#insertFamilyCustName').val();
		var mateSexSign = getComboValue('#insertMateSexSign');
		var mateMobilePhone =$('#insertMateMobilePhone').val();
		var relaCustName =$('#insertRelaCustName').val();
		var relaKind =$('#insertRelaKind').val();
		var relaKind = getComboValue('#insertRelaKind');
		var relaMobilePhone =$('#insertRelaMobilePhone').val();
		var relaTel =$('#insertRelaTel').val();
		var contactAddrFlag = getRadioValue('insertAddrFlag');
		var mateBirtDate =$('#insertMateBirtDate').val();
		if(typeof(matePaperId)!="undefined" && matePaperId != ""){
			if(matePaperId == paperId){
				$.messager.alert("操作提示","配偶身份证号与申请人证件不能相同!","error");
				return;
			}
		}
		var occurType = getRadioValue('insertOccurType');
		var currMonth0 = $('#currMonth0').val();
		var bankName0 = $('#bankName0').val();
		var bankAccno0 = $('#bankAccno0').val();
		var currMonthIn0 = $('#currMonthIn0').val();
		var currMonthOut0 = $('#currMonthOut0').val();
		var currSeaInterestAmt0 = $('#currSeaInterestAmt0').val();
		var currMonth1 = $('#currMonth1').val();
		var bankName1 = $('#bankName1').val();
		var bankAccno1 = $('#bankAccno1').val();
		var currMonthIn1 = $('#currMonthIn1').val();
		var currMonthOut1 = $('#currMonthOut1').val();
		var currSeaInterestAmt1 = $('#currSeaInterestAmt1').val();
		var currMonth2 = $('#currMonth2').val();
		var bankName2 = $('#bankName2').val();
		var bankAccno2 = $('#bankAccno2').val();
		var currMonthIn2 = $('#currMonthIn2').val();
		var currMonthOut2 = $('#currMonthOut2').val();
		var currSeaInterestAmt2 = $('#currSeaInterestAmt2').val();
		var currMonth3 = $('#currMonth3').val();
		var bankName3 = $('#bankName3').val();
		var bankAccno3 = $('#bankAccno3').val();
		var currMonthIn3 = $('#currMonthIn3').val();
		var currMonthOut3 = $('#currMonthOut3').val();
		var currSeaInterestAmt3 = $('#currSeaInterestAmt3').val();
		var currMonth4 = $('#currMonth4').val();
		var bankName4 = $('#bankName4').val();
		var bankAccno4 = $('#bankAccno4').val();
		var currMonthIn4 = $('#currMonthIn4').val();
		var currMonthOut4 = $('#currMonthOut4').val();
		var currSeaInterestAmt4 = $('#currSeaInterestAmt4').val();
		var currMonth5 = $('#currMonth5').val();
		var bankName5 = $('#bankName5').val();
		var bankAccno5 = $('#bankAccno5').val();
		var currMonthIn5 = $('#currMonthIn5').val();
		var currMonthOut5 = $('#currMonthOut5').val();
		var currSeaInterestAmt5 = $('#currSeaInterestAmt5').val();
		var currMonth6 = $('#currMonth6').val();
		var bankName6 = $('#bankName6').val();
		var bankAccno6 = $('#bankAccno6').val();
		var currMonthIn6 = $('#currMonthIn6').val();
		var currMonthOut6 = $('#currMonthOut6').val();
		var currSeaInterestAmt6 = $('#currSeaInterestAmt6').val();
		var currMonth7 = $('#currMonth7').val();
		var bankName7 = $('#bankName7').val();
		var bankAccno7 = $('#bankAccno7').val();
		var currMonthIn7 = $('#currMonthIn7').val();
		var currMonthOut7 = $('#currMonthOut7').val();
		var currSeaInterestAmt7 = $('#currSeaInterestAmt7').val();
		var currMonth8 = $('#currMonth8').val();
		var bankName8 = $('#bankName8').val();
		var bankAccno8 = $('#bankAccno8').val();
		var currMonthIn8 = $('#currMonthIn8').val();
		var currMonthOut8 = $('#currMonthOut8').val();
		var currSeaInterestAmt8 = $('#currSeaInterestAmt8').val();
		var currMonth9 = $('#currMonth9').val();
		var bankName9 = $('#bankName9').val();
		var bankAccno9 = $('#bankAccno9').val();
		var currMonthIn9 = $('#currMonthIn9').val();
		var currMonthOut9 = $('#currMonthOut9').val();
		var currSeaInterestAmt9 = $('#currSeaInterestAmt9').val();
		var currMonth10 = $('#currMonth10').val();
		var bankName10 = $('#bankName10').val();
		var bankAccno10 = $('#bankAccno10').val();
		var currMonthIn10 = $('#currMonthIn10').val();
		var currMonthOut10 = $('#currMonthOut10').val();
		var currSeaInterestAmt10 = $('#currSeaInterestAmt10').val();
		var currMonth11 = $('#currMonth11').val();
		var bankName11 = $('#bankName11').val();
		var bankAccno11 = $('#bankAccno11').val();
		var currMonthIn11 = $('#currMonthIn11').val();
		var currMonthOut11 = $('#currMonthOut11').val();
		var currSeaInterestAmt11 = $('#currSeaInterestAmt11').val();
		$.post(reqUrl, {channel: channel,
		loanId: loanId,
		custName: custName,
		paperKind: paperKind,
		applyAmt: applyAmt,
		custName: custName,
		currSign: currSign,
		applyTerm: applyTerm,
		returnKind: returnKind,
		bankAccno: bankAccno,
		bankName: bankName,
		bankBranName: bankBranName,
		bankSubbName: bankSubName,
		recOrg: recOrg,
		recPerson: recPerson,
		remark: remark,
		recContactNo: recContactNo,
		posCustName:posCustName,
		posCustBusiScope: posCustBusiScope,
		busiDivision: busiDivision,
		posCustAddress: posCustAddress,
		custName: custName,
		paperId: paperId,
		birtDate: birtDate,
		sexSign: sexSign,
		busiYear: busiYear,
		marrSign: marrSign,
		educSign: educSign,
		childNum: childNum,
		localHouseNum: localHouseNum,
		otherHouseNum: otherHouseNum,
		mobilePhone: mobilePhone,
		tel: tel,
		residentProv: residentProv,
		residentCity: residentCity,
		residentDetail: residentDetail,
		weixinNo: weixinNo,
		qqNo: qqNo,
		email: email,
		familyCustName: familyCustName,
		matePaperKind: matePaperKind,
		matePaperId: matePaperId,
		mateBirtDate: mateBirtDate,
		mateSexSign: mateSexSign,
		mateMobilephone: mateMobilePhone,
		relaCustName: relaCustName,
		relaKind: relaKind,
		relaMobilePhone: relaMobilePhone,
		relaTel: relaTel,
		contactAddrFlag: contactAddrFlag,
		occurType: occurType,
		currMonth0: currMonth0,
		bankName0: bankName0,
		bankAccno0: bankAccno0,
		currMonthIn0: currMonthIn0,
		currMonthOut0: currMonthOut0,
		currSeaInterestAmt0: currSeaInterestAmt0,
		currMonth1: currMonth1,
		bankName1: bankName1,
		bankAccno1: bankAccno1,
		currMonthIn1: currMonthIn1,
		currMonthOut1: currMonthOut1,
		currSeaInterestAmt1: currSeaInterestAmt1,
		currMonth2: currMonth2,
		bankName2: bankName2,
		bankAccno2: bankAccno2,
		currMonthIn2: currMonthIn2,
		currMonthOut2: currMonthOut2,
		currSeaInterestAmt2: currSeaInterestAmt2,
		currMonth3: currMonth3,
		bankName3: bankName3,
		bankAccno3: bankAccno3,
		currMonthIn3: currMonthIn3,
		currMonthOut3: currMonthOut3,
		currSeaInterestAmt3: currSeaInterestAmt3,
		currMonth4: currMonth4,
		bankName4: bankName4,
		bankAccno4: bankAccno4,
		currMonthIn4: currMonthIn4,
		currMonthOut4: currMonthOut4,
		currSeaInterestAmt4: currSeaInterestAmt4,
		currMonth5: currMonth5,
		bankName5: bankName5,
		bankAccno5: bankAccno5,
		currMonthIn5: currMonthIn5,
		currMonthOut5: currMonthOut5,
		currSeaInterestAmt5: currSeaInterestAmt5,
		currMonth6: currMonth6,
		bankName6: bankName6,
		bankAccno6: bankAccno6,
		currMonthIn6: currMonthIn6,
		currMonthOut6: currMonthOut6,
		currSeaInterestAmt6: currSeaInterestAmt6,
		currMonth7: currMonth7,
		bankName7: bankName7,
		bankAccno7: bankAccno7,
		currMonthIn7: currMonthIn7,
		currMonthOut7: currMonthOut7,
		currSeaInterestAmt7: currSeaInterestAmt7,
		currMonth8: currMonth8,
		bankName8: bankName8,
		bankAccno8: bankAccno8,
		currMonthIn8: currMonthIn8,
		currMonthOut8: currMonthOut8,
		currSeaInterestAmt8: currSeaInterestAmt8,
		currMonth9: currMonth9,
		bankName9: bankName9,
		bankAccno9: bankAccno9,
		currMonthIn9: currMonthIn9,
		currMonthOut9: currMonthOut9,
		currSeaInterestAmt9: currSeaInterestAmt9,
		currMonth10: currMonth10,
		bankName10: bankName10,
		bankAccno10: bankAccno10,
		currMonthIn10: currMonthIn10,
		currMonthOut10: currMonthOut10,
		currSeaInterestAmt10: currSeaInterestAmt10,
		currMonth11: currMonth11,
		bankName11: bankName11,
		bankAccno11: bankAccno11,
		currMonthIn11: currMonthIn11,
		currMonthOut11: currMonthOut11,
		currSeaInterestAmt11: currSeaInterestAmt11,
		residentDivision: residentDivision,
		//posCustProText: posCustProText,
		//posCustCityText: posCustCityText,
		inChannelKind: inChannelKind,
		repayMethod: repayMethod
		//posCustDivText: posCustDivText
		}, function(data){
			//insertClear();
			alert(data);
			if(flag == '1' && '新增授信成功' == data){
				$('#creditApplyWindow').window("close");
			}else{
				return;
			}
			queryCreditApply();
		}, 'text');
	}
	
	/*修改申请记录*/
	function modifyCreditApply(){
		var flag = validateForm("editform");
		if (!flag){
			$.messager.alert("操作提示","还有未填写的必输项.","error");
			return;
		}
		
		var reqUrl = "<%=request.getContextPath()%>/creditApply/updateCreditApply.do";
		var row = $('#tt').datagrid("getSelected");
		var loanId = row.loanId;
		//var channel = $('#editChannel').val();
		var channel = getComboValue('#editChannel');
		//var paperKind = $('#editPaperKind').val();
		var applyAmt = $('#editApplyAmt').val();
		//var currSign = $('#editCurrSign').val();
		//var returnKind = $('#editReturnKind').val();
		var returnKind = getComboValue('#editReturnKind');
		var bankAccno = $('#editBankAccno').val();
		//var bankName = $('#editBankName').val();
		var bankName = getComboValue('#editBankName');
		var bankBranName = $('#editBankBranName').val();
		var	bankSubName = $('#editBankSubName').val();
		var recOrg = $('#editRecOrg').val();
		var recPerson = $('#editRecPerson').val();
		var recContactNo = $('#editRecContactNo').val();
		var remark = $('#editRemark').val();
        if (getTotalBytes(remark) > 1000){
			alert('备注不能超过1000个字符！');
			return;
		}
		var posCustName = $('#editPosCustName').val();
		var posCustBusiScope = $('#editPosCustBusiScope').val();		
		//var busiDivision = $('#editBusiDivision').val();
		var busiDivision = getComboValue('#editBusiDivision');
		//var posCustDivText = $('#editBusiDivision').find("option:selected").text();
		//var posCustProText = $('#editPosCustProSelect').find("option:selected").text();
		//var posCustCityText = $('#editPosCustCitySelect').find("option:selected").text();
		var posCustProv = getComboValue('#editPosCustProSelect');
		var posCustCity = getComboValue('#editPosCustCitySelect');
		var posCustAddress = $('#editPosCustAddress').val();
		var custName =$('#editCustName').val();
		//var paperId =$('#editPaperId').val();
		//var birtDate =$('#editBirtDate').datebox("getValue");
		//var birtDate =$('#editBirtDate').val();
		//var sexSign =$('#editSexSign').val();
		//var sexSign = getComboValue('#editSexSign');
		var busiYear =$('#editBusiYear').val();
		//var marrSign =$('#editMarrSign').val();
		//var marrSign = getComboValue('#editMarrSign');
		//var educSign =$('#editEducSign').val();
		var educSign = getComboValue('#editEducSign');
		var childNum =$('#editChildNum').val();
		var localHouseNum =$('#editLocalHouseNum').val();
		var otherHouseNum =$('#editOtherHouseNum').val();
		var mobilePhone =$('#editMobilePhone').val();
		var tel =$('#editTel').val();
		//var residentProv =$('#editResidentProv').val();
		var residentProv = getComboValue('#editResidentProv');
		//var residentCity =$('#editResidentCity').val();
		var residentCity = getComboValue('#editResidentCity');
		//var residentDivision = $('#editResidentDivision').val();
		var residentDivision = getComboValue('#editResidentDivision');
		var residentDetail =$('#editResidentedit').val();
		var weixinNo =$('#editWeixinNo').val();
		var qqNo =$('#editQQNo').val();
		var email =$('#editEmail').val();
		var familyCustName =$('#editFamilyCustName').val();
		//alert("familyCustName="+familyCustName);
		var matePaperKind =$('#editMatePaperKind').val();
		var matePaperId =$('#editMatePaperId').val();
		var mateBirtDate =$('#editMateBirtDate').val();
		//var mateSexSign =$('#editMateSexSign').val();
		var mateSexSign = getComboValue('#editMateSexSign');
		var mateMobilePhone =$('#editMateMobilePhone').val();
		var relaCustName =$('#editRelaCustName').val();
		//var relaKind =$('#editRelaKind').val();
		var relaKind = getComboValue('#editRelaKind');
		var relaMobilePhone =$('#editRelaMobilePhone').val();
		var relaTel =$('#editRelaTel').val();
		var relativeId = $('#editRelativeId').val();
		var posCustId = $('#editPosCustId').val();
		var custId = $('#editCustId').val();
		var contactAddrFlag = getRadioValue('editAddrFlag');
		var posRegiCode = getTextValue("#editRegiCode");
		var occurType = getRadioValue('editOccurType');
		//银行流水
		/*
		var currMonth0 = $('#currMonth0').val();
		var bankName0 = $('#bankName0').val();
		var bankAccno0 = $('#bankAccno0').val();
		var currMonthIn0 = $('#currMonthIn0').val();
		var currMonthOut0 = $('#currMonthOut0').val();
		var currSeaInterestAmt0 = $('#currSeaInterestAmt0').val();
		var currMonth1 = $('#currMonth1').val();
		var bankName1 = $('#bankName1').val();
		var bankAccno1 = $('#bankAccno1').val();
		var currMonthIn1 = $('#currMonthIn1').val();
		var currMonthOut1 = $('#currMonthOut1').val();
		var currSeaInterestAmt1 = $('#currSeaInterestAmt1').val();
		var currMonth2 = $('#currMonth2').val();
		var bankName2 = $('#bankName2').val();
		var bankAccno2 = $('#bankAccno2').val();
		var currMonthIn2 = $('#currMonthIn2').val();
		var currMonthOut2 = $('#currMonthOut2').val();
		var currSeaInterestAmt2 = $('#currSeaInterestAmt2').val();
		var currMonth3 = $('#currMonth3').val();
		var bankName3 = $('#bankName3').val();
		var bankAccno3 = $('#bankAccno3').val();
		var currMonthIn3 = $('#currMonthIn3').val();
		var currMonthOut3 = $('#currMonthOut3').val();
		var currSeaInterestAmt3 = $('#currSeaInterestAmt3').val();
		var currMonth4 = $('#currMonth4').val();
		var bankName4 = $('#bankName4').val();
		var bankAccno4 = $('#bankAccno4').val();
		var currMonthIn4 = $('#currMonthIn4').val();
		var currMonthOut4 = $('#currMonthOut4').val();
		var currSeaInterestAmt4 = $('#currSeaInterestAmt4').val();
		var currMonth5 = $('#currMonth5').val();
		var bankName5 = $('#bankName5').val();
		var bankAccno5 = $('#bankAccno5').val();
		var currMonthIn5 = $('#currMonthIn5').val();
		var currMonthOut5 = $('#currMonthOut5').val();
		var currSeaInterestAmt5 = $('#currSeaInterestAmt5').val();
		var currMonth6 = $('#currMonth6').val();
		var bankName6 = $('#bankName6').val();
		var bankAccno6 = $('#bankAccno6').val();
		var currMonthIn6 = $('#currMonthIn6').val();
		var currMonthOut6 = $('#currMonthOut6').val();
		var currSeaInterestAmt6 = $('#currSeaInterestAmt6').val();
		var currMonth7 = $('#currMonth7').val();
		var bankName7 = $('#bankName7').val();
		var bankAccno7 = $('#bankAccno7').val();
		var currMonthIn7 = $('#currMonthIn7').val();
		var currMonthOut7 = $('#currMonthOut7').val();
		var currSeaInterestAmt7 = $('#currSeaInterestAmt7').val();
		var currMonth8 = $('#currMonth8').val();
		var bankName8 = $('#bankName8').val();
		var bankAccno8 = $('#bankAccno8').val();
		var currMonthIn8 = $('#currMonthIn8').val();
		var currMonthOut8 = $('#currMonthOut8').val();
		var currSeaInterestAmt8 = $('#currSeaInterestAmt8').val();
		var currMonth9 = $('#currMonth9').val();
		var bankName9 = $('#bankName9').val();
		var bankAccno9 = $('#bankAccno9').val();
		var currMonthIn9 = $('#currMonthIn9').val();
		var currMonthOut9 = $('#currMonthOut9').val();
		var currSeaInterestAmt9 = $('#currSeaInterestAmt9').val();
		var currMonth10 = $('#currMonth10').val();
		var bankName10 = $('#bankName10').val();
		var bankAccno10 = $('#bankAccno10').val();
		var currMonthIn10 = $('#currMonthIn10').val();
		var currMonthOut10 = $('#currMonthOut10').val();
		var currSeaInterestAmt10 = $('#currSeaInterestAmt10').val();
		var currMonth11 = $('#currMonth11').val();
		var bankName11 = $('#bankName11').val();
		var bankAccno11 = $('#bankAccno11').val();
		var currMonthIn11 = $('#currMonthIn11').val();
		var currMonthOut11 = $('#currMonthOut11').val();
		var currSeaInterestAmt11 = $('#currSeaInterestAmt11').val();		
		*/
		//alert("all in");
		var cols = {channel: channel,
				custName: custName,
				//paperKind: paperKind,
				applyAmt: applyAmt,
				custName: custName,
				/* maxTradeAmtPerWeek: maxTradeAmtPerWeek, */
				//currSign: currSign,
				returnKind: returnKind,
				bankAccno: bankAccno,
				bankName: bankName,
				bankBranName: bankBranName,
				bankSubbName: bankSubName,
				recOrg: recOrg,
				recPerson: recPerson,
				recContactNo: recContactNo,
				remark: remark,
				posCustName:posCustName,
				posCustBusiScope: posCustBusiScope,
				busiDivision: busiDivision,
				posCustProv : posCustProv,		//add by zllin
				posCustCity : posCustCity,
				posCustAddress: posCustAddress,
				//paperId: paperId,
				//birtDate: birtDate,
				//sexSign: sexSign,
				busiYear: busiYear,
				//marrSign: marrSign,
				educSign: educSign,
				childNum: childNum,
				localHouseNum: localHouseNum,
				otherHouseNum: otherHouseNum,
				mobilephone: mobilePhone,
				tel: tel,
				residentProv: residentProv,
				residentCity: residentCity,
				residentDetail: residentDetail,
				weixinNo: weixinNo,
				qqNo: qqNo,
				email: email,
				familyCustName: familyCustName,
				matePaperKind: matePaperKind,
				matePaperId: matePaperId,
				mateBirtDate: mateBirtDate,
				mateSexSign: mateSexSign,
				mateMobilephone: mateMobilePhone,
				relaCustName: relaCustName,
				relaKind: relaKind,
				relaMobilePhone: relaMobilePhone,
				relaTel: relaTel,
				loanId: loanId,
				residentDivision : residentDivision,
				relativeId: relativeId,
				posCustId: posCustId,
				custId: custId,
				contactAddrFlag: contactAddrFlag,
				regiCode: posRegiCode,		//add by Lin,Zhaolin
				occurType: occurType
				/*		//comment by Lin,Zhaolin
				currMonth0: currMonth0,
				bankName0: bankName0,
				bankAccno0: bankAccno0,
				currMonthIn0: currMonthIn0,
				currMonthOut0: currMonthOut0,
				currSeaInterestAmt0: currSeaInterestAmt0,
				currMonth1: currMonth1,
				bankName1: bankName1,
				bankAccno1: bankAccno1,
				currMonthIn1: currMonthIn1,
				currMonthOut1: currMonthOut1,
				currSeaInterestAmt1: currSeaInterestAmt1,
				currMonth2: currMonth2,
				bankName2: bankName2,
				bankAccno2: bankAccno2,
				currMonthIn2: currMonthIn2,
				currMonthOut2: currMonthOut2,
				currSeaInterestAmt2: currSeaInterestAmt2,
				currMonth3: currMonth3,
				bankName3: bankName3,
				bankAccno3: bankAccno3,
				currMonthIn3: currMonthIn3,
				currMonthOut3: currMonthOut3,
				currSeaInterestAmt3: currSeaInterestAmt3,
				currMonth4: currMonth4,
				bankName4: bankName4,
				bankAccno4: bankAccno4,
				currMonthIn4: currMonthIn4,
				currMonthOut4: currMonthOut4,
				currSeaInterestAmt4: currSeaInterestAmt4,
				currMonth5: currMonth5,
				bankName5: bankName5,
				bankAccno5: bankAccno5,
				currMonthIn5: currMonthIn5,
				currMonthOut5: currMonthOut5,
				currSeaInterestAmt5: currSeaInterestAmt5,
				currMonth6: currMonth6,
				bankName6: bankName6,
				bankAccno6: bankAccno6,
				currMonthIn6: currMonthIn6,
				currMonthOut6: currMonthOut6,
				currSeaInterestAmt6: currSeaInterestAmt6,
				currMonth7: currMonth7,
				bankName7: bankName7,
				bankAccno7: bankAccno7,
				currMonthIn7: currMonthIn7,
				currMonthOut7: currMonthOut7,
				currSeaInterestAmt7: currSeaInterestAmt7,
				currMonth8: currMonth8,
				bankName8: bankName8,
				bankAccno8: bankAccno8,
				currMonthIn8: currMonthIn8,
				currMonthOut8: currMonthOut8,
				currSeaInterestAmt8: currSeaInterestAmt8,
				currMonth9: currMonth9,
				bankName9: bankName9,
				bankAccno9: bankAccno9,
				currMonthIn9: currMonthIn9,
				currMonthOut9: currMonthOut9,
				currSeaInterestAmt9: currSeaInterestAmt9,
				currMonth10: currMonth10,
				bankName10: bankName10,
				bankAccno10: bankAccno10,
				currMonthIn10: currMonthIn10,
				currMonthOut10: currMonthOut10,
				currSeaInterestAmt10: currSeaInterestAmt10,
				currMonth11: currMonth11,
				bankName11: bankName11,
				bankAccno11: bankAccno11,
				currMonthIn11: currMonthIn11,
				currMonthOut11: currMonthOut11,
				currSeaInterestAmt11: currSeaInterestAmt11,
				//posCustDivText:posCustDivText,
				//posCustProText: posCustProText,
				//posCustCityText: posCustCityText
				*/
				};
		//alert("cols="+cols);
		//return;
		$.post(reqUrl, cols, function(data){
			alert(data);
			if(flag == '1' && '申请更新成功' == data){
				$('#modifyApplyWindow').window("close");
			}else{
				return;
			}
			queryCreditApply();
			//$('#modifyApplyWindow').window("close");
		}, 'text');
	}
	
	
	
	function rowformater(value, row, index) {
        return "<a href='javascript:openModifyApply();'>修改</a> <a href='javascript:openDetailApply()'>详情</a>";
    }
	
	function detailFormat(value, row, index){
		
		
	}
	
	//开启窗口
	function openCreditApply(){
		$('#creditApplyWindow').openWin({
				title:'新增申请',
				maximized:true,
				href:'openCreditMain.do?applyStatus=00&direct2Path=creditApply/insertCredit/insertCreditMain',
		//		onLoad: function () { initValidatebox();},
				});
	}
	
	
	//关闭登录窗口
    function closeCreditApply() {
        $('#creditApplyWindow').window('close');
    }
	/////////////////////////申请修改/////////////////////
	//影像件修改
	function editImageDataButton(obj){
		var btnTextValue = obj.textContent?obj.textContent:obj.innerText;		//use textContent in firefox 
		var buttonVal = btnTextValue.trim();
		if(buttonVal == '重新上传'){
			$('#reUpload').linkbutton({text:'取消上传'}); 
			$("#editImageDataIframe1").attr("style","display: block");
			$("#editImageDataIframe").attr("style","display: none");
		}else{
			$('#reUpload').linkbutton({text:'重新上传'}); 
			$("#editImageDataIframe1").attr("style","display: none");
			$("#editImageDataIframe").attr("style","display: block");
		}
	}
    
	//影像件修改
	function editImageDataButtonFromServer(obj){
		var btnTextValue = obj.textContent?obj.textContent:obj.innerText;		//use textContent in firefox 
		var buttonVal = btnTextValue.trim();
		if(buttonVal == '重新上传'){
			$('#reUploadback').linkbutton({text:'取消上传'}); 
			$("#editImageDataIframeback1").attr("style","display: block");
			$("#editImageDataIframeback").attr("style","display: none");
		}else{
			$('#reUploadback').linkbutton({text:'重新上传'}); 
			$("#editImageDataIframeback1").attr("style","display: none");
			$("#editImageDataIframeback").attr("style","display: block");
		}
	}
    
	//开启窗口
	function openModifyApply(){
		var row = $('#tt').datagrid("getSelected");
		var loanId = row.loanId;
		
		$('#modifyApplyWindow').openWin({
			title:'修改授信申请',
			maximized:true,
			href:'openCreditMain.do?applyStatus=00&loanId='+loanId+'&direct2Path=creditApply/editCredit/editCreditMain',
			onLoad : function(){var editMarrSign = $('#editMarrSign').val();switchRequired(editMarrSign,"Edit");}		//根据婚姻状况初始化必输项
			});
		
		return;
	}
  	//关闭登录窗口
    function closeModifyApply() {
        $('#modifyApplyWindow').window('close');
    }
  	
  	//关闭申请详情窗口
    function closeDetailApply(){
    	$('#detailApplyWindow').window('close');
    }
    
    //申请详情窗口
    function openDetailApply(){
    	//检查是否只选择了记录
		if (!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid("getSelected");
		var loanId = row.loanId;
		$('#detailApplyWindow').openWin({
			title:'查看授信详情',
			maximized:true,
			href:'openCreditMain.do?applyStatus=00&loanId='+loanId+'&direct2Path=creditApply/detailCredit/detailCreditMain',
			});
		
		return;
		
    }
   	/* 通过身份证获取年龄*/
    function getAgeFromUUserCard(UUserCard){
		var myDate = new Date();
        var month = myDate.getMonth() + 1;
        var day = myDate.getDate();
        var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1;
        if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) {
            age++;
        }
        return age;
	}
   	/* 初始化*/
    $(function() {
    	<%
    	com.hrbb.loan.web.security.entity.AccessPrivilege access = (com.hrbb.loan.web.security.entity.AccessPrivilege)session.getAttribute("accessPrivilege");
    	String applyStatus = (String)session.getAttribute("applyStatus");
    	if(!access.hasAnyPrivilege("ROLE_APPLY_QUERY") || (applyStatus!=null && applyStatus.trim().length()>0)){	//具有全量查询权限时,初始化不进行查询
    	%>
    		queryCreditApply();
    	<%}%>
    	
    	$('#tt').datagrid({
    		onClickCell: function (rowIndex, field, value) { 
                if(field != 'id'){
                	$(this).datagrid('unselectAll');
                }
                
            },
            onDblClickRow:function(rowIndex, rowData) {
            <%if(applyStatus!=null && applyStatus.equals("00")){%>
            	openDetailApply();
            <%}else{%>
            	executeApproval();
            <%}%>
            },
            onCheck: function (index, row){
            	switchFunctions(row);
            },
            singleSelect: true
    	});
    	
    	hideFilterArea();
    });
   	
    function switchFunctions(row){
    	var applyStutus = row["applyStatus"];
    	if(typeof(applyStutus)!="undefined" && applyStutus!=""){
    		if(applyStutus=="00" || applyStutus=="10"){
    			if($("#btnAppr").length>0){ $("#btnAppr").linkbutton("disable"); }
    		}else{
    			if($("#btnAppr").length>0){ $("#btnAppr").linkbutton("enable"); }
    		}
    	}
    }

    //审批详情
    /*
    function showAuditListWindow(){
			//检查是否只选择了记录
			if (!checkSelected()){
				return;
			}
			$('#auditListWindow').window('open');
			var row = $('#tt').datagrid('getSelected');
			//查询审批记录列表
			getInforAuditList(row.loanId);
		}
    */
    
    //检查是否只选择了记录
    function checkSelected(){
    	var rows = $('#tt').datagrid('getSelections');
    	var length = rows.length;
		if (length == 0){
		    alert("请选择一条记录！");
		    return false;
		}else if(length > 1){ 
		    alert("请只选择一条记录！");
		    return false;
		}else{
		    return true;
		}
    }
	
    function reloadPOSData(container,loandId){
    	$(container).datagrid({
    		url: "<%=request.getContextPath()%>/creditApply/queryCreditApplyPosSerialDetail.do?loanId="+loandId
    	});
    }
    //审批详情画面
	function executeApproval(){
		if(!checkSelected()){
			return;
		}
		var row = $('#tt').datagrid("getSelected");
		var loanId = row.loanId;
		$('#signSubmitWindow').openWin({
			title:'查看授信详情',
			maximized:true,
			href:'openApprovalView.do?loanId='+loanId+'&opflag=9&directTo=review/ApprovalUnifiedView',
			});
	}
	function imgFormatter(value,row,index){
		if (value == 0){
			return  "<img style='width:19px; height:19px' src='../img/rcv-success.png'>";
		}else if (value == 1){
      		return "<img style='width:19px; height:19px' src='../img/rcv-alert.png'>";
		}else{
			$("input[id='apprResult01']").hide();
			$('#apprResult01L').hide();
			$('#apprResult02L').html("拒绝（风险探测存在拦截项）"); 
			$("input[id='apprResult02']").attr("checked",'true');
			$("input[id='apprResult03']").hide();
			$('#apprResult03L').hide();
			$('#backToInfos + .combo').hide();
			$("input[id='apprResult04']").hide();
			$('#apprResult04L').hide();
			$("input[id='apprResult05']").hide();
			$('#apprResult05L').hide();
			$("input[id='apprResult06']").hide();
			$('#apprResult06L').hide();
			return  "<img style='width:19px; height:19px' src='../img/rcv-stop.png'>";
		}
    }
	
	//打开申请复议窗口
	function openReconsiderWindow(){
    	//检查是否只选择了记录
		if (!checkSelected()){
			return;
		}
	    $('#reconsiderWindow').window({
	        width: 650,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 300,
	        resizable:false
	    });
	    $('#reconsiderReason').val('');
	    $('#reconsiderWindow').window('open');
	}
	//关闭窗口
	function closeReconsiderWindow() {
	    $('#reconsiderReason').val('');
	    $('#reconsiderWindow').window('close');
	}
	//申请复议
	function reconsider() {
		var reconsiderReason = $('#reconsiderReason').val();
		if (reconsiderReason == ''){
			$.messager.alert("操作提示","请输入申请复议原因。","error");
			return;
		}
		var row = $('#tt').datagrid("getSelected");
	    var reqUrl = "<%=request.getContextPath()%>/creditApplyForReview/reconsider.do";
		$.post(reqUrl, 
			{loanId: row.loanId,
			reconsiderReason: reconsiderReason,
			applyStatus: row.applyStatus}, 
			function(data){
				alert(data);
				closeReconsiderWindow();
				queryCreditApply();
			}
		);
	}
	//申请撤回
	function withdrawCreditApply(){
		var row = $('#tt').datagrid("getSelected");
		var reqUrl = '<%=request.getContextPath()%>/creditApply/withdrawCreditApply.do';
			var loanId = row.loanId;
			$.post(reqUrl, {
				loanId : loanId
			}, function(data) {
				alert(data);
				$('#tt').datagrid('reload');
			},'text')
		}
	/*
	 Luhm校验规则：16位银行卡号（19位通用）:
	 
	1.将未带校验位的 15（或18）位卡号从右依次编号 1 到 15（18），位于奇数位号上的数字乘以 2。
	2.将奇位乘积的个十位全部相加，再加上所有偶数位上的数字。
	3.将加法和加上校验位能被 10 整除。
	//bankno为银行卡号 banknoInfo为显示提示信息的DIV或其他控件*/
	function luhmCheck(bankno){
	    var lastNum=bankno.substr(bankno.length-1,1);//取出最后一位（与luhm进行比较）
	 
	    var first15Num=bankno.substr(0,bankno.length-1);//前15或18位
	    var newArr=new Array();
	    for(var i=first15Num.length-1;i>-1;i--){    //前15或18位倒序存进数组
	        newArr.push(first15Num.substr(i,1));
	    }
	    var arrJiShu=new Array();  //奇数位*2的积 <9
	    var arrJiShu2=new Array(); //奇数位*2的积 >9
	     
	    var arrOuShu=new Array();  //偶数位数组
	    for(var j=0;j<newArr.length;j++){
	        if((j+1)%2==1){//奇数位
	            if(parseInt(newArr[j])*2<9)
	            arrJiShu.push(parseInt(newArr[j])*2);
	            else
	            arrJiShu2.push(parseInt(newArr[j])*2);
	        }
	        else //偶数位
	        arrOuShu.push(newArr[j]);
	    }
	     
	    var jishu_child1=new Array();//奇数位*2 >9 的分割之后的数组个位数
	    var jishu_child2=new Array();//奇数位*2 >9 的分割之后的数组十位数
	    for(var h=0;h<arrJiShu2.length;h++){
	        jishu_child1.push(parseInt(arrJiShu2[h])%10);
	        jishu_child2.push(parseInt(arrJiShu2[h])/10);
	    }        
	     
	    var sumJiShu=0; //奇数位*2 < 9 的数组之和
	    var sumOuShu=0; //偶数位数组之和
	    var sumJiShuChild1=0; //奇数位*2 >9 的分割之后的数组个位数之和
	    var sumJiShuChild2=0; //奇数位*2 >9 的分割之后的数组十位数之和
	    var sumTotal=0;
	    for(var m=0;m<arrJiShu.length;m++){
	        sumJiShu=sumJiShu+parseInt(arrJiShu[m]);
	    }
	     
	    for(var n=0;n<arrOuShu.length;n++){
	        sumOuShu=sumOuShu+parseInt(arrOuShu[n]);
	    }
	     
	    for(var p=0;p<jishu_child1.length;p++){
	        sumJiShuChild1=sumJiShuChild1+parseInt(jishu_child1[p]);
	        sumJiShuChild2=sumJiShuChild2+parseInt(jishu_child2[p]);
	    }      
	    //计算总和
	    sumTotal=parseInt(sumJiShu)+parseInt(sumOuShu)+parseInt(sumJiShuChild1)+parseInt(sumJiShuChild2);
	     
	    //计算Luhm值
	    var k= parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;        
	    var luhm= 10-k;
	     
	    if(lastNum==luhm){
	   // $("#banknoInfo").html("Luhm验证通过");
	    return true;
	    }
	    else{
	   //$("#banknoInfo").html("银行卡号必须符合Luhm校验");
	    return false;
	    }        
	}
	</script>
</head>
<body>
	<table id="tt" style="height:600px"
			title="Searching" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
			    <th field="id" checkbox="true"></th>
				<th field="bizLoanId" width="140px">申请编号</th>
				<th field="prodName" width="60px">产品</th>
				<th field="channelName" width="60px">业务渠道</th>
				<th field="applyAmt" width="80px" align="right" formatter="formatMoney">申请额度</th>
				<th field="beginDate" width="80px" formatter="dateFormat">申请日期</th>
				<th field="custName" width="80px">客户名称</th>
				<th field="posCustName" width="120px">商户名称</th>
				<th field="region" width="80px">地区</th>
				<!-- <th field="tradeArea" width="40px"></th> -->
				<th field="mobilePhone" width="80px">手机号码</th>
			<c:if test="${applyStatus == '90'}">
				<th field="creditLine" width="80px" align="right" formatter="formatMoney">授信额度</th>
				<th field="creditInterest" width="60px">授信利率</th>
				<!-- 
				<th field="creditResult" width="60px">授信结果</th> -->
			</c:if>
				<th field="applyStatusName" width="80px">当前状态</th>
			<c:if test="${(applyStatus != '00' and applyStatus != '10' and applyStatus!=null) or (applyStatus==null and isApplyStatus!='')}">
				<th field="execReviwer" width="60px">当前处理人</th>
				<th field="lastStep" width="60px">上一环节</th>
				<th field="lastStepOperName" width="60px">上一环节处理人</th>
			</c:if>
			<c:if test="${applyStatus == '00' or applyStatus == '10' or applyStatus==null or applyStatus==''}">
				<th field="regDate" width="110px" formatter="timeFormat">录入时间</th>
				<th field="operName" width="60px">录入人</th>
				<c:if test="${applyStatus == '00'}">
				<th field="hh" width="80px"  align="center"  formatter="rowformater">操作</th>
				</c:if>
			</c:if>
				<th field="loanId" width="110px">申请流水号</th>
				<!-- hidden fields -->
				<th field="prodId" hidden="true">产品代码</th>
				<th field="channel" hidden="true">渠道编码</th>
				<th field="applyStatus" hidden="true">申请状态编码</th>
			</tr>
		</thead>
	</table>
	
	<div id="creditApplyWindow"></div>	<!-- 新增申请 -->
	<div id="modifyApplyWindow"></div>	<!-- 修改申请 -->
	<div id="detailApplyWindow"></div>	<!-- 查看申请 -->
	<div id="signSubmitWindow"></div>
	<div id="reviewNoteWindow"></div>
	<jsp:include page="searchCredit.jsp"/>
	<jsp:include page="reconsider.jsp"/>
</body>
</html>