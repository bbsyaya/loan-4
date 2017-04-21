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
		function queryBlacklist(){
			$('#tt').datagrid('load',{
				infoDetail: $('#searchInfoDetail').val(),
				certType: $('#searchCertType').val(),
				infoType: $('#searchInfoType').val(),
				confirmUser: $('#searchConfirmUser').val(),
				confirmReason: $('#searchConfirmReason').val(),
				uneffTime: $('#searchUneffTime').datebox("getValue"),
				effectTime: $('#searchEffectTime').datebox("getValue")
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
			$('#searchInfoDetail').val("");
			$('#searchCertType').val("");
			$('#searchInfoType').val("");
			$('#searchConfirmUser').val("");
			$('#searchConfirmUserId').val("");
			$('#searcheffectTime').val("");
			$('#searchuneffTime').val("");
			queryBlacklist();
		}
		
		
		
		function deleteBlacklist(){
			var reqUrl = "<%=request.getContextPath()%>/blacklist/deleteblacklist.do";
			var reqStr = "";
			var rows = $('#tt').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				reqStr=reqStr+rows[i].blacklistId+"|";
			}
			var conf = window.confirm("真的要删除吗?");
			if(conf==true){
			$.get(reqUrl, {deleteItem: reqStr}, function(data){
				queryBlacklist();
			});
			}
		}
		
		/*insert blacklist  */
		function blacklistReg(){
			var reqUrl = "<%=request.getContextPath()%>/blacklist/insertblacklist.do";
			var infoType = $('#insertinfoType').val();
			var certType = $('#insertcertType').val();
			var infoDetail = $('#insertinfoDetail').val();
			var confirmReason = $('#insertconfirmReason').val();
			var effectTime = $('#inserteffectTime').datebox("getValue");
			var uneffTime = $('#insertuneffTime').datebox("getValue");
			var intervalType = $('#insertintervalType').val();
			var effectFlag = $('#inserteffectFlag').val();
			$.post(reqUrl, {infoType: infoType,certType: certType,
				infoDetail: infoDetail,
				confirmReason: confirmReason,
				effectTime: effectTime,
				uneffTime: uneffTime,
				intervalType: intervalType,
				effectFlag: effectFlag}, function(data){
					alert(data);
				queryBlacklist();
			});
		}
		
		function modifyBlacklist(){
			closeModifyApply();
			var reqUrl = "<%=request.getContextPath()%>/blacklist/updateblacklist.do";
			var row = $('#tt').datagrid("getSelected");
			var id = row.id;
			var blacklistId = $('#editblacklistId').val();
			var infoType = $('#editinfoType').val();
			var certType = $('#editcertType').val();
			var infoDetail = $('#editinfoDetail').val();
			var confirmReason = $('#editconfirmReason').val();
			var effectTime = $('#editeffectTime').datebox("getValue");
			var uneffTime = $('#edituneffTime').datebox("getValue");
			var intervalType = $('#editintervalType').val();
			var effectFlag = $('#editeffectFlag').val();
			var conf = window.confirm("真的要提交修改吗?");
			if(conf==true){
			$.post(reqUrl, {blacklistId: blacklistId,infoType: infoType,certType: certType,
				infoDetail: infoDetail,
				confirmReason: confirmReason,
				effectTime: effectTime,
				uneffTime: uneffTime,
				intervalType: intervalType,
				effectFlag: effectFlag}, function(data){
					/*alert(data);*/
				queryBlacklist();
			});
			}
		}
		
		
		function rowformater(value, row, index) {
			var aa = row.loanId;
            return "<a href='javascript:openModifyApply();'>修改</a> <a href='javascript:deleteBlacklist()'>删除</a>";
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
		function modifyBlacklistWindow(){
			$('#modifyBlacklistWindow').window({
                title: '修改黑名单',
                width: 1000,
                modal: true,
                shadow: true,
                closed: true,
                height: 500,
                resizable:false
            });
			
		}
        
		//开启窗口
		function openModifyApply(){
			var row = $('#tt').datagrid('getSelected');
			$('#editblacklistId').val(row.blacklistId);
			$('#editinfoType').val(row.infoType);
			$('#editcertType').val(row.certType);
			$('#editinfoDetail').val(row.infoDetail);
			$('#editconfirmUser').val(row.confirmUser);
			$('#editconfirmTime').val(row.confirmTime);
			$('#editconfirmReason').val(row.confirmReason);
			$('#editeffectTime').val(row.effectTime);
			$('#edituneffTime').val(row.uneffTime);
			$('#editintervalType').val(row.intervalType);
			$('#editeffectFlag').val(row.effectFlag);
			$('#modifyBlacklistWindow').window('open');

		}
      //关闭登录窗口
        function closeModifyApply() {
            $('#modifyBlacklistWindow').window('close');
        }
      	
      	function detailApplyWindow(){
      		$('#detailApplyWindow').window({
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
        	
        	$('#detailApplyWindow').window('close');
        }
        
        $(function() {

        	blacklistRegWindow();
        	modifyBlacklistWindow();
        	detailApplyWindow();
        	
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
	
	<table id="tt" class="easyui-datagrid" style="width:1600px;height:600px"
			url="<%=request.getContextPath()%>/blacklist/queryblacklist.do"
			title="黑名单列表" iconCls="icon-search" toolbar="#tb" onClickRow="clickRow"
			rownumbers="true" pagination="true">
		<thead>
			<tr>
				<!-- <th field="bb" width="50px" formatter="detailFormat">详情</th> -->
				<th field="id" checkbox="true"></th>
				<th field="hh" width="80"  align="center" formatter="rowformater">操作</th>
				<th field="infoType" width="30px">分类</th>
				<th field="certType" width="40px">证件类型</th>
				<th field="infoDetail" width="350px">明细</th>
				<th field="confirmReason" width="350px">原因</th>
				<th field="effectTime"  formatter="dateFormat" width="140px">生效时间</th>
				<th field="uneffTime"  formatter="dateFormat" width="140px">失效时间</th>
				<th field="effectFlag" width="40px">状态</th>
				<th field="intervalType" width="70px">间隔</th>
				<th field="confirmUser" width="40px">操作员</th>
				<th field="blacklistId" width="100px">ID</th>
			</tr>
		</thead>
	</table>
	
	<!--新增窗口-->
    <div id="AddBlacklistWindow" class="easyui-window" title="录入黑名单" collapsible="false" minimizable="false"
        maximizable="true" icon="icon-save"  style="width: 1000px; height: 500px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <div title="黑名单信息" style="padding:20px;">
                	<table>
                		<tr>
                			<td>筛选类别:
                				<select id="insertinfoType" name="insertinfoType">
									<option value="">全部</option>
									<option value="0">证件</option>
									<option value="1">手机</option>
									<option value="2">商户</option>
									<option value="3">地址</option>
								</select>
                			</td>  
                			<td>证件类别:
					            <select id="insertcertType" name="insertcertType">
									<option value="">全部</option>
									<option value="00">身份证</option>
									<option value="01">护照</option>
									<option value="02">港澳通行证</option>
									<option value="03">台胞证</option>
								</select>
							</td>
						<tr/>
						<tr>
                			<td>		
                				内容：<input id="insertinfoDetail" name="insertinfoDetail" style="line-height:20px;border:1px solid #ccc"/>
							</td>
								<tr/>
						<tr>
                		    <td>		
                				录入原因：<input id="insertconfirmReason" name="insertconfirmReason" style="line-height:20px;border:1px solid #ccc"/>
							</td>
						<tr/>
						<tr>
							<td>		
                				期限类型：					           
                				<select id="insertintervalType" name="insertintervalType">
									<option value="01">1个月</option>
									<option value="03">3个月</option>
									<option value="06">半年</option>
									<option value="12">1年</option>
									<option value="EV">永久</option>
									<option value="">不设</option>
								</select>
							</td> 	
                		    <td>		
                				生效时间：<input  class="easyui-datetimebox"  id="inserteffectTime" name="inserteffectTime" type="text" style="line-height:20px;border:1px solid #ccc"/>
							</td>                		
                		    <td>		
                				失效时间：<input  class="easyui-datetimebox"  id="insertuneffTime" name="insertuneffTime" type="text"  style="line-height:20px;border:1px solid #ccc"/>
							</td> 						
						</tr>
                	</table>
                </div>
               
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" onclick="blacklistReg()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
    
    <!--修改窗口-->
    <div id="modifyBlacklistWindow" class="easyui-window" title="新增授信申请" collapsible="false" minimizable="false"
        maximizable="true" icon="icon-save"  style="width: 800px; height: 500px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" class="easyui-tabs" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <div title="申请人信息" style="padding:20px;">
                	<table>
                		<tr>
                			<td>筛选类别:
                				<select id="editinfoType" name="editinfoType">
									<option value="">全部</option>
									<option value="0">证件</option>
									<option value="1">手机</option>
									<option value="2">商户</option>
									<option value="3">地址</option>
								</select>
                			</td>  
                			<td>证件类别:
					            <select id="editcertType" name="editcertType">
									<option value="">全部</option>
									<option value="00">身份证</option>
									<option value="01">护照</option>
									<option value="02">港澳通行证</option>
									<option value="03">台胞证</option>
								</select>
							</td>
						<tr/>
						<tr>
                			<td>		
                				内容：<input id="editinfoDetail" name="editinfoDetail" style="line-height:20px;border:1px solid #ccc"/>
							</td>
                		    <td>		
                				原因：<input id="editconfirmReason" name="editconfirmReason" style="line-height:20px;border:1px solid #ccc"/>
							</td>
						<tr/>
						<tr>
							<td>		
                				期限类型：					           
                				<select id="editintervalType" name="editintervalType">
									<option value="">不设</option>
									<option value="01">1个月</option>
									<option value="03">3个月</option>
									<option value="06">半年</option>
									<option value="12">1年</option>
									<option value="EV">永久</option>
								</select>
							</td> 	
                		    <td>		
                				生效时间：<input  class="easyui-datetimebox" type="text"  id="editeffectTime"  name="editeffectTime"  style="line-height:20px;border:1px solid #ccc"/>
							</td>                		
                		    <td>		
                				失效时间：<input  class="easyui-datetimebox" type="text"  id="edituneffTime" name="edituneffTime"  style="line-height:20px;border:1px solid #ccc"/>
							</td> 						
						</tr>
						<input id="editblacklistId" name="editblacklistId" style="line-height:20px;border:1px solid #ccc" type="hidden"/>
                	</table>
                </div>
                <!-- <div title="银行流水信息">
                	<tr>
                		<th>客户编号</th>
                		<th>客户名称</th>
                		<th>银行名称</th>
                		
                	</tr>
                </div> -->
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
            	<a id="btnEi" onclick="modifyBlacklist()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">
            		保存并继续
            	</a>
                <a id="btnEp" onclick="modifyBlacklist()" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">
                   保存并退出</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
    
    
	<div id="tb" style="padding:5px;height:auto">  
	<div id="tb">  
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openBlacklist()">录入黑名单</a>  
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBlacklist()">删除列表</a> 
    </div>  
	
	<div id="tb" style="padding:3px">
		<span>筛选类别:</span>
		<select id="searchInfoType" name="searchInfoType">
			<option value="">全部</option>
			<option value="0">证件</option>
			<option value="1">手机</option>
			<option value="2">商户</option>
			<option value="3">地址</option>
		</select>
		<span>信息明细:</span>
		<input id="searchInfoDetail" name="searchInfoDetail" style="line-height:20px;border:1px solid #ccc"/>
		<span>证件类型:</span>
		<select id="searchCertType" name="searchCertType">
			<option value="">全部</option>
			<option value="00">身份证</option>
			<option value="01">护照</option>
			<option value="02">港澳通行证</option>
			<option value="03">台胞证</option>
		</select>
		<br/><br/>
		<span>操作员名:</span>
		<input id="searchConfirmUser" name="searchConfirmUser" style="line-height:20px;border:1px solid #ccc"/>
		<span>生效时间：</span><input  class="easyui-datetimebox" type="text"  id="searchEffectTime"  name="searchEffectTime"  style="line-height:20px;border:1px solid #ccc"/>
        <span>失效时间</span>：<input  class="easyui-datetimebox" type="text"  id="searchUneffTime" name="searchUneffTime"  style="line-height:20px;border:1px solid #ccc"/>
		<br/><br/>
		</div>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="queryBlacklist()" iconCls="icon-search" plain="true">查询</a>
		&nbsp&nbsp<a href="javascript:void(0)"  onclick="queryBlank()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
		</div>
	</div>  
</body>
</html>