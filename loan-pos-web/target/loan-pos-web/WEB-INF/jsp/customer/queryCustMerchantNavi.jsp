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
	<script type="text/javascript">
	
	/*infoType certType infoDetail confirmUser*/
		function queryCustMerchant(){
			$('#tt').datagrid('load',{
				custId: $('#searchCustId').val(),
				custName: $('#searchCustName').val(),
				paperId: $('#searchPaperId').val()
			});
		}
		
		
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
		
		function queryBlank(){
			$('#searchCustId').val("");
			$('#searchCustName').val("");
			$('#searchPaperId').val("");
			queryCustMerchant();
		}
		
		function deleteCustMerchant(){
			var reqUrl = "<%=request.getContextPath()%>/custMerchant/deleteCustMerchant.do";
			var reqStr = "";
			var rows = $('#tt').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				reqStr=reqStr+rows[i].custId+"|";
			}
			var conf = window.confirm("真的要删除吗?");
			if(conf==true){
			$.get(reqUrl, {deleteItem: reqStr}, function(data){
				queryCustMerchant();
			});
			}
		}
		
		function modifyCustMerchant(){
			closeModifyCustMerchant();
			var reqUrl = "<%=request.getContextPath()%>/custMerchant/updateCustMerchant.do";
			var row = $('#tt').datagrid("getSelected");
			var posCustId = $('#posCustId').val();
			var custId = $('#editcustId').val();
			var posCustName = $('#editposCustName').val();
			var busiDivision = $('#editbusiDivision').val();
			var posCustBusiScope = $('#editposCustBusiScope').val();
			var posCustAddress = $('#editposCustAddress').val();
			var operAddrCode = $('#editoperAddrCode').val();
			var industryTypeId = $('#editindustryTypeId').val();
			var industryTypeId2 = $('#editindustryTypeId2').val();
			var regiCode = $('#editregiCode').val();
			
			var conf = window.confirm("真的要提交修改吗?");
			if(conf==true){
			$.post(reqUrl, {custId: custId,
				posCustId: posCustId,
				posCustName: posCustName,
				busiDivision: busiDivision,
				posCustBusiScope: posCustBusiScope,
				posCustAddress: posCustAddress,
				operAddrCode: operAddrCode,
				industryTypeId: industryTypeId,
				industryTypeId2: industryTypeId2,
				regiCode: regiCode
				}, function(data){
				queryCustMerchant();
			});
			}
		}
		
		
		function rowformater(value, row, index) {
			var aa = row.loanId;
            return "<a href='javascript:openModifyCustMerchant();'>修改</a>";
        }
		
		function detailFormat(value, row, index){
			
			
		}
		
		function dateFormat(value, row, index){
			var unixTimestamp = new Date(value);  
            return unixTimestamp.toLocaleString();
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
		function modifyCustMerchantWindow(){
			$('#modifyCustMerchantWindow').window({
                title: '修改客户亲属信息',
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                resizable:false
            });
			
		}
        
		//开启窗口
		function openModifyCustMerchant(){
			var row = $('#tt').datagrid('getSelected');
			$('#posCustId').val(row.posCustId);
			$('#editposCustName').val(row.posCustName);
			$('#editbusiDivision').val(row.busiDivision);
			$('#editposCustBusiScope').val(row.posCustBusiScope);
			$('#editoperAddrCode').val(row.operAddrCode);
			$('#editindustryTypeId').val(row.industryTypeId);
			$('#editindustryTypeId2').val(row.industryTypeId2);
			$('#editregiCode').val(row.regiCode);
			$('#modifyCustMerchantWindow').window('open');

		}
      //关闭登录窗口
        function closeModifyCustMerchant() {
            $('#modifyCustMerchantWindow').window('close');
        }
      	
      	function detailCustMerchantWindow(){
      		$('#detailCustMerchantWindow').window({
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
        	
        	$('#detailCustMerchantWindow').window('close');
        }
        
        $(function() {

        	blacklistRegWindow();
        	modifyCustMerchantWindow();
        	detailCustMerchantWindow();
        	
        	$('#tt').datagrid({
        		onClickCell: function (rowIndex, field, value) { 
                    if(field == 'hh' || field == 'bb'){
                    	$(this).datagrid('unselectAll');
                    }
                    
                },
        	});
        	
        	$('#insertBirtDate').datebox({
        	    formatter: function(date){ return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();},
        	    parser: function(date){ return new Date(Date.parse(date.replace(/-/g,"/")));}
        	});
        	
        });
        
        
	</script>

</head>
<body>
	
	<table id="tt" class="easyui-datagrid" style="width:5000px;height:600px"
			url="<%=request.getContextPath()%>/custMerchant/queryCustMerchantInfo.do"
			title="客户亲属列表" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<!-- <th field="bb" width="50px" formatter="detailFormat">详情</th> -->
				<th field="id" checkbox="true"></th>
				<th field="hh" width="40"  align="center" formatter="rowformater">操作</th>
				<th field="custId" width="60px">用户号</th>
				<th field="posCustId" width="60px">记录ID</th>
				<th field="posCustName" width="80px">商户名字</th>
				<th field="busiDivision" width="100px">经营区划</th>
				<th field="posCustBusiScope" width="150px">主营业务</th>
 				<th field="posCustAddress" width="100px">地址详情</th>
 				<th field="operAddrCode" width="100px">区划国标码</th>
 				<th field="industryTypeId" width="100px">互金行业分类(国标)</th>
 				<th field="industryTypeId2" width="100px">互金行业分类(内部)</th>
 				<th field="regiCode" width="100px">营业执照</th>
			</tr>
		</thead>
	</table>
	
    <jsp:include page="editCustMerchant.jsp"></jsp:include>
    
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
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryCustMerchant()" iconCls="icon-search" plain="true">查询</a>
		&nbsp&nbsp<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
		</div>
	</div>  
</body>
</html>