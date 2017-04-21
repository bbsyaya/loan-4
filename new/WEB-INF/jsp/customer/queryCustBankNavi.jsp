<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/locale/easyui-lang-zh_CN.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validator.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/calendar.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/js/common_uiext.js'></script>
	<script type="text/javascript">
	
	/*infoType certType infoDetail confirmUser*/
		function queryCustBank(){
			$('#tt').datagrid('load',{
				custId: $('#searchCustId').val(),
				custName: $('#searchCustName').val(),
				paperId: $('#searchPaperId').val()
			});
		}
		
		/*
		var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}   
		  
		function isCardID(sId){   
		    var iSum=0 ;  
		    var info="" ;  
		    if(!/^\d{17}(\d|x)$/i.test(sId)) return "你输入的身份证长度或格式错误";   
		    sId=sId.replace(/x$/i,"a");   
		    if(aCity[parseInt(sId.substr(0,2))]==null) return "你的身份证地区非法";   
		    sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));   
		    var d=new Date(sBirthday.replace(/-/g,"/")) ;  
		    if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))return "身份证上的出生日期非法";   
		    for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;  
		    if(iSum%11!=1) return "你输入的身份证号非法";   
		    return true;//aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女")   
		}   
		  
		$.extend($.fn.validatebox.defaults.rules, {     
		    idcard: {     
		        validator: function(value,param){    
		            var flag= isCardID(value);  
		            return flag==true?true:false;    
		        },     
		        message: '不是有效的身份证号码'    
		    },
			
		//验证汉子
	    CHS: {
	        validator: function (value) {
	            return /^[\u0391-\uFFE5]+$/.test(value);
	        },
	        message: '只能输入汉字'
	    },
	    //移动手机号码验证
	    mobile: {//value值为文本框中的值
	        validator: function (value) {
	            var reg = /^1[3|4|5|8|9]\d{9}$/;
	            return reg.test(value);
	        },
	        message: '输入手机号码格式不准确.'
	    },
	    //国内邮编验证
	    zipcode: {
	        validator: function (value) {
	            var reg = /^[1-9]\d{5}$/;
	            return reg.test(value);
	        },
	        message: '邮编必须是非0开始的6位数字.'
	    },
	    //用户账号验证(只能包括 _ 数字 字母) 
	    account: {//param的值为[]中值
	        validator: function (value, param) {
	            if (value.length < param[0] || value.length > param[1]) {
	                $.fn.validatebox.defaults.rules.account.message = '用户名长度必须在' + param[0] + '至' + param[1] + '范围';
	                return false;
	            } else {
	                if (!/^[\w]+$/.test(value)) {
	                    $.fn.validatebox.defaults.rules.account.message = '用户名只能数字、字母、下划线组成.';
	                    return false;
	                } else {
	                    return true;
	                }
	            }
	        }, message: ''
	    }
		});
		*/
		function queryBlank(){
			$('#searchCustId').val("");
			$('#searchCustName').val("");
			$('#searchPaperId').val("");
			queryCustBank();
		}
		
		function deleteCustBank(){
			var reqUrl = "<%=request.getContextPath()%>/custBank/deleteCustBank.do";
			var reqStr = "";
			var rows = $('#tt').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				reqStr=reqStr+rows[i].custId+"|";
			}
			var conf = window.confirm("真的要删除吗?");
			if(conf==true){
			$.get(reqUrl, {deleteItem: reqStr}, function(data){
				queryCustBank();
			});
			}
		}
		
		function modifyCustBank(){
			//closeModifyCustBank();
			//var reqUrl = "<%=request.getContextPath()%>/custBank/updateCustBank.do";
			//var row = $('#tt').datagrid("getSelected");
			var bankAccno = $('#bankAccno').val();
			//var bankName = $('#editbankName').val();
			var bankName = getComboValue('#editbankName');
			var bankBranName = $('#editbankBranName').val();
			var bankSubbName = $('#editbankSubbName').val();
			var cdtbranchid = getTextValue("#editCdtbranchid");
			/*
			var conf = window.confirm("真的要提交修改吗?");
			if(conf==true){
			$.post(reqUrl, {
				bankAccno: bankAccno,
				bankName: bankName,
				bankBranName: bankBranName,
				bankSubbName: bankSubbName
				}, function(data){
				queryCustBank();
			});
			}
			*/
			$.messager.confirm("确认", "确认提交修改该银行卡吗？", 
				function (r) {
		        if (r) {
		        	var reqUrl = "<%=request.getContextPath()%>/custBank/updateCustBank.do";
		        	$.post(reqUrl, 
		        		{
							bankAccno: bankAccno,
							bankName: bankName,
							bankBranName: bankBranName,
							bankSubbName: bankSubbName,
							cdtbranchid : cdtbranchid
						},
						function(data){
							if(typeof(data)!="undefined" ){
								if(data=="success"){
									$.messager.alert("操作提示","银行卡修改成功.","info");
								}else{
									$.messager.alert("操作提示","银行卡修改失败.","error");
								}
								closeModifyCustBank();
								queryCustBank();
							}
					});
		        }
		    });
		}
		
		
		function rowformater(value, row, index) {
			var aa = row.loanId;
            return "<a href='javascript:openModifyCustBank();'>修改</a>";
        }
		
		function detailFormat(value, row, index){
			
			
		}
		
		function dateFormat(value, row, index){
			var unixTimestamp = new Date(value);  
            //return unixTimestamp.toLocaleString();
        	//var date = (new Date(value)).format("yyyy-MM-dd");
        	return unixTimestamp.format("yyyy-MM-dd hh:mm:ss");
		}
		
		//新增窗口
        function blacklistRegWindow() {
            $('#AddBlacklistWindow').window({
                title: '录入黑名单',
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                resizable:false
            });
        }
		//开启窗口
		function openBlacklist(){
			$('#AddBlacklistWindow').window('open');
		}
      //关闭登录窗口
        function closeBlacklist() {
            $('#AddBlacklistWindow').window('close');
        }
		/////////////////////////申请修改/////////////////////
		//修改窗口
		/*
		function modifyCustBankWindow(){
			$('#modifyCustBankWindow').window({
                title: '修改客户亲属信息',
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                resizable:false
            });
			
		}
        */
		//开启窗口
		function openModifyCustBank(){
			var row = $('#tt').datagrid('getSelected');
			/*
			$('#bankAccno').val(row.bankAccno);
			$('#editbankName').val(row.bankName);
			$('#editbankBranName').val(row.bankBranName);
			$('#editbankSubbName').val(row.bankSubbName);
			$('#modifyCustBankWindow').window('open');
			*/
			var bankAccno = row.bankAccno;
			$('#modifyCustBankWindow').openWin({
				title:'客户银行卡修改',
				width:400,
				height:300,
				href:'<%=request.getContextPath()%>/custBank/modifyBankAccount.do?accountNo='+bankAccno
			})
		}
        
      	//关闭登录窗口
        function closeModifyCustBank() {
            $('#modifyCustBankWindow').window('close');
        }
      	
      	function detailCustBankWindow(){
      		$('#detailCustBankWindow').window({
                title: '修改授信申请',
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                resizable:false
            });
      	}
      	
        function closeDetailApply(){
        	
        	$('#detailCustBankWindow').window('close');
        }
        
        $(function() {

        	blacklistRegWindow();
        	//modifyCustBankWindow();
        	detailCustBankWindow();
        	
        	$('#tt').datagrid({
        		onClickCell: function (rowIndex, field, value) { 
                    if(field == 'hh' || field == 'bb'){
                    	$(this).datagrid('unselectAll');
                    }
                    
                },
                singleSelect:true
        	});
        	
        	$('#insertBirtDate').datebox({
        	    formatter: function(date){ return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();},
        	    parser: function(date){ return new Date(Date.parse(date.replace(/-/g,"/")));}
        	});
        	
        });
        
        
	</script>

</head>
<body>
	
	<table id="tt" class="easyui-datagrid" style="width:1024px;height:600px"
			url="<%=request.getContextPath()%>/custBank/queryCustBank.do"
			title="客户银行卡列表" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<!-- <th field="bb" width="50px" formatter="detailFormat">详情</th> -->
				<th field="id" checkbox="true"></th>
				<th field="hh" width="40"  align="center" formatter="rowformater">操作</th>
				<th field="custId" hidden="true">用户号</th>
				<th field="bankAccno" width="150px">银行卡号</th>
				<th field="bankName" hidden="true"> 开户行</th>
				<th field="displayName" width="100px"> 开户行</th>
				<th field="bankBranName" width="120px">分行</th>
				<th field="bankSubbName" width="120px">支行</th>
				<th field="cdtbranchid" width="120px">联行号</th>
 				<th field="createTime" formatter="dateFormat" width="120px">创建时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="modifyCustBankWindow"></div>
    
	<div id="tb" style="padding:5px;height:auto">
	
	<div id="tb" style="padding:3px">
		<span>客户ID:</span>
		<input id="searchCustId" name="searchCustId" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户名:</span>
		<input id="searchCustName" name="searchCustName" style="line-height:20px;border:1px solid #ccc"/>
		<span>客户证件号:</span>
		<input id="searchPaperId" name="searchPaperId" style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		</div>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryCustBank()" iconCls="icon-search" plain="true">查询</a>
		&nbsp&nbsp<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
		</div>
	</div>  
</body>
</html>